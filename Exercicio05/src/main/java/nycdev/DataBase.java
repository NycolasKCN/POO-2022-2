package nycdev;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static final String pathLivros = "src/main/resources/db/livros.txt";

    public void gravarLivros(List<Livro> livros) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(pathLivros));
            out.writeObject(livros);
        } catch (FileNotFoundException e) {
            throw new IOException("Arquivo 'Livros.txt' não foi encontrado.");
        } catch (IOException e) {
          throw e;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public List<Livro> leLivros() throws IOException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(pathLivros));
            return (ArrayList<Livro>) in.readObject();
        } catch (FileNotFoundException e) {
            throw new IOException("Arquivo 'Livros.txt' não foi encontrado.");
        } catch (IOException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw new IOException("Classe dos objetos gravados não existe.");
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

}
