package projekat;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;



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
		
		final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));   // This line converts the given date into UTC time zone

		Student student1;
		try {
			student1 = new Student("Luka", "Jovanovic",sdf.parse("01-01-2000"), "Karadjordjeva 83, Novi Sad", "021/333-555", "luka.jovanovic@mailinator.com", "RA 1/2019", sdf.parse("01-07-2019"), 1, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student2=new Student("Sofija", "Petrovic",sdf.parse("16-05-2000"), "Milosa Pocerca 55, Sabac", "015/343-356", "sofija.petrovic@mailinator.com", "RA 5/2019", sdf.parse("11-07-2019"), 1, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student3=new Student("Stefan", "Nikolic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 3/2019", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student4=new Student("Dunja", "Ilic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 2/2019", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student5=new Student("Lazar", "Djordjevic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 4/2019", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			
			Student student6=new Student("Sara", "Pavlovic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 3/2018", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student7=new Student("Vuk", "Markovic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 15/2018", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student8=new Student("Teodora", "Popovic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 133/2017", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student9=new Student("Filip", "Stojanovic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 122/2017", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student10=new Student("Ana", "Zivkovic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 201/2017", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			
			Student student11=new Student("Viktor", "Jankovic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 1/2017", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student12=new Student("Petra", "Todorovic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 5/2017", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student13=new Student("Andrej", "Stankovic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 33/2017", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student14=new Student("Mila", "Ristic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 152/2016", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student15=new Student("Pavle", "Kostic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 104/2016", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			
			Student student16=new Student("Lena", "Kovacevic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 1/2016", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student17=new Student("Filip", "Zivkovic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 5/2016", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student18=new Student("Tara", "Dimitrijevic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 33/2015", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student19=new Student("Vasilije", "Micic",sdf.parse("12-4-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 102/2015", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
			Student student20=new Student("Lenka", "Jovic", sdf.parse("12-04-1998"), "Jug Bogdana 34", "021584481", "maja.stamenic@gmail.com", "RA 244/2016", sdf.parse("12-4-2008"), 3, Status.B, 9.09 , new ArrayList<Predmet>());
	//		new Date(12-4-1998).UTC(1998, 04, 12, 0, 0, 0)
			
		
			
			Profesor profesor1 = new Profesor("Aleksa", "Petkovic", sdf.parse("15-1-1965"), "Temerinska 15, Novi Sad", "021/334-990", "aleksa.petkovic@mailinator.com", "Dositeja Obradovica 6, Novi Sad, MI 105", "007198721", "Prof. dr", "Redovni profesor", new ArrayList<Predmet>());
			Profesor profesor2 = new Profesor("Jana", "Lazarevic",sdf.parse("25-2-1963"), "Jovana Cvijica 26, Novi Sad", "021/435-891", "jana.lazarevic@mailinator.com", "Dositeja Obradovica 6, Novi Sad, Nastavni blok 206", "008431903", "Prof dr.", "Redovni profesor", new ArrayList<Predmet>());
			Profesor profesor3 = new Profesor("Nadja", "Aleksic", sdf.parse("23-3-1973"), "Gunduliceva 75, Novi Sad", "021/730-172", "nadja.aleksic@mailinator.com", "Dositeja Obradovica 6, Novi Sad, NTP 307", "005671007", "Dr", "Vanredni profesor", new ArrayList<Predmet>());
			Profesor profesor4 = new Profesor("Djordje", "Spasojevic", sdf.parse("24- 8-1978"), "Sekspirova 44, Novi Sad", "021/514-893", "djordje.spasojevic@mailinator.com", "Dositeja Obradovica 6, Novi Sad, MI 118", "009999331", "Dr", "Vanredni profesor",new ArrayList<Predmet>());
			Profesor profesor5 = new Profesor("Elena", "Milenkovic", sdf.parse("8-11-1985"), "Tolstojeva 52, Novi Sad", "021/834-901", "elena.milenkovic@mailinator.com", "Dositeja Obradovica 6, Novi Sad, Nastavni blok 217", "003330976", "Dr", "Docent", new ArrayList<Predmet>());
			Profesor profesor6 = new Profesor("Teodor", "Mladenovic", sdf.parse("14-12-1983"), "Jovana Subotica 33, Novi Sad", "021/441-001", "teodor.mladenovic@mailinator.com", "Dositeja Obradovica 6, Novi Sad, NTP M35", "007441998", "Dr", "Docent", new ArrayList<Predmet>());
			
			Predmet predmet1 = new Predmet("OP301","Osnove programiranja", 1, 1, profesor1, new ArrayList<Student>());
			Predmet predmet2 = new Predmet("DM881","Diskretna matematika", 3, 2, profesor2, new ArrayList<Student>());
			Predmet predmet3 = new Predmet("PP007","Paralelno programiranje", 5, 3, profesor3, new ArrayList<Student>());
			Predmet predmet4 = new Predmet("RVP33","Racunarstvo visokih performansi", 7, 4, profesor4, new ArrayList<Student>());
			Predmet predmet5 = new Predmet("JSD91","Jezici specificni za domen", 8, 4, null, new ArrayList<Student>());
			
			student1.getSpisakPredmetaKojeSlusa().add(predmet1);
			student2.getSpisakPredmetaKojeSlusa().add(predmet1);
			student3.getSpisakPredmetaKojeSlusa().add(predmet1);
			student4.getSpisakPredmetaKojeSlusa().add(predmet1);
			
			student6.getSpisakPredmetaKojeSlusa().add(predmet2);
			student7.getSpisakPredmetaKojeSlusa().add(predmet2);
			student8.getSpisakPredmetaKojeSlusa().add(predmet2);
			student9.getSpisakPredmetaKojeSlusa().add(predmet2);
			
			student11.getSpisakPredmetaKojeSlusa().add(predmet3);
			student12.getSpisakPredmetaKojeSlusa().add(predmet3);
			student13.getSpisakPredmetaKojeSlusa().add(predmet3);
			student14.getSpisakPredmetaKojeSlusa().add(predmet3);
			
			student16.getSpisakPredmetaKojeSlusa().add(predmet4);
			student17.getSpisakPredmetaKojeSlusa().add(predmet4);
			student18.getSpisakPredmetaKojeSlusa().add(predmet4);
			student19.getSpisakPredmetaKojeSlusa().add(predmet4);
			
			profesor1.getSpisakPredmeta().add(predmet1);
			profesor2.getSpisakPredmeta().add(predmet2);
			profesor3.getSpisakPredmeta().add(predmet3);
			profesor4.getSpisakPredmeta().add(predmet4);
			
			predmet1.getSpisakStudenata().add(student1);
			predmet1.getSpisakStudenata().add(student2);
			predmet1.getSpisakStudenata().add(student3);
			predmet1.getSpisakStudenata().add(student4);
			
			predmet2.getSpisakStudenata().add(student6);
			predmet2.getSpisakStudenata().add(student7);
			predmet2.getSpisakStudenata().add(student8);
			predmet2.getSpisakStudenata().add(student9);
			
			predmet3.getSpisakStudenata().add(student11);
			predmet3.getSpisakStudenata().add(student12);
			predmet3.getSpisakStudenata().add(student13);
			predmet3.getSpisakStudenata().add(student14);
			
			predmet4.getSpisakStudenata().add(student16);
			predmet4.getSpisakStudenata().add(student17);
			predmet4.getSpisakStudenata().add(student18);
			predmet4.getSpisakStudenata().add(student19);
		
			
			studenti.add(student1);
			studenti.add(student2);
			studenti.add(student3);
			studenti.add(student4);
			studenti.add(student5);
			studenti.add(student6);
			studenti.add(student7);
			studenti.add(student8);
			studenti.add(student9);
			studenti.add(student10);
			studenti.add(student11);
			studenti.add(student12);
			studenti.add(student13);
			studenti.add(student14);
			studenti.add(student15);
			studenti.add(student16);
			studenti.add(student17);
			studenti.add(student18);
			studenti.add(student19);
			studenti.add(student20);
			
			profesori.add(profesor1);
			profesori.add(profesor2);
			profesori.add(profesor3);
			profesori.add(profesor4);
			profesori.add(profesor5);
			profesori.add(profesor6);
			
			predmeti.add(predmet1);
			predmeti.add(predmet2);
			predmeti.add(predmet3);
			predmeti.add(predmet4);
			predmeti.add(predmet5);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
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
