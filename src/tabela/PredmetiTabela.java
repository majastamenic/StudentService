package tabela;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import projekat.Predmet;

public class PredmetiTabela extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PredmetiTabela(ArrayList<Predmet> predmeti) {
		PredmetiTabelaModel predmetiTabelaModel = new PredmetiTabelaModel(predmeti);
		this.setRowSelectionAllowed(true);
		//this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(predmetiTabelaModel);
		setAutoCreateRowSorter(true);
	}

}
