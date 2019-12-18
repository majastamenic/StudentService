package projekat;

import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.JDialog;

public class DialogDodavanjePredmeta extends JDialog{
	
	public DialogDodavanjePredmeta() {
		// poljla forme dijaloga (naziv predmeta,...)
		
		setTitle("Dodavanje predmeta");
		setSize(new Dimension(300, 200));
//		TextField tf = new TextField("200");
//		
//		Predmet predmet = new Predmet();
//		predmet.setSemestar(Integer.parseInt(tf.getText()));
//		// na dugme pozivam metodu dodavanje predmeta
//		Predmet.dodavanjePredmeta(predmet);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
