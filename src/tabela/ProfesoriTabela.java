package tabela;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import projekat.Profesor;

public class ProfesoriTabela extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfesoriTabela(ArrayList<Profesor> profesori) {
		ProfesoriTabelaModel profesoriTabelaModel = new ProfesoriTabelaModel(profesori);
		this.setRowSelectionAllowed(true);
		//this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(profesoriTabelaModel);
		new ProfesorTabelaButton(this, 10);
	}
}
