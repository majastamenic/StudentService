package projekat;


import java.sql.Date;
import java.util.ArrayList;



public class MyApp {

	static ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
	static ArrayList<Profesor> profesori = new ArrayList<Profesor>();
	static ArrayList<Student> studenti = new ArrayList<Student>();

	
	public static void main(String[] args) {
		
//		predmeti = Util.ucitajPredmet();
//		profesori = Util.ucitajProfesore();
//		studenti= Util.ucitajStudente();
		
		
		test();
	//	predmeti.get(0).getSpisakStudenata().add(studenti.get(0));
	//	predmeti.get(0).getSpisakStudenata().add(studenti.get(1));

	
		
		MainFrame mainframe = MainFrame.getInstance();
		mainframe.setVisible(true);
		
		
		
	}
	
	//Metoda za proveru funkcionalnosti klasa Predmet, Profesor i Student.
	public static void test() {
		Student student1=new Student("Maja", "Stamenic",new Date(12,4,1998), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA60-2017", new Date(12,4,1998), 3, Status.B, 9.09 , new ArrayList<Predmet>());
		studenti.add(student1);
		
		Student student2=new Student("Marija", "Milanovic",new Date(12,4,1998), "Papa Pavla 28", "021456245", "marija.milanovic@gmail.com", "RA197-2017", new Date(12,4,1998), 3, Status.B, 9.06 , new ArrayList<Predmet>());
		studenti.add(student2);
		
		Profesor profesor1 = new Profesor("Rade", "Doroslovacki", new Date(12,4,1998), "bul. Mihajla Pupina 1.", "021/485-2055", "rade.doroslovacki@uns.ac.rs", "Trg Dositeja Obradovica 6.", 123456789L, "doktor nauka", "redovni profesor", new ArrayList<Predmet>());
		Profesor profesor2 = new Profesor("Nebojsa", "Ralevic",new Date(12,4,1998), "bul Oslobodjenja 2.", "021/654-987", "nebojsa.ralevic@uns.ac.rs", "Cirpanova 34.", 234567891L, "doktor nauka", "redovni profesor", new ArrayList<Predmet>());
		Profesor profesor3 = new Profesor("Mila", "Stojakovic", new Date(12,4,1998), "Stanoja Glavasa 13.", "021/453-345", "mila@uns.ac.rs", "Maksima Gorkog 2.", 345678912L, "doktor nauka", "redovni profesor", new ArrayList<Predmet>());
		Profesor profesor4 = new Profesor("Srdjan", "Milicevic", new Date(12,4,1998), "Kraljevica Marka 56.", "021/476-521", "srdjan.milicevic88@gmail.com", "Kralja Petra Prvog 4.", 456789123L, "doktor nauka", "asistent",new ArrayList<Predmet>());
		Profesor profesor5 = new Profesor("Slobodan", "Supic", new Date(12,4,1998), "Gorana Kovacica 45.", "021/948-234", "ssupic@uns.ac.rs", "Dunavska 3.", 567891234L, "doktor nauka", "asistent", new ArrayList<Predmet>());
		
		Predmet predmet1 = new Predmet("M23","Algebra", 1, 2, null);
		Predmet predmet2 = new Predmet("M24","Matematicka analiza 1", 2, 3, null);
		Predmet predmet3 = new Predmet("M25","Matematicka analiza 2", 3, 4, null);
		Predmet predmet4 = new Predmet("M26","Diskretna matematika", 4, 5, null);
		Predmet predmet5 = new Predmet("M27","Geodezija", 1, 2, null);
		Predmet predmet6 = new Predmet("M28","Finansijska matematika", 2, 3, null);
		Predmet predmet7 = new Predmet("M29","Nacrtna geometrija", 3, 4, null);
		Predmet predmet8 = new Predmet("M30","Fizika", 4, 5, null);
		Predmet predmet9 = new Predmet("M31","Programski prevodioci", 4, 7, null);
		
		
		profesor1.getSpisakPredmeta().add(predmet1);
		profesor1.getSpisakPredmeta().add(predmet5);
		
		profesor2.getSpisakPredmeta().add(predmet2);
		profesor2.getSpisakPredmeta().add(predmet7);
		profesor2.getSpisakPredmeta().add(predmet9);
		
		profesor3.getSpisakPredmeta().add(predmet3);
		profesor3.getSpisakPredmeta().add(predmet8);
		
		profesor4.getSpisakPredmeta().add(predmet4);
		
		profesor5.getSpisakPredmeta().add(predmet6);
		
		student1.getSpisakPredmetaKojeSlusa().add(predmet1);
		student1.getSpisakPredmetaKojeSlusa().add(predmet2);
		student1.getSpisakPredmetaKojeSlusa().add(predmet4);
		student1.getSpisakPredmetaKojeSlusa().add(predmet6);
		student1.getSpisakPredmetaKojeSlusa().add(predmet8);
		student1.getSpisakPredmetaKojeSlusa().add(predmet9);
		
		student2.getSpisakPredmetaKojeSlusa().add(predmet1);
		student2.getSpisakPredmetaKojeSlusa().add(predmet3);
		student2.getSpisakPredmetaKojeSlusa().add(predmet5);
		student2.getSpisakPredmetaKojeSlusa().add(predmet7);
		student2.getSpisakPredmetaKojeSlusa().add(predmet9);
		
		
		predmet1.setPredmetniProfesor(profesor1);
		predmet5.setPredmetniProfesor(profesor1);
		predmet2.setPredmetniProfesor(profesor2);
		predmet7.setPredmetniProfesor(profesor2);
		predmet9.setPredmetniProfesor(profesor2);

		predmet3.setPredmetniProfesor(profesor3);
		predmet8.setPredmetniProfesor(profesor3);
		predmet4.setPredmetniProfesor(profesor4);
		predmet6.setPredmetniProfesor(profesor5);
		
		predmet1.getSpisakStudenata().add(student1);
		predmet1.getSpisakStudenata().add(student2);
		predmet2.getSpisakStudenata().add(student1);
		predmet3.getSpisakStudenata().add(student2);
		predmet4.getSpisakStudenata().add(student1);
		predmet5.getSpisakStudenata().add(student2);
		predmet6.getSpisakStudenata().add(student1);
		predmet7.getSpisakStudenata().add(student2);
		predmet8.getSpisakStudenata().add(student1);
		predmet9.getSpisakStudenata().add(student1);
		predmet9.getSpisakStudenata().add(student2);
		
		
		
		profesori.add(profesor1);
		profesori.add(profesor2);
		profesori.add(profesor3);
		profesori.add(profesor4);
		profesori.add(profesor5);
		
		predmeti.add(predmet1);
		predmeti.add(predmet2);
		predmeti.add(predmet3);
		predmeti.add(predmet4);
		predmeti.add(predmet5);
		predmeti.add(predmet6);
		predmeti.add(predmet7);
		predmeti.add(predmet8);
		predmeti.add(predmet9);
		
		
		
		ArrayList<Student> studentiKojiSlusajuPredmet1 = new ArrayList<Student>();
		ArrayList<Student> studentiKojiSlusajuPredmet2 = new ArrayList<Student>();
		ArrayList<Student> studentiKojiSlusajuPredmet3 = new ArrayList<Student>();
		ArrayList<Student> studentiKojiSlusajuPredmet4 = new ArrayList<Student>();
		ArrayList<Student> studentiKojiSlusajuPredmet5 = new ArrayList<Student>();
		ArrayList<Student> studentiKojiSlusajuPredmet6 = new ArrayList<Student>();
		ArrayList<Student> studentiKojiSlusajuPredmet7 = new ArrayList<Student>();
		ArrayList<Student> studentiKojiSlusajuPredmet8 = new ArrayList<Student>();
		ArrayList<Student> studentiKojiSlusajuPredmet9 = new ArrayList<Student>();
		
//		ArrayList<Predmet> predmetiKojePredajeProfesor1 = new ArrayList<Predmet>();
//		ArrayList<Predmet> predmetiKojePredajeProfesor2 = new ArrayList<Predmet>();
//		ArrayList<Predmet> predmetiKojePredajeProfesor3 = new ArrayList<Predmet>();
//		ArrayList<Predmet> predmetiKojePredajeProfesor4 = new ArrayList<Predmet>();
//		ArrayList<Predmet> predmetiKojePredajeProfesor5 = new ArrayList<Predmet>();
//		
//		predmetiKojePredajeProfesor1.add(predmet1);
//		predmetiKojePredajeProfesor1.add(predmet6);
//		predmetiKojePredajeProfesor2.add(predmet2);
//		predmetiKojePredajeProfesor2.add(predmet7);
//		predmetiKojePredajeProfesor3.add(predmet3);
//		predmetiKojePredajeProfesor3.add(predmet8);
//		predmetiKojePredajeProfesor4.add(predmet4);
//		predmetiKojePredajeProfesor4.add(predmet8);
//		predmetiKojePredajeProfesor5.add(predmet5);
		
//		predmet1.setPredmetniProfesor(profesor1);
//		predmet2.setPredmetniProfesor(profesor2);
//		predmet3.setPredmetniProfesor(profesor3);
//		predmet4.setPredmetniProfesor(profesor4);
//		predmet5.setPredmetniProfesor(profesor5);
//		predmet6.setPredmetniProfesor(profesor1);
//		predmet7.setPredmetniProfesor(profesor2);
//		predmet8.setPredmetniProfesor(profesor3);
//		predmet9.setPredmetniProfesor(profesor4);
		
//		predmet1.getSpisakStudenata().add(student1);
//		predmet1.getSpisakStudenata().add(student2);
//		predmet2.getSpisakStudenata().add(student1);
//		predmet3.getSpisakStudenata().add(student2);
//		predmet4.getSpisakStudenata().add(student1);
//		predmet5.getSpisakStudenata().add(student2);
//		predmet6.getSpisakStudenata().add(student1);
//		predmet7.getSpisakStudenata().add(student2);
//		predmet8.getSpisakStudenata().add(student1);
//		predmet9.getSpisakStudenata().add(student2);
//		
//		studentiKojiSlusajuPredmet1.add(student1);
//		studentiKojiSlusajuPredmet1.add(student2);
//		studentiKojiSlusajuPredmet2.add(student1);
//		studentiKojiSlusajuPredmet3.add(student2);
//		studentiKojiSlusajuPredmet4.add(student1);
//		studentiKojiSlusajuPredmet5.add(student2);
//		studentiKojiSlusajuPredmet6.add(student1);
//		studentiKojiSlusajuPredmet7.add(student2);
//		studentiKojiSlusajuPredmet8.add(student1);
//		studentiKojiSlusajuPredmet9.add(student2);
//		
//		profesor1.setSpisakPredmeta(predmetiKojePredajeProfesor1);
//		profesor2.setSpisakPredmeta(predmetiKojePredajeProfesor2);
//		profesor3.setSpisakPredmeta(predmetiKojePredajeProfesor3);
//		profesor4.setSpisakPredmeta(predmetiKojePredajeProfesor4);
//		profesor5.setSpisakPredmeta(predmetiKojePredajeProfesor5);
//		
//		profesori.add(profesor1);
//		profesori.add(profesor2);
//		profesori.add(profesor3);
//		profesori.add(profesor4);
//		profesori.add(profesor5);
//		
//		predmeti.add(predmet1);
//		predmeti.add(predmet2);
//		predmeti.add(predmet3);
//		predmeti.add(predmet4);
//		predmeti.add(predmet5);
//		predmeti.add(predmet6);
//		predmeti.add(predmet7);
//		predmeti.add(predmet8);
//		predmeti.add(predmet9);
		
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
	
	
	
	
	
	

}
