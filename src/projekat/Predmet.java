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

	public Predmet(String sifra, String naziv, int semestar, int godinaStudija, Profesor predmetniProfesor,
			ArrayList<Student> spisakStudenataKojiPohadjaju) {
		this();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;
		if (spisakStudenataKojiPohadjaju != null) {
			this.spisakStudenataKojiPohadjaju = spisakStudenataKojiPohadjaju;
		}

	}
//	Konstruktor bez liste studenata koji slusaju predmet.
	public Predmet(String sifra, String naziv, int semestar, int godinaStudija, Profesor predmetniProfesor) {
		this();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;

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

	public ArrayList<Student> getSpisakStudenata() {
		return spisakStudenataKojiPohadjaju;
	}

	public void setSpisakStudenata(ArrayList<Student> spisakStudenataKojiPohadjaju) {
		this.spisakStudenataKojiPohadjaju = spisakStudenataKojiPohadjaju;
	}

	@Override
	//Ne mogu postojati dva predmeta sa istim siframa.
	public boolean equals(Object obj) {
		return ((Predmet) obj).getSifra().equals(this.sifra);
	}

	public static boolean dodavanjePredmeta(Predmet predmet) {
		if (MyApp.predmeti.contains(predmet)) {							//ako u predmetima vec postoji uneti predmet
			return false;
		}
		for(Profesor profesor : MyApp.profesori) {						//Prolazimo kroz sve profesore u nasoj bazi profesora.
			if(predmet.getPredmetniProfesor().equals(profesor)) {		//Nadjemo profesora koji je predmetni profesor na unetom predmetu.
				profesor.getSpisakPredmeta().add(predmet);				//Kod profesora u spisak predmeta koje predaje dodamo uneti predmet.
			}
		}
		
		MyApp.predmeti.add(predmet);									//Dodamo predmet
		return true;
	}

	public static boolean brisanjePredmeta(String sifra) {
		for(Predmet predmet : MyApp.predmeti) {							//Prolazimo kroz sve predmete
			if(predmet.getSifra().equals(sifra)) {						//Nalazimo predmet koji treba da obrisemo
// 				Brisanje predmeta iz studenta
				for(Student studentKodKogTrebaObrisatiPredmet : MyApp.studenti) {					//Prolazimo kroz sve studente.
					if((studentKodKogTrebaObrisatiPredmet.getSpisakPredmetaKojeSlusa()!=null) 		//Ako kod studenta postoji spisak predmeta koje slusa i nije null
							&& studentKodKogTrebaObrisatiPredmet.getSpisakPredmetaKojeSlusa().contains(predmet)) {   //i ako taj spisak sadrzi predmet koji treba da se obrise					
						studentKodKogTrebaObrisatiPredmet.getSpisakPredmetaKojeSlusa().remove(predmet);		//Obrisati predmet iz spiska predmeta kod studenta
					}
				}
				//Brisanje predmeta iz profesora
				for(Profesor profesorIzKogTrebaObrisatiPredmet : MyApp.profesori) {					//Prolazimo kroz listu profesora.
					if((profesorIzKogTrebaObrisatiPredmet.getSpisakPredmeta()!=null) 				//Ako profesor ima spisak predmeta na kojima predaje koji nije null
							&& profesorIzKogTrebaObrisatiPredmet.getSpisakPredmeta().contains(predmet)) {	//i ako taj spisak sadrzi predmet koji treba da se obrise
						profesorIzKogTrebaObrisatiPredmet.getSpisakPredmeta().remove(predmet);		//Obrisati predmet iz spisak predmeta koje predaje profesor
						break;								//Postoji samo jedan predmetni profesor
					}
				}
				int i = MyApp.predmeti.indexOf(predmet);
				MyApp.predmeti.remove(i);
				return true;
			}
		}
		return false;
	}

	public static boolean izmenaPredmeta(Predmet p) {
		for (int i = 0; i <= MyApp.predmeti.size(); i++) {
			if (MyApp.predmeti.get(i).getSifra().equals(p.getSifra())) { // Pretraga po sifri.
				MyApp.predmeti.remove(i); 								// Brisemo prethodnu verziju prosledjenog objekta p.
				MyApp.predmeti.add(p); 									// Postavljamo novu verziju objekta.
				return true;
			}
		}
		return false;
	}

	public static boolean dodavanjeProfesora(Profesor profesor, String sifraPredmeta) {
		for (Predmet predmet : MyApp.predmeti) {
			if (predmet.getSifra().equals(sifraPredmeta)) {
				// Podesavanje u klasi profesor
				// Brisanje starog profesora ako je postojao
				if (predmet.getPredmetniProfesor() != null) { // Ako je vec bio postavljen profesor

					for (Profesor prof : MyApp.profesori) {
						if (predmet.getPredmetniProfesor().getBrojLicneKarte().equals(prof.getBrojLicneKarte())) {
							uklanjanjeProfesora(prof, sifraPredmeta);
							break;
						}
					}
				}
				// Dodavanje predmeta novom profesoru
				for (Profesor profesorKomeDodajemoPredmet : MyApp.profesori) {

					if (profesorKomeDodajemoPredmet.getBrojLicneKarte().equals(profesor.getBrojLicneKarte())) {
						profesorKomeDodajemoPredmet.getSpisakPredmeta().add(predmet);
						break;
					}
				}

				// Podesavanje u klasi predmet
				int index = MyApp.predmeti.indexOf(predmet);
				MyApp.predmeti.get(index).setPredmetniProfesor(profesor);

				return true;
			}
		}
		return false;
	}

	public static boolean uklanjanjeProfesora(Profesor profesor, String sifraPredmeta) {
		for (Predmet predmet : MyApp.predmeti) { 						//Prolazimo kroz predmete
			if (predmet.getSifra().equals(sifraPredmeta)) {				//Nadjemo predmet
				for (Profesor profesorIzKogTrebaObrisatiPredmet : MyApp.profesori) {	

					if (profesorIzKogTrebaObrisatiPredmet.getBrojLicneKarte().equals(profesor.getBrojLicneKarte())) {	//Nadjemo profesora kod koga brisemo predmet
						for (Predmet predmetKojiSeBriseIzProfesora : profesorIzKogTrebaObrisatiPredmet.getSpisakPredmeta()) {	//Prodjemo kroz njegovu listu predmeta

							if (predmetKojiSeBriseIzProfesora.getSifra().equals(sifraPredmeta)) {			//Kada nadjemo predmet u spisku predmeta koje profesor predaje
								int indexPredmeta = profesorIzKogTrebaObrisatiPredmet.getSpisakPredmeta()
										.indexOf(predmetKojiSeBriseIzProfesora);
								profesorIzKogTrebaObrisatiPredmet.getSpisakPredmeta().remove(indexPredmeta); // Obrisan predmet iz profesora																								
								break;
							}
						}
						break;
					}
				}
				int index = MyApp.predmeti.indexOf(predmet);
				MyApp.predmeti.get(index).setPredmetniProfesor(null);			//Postavljanje predmetnog profesora na null
				;

				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return sifra + " " + naziv;
	}
}
