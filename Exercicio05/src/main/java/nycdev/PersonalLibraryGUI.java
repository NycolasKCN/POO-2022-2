package nycdev;

import javax.swing.*;
import java.awt.*;

public class PersonalLibraryGUI extends JFrame {

    JLabel title, image;
    JMenuBar menuBar = new JMenuBar();
    ImageIcon reiImg = new ImageIcon("src/main/resources/assets/reiImg.png");


    PersonalLibraryGUI() {
        setSize(800,600);
        setLocation(300, 50);
        setResizable(false);
        setTitle("PersonalLibrary");
        setBackground(Color.lightGray);

        title = new JLabel("Bem vindo, User", JLabel.CENTER);
        title.setFont(new Font("serif", Font.BOLD, 28));
        image = new JLabel(reiImg, JLabel.CENTER);

        JMenu cadastrarMenu = new JMenu("Cadastrar");
        JMenuItem cadastraLivro = new JMenuItem("Cadastar novo livro");
        cadastrarMenu.add(cadastraLivro);
        JMenu pesquisaMenu = new JMenu("Pesquisar");
        JMenuItem pesquisaLivro = new JMenuItem("Pesquisar livro");
        pesquisaMenu.add(pesquisaLivro);
        JMenu excluirMenu = new JMenu("Excluir");
        JMenuItem excluirLivro = new JMenuItem("Excluir livro");
        excluirMenu.add(excluirLivro);

        menuBar.add(cadastrarMenu);
        menuBar.add(pesquisaMenu);
        menuBar.add(excluirMenu);

        setJMenuBar(menuBar);
        setLayout(new GridLayout(1,2));
        add(title);
        add(image);

    }

    public static void main(String[] args) {
        JFrame f = new PersonalLibraryGUI();
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
