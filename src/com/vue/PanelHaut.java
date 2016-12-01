package com.vue;

import com.vue.button.BTN_Annuler;
import com.vue.button.BTN_Valider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by baptiste on 30/11/16.
 * Hi
 */
public class PanelHaut extends JPanel{
    public PanelHaut(ActionListener maFrame) {
        this.setBackground(new Color(226, 226, 226));
        JButton btnNope = new BTN_Annuler();

        btnNope.addActionListener(maFrame);

        add(new JLabel("Vous: ")) ;
        add(new JLabel("Votre père: "));
        add(new JLabel("Votre évaluation: "));

        add(btnNope);

    }
}
