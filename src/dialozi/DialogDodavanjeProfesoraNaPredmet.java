package dialozi;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import projekat.Profesor;


public class DialogDodavanjeProfesoraNaPredmet extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DialogDodavanjeProfesoraNaPredmet() {
		setTitle("Dodavanje profesora na predmet");
		setSize(new Dimension(400, 200));
		setLocationRelativeTo(null);
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		add(new JLabel("Izaberi profesora: "));
		
		JComboBox<Profesor> profesoriComboBox = new JComboBox<Profesor>();
		ArrayList<Profesor> profesoriLista = Util.ucitajProfesore();
		
		for (Profesor profesor : profesoriLista) {
			profesoriComboBox.addItem(profesor);
		}
		
		setVisible(true);
		
		
	}
}
