package dialozi;

import java.awt.Dimension;

import javax.swing.JDialog;

public class DialogDodavanjeProfesora extends JDialog{

	private static final long serialVersionUID = 1L;

	public DialogDodavanjeProfesora() {
		setTitle("Dodavanje profesora");
		setSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
