package br.com.nycdev;

import javax.swing.*;
import java.awt.*;

public class AgendaGUI extends JFrame {
    AgendaGUI() {
        setTitle("Agenda de aniversários");
        setSize(450,450);
        setLocation(150,150);
        setResizable(false);
        getContentPane().setBackground(Color.lightGray);

        setLayout(new GridLayout(3,1));
        

        JLabel text = new JLabel("Agenda de Aniversarios");

        add(text);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        AgendaGUI a = new AgendaGUI();
        a.setVisible(true);
    }
}

