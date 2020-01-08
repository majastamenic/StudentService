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
	public boolean equals(Object obj) {
		return ((Predmet) obj).getSifra().equals(this.sifra);
	}

	public static boolean dodavanjePredmeta(Predmet predmet) {
		if (MyApp.predmeti.contains(predmet)) {
			return false;
		}
		//TODO Dodati studente kad Tasa zavrsi 
		for(Profesor profesor : MyApp.profesori) {
			if(predmet.getPredmetniProfesor().equals(profesor)) {
				profesor.getSpisakPredmeta().add(predmet);
			}
		}
		MyApp.predmeti.add(predmet);
		return true;
	}

	public static boolean brisanjePredmeta(String sifra) {
		for(Predmet predmet : MyApp.predmeti) {
			if(predmet.getSifra().equals(sifra)) {
				//Brisanje predmeta iz studenta
				for(Student studentKodKogTrebaObrisatiPredmet : MyApp.studenti) {
					if(studentKodKogTrebaObrisatiPredmet.getSpisakPredmetaKojeSlusa().contains(predmet)) {
						studentKodKogTrebaObrisatiPredmet.getSpisakPredmetaKojeSlusa().remove(predmet);
						continue;
					}
				}
				//Brisanje predmeta iz profesora
				for(Profesor profesorIzKogTrebaObrisatiPredmet : MyApp.profesori) {
					if(profesorIzKogTrebaObrisatiPredmet.getSpisakPredmeta().contains(predmet)) {
						profesorIzKogTrebaObrisatiPredmet.getSpisakPredmeta().remove(predmet);
						break;
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
				MyApp.predmeti.remove(i); // Brisemo prethodnu verziju prosledjenog objekta p.
				MyApp.predmeti.add(p); // Postavljamo novu verziju objekta.
				return true;
			}
		}
		return false;
	}

	public static boolean dodavanjeProfesora(Profesor profesor, String sifraPredmeta) {
		for (Predmet predmet : MyApp.predmeti) {
			if (predmet.getSifra().equals(sifraPredmeta)) {
				// podesavanje u klasi profesor
				// brisanje starog profesora ako je postojao
				if (predmet.getPredmetniProfesor() != null) { // ako je vec bio postavljen profesor

					for (Profesor prof : MyApp.profesori) {
						if (predmet.getPredmetniProfesor().getBrojLicneKarte().equals(prof.getBrojLicneKarte())) {
							uklanjanjeProfesora(prof, sifraPredmeta);
							break;
						}
					}
				}
				// dodavanje predmeta novom profesoru
				for (Profesor profesorKomeDodajemoPredmet : MyApp.profesori) {

					if (profesorKomeDodajemoPredmet.getBrojLicneKarte().equals(profesor.getBrojLicneKarte())) {
						profesorKomeDodajemoPredmet.getSpisakPredmeta().add(predmet);
						break;
					}
				}

				// podesavanje u klasi predmet
				int index = MyApp.predmeti.indexOf(predmet);
				MyApp.predmeti.get(index).setPredmetniProfesor(profesor);

				return true;
			}
		}
		return false;
	}

	public static boolean uklanjanjeProfesora(Profesor profesor, String sifraPredmeta) {
		for (Predmet predmet : MyApp.predmeti) { // trazimo predmet koji se menja
			if (predmet.getSifra().equals(sifraPredmeta)) {
				for (Profesor profesorIzKogTrebaObrisatiPredmet : MyApp.profesori) {

					if (profesorIzKogTrebaObrisatiPredmet.getBrojLicneKarte().equals(profesor.getBrojLicneKarte())) {
						for (Predmet predmetKojiSeBriseIzProfesora : profesorIzKogTrebaObrisatiPredmet
								.getSpisakPredmeta()) {

							if (predmetKojiSeBriseIzProfesora.getSifra().equals(sifraPredmeta)) {
								int indexPredmeta = profesorIzKogTrebaObrisatiPredmet.getSpisakPredmeta()
										.indexOf(predmetKojiSeBriseIzProfesora);
								profesorIzKogTrebaObrisatiPredmet.getSpisakPredmeta().remove(indexPredmeta); // Obrisan
																												// predmet
																												// iz
																												// profesora
								break;
							}
						}
						break;
					}
				}
				int index = MyApp.predmeti.indexOf(predmet);
				MyApp.predmeti.get(index).setPredmetniProfesor(null);
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
