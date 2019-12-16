package projekat;

import java.util.ArrayList;

/**
 * @author Admin
 *
 */
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

	@Override
	public boolean equals(Object obj) {
		return ((Predmet)obj).getSifra().equals(this.sifra);
	}

	public static boolean dodavanjePredmeta(Predmet predmet) {
		if(MyApp.predmeti.contains(predmet)) {
			return false;
		}
		MyApp.predmeti.add(predmet);
		return true;
		
	}
	
	public static boolean brisanjePredmeta(String sifra) {
		for(int i=0; i<=MyApp.predmeti.size(); i++) {
			if(MyApp.predmeti.get(i).getSifra().equals(sifra)) {	
				MyApp.predmeti.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public static boolean izmenaPredmeta(Predmet p) {
		for(int i = 0; i <= MyApp.predmeti.size(); i++) {
			if(MyApp.predmeti.get(i).getSifra().equals(p.getSifra())) {	//Pretraga po sifri.
				MyApp.predmeti.remove(i);								//Brisemo prethodnu verziju prosledjenog objekta p.
				MyApp.predmeti.add(p);									//Postavljamo novu verziju objekta.
				return true;
			}
		}
		return false;
	}
	public static boolean dodavanjeProfesora(Profesor profesor, String sifraPredmeta) {
		for(int i = 0; i <= MyApp.predmeti.size(); i++) {
			if(MyApp.predmeti.get(i).getSifra().equals(sifraPredmeta)) {
				MyApp.predmeti.get(i).setPredmetniProfesor(profesor);
				return true;
			}
		}
		return false;
	}
}
