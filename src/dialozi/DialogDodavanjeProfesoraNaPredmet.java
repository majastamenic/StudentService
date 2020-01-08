package dialozi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

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
		
		setTitle("Dodavanje profesora na predmet");
		setSize(new Dimension(400, 200));
		setLocationRelativeTo(null);
		
		ImageIcon img = new ImageIcon("Images/Icon5.png");
		Image image = img.getImage();
		Image newimg = image.getScaledInstance(330, 410, java.awt.Image.SCALE_SMOOTH); 
		img = new ImageIcon(newimg);
		setIconImage(img.getImage());
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		add(new JLabel("Izaberi profesora: "));
		
		JComboBox<Profesor> profesoriComboBox = new JComboBox<Profesor>();
		ArrayList<Profesor> profesoriLista = Util.ucitajProfesore();
		
		for (Profesor profesor : profesoriLista) {
			profesoriComboBox.addItem(profesor);
		}
		
		profesoriComboBox.setMinimumSize(new Dimension(200,20));
		profesoriComboBox.setMaximumSize(new Dimension(200,20));
		profesoriComboBox.setPreferredSize(new Dimension(200, 20));
		add(profesoriComboBox, BorderLayout.CENTER);
		
		JButton dugmeSacuvaj = new JButton("Sacuvaj");
		ActionListener sacuvajAkcija = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Profesor profesor = (Profesor) profesoriComboBox.getSelectedItem();
				String sifraPredmeta = MyApp.getPredmeti().get(indexUModelu).getSifra();
				Predmet.dodavanjeProfesora(profesor, sifraPredmeta);
				
				MainFrame.refreshTabova();
				dispose();
				
			}
		};
		
		dugmeSacuvaj.addActionListener(sacuvajAkcija);
		add(dugmeSacuvaj, BorderLayout.PAGE_END);
		setVisible(true);
		
		
		
		
	}
}
