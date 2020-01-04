package dialozi;

import java.awt.Dimension;

import javax.swing.JDialog;

public class DialogIzmenaProfesora extends JDialog{

	private static final long serialVersionUID = 1L;
	
	public DialogIzmenaProfesora() {
		
		setTitle("Izmena profesora");
		setSize(new Dimension(300, 200));
		setLocationRelativeTo(null);
		setVisible(true);
}

}
