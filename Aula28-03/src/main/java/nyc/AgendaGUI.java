package nyc;

import javax.swing.*;
import java.awt.*;

public class AgendaGUI extends JFrame {
    public AgendaGUI() {
        setTitle("Agenda pessoal");
        setSize(800, 600);
        setLocation(150, 200);
        setResizable(false);

        getContentPane().setBackground(Color.lightGray);
    }

    public static void main(String[] args) {
        JFrame janela = new AgendaGUI();

        janela.setVisible(true);
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
