package dialozi;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projekat.MainFrame;
import projekat.Predmet;
import projekat.Profesor;
import projekat.Util;

public class DialogDodavanjePredmeta extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DialogDodavanjePredmeta() {
		// poljla forme dijaloga (naziv predmeta,...)
		
		setTitle("Dodavanje predmeta");
		setSize(new Dimension(400, 300));
		
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		
		JTextField nazivPolje = new JTextField();
		JTextField semestarPolje = new JTextField();
		JTextField godStudijaPolje = new JTextField();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("Sifra: "), gbc);
//		add(sifraPolje, gbc);
		
		gbc.gridx = 1; // tacka(1, 0)
		JTextField sifraPolje = new JTextField();
		sifraPolje.setMinimumSize(new Dimension(200, 20));
		sifraPolje.setMaximumSize(new Dimension(200, 20));
		sifraPolje.setPreferredSize(new Dimension(200, 20));
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
		profesoriComboBox.setMinimumSize(new Dimension(200, 20));
		profesoriComboBox.setMaximumSize(new Dimension(200, 20));
		profesoriComboBox.setPreferredSize(new Dimension(200, 20));
		//profesoriComboBox.addItem(new Profesor("Pera", "Peric", null, "Adresa 10", "7655778", "email", "adresaKancelarije", 76566L, null, null, null));
		add(profesoriComboBox, gbc);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JButton dugmeSacuvaj = new JButton("Sacuvaj");
		ActionListener sacuvajAkcija = new ActionListener() {
			
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
				
				Predmet.dodavanjePredmeta(predmet);
				
				MainFrame.refreshTabova();
				dispose();
				
			}
		};
		dugmeSacuvaj.addActionListener(sacuvajAkcija);
		gbc.gridx = 2;
		gbc.gridy = 5;
		add(dugmeSacuvaj, gbc);
		
		
	}


}
