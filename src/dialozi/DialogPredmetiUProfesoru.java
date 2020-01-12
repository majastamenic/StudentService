package dialozi;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;


import projekat.MainFrame;
import projekat.MyApp;
import projekat.Predmet;
import projekat.Profesor;

public class DialogPredmetiUProfesoru extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DialogPredmetiUProfesoru(Profesor profesor) {
		setTitle("Predmeti koje profesor predaje");
		setSize(new Dimension(500, 300));
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
		
		add(new JLabel("Predmeti: "), gbc);
		
		DefaultListModel<Predmet> listModel = new DefaultListModel<Predmet>();
		ArrayList<Predmet> listaPredmeta = profesor.getSpisakPredmeta();
		
		for (Predmet predmet : listaPredmeta) {
			listModel.addElement(predmet);
		}
		
		JList<Predmet> list = new JList<Predmet>(listModel);
		list.setBounds(100, 100, 75, 75);
		gbc.gridx = 1;
		add(list, gbc);
		
		JButton obrisi = new JButton("Obrisi");
		ActionListener obrisiAkcija = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int selektovanIndex = list.getSelectedIndex();
					Predmet predmetZaBrisanje = list.getSelectedValue();
					
					for (Predmet pr : MyApp.getPredmeti()) {
						if(predmetZaBrisanje.equals(pr)) {
							pr.setPredmetniProfesor(null);
						}
					}
					
					if(selektovanIndex != -1) {
						listModel.remove(selektovanIndex);
					}
					ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
					for(int i=0; i<listModel.size(); i++) {
						predmeti.add(listModel.get(i));
					}
					profesor.setSpisakPredmeta(predmeti);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili predmet koji zelite da obrisete.",
							"Oznacite predmet", JOptionPane.OK_CANCEL_OPTION);
					
				}
				
			}
		};
		obrisi.addActionListener(obrisiAkcija);
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(obrisi, gbc);
		
		JButton nazad = new JButton("Nazad");
		ActionListener nazadAkcija = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		};
		nazad.addActionListener(nazadAkcija);
		gbc.gridx = 2;
		gbc.gridy = 3;
		add(nazad, gbc);
		setVisible(true);
	}
}
