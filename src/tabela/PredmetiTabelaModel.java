package tabela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import projekat.Predmet;

public class PredmetiTabelaModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String[] naziviKolona = {"Sifra", "Naziv", "Semestar", "Godina Studija", "Predmetni profesor", "Studenti"};
	private static Class[] tipoviKolona = {String.class, String.class, Integer.class, Integer.class, String.class, JButton.class};
	private ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
	
	
	public PredmetiTabelaModel(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	@Override
	public int getColumnCount() {
		return naziviKolona.length;
	}

	@Override
	public int getRowCount() {
		return predmeti.size();
	}

	@Override
	public Object getValueAt(int red, int kolona) {
		Predmet predmet = predmeti.get(red);
		
		switch(kolona) {
		case 0:
			return predmet.getSifra();
		case 1:
			return predmet.getNaziv();
		case 2:
			return predmet.getSemestar();
		case 3:
			return predmet.getGodinaStudija();
		case 4:
			//Predmetni profesor moze da se dodaje i brise sa predmeta, jer moze biti null
			if(predmet.getPredmetniProfesor() != null) {
				return predmet.getPredmetniProfesor().getIme() + " " + predmet.getPredmetniProfesor().getPrezime();
			}
			return "";
		case 5:
			JButton prikaziStudente = new JButton(predmet.getSifra());
			return prikaziStudente;
		}
		return null;
	}

	// da bismo mogli prikazati dugme
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
  