package br.com.nycdev;

import javax.swing.*;
import java.awt.*;

public class AgendaGUI extends JFrame {
    AgendaGUI() {
        setTitle("Agenda de aniversários");
        setSize(450,200);
        setLocation(150,150);
        setResizable(false);
        getContentPane().setBackground(Color.lightGray);
    }

    public static void main(String[] args){
        AgendaGUI a = new AgendaGUI();
        a.setVisible(true);
    }
}

