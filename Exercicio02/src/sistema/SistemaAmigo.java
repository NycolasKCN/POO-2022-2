package sistema;

import java.util.ArrayList;
import java.util.List;

import exceptions.AmigoInexistenteException;
import exceptions.AmigoExistenteExeception;
import exceptions.AmigoNaoSorteadoException;
import exceptions.MaximoDeMensagensException;
import exceptions.SorteioException;

public class SistemaAmigo {
    private static final int MENSAGENS_SEM_LIMITE = -1;

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;
    private int maxMensagens;

    public SistemaAmigo() {
        this(MENSAGENS_SEM_LIMITE);
    }

    public SistemaAmigo(int maxMensagens) {
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
        this.maxMensagens = maxMensagens;
    }

    private boolean limiteDeMensagens() {
        if (mensagens.size() >= maxMensagens)
            return true;
        return false;
    }

    public void cadastraAmigo(String nome, String email) throws AmigoExistenteExeception {
        Amigo amigo = new Amigo(nome, email);
        if (!this.amigos.contains(amigo)) {
            throw new AmigoExistenteExeception("Amigo de nome: " + nome + " já cadastrado.");
        }
        amigos.add(amigo);
    }

    private boolean amigoExiste(String emailAmigo) {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(emailAmigo)) {
                return true;
            }
        }
        return false;
    }

    public Amigo pesquisaAmigo(String email) throws AmigoInexistenteException {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(email)) {
                return amigo;
            }
        }
        throw new AmigoInexistenteException("Amigo de email: " + email + " não existe.");
    }

    public List<Amigo> pesquisaTodosAmigos() {
        return this.amigos;
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for (Mensagem mensagem : mensagens) {
            if (mensagem.ehAnonima()) {
                mensagensAnonimas.add(mensagem);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return this.mensagens;
    }

    public String pesquisaAmigoSecretoDe(String email)
            throws AmigoInexistenteException, AmigoNaoSorteadoException {
                
        for (Amigo amigo : this.amigos) {
            if (amigo.getEmail().equals(emailAmigo)) {
                if (amigo.getEmailAmigoSecreto() == null)
                    throw new AmigoNaoSorteadoException("Amigo secreto do amigo: " + amigo.getEmail() + " não registrado.");

        for (Amigo a : this.amigos) {
            if (a.getEmail().equals(email)) {
                if (a.getEmailAmigoSecreto() == null)
                    throw new AmigoNaoSorteadoException("Amigo secreto de " + a.getNome() + " não sorteado.");

                return a.getEmailAmigoSecreto();
            }
        }
        throw new AmigoInexistenteException("Amigo de email: " + email + " não existe.");
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonima)
            throws AmigoInexistenteException, MaximoDeMensagensException {

        if (this.limiteDeMensagens()) {
            throw new MaximoDeMensagensException("Maximo de mensagens alcançada.");
        }
        if (!amigoExiste(emailRemetente)) {
            throw new AmigoInexistenteException(
                    "Amigo remetente de email: " + emailRemetente + " não existe.");
        }
        MensagemParaTodos mensagem = new MensagemParaTodos(texto, emailRemetente, anonima);
        mensagens.add(mensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima)
            throws AmigoInexistenteException, MaximoDeMensagensException {

        if (this.limiteDeMensagens()) {
            throw new MaximoDeMensagensException("Maximo de mensagens enviadas alcançada");
        }
        if (!this.amigoExiste(emailDestinatario)) {
            throw new AmigoInexistenteException(
                    "Amigo destinatário de email: " + emailDestinatario + " não existe.");
        }
        if (!this.amigoExiste(emailRemetente)) {
            throw new AmigoInexistenteException(
                    "Amigo remetente de email: " + emailRemetente + " não existe.");
        }

        MensagemParaAlguem mensagem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, anonima);
        mensagens.add(mensagem);
    }

    public void configuraAmigoSecretoDe(String emailAmigo, String emailAmigoSorteado) throws AmigoInexistenteException {
        if (!this.amigoExiste(emailAmigoSorteado)) {
            throw new AmigoInexistenteException("Amigo de email: " + emailAmigoSorteado + " não existe.");
        }

        for (Amigo amigo : this.amigos) {
            if (amigo.getEmail().equals(emailAmigo)) {
                amigo.setAmigoSecreto(emailAmigoSorteado);
                return;
            }
        }
        throw new AmigoInexistenteException("Amigo de email " + emailAmigo + " não está cadastrado.");
    }

    public void sortearAmigosSecretos() {
        List<Amigo> amigosParaSortear = new ArrayList<>(this.amigos);

        for (Amigo a : this.amigos) {
            Amigo amigoSorteado = null;
            do {
                amigoSorteado = sortear(a, amigosParaSortear);
            } while (amigoEhIgual(a, amigoSorteado));
            a.setAmigoSecreto(amigoSorteado.getEmail());
            amigosParaSortear.remove(amigoSorteado);
        }
    }

    private Amigo sortear(Amigo a, List<Amigo> listAmigos) {
        int index = (int) (Math.random() * listAmigos.size());
        Amigo amigoSorteado = listAmigos.get(index);
        return amigoSorteado;
        
    }

    private boolean amigoEhIgual(Amigo amigo, Amigo outroAmigo){
        return amigo.equals(outroAmigo);
    }

}
