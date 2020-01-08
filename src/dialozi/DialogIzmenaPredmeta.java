package dialozi;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projekat.MainFrame;
import projekat.MyApp;
import projekat.Predmet;
import projekat.Profesor;
import projekat.Util;

public class DialogIzmenaPredmeta extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DialogIzmenaPredmeta(int indexUModelu) {
		setTitle("Izmena predmeta");
		setSize(new Dimension(400, 200));
		setLocationRelativeTo(null);
		
		ImageIcon img = new ImageIcon("Images/Icon5.png");
		Image image = img.getImage();
		Image newimg = image.getScaledInstance(330, 410, java.awt.Image.SCALE_SMOOTH); // Podesavanje velicine ikonice.
		img = new ImageIcon(newimg);
		setIconImage(img.getImage());
		
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		
		Predmet predmet = MyApp.getPredmeti().get(indexUModelu);
		JTextField nazivPolje = new JTextField(predmet.getNaziv());
		JTextField semestarPolje = new JTextField(Integer.toString(predmet.getSemestar()));
		JTextField godStudijaPolje = new JTextField(Integer.toString(predmet.getGodinaStudija()));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("Sifra: "), gbc);
//		add(sifraPolje, gbc);
		
		gbc.gridx = 1; // tacka(1, 0)
		JTextField sifraPolje = new JTextField(predmet.getSifra());
		sifraPolje.setMinimumSize(new Dimension(200, 20));
		sifraPolje.setMaximumSize(new Dimension(200, 20));
		sifraPolje.setPreferredSize(new Dimension(200, 20));
		sifraPolje.setEditable(false);
		add(sifraPolje, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		add(new JLabel("Naziv: "), gbc);
		
		gbc.gridx = 1; // tacka(1,1)
//		nazivPolje.setSize(100, 20);
		nazivPolje.setMinimumSize(new Dimension(200, 20));
		nazivPolje.setMaximumSize(new Dimension(200, 20));
		nazivPolje.setPreferredSize(new Dimension(200, 20));

		add(nazivPolje, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(new JLabel("Semestar: "), gbc);
		gbc.gridx = 1; // tacka(1,2)
		semestarPolje.setMinimumSize(new Dimension(200, 20));
		semestarPolje.setMaximumSize(new Dimension(200, 20));
		semestarPolje.setPreferredSize(new Dimension(200, 20));
		add(semestarPolje, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(new JLabel("Godina studija: "), gbc);		
		gbc.gridx = 1; // tacka(1,3)
		godStudijaPolje.setMinimumSize(new Dimension(200, 20));
		godStudijaPolje.setMaximumSize(new Dimension(200, 20));
		godStudijaPolje.setPreferredSize(new Dimension(200, 20));
		add(godStudijaPolje, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(new JLabel("Profesor: "), gbc);
		gbc.gridx = 1;
		JComboBox<Profesor> profesoriComboBox = new JComboBox<Profesor>();
		ArrayList<Profesor> profesoriLista = Util.ucitajProfesore();
		
		for (Profesor profesor : profesoriLista) {
			profesoriComboBox.addItem(profesor);
		}
		
		for (int i = 0; i < profesoriComboBox.getItemCount(); i++) {
			if(predmet.getPredmetniProfesor().getBrojLicneKarte().equals(profesoriComboBox.getItemAt(i).getBrojLicneKarte())) {
				profesoriComboBox.setSelectedIndex(i);
				break;
			}
		}
		profesoriComboBox.setMinimumSize(new Dimension(200, 20));
		profesoriComboBox.setMaximumSize(new Dimension(200, 20));
		profesoriComboBox.setPreferredSize(new Dimension(200, 20));
		//profesoriComboBox.addItem(new Profesor("Pera", "Peric", null, "Adresa 10", "7655778", "email", "adresaKancelarije", 76566L, null, null, null));
		add(profesoriComboBox, gbc);
		setLocationRelativeTo(null);
		
		JButton dugmeIzmena = new JButton("Sacuvaj");
		ActionListener izmenaAkcija = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sifra = sifraPolje.getText();
				String naziv = nazivPolje.getText();
				int semestar = Integer.parseInt(semestarPolje.getText());
				int godinaStudija = Integer.parseInt(godStudijaPolje.getText());
				Profesor profesor = (Profesor) profesoriComboBox.getSelectedItem();
				
//				Predmet predmet = new Predmet(sifra, naziv, semestar, godinaStudija, profesor);

				Predmet predmet = new Predmet();
				predmet.setSifra(sifra);
				predmet.setNaziv(naziv);
				predmet.setSemestar(semestar);
				predmet.setGodinaStudija(godinaStudija);
				predmet.setPredmetniProfesor(profesor);
				
				Predmet.izmenaPredmeta(predmet);
				
				MainFrame.refreshTabova();
				dispose();
				
			}
		};
		dugmeIzmena.addActionListener(izmenaAkcija);
		gbc.gridx = 2;
		gbc.gridy = 5;
		add(dugmeIzmena, gbc);
		
		setVisible(true);
	}

}
