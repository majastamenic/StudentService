package dialozi;

import java.awt.Dimension;

import javax.swing.JDialog;

public class DialogIzmenaStudenta extends JDialog{

	private static final long serialVersionUID = 1L;

	public DialogIzmenaStudenta() {
		
		setTitle("Izmena predmeta");
		setSize(new Dimension(300, 200));
		setLocationRelativeTo(null);
		setVisible(true);
}
}
