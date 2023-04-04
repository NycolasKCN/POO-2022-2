package nycdev;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase();

        List<Livro> list = new ArrayList<>();
        list.add(new Livro("Evangelion", "Hideaki anno"));
        list.add(new Livro("My broken Mariko", "Waka Hirako"));
//        try {
//            db.gravarLivros(list);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try {
            System.out.println(db.leLivros());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
