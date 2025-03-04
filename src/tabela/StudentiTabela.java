package tabela;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import projekat.Student;

public class StudentiTabela extends JTable{

	private static final long serialVersionUID = 1L;

	public StudentiTabela(ArrayList<Student> studenti) {
		StudentiTabelaModel studentiTabelaModel = new StudentiTabelaModel(studenti);
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(studentiTabelaModel);
		new StudentiTabelaButton(this, 11); // postavljanje dugmeta u 11 kolonu tabele
		
		
		setAutoCreateRowSorter(true); //postavljanje sortera
	}

}
