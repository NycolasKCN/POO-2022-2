import java.util.ArrayList;
import java.util.List;

import exceptions.AmigoInexistenteException;
import exceptions.AmigoNaoSorteadoException;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public void cadastraAmigo(String nome, String email) {
        Amigo amigo = new Amigo(nome, email);
        amigos.add(amigo);
    }

    public Amigo pesquisaAmigo(String email) {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(email)) {
                return amigo;
            }
        }
        return null;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        MensagemParaTodos mensagem = new MensagemParaTodos(texto, emailRemetente, anonima);
        mensagens.add(mensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario,
            boolean anonima) {
        MensagemParaAlguem mensagem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, anonima);
        mensagens.add(mensagem);
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

    public void configuraAmigoSecretoDe(String emailAmigo, String emailAmigoSorteado) throws AmigoInexistenteException {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(emailAmigo)) {
                amigo.setAmigoSorteado(emailAmigoSorteado);
                return;
            }
        }
        throw new AmigoInexistenteException("Amigo inexistente!");
    }

    public String PesquisaAmigoSecretoDe(String emailAmigo)
            throws AmigoInexistenteException, AmigoNaoSorteadoException {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(emailAmigo)) {
                if (amigo.getEmailAmigoSorteado() == null)
                    throw new AmigoNaoSorteadoException("Amigo não sorteado!");

                return amigo.getEmailAmigoSorteado();
            }
        }
        throw new AmigoInexistenteException("Amigo inexistente!");
    }

    // ======================================================================

    public List<Amigo> amigosSemAmigoSecreto() {
        List<Amigo> amigosNaoSorteados = new ArrayList<>();
        for (Amigo amigo : amigos) {
            if (amigo.getEmailAmigoSorteado() == null) {
                amigosNaoSorteados.add(amigo);
            }
        }
        return amigosNaoSorteados;
    }

    private List<Amigo> amigosParaSortear() {
        List<Amigo> amigosParaSortear = new ArrayList<Amigo>(getAmigos());

        for (Amigo amigo : this.getAmigos()) {
            for (Amigo a : this.getAmigos()) {
                if (amigo.getEmail().equals(a.getEmailAmigoSorteado())) {
                    amigosParaSortear.remove(amigo);
                    break;
                }
            }
        }
        return amigosParaSortear;
    }

    public void sortearAmigoSecreto() {
        List<Amigo> amigosSemAmigoSecreto = amigosSemAmigoSecreto();
        List<Amigo> amigosParaSortear = amigosParaSortear();

        for (Amigo amigo : amigosSemAmigoSecreto) {
            Amigo amigoSorteado = null;
            do {
                amigoSorteado = amigosParaSortear.get((int) (Math.random() * amigosParaSortear.size()));
            } while (amigoSorteado.getEmail().equals(amigo.getEmail()));
            amigo.setAmigoSorteado(amigoSorteado.getEmail());
            amigosParaSortear.remove(amigoSorteado);
        }
    }

    public List<Amigo> getAmigos() {
        return this.amigos;
    }
}
