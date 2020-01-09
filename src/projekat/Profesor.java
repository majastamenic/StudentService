package projekat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Profesor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ime;
	private String prezime;
	private Date datumRodjenja; 
	private String adresaStanovanja;
	private String telefon;
	private String email;
	private String adresaKancelarije;
	private String brojLicneKarte;
	private String titula;
	private String zvanje;
	private ArrayList<Predmet> spisakPredmetaNaKojimaPredaje;
	
	public Profesor() {
		spisakPredmetaNaKojimaPredaje = new ArrayList<Predmet>();
	}
	
	public Profesor(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon, String email,String adresaKancelarije, String brojLicneKarte,
			String titula, String zvanje, ArrayList<Predmet> spisakPredmetaNaKojimaPredaje) {
		this();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.spisakPredmetaNaKojimaPredaje = spisakPredmetaNaKojimaPredaje;

	}

	public Profesor(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon, String email,String adresaKancelarije, String brojLicneKarte,
			String titula, String zvanje) {
		this();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
	}
	
	public ArrayList<Predmet> getSpisakPredmeta() {
		return spisakPredmetaNaKojimaPredaje;
	}
	
	public void setSpisakPredmeta(ArrayList<Predmet> spisakPredmetaNaKojimaPredaje) {
		this.spisakPredmetaNaKojimaPredaje = spisakPredmetaNaKojimaPredaje;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		return ((Profesor)obj).getBrojLicneKarte().equals(this.brojLicneKarte);
	}

	public static boolean brisanjeProfesora(String brojLicneKarte) {
		for(Profesor profesor : MyApp.profesori) {
			if(profesor.getBrojLicneKarte().equals(brojLicneKarte)) {
				for(Predmet predmetKodKogTrebaObrisatiProfesora : MyApp.predmeti) {
					if((predmetKodKogTrebaObrisatiProfesora.getPredmetniProfesor()!=null) && predmetKodKogTrebaObrisatiProfesora.getPredmetniProfesor().equals(profesor)) {
						predmetKodKogTrebaObrisatiProfesora.setPredmetniProfesor(null);
						continue;
					}
				}
				int i = MyApp.profesori.indexOf(profesor);
				MyApp.profesori.remove(i);
				return true;
			}
		}
		return false;
	}

	public static boolean dodavanjeProfesora(Profesor profesor) {
		if(MyApp.profesori.contains(profesor)) {
			return false;
		}
		MyApp.profesori.add(profesor);
		return true;
	}

	public static boolean izmenaProfesora(Profesor p) {
		for(int i = 0; i <= MyApp.profesori.size(); i++) {
			if(MyApp.profesori.get(i).getBrojLicneKarte().equals(p.getBrojLicneKarte())) {
				MyApp.profesori.remove(i);
				MyApp.profesori.add(p);
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return brojLicneKarte + " " + ime + " " + prezime;
	}
	
	
	
}
