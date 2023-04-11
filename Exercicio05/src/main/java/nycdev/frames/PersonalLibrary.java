package nycdev.frames;

import nycdev.SistemaLivro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PersonalLibrary {
    JFrame mainFrame;
    JFrame cadastraFrame;
    JMenuBar menuBar = new JMenuBar();
    JLabel title, image;
    ImageIcon reiImg = new ImageIcon("src/main/resources/assets/reiImg.png");

    SistemaLivro sistema;

    public PersonalLibrary() {
        sistema = new SistemaLivro();
        configFrame();

        cadastraFrame = new CadastrarLivroFrame(sistema);


        JMenu cadastrarMenu = new JMenu("Cadastrar");
        JMenuItem cadastraLivro = new JMenuItem("Cadastar novo livro");
        cadastraLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastraFrame.setVisible(true);
            }
        });
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


    }

    public void configLabels(){
        title = new JLabel("Bem vindo, User", JLabel.CENTER);
        title.setFont(new Font("serif", Font.BOLD, 28));
        image = new JLabel(reiImg, JLabel.CENTER);

    }

    public void configFrame(){
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int resp = JOptionPane.showConfirmDialog(mainFrame, "Tem certeza de fechar?");
                if (resp == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        mainFrame.setBackground(Color.lightGray);
        mainFrame.setLocation(300, 50);
        mainFrame.setResizable(false);
        mainFrame.setSize(800,600);
        mainFrame.setTitle("PersonalLibrary");
        mainFrame.setJMenuBar(menuBar);
        mainFrame.setLayout(new GridLayout(1,2));
        mainFrame.add(title);
        mainFrame.add(image);
    }

    public void configCadastraFrame(){

    }

    public void run() {
        mainFrame.setVisible(true);
    }
    public static void main(String[] args) {
        PersonalLibrary o = new PersonalLibrary();
        o.run();
    }
}
