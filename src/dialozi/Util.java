
package dialozi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import projekat.Predmet;
import projekat.Profesor;
import projekat.Student;

public class Util {

	private static final File fileProfesori = new File("Text files/profesori.txt");
	private static final File filePredmeti = new File("Text files/predmeti.txt");
	private static final File fileStudenti = new File("Text files/studenti.txt");

	public static ArrayList<Profesor> ucitajProfesore() {
		ArrayList<Profesor> listaProfesora = new ArrayList<Profesor>();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileProfesori)));
			listaProfesora = (ArrayList<Profesor>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return listaProfesora;
	}

	public static ArrayList<Predmet> ucitajPredmet() {
		ArrayList<Predmet> listaPredmeta = new ArrayList<Predmet>();
		ObjectInputStream ois = null;
		// Pokusaj ucitavanja fajla i deserijalizacije
		try {
			ois  = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePredmeti)));
			listaPredmeta = (ArrayList<Predmet>)ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Pokusaj zatvaranja strima
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return listaPredmeta;
	}
	
	public static ArrayList<Student> ucitajStudente() {
		ArrayList<Student> listaStudenata = new ArrayList<Student>();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileStudenti)));
			listaStudenata = (ArrayList<Student>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return listaStudenata;
	}
	
	public static void upisiProfesore(ArrayList<Profesor> listaProfesora) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileProfesori)));
			oos.writeObject(listaProfesora);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void upisiPredmete(ArrayList<Predmet> listaPredmeta) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePredmeti)));
			oos.writeObject(listaPredmeta);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void upisiStudente(ArrayList<Student> listaStudenata) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileStudenti)));
			oos.writeObject(listaStudenata);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
