package projekat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
enum Status {B,S};
public class Student implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String ime;
	private String prezime;
	private Date datumRodjenja; 
	private String adresaStanovanja;
	private String telefon;
	private String email;
	private String brojIndeksa;
	private Date datumUpisa;
	private Integer godinaStudija;
	private Status status;
	private Double prosecnaOcena;
	private ArrayList<Predmet> spisakPredmetaKojeSlusa;
	
	public Student() {
		spisakPredmetaKojeSlusa=new ArrayList<Predmet>();
	}

	public Student(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String brojIndeksa, Date datumUpisa, Integer godinaStudija, Status status,
			Double prosecnaOcena, ArrayList<Predmet> spisakPredmetaKojeSlusa) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.email = email;
		this.brojIndeksa = brojIndeksa;
		this.datumUpisa = datumUpisa;
		this.godinaStudija = godinaStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
		this.spisakPredmetaKojeSlusa = spisakPredmetaKojeSlusa;
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

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public Date getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public Integer getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(Integer godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(Double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public ArrayList<Predmet> getSpisakPredmetaKojeSlusa() {
		return spisakPredmetaKojeSlusa;
	}

	public void setSpisakPredmetaKojeSlusa(ArrayList<Predmet> spisakPredmetaKojeSlusa) {
		this.spisakPredmetaKojeSlusa = spisakPredmetaKojeSlusa;
	}
	
	/*public static boolean dodavanjeStudenta(Student student) {
		if(MyApp.studenti.contains(student)) {
			return false;
		}
		MyApp.studenti.add(student);
		return true;

	
	}*/
}