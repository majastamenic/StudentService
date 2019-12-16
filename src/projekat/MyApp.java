package projekat;

import java.awt.Dimension;
import java.sql.Date;
import java.util.ArrayList;

public class MyApp {

	static ArrayList<Predmet>predmeti = new ArrayList<Predmet>();
	
	public static void main(String[] args) {
		
		Profesor profa = new Profesor("Kata", "Jovanovic", new Date(1971, 9, 19), "Kneza Vlastimira 10.", "0655179970", "katajovanovic@gmail.com", "asywtdguyuew", 1234567891L, "maja", "ymaja", new ArrayList<Predmet>());
		
		Predmet predmet = new Predmet("M23","Matematika", 1, 1, profa, new ArrayList<String>());
		Predmet.dodavanjePredmeta(predmet);

		for (Predmet p : predmeti) {
			System.out.println(p.getSifra());
		}
		
		MainFrame mainframe = new MainFrame();
		mainframe.setVisible(true);
		mainframe.setSize(new Dimension(500, 300));
		mainframe.setLocationRelativeTo(null);
	}
	
	

}
