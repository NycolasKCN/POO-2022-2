public class MensagemParaAlguem extends Mensagem{
    public String emailDestinatario;


    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        if (super.ehAnonima()) {
            return "Mensagem para " + this.getEmailRemetente() + "Texto: " + this.getTexto();
        }
        return "Mensagem de: " + this.getEmailRemetente() + " para " + this.getEmailRemetente() + "Texto: " + this.getTexto();
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }
}
