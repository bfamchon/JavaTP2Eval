package com.vue.jpan;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.constante.Constante;
import com.controller.ModelAndView;
import com.controller.ModifEvalControler;
import com.controller.ValiderControler;
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
		this.frame.setLayout(new BorderLayout());

		this.add(new JLabel("Vous: "+ personne.getPrenom() + ' ' + personne.getNom())) ;
		this.add(new JLabel("Votre père: " + papa.getPrenom()+ ' '+ papa.getNom()));
		this.add(new JLabel("Votre évaluation: "+ personne.getEvaluation()));

		this.boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.addActionListener(this);
		this.add(boutonAnnuler);

		this.add(new JLabel("Vos fils: "));

		JListFils = new JList<Personne>();
		DefaultListModel<Personne> lmodel = new DefaultListModel<Personne>();
		for ( Personne p: personne.getFils()) {
			lmodel.addElement(p);
		}
		JListFils = new JList<Personne>(lmodel);
		JListFils.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JListFils.setVisibleRowCount(5);
		JListFils.addListSelectionListener(this);
		JScrollPane listScrollPane = new JScrollPane(JListFils);

		this.add(listScrollPane);
		this.add(new JLabel("Evaluation de "));
		this.textFieldNote = new JTextField(10);
		this.add(this.textFieldNote);
		
		boutonValider = new JButton("Valider");
		boutonValider.addActionListener(this);
		this.add(boutonValider);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		if(e.getSource().equals(this.boutonAnnuler)){
			this.mav.addRequest(Constante.EXFILS,exSelectedFils);
			this.mav.addRequest(Constante.EVALUATION,textFieldNote.getText());
			ModifEvalControler.doPost(mav);
			this.mav.viderSession();
			this.mav.setVue(new JP_Connexion(this.mav));
			this.mav.getVue().start();
		}if(e.getSource().equals(this.boutonValider)){
			this.setMav(ValiderControler.doPost(this.mav));
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
