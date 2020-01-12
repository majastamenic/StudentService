package dialozi;

import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
			profesoriComboBox.addItem(profesor);	//Dodajemo sve profesore
		}
		
		for (int i = 0; i < profesoriComboBox.getItemCount(); i++) {
			if(predmet.getPredmetniProfesor()!=null) {
				if(predmet.getPredmetniProfesor().getBrojLicneKarte().equals(profesoriComboBox.getItemAt(i).getBrojLicneKarte())) {
					profesoriComboBox.setSelectedIndex(i);
					break;
				}
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
				try {
					String sifra = sifraPolje.getText();
					String naziv = nazivPolje.getText();
					ImageIcon icon1 = new ImageIcon("Images/error.png");
					Image img1 = icon1.getImage();
					Image newimg1 = img1.getScaledInstance(40, 45, java.awt.Image.SCALE_SMOOTH); 
					icon1 = new ImageIcon(newimg1);
					
					if(naziv.equals("")) {	//Ako korisnik nije uneo naziv
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste validno popunili sva polja.",
								"Greska prilikom izmene predmeta", JOptionPane.OK_OPTION, icon1);
					}else {
						int semestar = 1;
						int godinaStudija = 1;
						try {
							semestar = Integer.parseInt(semestarPolje.getText());
							godinaStudija = Integer.parseInt(godStudijaPolje.getText());
						} catch(NumberFormatException exc) {
							JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste validno popunili sva polja.",
									"Greska prilikom izmene predmeta", JOptionPane.OK_OPTION, icon1);
						}
						if(semestar > 8) {		//Postoji 8 semestara
							JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste validno uneli broj semestra.", 
									"Greska prilikom izmene predmeta", JOptionPane.OK_OPTION, icon1);
						}else if(godinaStudija > 4) {	//Postoje 4 godine studija
							JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste validno uneli godinu studija.", 
									"Greska prilikom izmene predmeta", JOptionPane.OK_OPTION, icon1);
						}else {
							Profesor profesor = (Profesor) profesoriComboBox.getSelectedItem();	//Profesor je selektovani profesor iz comboBox-a
							
			//				Predmet predmet = new Predmet(sifra, naziv, semestar, godinaStudija, profesor);
			
							Predmet predmet = new Predmet();
							predmet.setSifra(sifra);
							predmet.setNaziv(naziv);
							predmet.setSemestar(semestar);
							predmet.setGodinaStudija(godinaStudija);
							predmet.setPredmetniProfesor(profesor);
							Predmet.izmenaPredmeta(predmet);
							
							// brisanje predmeta iz starog prof
							for (Predmet staraVrednostPredmeta : MyApp.getPredmeti()) {
								if (staraVrednostPredmeta.getSifra().equals(sifra)) {
									Profesor prethodniProfesor = staraVrednostPredmeta.getPredmetniProfesor();
									if (prethodniProfesor != null) {
										for(int i = 0; i < MyApp.getProfesori().size(); i++) {
											if (MyApp.getProfesori().get(i).getBrojLicneKarte().equals(prethodniProfesor.getBrojLicneKarte()) ) {
												// Prolazimo kroz sve predmete koje on predaje i brisemo trenutni
												for (int j = 0; j < MyApp.getProfesori().get(i).getSpisakPredmeta().size(); j++) {
													if (MyApp.getProfesori().get(i).getSpisakPredmeta().get(j).getSifra().equals(sifra)) {
														MyApp.getProfesori().get(i).getSpisakPredmeta().remove(j);
														break;
													}
												}
												break;		//Nadjen profesor
											}
										}
									}
								}
							}
							
							// Dodavanje predmeta u novog profesora
							if (profesor != null) {
								for(int i = 0; i < MyApp.getProfesori().size(); i++) {
									if (profesor.getBrojLicneKarte().equals(MyApp.getProfesori().get(i).getBrojLicneKarte())) {
										MyApp.getProfesori().get(i).getSpisakPredmeta().add(predmet);
									}
								}
							}
							
							MainFrame.refreshTabova();
							dispose();
						}
					}
				}catch(Exception ex) {	//Ukoliko nisu uneta sva polja ili ukoliko negde nije unet dobar tip podatka
					ImageIcon icon1 = new ImageIcon("Images/error.png");
					Image img1 = icon1.getImage();
					Image newimg1 = img1.getScaledInstance(40, 45, java.awt.Image.SCALE_SMOOTH); 
					icon1 = new ImageIcon(newimg1);
					
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste validno popunili sva polja.",
							"Greska prilikom izmene predmeta", JOptionPane.OK_OPTION, icon1);
				}
				
			}
		};
		
		dugmeIzmena.addActionListener(izmenaAkcija);
		gbc.gridx = 2;
		gbc.gridy = 5;
		add(dugmeIzmena, gbc);
		
		setVisible(true);
	}

}
