package projekat;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Admin
 *
 */
public class Predmet implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sifra;
	private String naziv;
	private int semestar;
	private int godinaStudija;
	private Profesor predmetniProfesor;
	
	private ArrayList<Student> spisakStudenataKojiPohadjaju;
	
	public Predmet() {
		spisakStudenataKojiPohadjaju = new ArrayList<Student>();
	}
	 
	public Predmet(String sifra, String naziv, int semestar, int godinaStudija, Profesor predmetniProfesor, ArrayList<Student> spisakStudenataKojiPohadjaju) {
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

	public ArrayList<Student> getSpisakStudenata(){
		return spisakStudenataKojiPohadjaju;
	}
	
	public void setSpisakStudenata(ArrayList<Student> spisakStudenataKojiPohadjaju) {
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
	
	public static boolean uklanjanjeProfesora(Profesor profesor, String sifraPredmeta) {
		for(int i = 0; i <= MyApp.predmeti.size(); i++) {
			if(MyApp.predmeti.get(i).getSifra().equals(sifraPredmeta)) {
				MyApp.predmeti.get(i).setPredmetniProfesor(null);;
				return true;
			}
		}
		return false;
	}
}
