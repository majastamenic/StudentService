package dialozi;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;


public class DialogDodavanjeProfesoraNaPredmet extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DialogDodavanjeProfesoraNaPredmet() {
		setTitle("Dodavanje profesora na predmet");
		setSize(new Dimension(300, 200));
		setLocationRelativeTo(null);
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		add(new JLabel("Izaberi profesora: "));
		
		
		setVisible(true);
		
		
	}
}
