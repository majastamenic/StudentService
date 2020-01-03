package dialozi;

import java.awt.Dimension;

import javax.swing.JDialog;

public class DialogDodavanjeStudenta extends JDialog{

	private static final long serialVersionUID = 1L;

	public DialogDodavanjeStudenta() {
		setTitle("Dodavanje studenta");
		setSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
