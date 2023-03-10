package br.com.nycdev.exercicio03;

import java.util.*;

public class SistemaAmigoMap {
    private static final int MENSAGENS_SEM_LIMITE = -1;

    private final List<Mensagem> mensagens;
    private final Map<String, Amigo> amigos;
    private final int maxMensagens;

    public SistemaAmigoMap() {
        this(MENSAGENS_SEM_LIMITE);
    }

    public SistemaAmigoMap(int maxMensagens) {
        this.mensagens = new ArrayList<>();
        this.amigos = new HashMap<>();
        this.maxMensagens = maxMensagens;
    }

    private boolean limiteDeMensagens() {
        return mensagens.size() >= maxMensagens;
    }

    public void cadastraAmigo(String nome, String email) throws AmigoJaExisteException {
        if (!amigos.containsKey(email)) {
            Amigo a = new Amigo(nome, email);
            amigos.put(email, a);
        } else {
            throw new AmigoJaExisteException("O amigo de email " + email + " já está cadastrado.");
        }
    }

    private boolean amigoExiste(String emailAmigo) {
        return this.amigos.containsKey(emailAmigo);
    }

    public Amigo pesquisaAmigo(String email) throws AmigoInexistenteException {
        Amigo a = amigos.get(email);
        if (!(a == null)) {
            return a;
        } else {
            throw new AmigoInexistenteException("Amigo de email: " + email + " não existe.");
        }
    }

    public List<Amigo> pesquisaTodosAmigos() {
        return new ArrayList<>((Collection) this.amigos);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for (Mensagem m : mensagens) {
            if (m.ehAnonima()) {
                mensagensAnonimas.add(m);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return this.mensagens;
    }

    public String pesquisaAmigoSecretoDe(String email) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo a = this.amigos.get(email);

        if (!(a == null)) {
            String amigoSecreto = a.getEmailAmigoSecreto();
            if (!(amigoSecreto == null)) {
                return amigoSecreto;
            } else {
                throw new AmigoNaoSorteadoException("Amigo secreto de " + email + " não foi configurado.");
            }
        } else {
            throw new AmigoInexistenteException("Amigo de email " + email + " não existe");
        }
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        MensagemParaTodos mensagem = new MensagemParaTodos(texto, emailRemetente, anonima);
        mensagens.add(mensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        MensagemParaAlguem mensagem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, anonima);
        mensagens.add(mensagem);
    }

    public void configuraAmigoSecretoDe(String emailAmigo, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo a = this.amigos.get(emailAmigo);

        if (!(a == null)) {
            a.setAmigoSecreto(emailAmigoSorteado);
        } else {
            throw new AmigoInexistenteException("Amigo de email " + emailAmigo + " não existe");
        }
    }
}