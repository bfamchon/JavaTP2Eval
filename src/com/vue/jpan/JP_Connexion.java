package com.vue.jpan;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.constante.Constante;

import com.controller.ConnexionControler;
import com.controller.ModelAndView;

public class JP_Connexion extends JPanelPerso implements ActionListener{

	/**
	 * Vue correspondant a la connexion
	 */
	private static final long serialVersionUID = -8241030884619610422L;


	private JTextField textFieldName;
	private JLabel labelInfo;

	/**
	 * Constructeur
	 * @param mav
	 */
	public JP_Connexion(final ModelAndView mav) {
		super(mav);
		this.buildContentPane();

	}

	/**
	 * Methode permettant d'ajouter les composants dans le panel de connexion
	 */
	private void buildContentPane(){
		this.frame.setLayout(new FlowLayout());

		this.labelInfo = new JLabel("Votre id: ");
		this.add(this.labelInfo);

		this.textFieldName  = new JTextField();
		this.textFieldName.setColumns(10); //On lui donne un nombre de colonnes a afficher

		this.add(this.textFieldName);

		final JButton bouton = new JButton("Connexion");
		bouton.addActionListener(this);
		this.add(bouton);

	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		this.mav.addRequest(Constante.IDENTIFIANT_PERSONNE,this.textFieldName.getText());
		this.setMav(ConnexionControler.doPost(this.mav));
		if(this.mav.recupSession(Constante.UTILISATEUR) != null){
			this.mav.setVue(new JP_Accueil(this.mav));
			this.mav.getVue().start();
		}else{
			new JP_Erreur(this.mav).start();
		}
	}
}
