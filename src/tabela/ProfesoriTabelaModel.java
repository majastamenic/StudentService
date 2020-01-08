package tabela;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import projekat.Profesor;

public class ProfesoriTabelaModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String[] naziviKolona = {"Ime", "Prezime", "Datum rodjenja", "Adresa stanovanja", "Telefon", "E-mail", "Adresa kancelarije", "Broj licne karte", "Titula", "Zvanje", "Spisak predmeta na kojima predaje"};
	private static Class[] tipoviKolona = {String.class, String.class, Date.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, JButton.class};
	private ArrayList<Profesor> profesori = new ArrayList<Profesor>();
	
	public ProfesoriTabelaModel(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}

	@Override
	public int getColumnCount() {
		return naziviKolona.length;
	}

	@Override
	public int getRowCount() {
		return profesori.size();
	}

	@Override
	public Object getValueAt(int red, int kolona) {
		Profesor profesor = profesori.get(red);
		
		switch(kolona) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return profesor.getDatumRodjenja();
		case 3:
			return profesor.getAdresaStanovanja();
		case 4:
			return profesor.getTelefon();
		case 5:
			return profesor.getEmail();
		case 6:
			return profesor.getAdresaKancelarije();
		case 7:
			return profesor.getBrojLicneKarte();
		case 8:
			return profesor.getTitula();
		case 9:
			return profesor.getZvanje();
		case 10:
			JButton prikaziPredmete = new JButton(String.valueOf(profesor.getBrojLicneKarte()));
			return prikaziPredmete;
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
