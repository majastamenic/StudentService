package projekat;

import java.util.ArrayList;

public class Predmet {
	private String sifra;
	private String naziv;
	private int semestar;
	private int godinaStudija;
	private Profesor predmetniProfesor;
	
	// TODO Zameniti string sa studentom.
	private ArrayList<String> spisakStudenataKojiPohadjaju;
	
	public Predmet() {
		spisakStudenataKojiPohadjaju = new ArrayList<String>();
	}
	
	public Predmet(String sifra, String naziv, int semestar, int godinaStudija, Profesor predmetniProfesor, ArrayList<String> spisakStudenataKojiPohadjaju) {
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;
		this.spisakStudenataKojiPohadjaju = spisakStudenataKojiPohadjaju;
		
	}
	
	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getSemestar() {
		return semestar;
	}

	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}

	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}

	public ArrayList<String> getSpisakStudenata(){
		return spisakStudenataKojiPohadjaju;
	}
	
	public void setSpisakStudenata(ArrayList<String> spisakStudenataKojiPohadjaju) {
		this.spisakStudenataKojiPohadjaju = spisakStudenataKojiPohadjaju;
	}
	
	
	
}
