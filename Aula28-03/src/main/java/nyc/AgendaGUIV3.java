package nyc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AgendaGUIV3 extends JFrame {
    JLabel linha1, linha2;
    JButton botaoAdicionar, botaoPesquisar, botaoRemover;
    ImageIcon reiIMG = new ImageIcon("imgs/chikita.png");
    ImageIcon addImg = new ImageIcon("imgs/person_add.png");
    ImageIcon pesqImg = new ImageIcon("imgs/person_search.png");
    ImageIcon removImg = new ImageIcon("imgs/person_remove.png");

    AgendaGUIV3() {
        setTitle("Agenda GUIV3");
        setSize(800, 600);
        setLocation(400, 100);

        getContentPane().setBackground(Color.BLACK);

        linha1 = new JLabel("Minha agenda!", JLabel.CENTER);
        linha1.setFont(new Font("Arial", Font.BOLD, 26));
        linha1.setForeground(new Color(67, 197, 217));
        linha2 = new JLabel(reiIMG, JLabel.CENTER);

        botaoAdicionar = new JButton("Adicionar", addImg);
        botaoAdicionar.setBorderPainted(false);
        botaoAdicionar.setFocusPainted(false);
        botaoPesquisar = new JButton("Pesquisar", pesqImg);
        botaoPesquisar.setBorderPainted(false);
        botaoPesquisar.setFocusPainted(false);
        botaoRemover = new JButton("Remover", removImg);
        botaoRemover.setBorderPainted(false);
        botaoRemover.setFocusPainted(false);

        setLayout(new GridLayout(3, 2));
        add(linha1);
        add(botaoAdicionar);
        add(linha2);
        add(botaoPesquisar);
        add(new JLabel());
        add(botaoRemover);

    }

    public static void main(String[] args) {
        JFrame f = new AgendaGUIV3();
        f.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int resp = JOptionPane.showConfirmDialog(f, "Tem certeza de fechar?");
                if (resp == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

}
