package dialozi;

import java.awt.Dimension;

import javax.swing.JDialog;

public class DialogBrisanjeProfesora extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DialogBrisanjeProfesora() {
		setTitle("Brisanje predmeta");
		setSize(new Dimension(300, 200));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
