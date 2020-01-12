package tabela;

import java.util.ArrayList;
import java.util.Date;

import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import projekat.Student;

public class StudentiTabelaModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;

	private static String[] naziviKolona = {"Ime", "Prezime",  "Datum rodjenja", "Adresa stanovanja", "Telefon", "E-mail","Broj indeksa", "Datum upisa", "Trenutna godina studija","Status studenta","Prosecna ocena", "Spisak predmeta koje slusa"};
	private static Class[] tipoviKolona = {String.class,String.class,Date.class,String.class,String.class,String.class,String.class,Date.class,String.class,Status.class,Double.class, JButton.class};
	private ArrayList<Student> studenti = new ArrayList<Student>();
	
	public StudentiTabelaModel(ArrayList<Student> studenti) {
		// TODO Auto-generated constructor stub
		this.studenti=studenti;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return naziviKolona.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return studenti.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Student student=studenti.get(rowIndex);
		
		switch(columnIndex) {
		case 0:
			return student.getIme();
		case 1:
			return student.getPrezime();
		case 2:
			return student.getDatumRodjenja();
		case 3:
			return student.getAdresaStanovanja();
		case 4:
			return student.getTelefon();
		case 5:
			return student.getEmail();
		case 6:
			return student.getBrojIndeksa();
		case 7:
			return student.getDatumUpisa();
		case 8:
			return student.getGodinaStudija();
		case 9:
			return student.getStatus();
		case 10:
			return student.getProsecnaOcena();
		case 11:
			JButton studenti = new JButton(String.valueOf(student.getBrojIndeksa()));
			return studenti;
		}
		return null;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return tipoviKolona[columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return naziviKolona[column];
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}

}
