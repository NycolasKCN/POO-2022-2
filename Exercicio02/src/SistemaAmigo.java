import java.util.ArrayList;
import java.util.List;

import exceptions.AmigoInexistenteException;
import exceptions.AmigoNaoSorteadoException;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

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

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
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

    public void configuraAmigoSecretoDe(String emailAmigo, String emailAmigoSorteado) throws AmigoInexistenteException{
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(emailAmigo)) {
                amigo.setAmigoSorteado(emailAmigoSorteado);
                return;
            }
        }
        throw new AmigoInexistenteException("Amigo inexistente!");
    }

    public String PesquisaAmigoSecretoDe(String emailAmigo) throws AmigoInexistenteException, AmigoNaoSorteadoException{
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(emailAmigo)) {
                if (amigo.getEmailAmigoSorteado() == null) throw new AmigoNaoSorteadoException("Amigo não sorteado!");
                
                return amigo.getEmailAmigoSorteado();
            }
        }
        throw new AmigoInexistenteException("Amigo inexistente!");
    }
}
