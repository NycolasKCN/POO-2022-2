package br.com.nycdev.exercicio03;
public class MensagemParaTodos extends Mensagem{

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
    }

    @Override
    public String getTextoCompletoAExibir() {
        if (super.ehAnonima()) {
            return "Mensagem para Todos. Texto: " + super.getTexto();
        }
        return "Mensagem de: " + super.getEmailRemetente() + " para todos. Texto: " + super.getTexto();
    }
}
