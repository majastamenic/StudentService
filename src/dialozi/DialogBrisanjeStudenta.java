package dialozi;

import java.awt.Dimension;

import javax.swing.JDialog;

public class DialogBrisanjeStudenta extends JDialog{

	private static final long serialVersionUID = 1L;

	public DialogBrisanjeStudenta() {
		setTitle("Brisanje studenta");
		setSize(new Dimension(300, 200));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
