package com.vue;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by baptiste on 30/11/16.
 * Hi
 */
public class MainPanel extends JPanel {
    public MainPanel(ActionListener maFrame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel haut = new PanelHaut(maFrame);
        add(haut);

    }
}
