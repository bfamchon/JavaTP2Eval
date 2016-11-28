package com.vue.jpan;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;


import com.controller.ModelAndView;
import com.vue.mainframe.MainFrame;

/**
 * Page correspondant � l'accueil de l'application apr�s connexion
 * @author laurent
 */
public class JP_Accueil extends JPanelPerso implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 7147264270278260551L;

	private JLabel labelInfo;

	/**
	 * Constructeur du pannel d'accueil
	 * @param mav
	 */
	public JP_Accueil(final ModelAndView mav) {
		super(mav);
		this.buildContentPane();
	}

	/**
	 * Construit le panel
	 */
	private void buildContentPane(){
		this.frame.setLayout(new FlowLayout());

		final JButton bouton = new JButton("Deconnexion");
		bouton.addActionListener(this);
		this.add(bouton);


		this.labelInfo = new JLabel();
		this.add(this.labelInfo);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		//Deconnexion
	}


}
