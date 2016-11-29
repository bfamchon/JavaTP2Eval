package com.vue.mainframe;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Represente la Frame principal de l'application
 * @author laurent
 *
 */
public class MainFrame extends JFrame {
	private static final String TITRE_FENETRE_INITIAL = "TP COO Trimestre 1";
	/**
	 *
	 */
	private static final long serialVersionUID = 15220674368630040L;

	private static MainFrame instance = null;

	public static MainFrame getInstance(){
		if(instance == null ){
			instance = new MainFrame();
		}
		return instance;
	}

	/**
	 * Constructeur appele par le Main au lancement de l'application
	 */
	public MainFrame() {
		super(TITRE_FENETRE_INITIAL);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	public static void changerPanelFrame(final JFrame frame, final JPanel jpan){
		frame.getContentPane().removeAll();
		frame.getContentPane().add(jpan);
		frame.repaint();
		frame.revalidate();
		frame.setVisible(true);
	}
}
