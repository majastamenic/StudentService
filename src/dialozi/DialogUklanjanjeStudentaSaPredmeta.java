package dialozi;

import java.awt.Dimension;

import javax.swing.JDialog;

public class DialogUklanjanjeStudentaSaPredmeta extends JDialog{

	private static final long serialVersionUID = 1L;

	public DialogUklanjanjeStudentaSaPredmeta(){
		setTitle("Uklanjanje studenta sa predmeta");
		setSize(new Dimension(300, 200));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
