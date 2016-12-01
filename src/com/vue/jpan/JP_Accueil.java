package com.vue.jpan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.constante.Constante;
import com.controller.ModelAndView;
import com.controller.ModifEvalControler;
import com.domain.Personne;

/**
 * Page correspondant a l'accueil de l'application apres connexion
 * @author laurent
 */
public class JP_Accueil extends JPanelPerso implements ActionListener, ListSelectionListener {
	private JTextField textFieldNote;
	private JButton boutonAnnuler;
	private JButton boutonValider;
	private Personne personne;
	private Personne papa;
	private JList<Personne> JListFils;
	private Personne exSelectedFils;

	/**
	 *
	 */
	private static final long serialVersionUID = 7147264270278260551L;


	/**
	 * Constructeur du pannel d'accueil
	 * @param mav
	 */
	public JP_Accueil(final ModelAndView mav) {
		super(mav);
		personne = (Personne) mav.recupSession(Constante.UTILISATEUR);
		papa= (Personne) mav.recupSession(Constante.PERE);
		exSelectedFils = null;
		this.buildContentPane();
	}

	/**
	 * Construit le panel
	 */
	private void buildContentPane(){
		GridLayout gridLayout = new GridLayout(6,1);
		this.frame.setLayout(gridLayout);

		this.add(new JLabel("Vous: "+ personne.getNom() + ' ' + personne.getPrenom())) ;
		this.add(new JLabel("Votre père: " + papa.getNom()+ ' '+ papa.getPrenom()));
		this.add(new JLabel("Votre évaluation: "+ personne.getEvaluation()));

		this.boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.addActionListener(this);
		this.add(boutonAnnuler);

		this.add(new JLabel("Vos fils: "));

		// Liste
		JListFils = new JList<Personne>();
		DefaultListModel<Personne> lmodel = new DefaultListModel<Personne>();
		for ( Personne p: personne.getFils()) {
			lmodel.addElement(p);
		}

		this.add(new JLabel("Evaluation de "));
		this.textFieldNote = new JTextField(10);

		boutonValider = new JButton("Valider");
		boutonValider.addActionListener(this);
		this.add(boutonValider);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		if(e.getSource().equals(this.boutonAnnuler)){
			this.mav.viderSession();
			this.mav.setVue(new JP_Connexion(this.mav));
			this.mav.getVue().start();
		}if(e.getSource().equals(this.boutonValider)){

		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if( e.getValueIsAdjusting() ) {
			if ( exSelectedFils != null ) {
				this.mav.addRequest(Constante.EXFILS,exSelectedFils);
				this.mav.addRequest(Constante.EVALUATION,textFieldNote.getText());
				ModifEvalControler.doPost(mav);
			}
			Personne fils = JListFils.getSelectedValue();
			textFieldNote.setText(fils.getEvaluation());

			exSelectedFils = fils;
		}
	}
}
