package dialozi;

import java.awt.Dimension;

import javax.swing.JDialog;

public class DialogIzmenaPredmeta extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DialogIzmenaPredmeta() {
		setTitle("Izmena predmeta");
		setSize(new Dimension(300, 200));
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
