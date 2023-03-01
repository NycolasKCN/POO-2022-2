package sistema;
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

    private boolean amigoExiste(String emailAmigo) {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(emailAmigo)) {
                return true;
            }
        }
        return false;
    }

    public Amigo pesquisaAmigo(String email) {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(email)) {
                return amigo;
            }
        }
        return null;
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

    public String pesquisaAmigoSecretoDe(String emailAmigo)
            throws AmigoInexistenteException, AmigoNaoSorteadoException {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(emailAmigo)) {
                if (amigo.getEmailAmigoSecreto() == null)
                    throw new AmigoNaoSorteadoException("Amigo não sorteado!");

                return amigo.getEmailAmigoSecreto();
            }
        }
        throw new AmigoInexistenteException("Amigo inexistente!");
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonima)
            throws AmigoInexistenteException {
        if (!amigoExiste(emailRemetente)) {
            throw new AmigoInexistenteException("Amigo remetente não existe, ou não está listado");
        }
        MensagemParaTodos mensagem = new MensagemParaTodos(texto, emailRemetente, anonima);
        mensagens.add(mensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima)
            throws AmigoInexistenteException {
        if ((!this.amigoExiste(emailDestinatario)) || (!this.amigoExiste(emailRemetente))) {
            throw new AmigoInexistenteException(
                    "Amigo destinatário ou remetente, não existe(m) ou não está(am) listado(s).");
        }
        MensagemParaAlguem mensagem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, anonima);
        mensagens.add(mensagem);
    }

    public void configuraAmigoSecretoDe(String emailAmigo, String emailAmigoSorteado) throws AmigoInexistenteException {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(emailAmigo)) {
                amigo.setAmigoSecreto(emailAmigoSorteado);
                return;
            }
        }
        throw new AmigoInexistenteException("Amigo inexistente!");
    }

    public List<Amigo> amigosSemAmigoSecreto() {
        List<Amigo> amigosNaoSorteados = new ArrayList<>();
        for (Amigo amigo : amigos) {
            if (amigo.getEmailAmigoSecreto() == null) {
                amigosNaoSorteados.add(amigo);
            }
        }
        return amigosNaoSorteados;
    }

    private List<Amigo> amigosParaSortear() {
        List<Amigo> amigosParaSortear = new ArrayList<Amigo>(pesquisaTodosAmigos());

        for (Amigo amigo : this.pesquisaTodosAmigos()) {
            for (Amigo a : this.pesquisaTodosAmigos()) {
                if (amigo.getEmail().equals(a.getEmailAmigoSecreto())) {
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
            amigo.setAmigoSecreto(amigoSorteado.getEmail());
            amigosParaSortear.remove(amigoSorteado);
        }
    }
}
