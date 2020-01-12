package projekat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

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
	private String godinaStudija;
	private StatusStudenta status;
	private Double prosecnaOcena;
	private ArrayList<Predmet> spisakPredmetaKojeSlusa;
	private Boolean samofinansiranje;

	public Student() {
		spisakPredmetaKojeSlusa=new ArrayList<Predmet>();
	}

	public Student(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String brojIndeksa, Date datumUpisa, String godinaStudija,
			Double prosecnaOcena, ArrayList<Predmet> spisakPredmetaKojeSlusa,Boolean samofinansiranje) {
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
		this.prosecnaOcena = prosecnaOcena;
		this.spisakPredmetaKojeSlusa = spisakPredmetaKojeSlusa;
		this.samofinansiranje=samofinansiranje;
		if(samofinansiranje)
			this.status=StatusStudenta.S;
		else
			this.status=StatusStudenta.B;
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

	public String getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(String godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public StatusStudenta getStatus() {
		return status;
	}

	public void setStatus(StatusStudenta s) {
		this.status = s;
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
	
	public Boolean getSamofinansiranje() {
		return samofinansiranje;
	}

	public void setSamofinansiranje(Boolean samofinansiranje) {
		this.samofinansiranje = samofinansiranje;
	}


	public boolean equals(Object obj) {
		return ((Student)obj).getBrojIndeksa().equals(this.brojIndeksa);
	}

	public static boolean dodavanjeStudenta(Student student) {//proveravamo da li postoji student, ako ne postoji dodajemo ga
		if(MyApp.studenti.contains(student)) {
			return false;
		}
		MyApp.studenti.add(student);
		return true;

	
	}
	
	public static boolean brisanjeStudenta(String brojIndeksa) {//uzimamo studenta sa prosledjenim brojem indeksa, trazimo ga i uklanjamo
		for(int i=0; i<=MyApp.studenti.size(); i++) {
			if(MyApp.studenti.get(i).getBrojIndeksa().equals(brojIndeksa)) {	
				MyApp.studenti.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public static boolean izmenaStudenta(Student s) {	//trazimo studenta po ovom broju indeksa, uklanjamo starog, dodajemo novog
		for(int i = 0; i <= MyApp.studenti.size(); i++) {
			if(MyApp.studenti.get(i).getBrojIndeksa().equals(s.getBrojIndeksa())) {	
				MyApp.studenti.remove(i);								
				MyApp.studenti.add(s);									
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return brojIndeksa+" "+ime+" "+prezime;
	}
}
