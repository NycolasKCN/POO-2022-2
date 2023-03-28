package nyc;

import javax.swing.*;
import java.awt.*;

public class AgendaGUIV2 extends JFrame {
    JLabel linha1, linha2;
    ImageIcon img = new ImageIcon("imgs/chikita.png");

    public AgendaGUIV2(){
        setTitle("Janela");
        setSize(800, 600);
        setLocation(900,20);
        setResizable(false);
        getContentPane().setBackground(Color.black);
        linha1 = new JLabel("Minha coleção de chiquitas", JLabel.CENTER);
        linha1.setForeground(new Color(67, 197, 217));
        linha1.setFont(new Font("Serif", Font.BOLD, 24));

        linha2 = new JLabel(img, JLabel.CENTER);


        getContentPane().setLayout(new GridLayout(3,1));
        getContentPane().add(linha1);
        getContentPane().add(linha2);
    }

    public static void main(String[] args) {
        JFrame frame = new AgendaGUIV2();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
