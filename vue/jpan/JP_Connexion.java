package vue.jpan;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.constante.Constante;

import controller.ModelAndView;
import vue.mainframe.MainFrame;

public class JP_Connexion extends JPanelPerso implements ActionListener{

	/**
	 * Vue correspondant à la connexion
	 */
	private static final long serialVersionUID = -8241030884619610422L;


	private JTextField textFieldName;
	private JPasswordField passwordField;
	private JLabel labelInfo;


	/**
	 * Constructeur
	 * @param frame frame parente du panel
	 */
	public JP_Connexion(final ModelAndView mav) {
		super(mav);
		this.buildContentPane();

	}

	/**
	 * Méthode permettant d'ajouter les composants dans le panel de connexion
	 */
	private void buildContentPane(){
		this.frame.setLayout(new FlowLayout());

		this.labelInfo = new JLabel();
		this.add(this.labelInfo);

		this.textFieldName  = new JTextField();
		this.textFieldName.setColumns(10); //On lui donne un nombre de colonnes à afficher

		this.add(this.textFieldName);

		final JButton bouton = new JButton("Connexion");
		bouton.addActionListener(this);
		this.add(bouton);



	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		/*this.mav.addRequest(Constante.PSEUDO, this.textFieldName.getText());
		this.setMav(ConnexionControler.doPost(this.mav));*/
		if(this.mav.recupRequest(Constante.IDENTIFIANT_PERSONNE) != null){
			this.mav.setVue(new JP_Accueil(this.mav));
			this.mav.getVue().start();
		}else{
			this.labelInfo.setText(this.mav.getErreur());
			this.repaint();
		}
	}
}
