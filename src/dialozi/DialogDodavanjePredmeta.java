package dialozi;

import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class DialogDodavanjePredmeta extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DialogDodavanjePredmeta() {
		// poljla forme dijaloga (naziv predmeta,...)
		
		setTitle("Dodavanje predmeta");
		setSize(new Dimension(400, 300));
		
		JLabel labela1 = new JLabel("Sifra predmeta: ");
		
		labela1.setSize(50, 20);
		add(labela1);
		JLabel labela2 = new JLabel("Naziv predmeta: ");
		labela2.setSize(50, 20);
		add(labela2);
		JLabel labela3 = new JLabel("Broj semestra: ");
		labela3.setSize(50, 20);
		add(labela3);
		JLabel labela4 = new JLabel("Godina studija: ");
		labela3.setSize(50, 20);
		add(labela4);
		JLabel labela5 = new JLabel("Predmetni profesor: ");
		labela5.setSize(50, 20);
		add(labela5);

//		TextField tf = new TextField("200");
		
//		Predmet predmet = new Predmet();
//		predmet.setSemestar(Integer.parseInt(tf.getText()));
//		// na dugme pozivam metodu dodavanje predmeta
//		Predmet.dodavanjePredmeta(predmet);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
