import javax.swing.JOptionPane;

import exceptions.AmigoExistenteException;
import exceptions.AmigoInexistenteException;
import exceptions.MaximoDeMensagensException;
import sistema.Amigo;
import sistema.Mensagem;
import sistema.SistemaAmigo;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {
        int maxMensagens, amigosParticipantes;
        String maxMensagensString = JOptionPane.showInputDialog("Digite o número máximo de mensagens");
        maxMensagens = Integer.parseInt(maxMensagensString);
        SistemaAmigo sistema = new SistemaAmigo(maxMensagens);

        String amigosParticipanteString = JOptionPane.showInputDialog("Digite o número de amigos participantes");
        amigosParticipantes = Integer.parseInt(amigosParticipanteString);
        
        for (int i = 0; i < amigosParticipantes; i++) {
            String nome = JOptionPane.showInputDialog("Digite o nome do amigo");
            String email = JOptionPane.showInputDialog("Digite o email do amigo");
            try {
                sistema.cadastraAmigo(nome, email);
            } catch (AmigoExistenteException e) {
                System.out.println(e.getMessage());
            }
        }

        sistema.sortearAmigosSecretos();

        String textFormated = "Nome - Email do amigo secreto\n";
        for (Amigo amigo : sistema.pesquisaTodosAmigos()) {
            textFormated += amigo.getNome() + " - " + amigo.getEmailAmigoSecreto() + "\n";
        }

        JOptionPane.showMessageDialog(null, textFormated);

        try {
            String emailRemetente, texto, anonimaString;
            boolean anonima;

            emailRemetente = JOptionPane.showInputDialog("Digite o email do remetente");
            texto = JOptionPane.showInputDialog("Digite o texto da mensagem");

            anonimaString = JOptionPane.showInputDialog("A mensagem é anônima? (sim/não)").strip().toLowerCase();
            anonima = anonimaString.equals("sim");
            sistema.enviarMensagemParaTodos(texto, emailRemetente, anonima);

        } catch (MaximoDeMensagensException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (AmigoInexistenteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        for (Mensagem mensagem : sistema.pesquisaMensagensAnonimas()) {
            JOptionPane.showMessageDialog(null, mensagem.getTextoCompletoAExibir());
        }
    }
}