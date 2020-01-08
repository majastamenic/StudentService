package dialozi;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class DialogDodavanjeStudentaNaPredmet extends JDialog{

	private static final long serialVersionUID = 1L;
	
	public DialogDodavanjeStudentaNaPredmet() {
		
		setTitle("Dodavanje studenta na predmet");
		setSize(new Dimension(400, 200));
		setLocationRelativeTo(null);
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		add(new JLabel("Izaberi studenta: "));
		
		
		setVisible(true);
	}

}
