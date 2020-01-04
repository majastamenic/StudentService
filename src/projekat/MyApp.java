package projekat;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ObjectInputStream.GetField;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.WindowConstants;


public class MyApp {

	static ArrayList<Predmet>predmeti = new ArrayList<Predmet>();
	static ArrayList<Profesor> profesori = new ArrayList<Profesor>();
	static ArrayList<Student> studenti = new ArrayList<Student>();

	
	public static void main(String[] args) {
		
		predmeti = Util.ucitajPredmet();
		profesori = Util.ucitajProfesore();
		studenti= Util.ucitajStudente();
		//test();
	
		MainFrame mainframe = MainFrame.getInstance();
		mainframe.setVisible(true);
		
		
	}
	
	//Metoda za proveru funkcionalnosti klasa Predmet, Profesor i Student.
	public static void test() {
		Profesor profesor1 = new Profesor("Rade", "Doroslovacki", new Date(12,4,1998), "bul. Mihajla Pupina 1.", "021/485-2055", "rade.doroslovacki@uns.ac.rs", "Trg Dositeja Obradovica 6.", 123456789L, "doktor nauka", "redovni profesor", new ArrayList<Predmet>());
		Profesor profesor2 = new Profesor("Nebojsa", "Ralevic",new Date(12,4,1998), "bul Oslobodjenja 2.", "021/654-987", "nebojsa.ralevic@uns.ac.rs", "Cirpanova 34.", 234567891L, "doktor nauka", "redovni profesor", new ArrayList<Predmet>());
		Profesor profesor3 = new Profesor("Mila", "Stojakovic", new Date(12,4,1998), "Stanoja Glavasa 13.", "021/453-345", "mila@uns.ac.rs", "Maksima Gorkog 2.", 345678912L, "doktor nauka", "redovni profesor", new ArrayList<Predmet>());
		Profesor profesor4 = new Profesor("Srdjan", "Milicevic", new Date(12,4,1998), "Kraljevica Marka 56.", "021/476-521", "srdjan.milicevic88@gmail.com", "Kralja Petra Prvog 4.", 456789123L, "doktor nauka", "asistent", new ArrayList<Predmet>());
		Profesor profesor5 = new Profesor("Slobodan", "Supic", new Date(12,4,1998), "Gorana Kovacica 45.", "021/948-234", "ssupic@uns.ac.rs", "Dunavska 3.", 567891234L, "doktor nauka", "asistent", new ArrayList<Predmet>());
		profesori.add(profesor1);
		profesori.add(profesor2);
		profesori.add(profesor3);
		profesori.add(profesor4);
		profesori.add(profesor5);
		
		/*System.out.println("Dodati profesori");
		for (Profesor pr : profesori) {
			System.out.println(pr.getBrojLicneKarte());
		}*/
		
//		System.out.println("               ");
//		Profesor.brisanjeProfesora(567891234L);
//		
//		System.out.println("Obrisan profesor 567891234L");
//		for (Profesor pr : profesori) {
//			System.out.println(pr.getBrojLicneKarte());
//		}
		
		Predmet predmet1 = new Predmet("M23","Algebra", 1, 2, profesor1, new ArrayList<Student>());
		Predmet predmet2 = new Predmet("M24","Matematicka analiza 1", 2, 3, profesor2, new ArrayList<Student>());
		Predmet predmet3 = new Predmet("M25","Matematicka analiza 2", 3, 4, profesor3, new ArrayList<Student>());
		Predmet predmet4 = new Predmet("M26","Diskretna matematika", 4, 5, profesor4, new ArrayList<Student>());
		Predmet predmet5 = new Predmet("M26","Geodezija", 4, 7, profesor5, new ArrayList<Student>());
		Predmet.dodavanjePredmeta(predmet1);
		Predmet.dodavanjePredmeta(predmet2);
		Predmet.dodavanjePredmeta(predmet3);
		Predmet.dodavanjePredmeta(predmet4);
		Predmet.dodavanjePredmeta(predmet5);
		
		Student student1=new Student("Maja", "Stamenic",new Date(12,4,1998), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA60-2017", new Date(12,4,1998), 3, Status.B, 9.09 , new ArrayList<Predmet>());
		studenti.add(student1);		
		Student student2=new Student("Marija", "Milanovic",new Date(12,4,1998), "Papa Pavla 28", "021456245", "marija.milanovic@gmail.com", "RA197-2017", new Date(12,4,1998), 3, Status.B, 9.06 , new ArrayList<Predmet>());
		studenti.add(student2);
		
		/*System.out.println("Dodati studenti");
		for (Student s : studenti) {
			System.out.println(s.getBrojIndeksa());
		}*/
		
		
		/*System.out.println("Dodati predmeti");
		for (Predmet p : predmeti) {
			System.out.println(p.getSifra());
		}
		
		Predmet.brisanjePredmeta("M23");
		System.out.println("Obrisan predmet M23");
		for (Predmet p : predmeti) {
			System.out.println(p.getSifra());
		}
		
		Predmet.izmenaPredmeta(new Predmet("M24","MISS", 2, 3, profesor1, new ArrayList<String>()));
		Predmet.dodavanjeProfesora(profesor2, "M26");
		Predmet.uklanjanjeProfesora(profesor3, "M25");
		
		for (Predmet p : predmeti) {
			System.out.println(p.getSifra()+"   "+p.getNaziv()+"   ");
			if(p.getPredmetniProfesor() != null) {
				System.out.println(p.getPredmetniProfesor().getIme());
			}
		}*/
	}

	public static ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}
	
	public static void setPredmeti(ArrayList<Predmet> predmeti) {
		MyApp.predmeti = predmeti;
	}

	public static ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public static void setProfesori(ArrayList<Profesor> profesori) {
		MyApp.profesori = profesori;
	}
	
	public static ArrayList<Student> getStudenti() {
		return studenti;
	}
	
	public static void setStudenti(ArrayList<Student> studenti) {
		MyApp.studenti = studenti;
	}
	
	
	
	
	
	

}
