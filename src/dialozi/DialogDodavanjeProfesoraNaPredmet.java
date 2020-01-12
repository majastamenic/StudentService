package dialozi;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import projekat.MainFrame;
import projekat.MyApp;
import projekat.Predmet;
import projekat.Profesor;


public class DialogDodavanjeProfesoraNaPredmet extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DialogDodavanjeProfesoraNaPredmet(int indexUModelu) {
		
		setTitle("Predmet - dodavanje profesora");
		setSize(new Dimension(400, 200));
		setLocationRelativeTo(null);
		
		ImageIcon img = new ImageIcon("Images/Icon5.png");
		Image image = img.getImage();
		Image newimg = image.getScaledInstance(330, 410, java.awt.Image.SCALE_SMOOTH); 
		img = new ImageIcon(newimg);
		setIconImage(img.getImage());
		
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("Broj licne karte profesora: "), gbc);
		
//		ArrayList<Profesor> profesoriLista = Util.ucitajProfesore();

//    	setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
//		add(new JLabel("Izaberi profesora: "));		
//		JComboBox<Profesor> profesoriComboBox = new JComboBox<Profesor>();		
//		for (Profesor profesor : profesoriLista) {
//			profesoriComboBox.addItem(profesor);
//		}
//		
//		profesoriComboBox.setMinimumSize(new Dimension(200,20));
//		profesoriComboBox.setMaximumSize(new Dimension(200,20));
//		profesoriComboBox.setPreferredSize(new Dimension(200, 20));
//		add(profesoriComboBox, BorderLayout.CENTER);
		
		gbc.gridx = 1;
		JTextField unosLicneKarte = new JTextField();
		
		unosLicneKarte.setMinimumSize(new Dimension(100, 20));
		unosLicneKarte.setMaximumSize(new Dimension(100, 20));
		unosLicneKarte.setPreferredSize(new Dimension(100, 20));
		
		add(unosLicneKarte, gbc);
		
		JButton dugmeSacuvaj = new JButton("Sacuvaj");
		ActionListener sacuvajAkcija = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String sifraPredmeta = MyApp.getPredmeti().get(indexUModelu).getSifra();
				String brojLicneKarte = unosLicneKarte.getText();
				boolean pronadjen = false;	
				
				for(int i = 0; i<MyApp.getProfesori().size(); i++) {
					if(MyApp.getProfesori().get(i).getBrojLicneKarte().equals(brojLicneKarte)) {
						Profesor profesor = MyApp.getProfesori().get(i);
						Predmet.dodavanjeProfesora(profesor, sifraPredmeta);	
						pronadjen = true;		//Pronadjen profesor sa unetim brojem indeksa
						break;
					}
				}
				if (!pronadjen){
					
					ImageIcon icon1 = new ImageIcon("Images/error.png");
					Image img1 = icon1.getImage();
					Image newimg1 = img1.getScaledInstance(40, 45, java.awt.Image.SCALE_SMOOTH); 
					icon1 = new ImageIcon(newimg1);
					
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ne postoji profesor sa datim brojem licne karte.",
							"Greska prilikom dodavanja predmetnog profesora", JOptionPane.OK_OPTION, icon1);	
				}
				
//				Profesor profesor = (Profesor) profesoriComboBox.getSelectedItem();
//				Predmet.dodavanjeProfesora(profesor, sifraPredmeta);
				
				MainFrame.refreshTabova();
				//dispose();
				
			}
		};
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		dugmeSacuvaj.addActionListener(sacuvajAkcija);
		add(dugmeSacuvaj, gbc);
		
		JButton dugmeOdustani = new JButton("Odustani");
		ActionListener odustaniAkcija = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		};
		gbc.gridx = 1;
		gbc.gridy = 3;
		dugmeOdustani.addActionListener(odustaniAkcija);
		add(dugmeOdustani, gbc);
		setVisible(true);
		
		
		
		
	}
}
