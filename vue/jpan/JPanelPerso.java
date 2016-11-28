/**
 *
 */
package vue.jpan;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ModelAndView;
import vue.Vue;
import vue.mainframe.MainFrame;

/**
 * @author laurent
 *
 */
public abstract class JPanelPerso extends JPanel implements Vue {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected JFrame frame;
	protected ModelAndView mav;



	public JPanelPerso(final ModelAndView mav) {
		super();
		this.frame = MainFrame.getInstance();
		this.mav = mav;
	}

	public void start(){
		MainFrame.changerPanelFrame(this.frame,(JPanel) this.mav.getVue());
	}

	public JFrame getFrame() {
		return this.frame;
	}
	public void setFrame(final JFrame frame) {
		this.frame = frame;
	}
	public ModelAndView getMav() {
		return this.mav;
	}
	public void setMav(final ModelAndView mav) {
		this.mav = mav;
	}
}
