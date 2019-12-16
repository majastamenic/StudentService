package projekat;

import java.awt.Dimension;
import java.sql.Date;
import java.util.ArrayList;

public class MyApp {

	static ArrayList<Predmet>predmeti = new ArrayList<Predmet>();
	
	public static void main(String[] args) {
		
		Profesor profa = new Profesor("Kata", "Jovanovic", new Date(1971, 9, 19), "Kneza Vlastimira 10.", "0655179970", "katajovanovic@gmail.com", "asywtdguyuew", 1234567891L, "maja", "ymaja", new ArrayList<Predmet>());
		
		Predmet predmet = new Predmet("M23","Matematika", 1, 1, profa, new ArrayList<String>());
		Predmet predmet1 = new Predmet("M24","Matematika", 1, 1, profa, new ArrayList<String>());
		Predmet predmet2 = new Predmet("M25","Matematika", 1, 1, profa, new ArrayList<String>());
		Predmet predmet3 = new Predmet("M26","Matematika", 1, 1, profa, new ArrayList<String>());
		Predmet.dodavanjePredmeta(predmet);
		Predmet.dodavanjePredmeta(predmet1);
		Predmet.dodavanjePredmeta(predmet2);
		Predmet.dodavanjePredmeta(predmet3);
		
		

		for (Predmet p : predmeti) {
			System.out.println(p.getSifra());
		}
		
		Predmet.brisanjePredmeta("M23");
		Predmet.izmenaPredmeta(new Predmet("M24","MISS", 1, 1, profa, new ArrayList<String>()));
		
		for (Predmet p : predmeti) {
			System.out.println(p.getSifra()+"   "+p.getNaziv());
		}
		
		MainFrame mainframe = new MainFrame();
		mainframe.setVisible(true);
		mainframe.setSize(new Dimension(500, 300));
		mainframe.setLocationRelativeTo(null);
	}
	
	

}
