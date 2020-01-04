package dialozi;

import java.awt.Dimension;

import javax.swing.JDialog;

public class DialogUklanjanjeProfesoraSaPredmet extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DialogUklanjanjeProfesoraSaPredmet(){
		setTitle("Uklanjanje profesora sa predmeta");
		setSize(new Dimension(300, 200));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
