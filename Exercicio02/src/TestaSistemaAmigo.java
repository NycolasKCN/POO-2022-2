import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import exceptions.AmigoExistenteExeception;
import exceptions.AmigoInexistenteException;
import exceptions.MaximoDeMensagensException;
import sistema.Amigo;
import sistema.Mensagem;
import sistema.SistemaAmigo;

public class TestaSistemaAmigo {
    private static final String CAMINHO_ARQUIVO_AMIGOS = "amigos.txt";

    public static void main(String[] args) {
        SistemaAmigo sistemaAmigo = new SistemaAmigo(2);
        carregaAmigos(sistemaAmigo);

        
        try {
            sistemaAmigo.cadastraAmigo("José", "josé@gmail.com");
            sistemaAmigo.cadastraAmigo("Maria", "maria@gmail.com");
            sistemaAmigo.configuraAmigoSecretoDe("josé@gmail.com", "maria@gmail.com");

            sistemaAmigo.enviarMensagemParaAlguem("Olá José! Tudo bem?", "maria@gmail.com", "josé@gmail.com", true);
            sistemaAmigo.enviarMensagemParaTodos("Olá pessoal! Espero que estejam bem.", "maria@gmail.com", true);
            sistemaAmigo.enviarMensagemParaAlguem("Oi Carrol!", "Sidney@gmail.com", "carrol@gmail.com", false);
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
            System.out.println("Amigo não encontrado!");
        } catch (MaximoDeMensagensException e) {
            System.out.println(e.getMessage());
            System.out.println("Limite de mensagens atingido!");
        } catch (AmigoExistenteExeception e) {
            System.out.println(e.getMessage());
            System.out.println("Amigo já cadastrado!");
        }

        for (Mensagem mensagem : sistemaAmigo.pesquisaMensagensAnonimas()) {
            System.out.println(mensagem.getTextoCompletoAExibir());
        }

        try {
            Amigo a = sistemaAmigo.pesquisaAmigo("josé@gmail.com");
            Amigo b = sistemaAmigo.pesquisaAmigo("maria@gmail.com");

            if (a.getEmailAmigoSecreto().equals(b.getEmail())) {
                System.out.println("Amigo secreto de José é Maria");
            } else {
                System.out.println("Amigo secreto de José não é Maria");
            }
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
            System.out.println("Amigo não encontrado!");
        }

        System.out.println();

        sistemaAmigo.sortearAmigosSecretos();
        System.out.println("Nome - Email - Email do Amigo Secreto");
        for (Amigo amigo : sistemaAmigo.pesquisaTodosAmigos()) {
            System.out.println(amigo.getNome() + " - " + amigo.getEmail() + " - " + amigo.getEmailAmigoSecreto());
        }
    }

    public static void carregaAmigos(SistemaAmigo sistemaAmigo) {
        try (Scanner scan = new Scanner(new FileReader(CAMINHO_ARQUIVO_AMIGOS))) {
            while (scan.hasNextLine()) {
                String[] dados = scan.nextLine().split(";");
                sistemaAmigo.cadastraAmigo(dados[0], dados[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Arquivo não encontrado!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("erro inesperado.");
        }
    }
}
