package sistema;
public class MensagemParaAlguem extends Mensagem{
    public String emailDestinatario;


    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        if (super.ehAnonima()) {
            return "Mensagem para " + this.getEmailDestinatario() + " Texto: " + super.getTexto();
        }
        return "Mensagem de: " + super.getEmailRemetente() + " para " + this.getEmailDestinatario() + " Texto: " + super.getTexto();
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }
}
