package projekat;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;



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

		final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));   

		Student student1;
		try {
			
			student1 = new Student("Luka", "Jovanović",sdf.parse("01-01-2000"), "Karađorđeva 83, Novi Sad", "021/333-555", "luka.jovanovic@mailinator.com", "RA 1/2019", sdf.parse("01-07-2019"), "I (prva)" , 9.09 , new ArrayList<Predmet>(), false);
			Student student2=new Student("Sofija", "Petrović",sdf.parse("16-05-2000"), "Miloša Pocerca 55, Šabac", "015/343-356", "sofija.petrovic@mailinator.com", "RA 5/2019", sdf.parse("11-07-2019"), "I (prva)", 9.09, new ArrayList<Predmet>(), false);
			Student student3=new Student("Stefan", "Nikolić",sdf.parse("18-03-2000"), "Knez Mihajlova 16, Beograd", "011/9234-857", "stefan.nikolic@mailinator.com", "RA 3/2019", sdf.parse("03-07-2019"), "I (prva)", 9.09 , new ArrayList<Predmet>(), false);
			Student student4=new Student("Dunja", "Ilić",sdf.parse("11-11-2000"), "Petefi Šandora 15, Novi Sad", "021/433-958", "dunja.ilic@mailinator.com", "RA 2/2019", sdf.parse("01-07-2019"), "I (prva)", 9.09 , new ArrayList<Predmet>(), true);
			Student student5=new Student("Lazar", "Đorđević",sdf.parse("03-12-2000"), "Josip Broz Tito 13, Subotica", "024/333-559", "lazar.djordjevic@mailinator.com", "RA 4/2019", sdf.parse("06-07-2019"), "I (prva)", 9.09 , new ArrayList<Predmet>(), true);

			Student student6=new Student("Sara", "Pavlović",sdf.parse("03-12-1999"), "Vojvode Mišića 23, Šabac", "015/313-061", "sara.pavlovic@mailinator.com", "RA 3/2018", sdf.parse("01-07-2018"), "II (druga)",  9.09 , new ArrayList<Predmet>(), false);
			Student student7=new Student("Vuk", "Marković",sdf.parse("03-12-1999"), "Temerinska 133, Novi Sad", "021/351-091", "vuk.markovic@mailinator.com", "RA 15/2018", sdf.parse("11-07-2018"), "II (druga)",  9.09 , new ArrayList<Predmet>(), false);
			Student student8=new Student("Teodora", "Popović",sdf.parse("03-12-1998"), "Surepova 15, Šabac", "015/324-500", "teodora.popovic@mailinator.com", "RA 133/2017", sdf.parse("03-07-2017"), "II (druga)", 9.09 , new ArrayList<Predmet>(), true);
			Student student9=new Student("Filip", "Stojanović",sdf.parse("03-12-1998"), "Francuska 113, Beograd", "011/2333-900", "filip.stojanovic@mailinator.com", "RA 122/2017", sdf.parse("02-07-2017"), "II (druga)",  9.09 , new ArrayList<Predmet>(), true);
			Student student10=new Student("Ana", "Živković",sdf.parse("03-12-1998"), "Kralja Petra 20, Novi Sad", "021/231-114", "ana.zivkovic@mailinator.com", "RA 201/2017", sdf.parse("04-07-2017"), "II (druga)",  9.09 , new ArrayList<Predmet>(), true);

			Student student11=new Student("Viktor", "Janković",sdf.parse("03-12-1998"), "Gogoljeva 3, Novi Sad", "021/135-463", "viktor.jankovic@mailinator.com", "RA 1/2017", sdf.parse("01-07-2017"),"III (treca)",  9.09 , new ArrayList<Predmet>(), false);
			Student student12=new Student("Petra", "Todorović",sdf.parse("03-12-1998"), "Njegoševa 2, Novi Sad", "021/903-463", "petra.todorovic@mailinator.com", "RA 5/2017", sdf.parse("12-07-2017"), "III (treca)",  9.09 , new ArrayList<Predmet>(), false);
			Student student13=new Student("Andrej", "Stanković",sdf.parse("03-12-1998"), "Radoja Domanovića 5, Novi Sad", "021/731-067", "andrej.stankovic@mailinator.com", "RA 33/2017", sdf.parse("19-07-2017"), "III (treca)",  9.09 , new ArrayList<Predmet>(), false);
			Student student14=new Student("Mila", "Ristić",sdf.parse("03-12-1997"), "Vojvode Stepe 183, Beograd", "011/4333-800", "mila.ristic@mailinator.com", "RA 152/2016", sdf.parse("15-07-2016"), "III (treca)",  9.09 , new ArrayList<Predmet>(), true);
			Student student15=new Student("Pavle", "Kostić",sdf.parse("03-12-1997"), "Crnotravska 13, Beograd", "011/3130-007", "pavle.kostic@mailinator.com", "RA 104/2016", sdf.parse("06-07-2016"), "III (treca)",  9.09 , new ArrayList<Predmet>(), true);

			Student student16=new Student("Lena", "Kovačević",sdf.parse("03-12-1997"), "Bulevar Oslobođenja 143, Novi Sad", "021/5333-801", "lena.kovacevic@mailinator.com", "RA 1/2016", sdf.parse("01-07-2016"), "IV (cetvrta)",  9.09 , new ArrayList<Predmet>(), false);
			Student student17=new Student("Filip", "Živković",sdf.parse("03-12-1997"), "1300 Kaplara, Šabac", "015/333-500", "filip.zivkovic@mailinator.com", "RA 5/2016", sdf.parse("21-07-2016"), "IV (cetvrta)",  9.09 , new ArrayList<Predmet>(), false);
			Student student18=new Student("Tara", "Dimitrijević",sdf.parse("03-12-1996"), "Milovana Glišića, Valjevo", "014/303-007", "tara.dimitrijevic@mailinator.com", "RA 33/2015", sdf.parse("23-07-2015"),"IV (cetvrta)",  9.09 , new ArrayList<Predmet>(), true);
			Student student19=new Student("Vasilije", "Micić",sdf.parse("03-12-1996"), "Vuka Karadžića, Loznica", "015/101-909", "vasilije.micic@mailinator.com", "RA 102/2015", sdf.parse("04-07-2015"), "IV (cetvrta)",  9.09 , new ArrayList<Predmet>(), true);
			Student student20=new Student("Lenka", "Jović", sdf.parse("03-12-1997"), "Bulevar Mihajla Pupina, Novi Sad", "021/431-500", "lenka.jovic@mailinator.com", "RA 244/2016", sdf.parse("07-07-2016"), "IV (cetvrta)",  9.09 , new ArrayList<Predmet>(), true);
	//		new Date(12-4-1998).UTC(1998, 04, 12, 0, 0, 0)



			Profesor profesor1 = new Profesor("Aleksa", "Petković", sdf.parse("15-1-1965"), "Temerinska 15, Novi Sad", "021/334-990", "aleksa.petkovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, MI 105", "007198721", "Prof. dr", "Redovni profesor", new ArrayList<Predmet>());
			Profesor profesor2 = new Profesor("Jana", "Lazarević",sdf.parse("25-2-1963"), "Jovana Cvijića 26, Novi Sad", "021/435-891", "jana.lazarevic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, Nastavni blok 206", "008431903", "Prof dr.", "Redovni profesor", new ArrayList<Predmet>());
			Profesor profesor3 = new Profesor("Nađa", "Aleksić", sdf.parse("23-3-1973"), "Gundulićeva 75, Novi Sad", "021/730-172", "nadja.aleksic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 307", "005671007", "Dr", "Vanredni profesor", new ArrayList<Predmet>());
			Profesor profesor4 = new Profesor("Đorđe", "Spasojević", sdf.parse("24- 8-1978"), "Šekspirova 44, Novi Sad", "021/514-893", "djordje.spasojevic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, MI 118", "009999331", "Dr", "Vanredni profesor",new ArrayList<Predmet>());
			Profesor profesor5 = new Profesor("Elena", "Milenković", sdf.parse("8-11-1985"), "Tolstojeva 52, Novi Sad", "021/834-901", "elena.milenkovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, Nastavni blok 217", "003330976", "Dr", "Docent", new ArrayList<Predmet>());
			Profesor profesor6 = new Profesor("Teodor", "Mladenović", sdf.parse("14-12-1983"), "Jovana Subotića 33, Novi Sad", "021/441-001", "teodor.mladenovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP M35", "007441998", "Dr", "Docent", new ArrayList<Predmet>());

			Predmet predmet1 = new Predmet("OP301","Osnove programiranja", 1, 1, profesor1, new ArrayList<Student>());
			Predmet predmet2 = new Predmet("DM881","Diskretna matematika", 3, 2, profesor2, new ArrayList<Student>());
			Predmet predmet3 = new Predmet("PP007","Paralelno programiranje", 5, 3, profesor3, new ArrayList<Student>());
			Predmet predmet4 = new Predmet("RVP33","Računarstvo visokih performansi", 7, 4, profesor4, new ArrayList<Student>());
			Predmet predmet5 = new Predmet("JSD91","Jezici specifični za domen", 8, 4, null, new ArrayList<Student>());

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
	
	public static ArrayList<Student> getStudenti() {
		return studenti;
	}

	public static void setStudenti(ArrayList<Student> studenti) {
		MyApp.studenti = studenti;
	}


	
	
	
	

}
