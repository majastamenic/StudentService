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
	private Long brojLicneKarte;
	private String titula;
	private String zvanje;
	private ArrayList<Predmet> spisakPredmetaNaKojimaPredaje;
	
	public Profesor() {
		spisakPredmetaNaKojimaPredaje = new ArrayList<Predmet>();
	}
	
	public Profesor(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon, String email,String adresaKancelarije, Long brojLicneKarte, 
			String titula, String zvanje, ArrayList<Predmet> spisakPredmetaNaKojimaPredaje) {
		
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

	public Long getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(Long brojLicneKarte) {
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

	public static boolean brisanjeProfesora(Long brojLicneKarte) {
		for(int i = 0; i <= MyApp.profesori.size(); i++) {
			if(MyApp.profesori.get(i).getBrojLicneKarte().equals(brojLicneKarte)) {
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

	@Override
	public String toString() {
		return ime + " " + prezime + ", br.LK=" + brojLicneKarte;
	}
	
	
	
}
