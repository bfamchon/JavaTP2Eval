package com.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by baptiste on 30/11/16.
 * Hi
 */
public class Fenetre extends JFrame implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        System.out.println("CANCEL l'opération en cours > source: " + e.getSource().toString());
    }
    public Fenetre() {
        JPanel p = new MainPanel(this);
        add(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 700));
        this.setVisible(true);
    }
}
