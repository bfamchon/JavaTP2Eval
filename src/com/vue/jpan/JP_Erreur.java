package com.vue.jpan;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.controller.ModelAndView;
import com.vue.mainframe.MainFrame;

public class JP_Erreur extends JPanelPerso implements ActionListener{

	/**
	 *
	 */
	private static final long serialVersionUID = 5881669386668368898L;
	private JLabel labelInfo;
	private final String messageErreur;

	/**
	 * Constructeur du pannel d'erreur
	 * @param mav
	 */
	public JP_Erreur(final ModelAndView mav) {
		super(mav);
		this.messageErreur = mav.getErreur();
		this.buildContentPane();
	}

	/**
	 * Construit le panel
	 */
	private void buildContentPane(){
		this.frame.setLayout(new FlowLayout());

		final JButton bouton = new JButton("Retour");
		bouton.addActionListener(this);
		this.add(bouton);


		this.labelInfo = new JLabel();
		this.labelInfo.setText(this.messageErreur);
		this.labelInfo.setForeground(Color.red);
		this.add(this.labelInfo);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		this.mav.getVue().start();
	}

}
