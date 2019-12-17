package projekat;

import java.awt.Color;
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
	
	public static void main(String[] args) {
		
		MainFrame mainframe = new MainFrame();
		
		mainframe.setLocationRelativeTo(null);
		mainframe.setTitle("Studentska sluzba");
		
		ImageIcon img = new ImageIcon("Images/Icon5.png");
		Image image = img.getImage();
		Image newimg = image.getScaledInstance(330, 410,  java.awt.Image.SCALE_SMOOTH); //Podesavanje velicine ikonice.
		img = new ImageIcon(newimg);
		mainframe.setIconImage(img.getImage());
		
		mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);     			//Gasi aplikaciju prilikom zatvaranje mainFrame-a.
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimenzijaEkrana = toolkit.getScreenSize();
		mainframe.setSize(new Dimension(dimenzijaEkrana.width*3/4, dimenzijaEkrana.height*3/4));   //Podesavanje dimenzije ekrana.
		
		mainframe.setVisible(true);
		
		test();
	}
	
	//Metoda za proveru funkcionalnosti klasa Predmet i Profesor.
	public static void test() {
		Profesor profa = new Profesor("Kata", "Jovanovic", new Date(1971, 9, 19), "Kneza Vlastimira 10.", "0655179970", "katajovanovic@gmail.com", "asywtdguyuew", 1234L, "maja", "ymaja", new ArrayList<Predmet>());
		Profesor profesor = new Profesor("Nina", "Stamenic", new Date(1996, 12, 3), "Kneza Vlastimira 10.", "061453", "nist998@gmail.com", "MAJAguyuew", 5678L, "maja", "ymaja", new ArrayList<Predmet>());
		Profesor profesor1 = new Profesor("Nina", "Stamenic", new Date(1996, 12, 3), "Kneza Vlastimira 10.", "061453", "nist998@gmail.com", "MAJAguyuew", 9123L, "maja", "ymaja", new ArrayList<Predmet>());
		Profesor profesor2 = new Profesor("Nina", "Stamenic", new Date(1996, 12, 3), "Kneza Vlastimira 10.", "061453", "nist998@gmail.com", "MAJAguyuew", 4567L, "maja", "ymaja", new ArrayList<Predmet>());
		Profesor profesor3 = new Profesor("Nina", "Stamenic", new Date(1996, 12, 3), "Kneza Vlastimira 10.", "061453", "nist998@gmail.com", "MAJAguyuew", 8912L, "maja", "ymaja", new ArrayList<Predmet>());
		profesori.add(profa);
		profesori.add(profesor);
		profesori.add(profesor1);
		profesori.add(profesor2);
		profesori.add(profesor3);
		
		System.out.println("Dodati profesori");
		for (Profesor pr : profesori) {
			System.out.println(pr.getBrojLicneKarte());
		}
		
		System.out.println("               ");
		Profesor.brisanjeProfesora(9123L);
		
		System.out.println("Obrisan profesor 9123L");
		for (Profesor pr : profesori) {
			System.out.println(pr.getBrojLicneKarte());
		}
		
		Predmet predmet = new Predmet("M23","Matematika", 1, 1, profa, new ArrayList<String>());
		Predmet predmet1 = new Predmet("M24","Matematika", 1, 1, profa, new ArrayList<String>());
		Predmet predmet2 = new Predmet("M25","Matematika", 1, 1, profa, new ArrayList<String>());
		Predmet predmet3 = new Predmet("M26","Matematika", 1, 1, profa, new ArrayList<String>());
		Predmet.dodavanjePredmeta(predmet);
		Predmet.dodavanjePredmeta(predmet1);
		Predmet.dodavanjePredmeta(predmet2);
		Predmet.dodavanjePredmeta(predmet3);
		
		
		
		System.out.println("Dodati predmeti");
		for (Predmet p : predmeti) {
			System.out.println(p.getSifra());
		}
		
		Predmet.brisanjePredmeta("M23");
		System.out.println("Obrisan predmet M23");
		for (Predmet p : predmeti) {
			System.out.println(p.getSifra());
		}
		
		Predmet.izmenaPredmeta(new Predmet("M24","MISS", 1, 1, profa, new ArrayList<String>()));
		Predmet.dodavanjeProfesora(profesor, "M26");
		Predmet.uklanjanjeProfesora(profa, "M25");
		
		for (Predmet p : predmeti) {
			System.out.println(p.getSifra()+"   "+p.getNaziv()+"   ");
			if(p.getPredmetniProfesor() != null) {
				System.out.println(p.getPredmetniProfesor().getIme());
			}
		}
	}
	
	

}
