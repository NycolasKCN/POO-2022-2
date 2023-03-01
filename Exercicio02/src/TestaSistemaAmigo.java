import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import exceptions.AmigoInexistenteException;

public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigo sistemaAmigo = new SistemaAmigo();
        carregaAmigos(sistemaAmigo);

        sistemaAmigo.cadastraAmigo("José", "josé@gmail.com");
        sistemaAmigo.cadastraAmigo("Maria", "maria@gmail.com");

        try {
            sistemaAmigo.configuraAmigoSecretoDe("josé@gmail.com", "maria@gmail.com");
            sistemaAmigo.configuraAmigoSecretoDe("maria@gmail.com", "josé@gmail.com");

            sistemaAmigo.enviarMensagemParaAlguem("Olá José! Tudo bem?", "maria@gmail.com", "josé@gmail.com", true);
            sistemaAmigo.enviarMensagemParaTodos("Olá pessoal! Espero que estejam bem.", "maria@gmail.com", true);
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }

        for (Mensagem mensagem : sistemaAmigo.pesquisaMensagensAnonimas()) {
            System.out.println(mensagem.getTextoCompletoAExibir());
        }

        if (sistemaAmigo.pesquisaAmigo("josé@gmail.com").getEmailAmigoSecreto().equals("maria@gmail.com")) {
            System.out.println("Amigo secreto configurado corretamente!");
        }

        System.out.println();

        sistemaAmigo.sortearAmigoSecreto();
        System.out.println("Nome - Email - Email do Amigo Secreto");
        for (Amigo amigo : sistemaAmigo.pesquisaTodosAmigos()) {
            System.out.println(amigo.getNome() + " - " + amigo.getEmail() + " - " + amigo.getEmailAmigoSecreto());
        }
    }

    public static void carregaAmigos(SistemaAmigo sistemaAmigo) {
        try (Scanner scan = new Scanner(new FileReader("Exercicio02\\src\\amigos.txt"))) {
            while (scan.hasNextLine()) {
                String[] dados = scan.nextLine().split(";");
                sistemaAmigo.cadastraAmigo(dados[0], dados[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
            System.out.println();
        } catch (Exception e) {
            System.out.println("Erro ao carregar amigos: " + e);
        }
    }
}
