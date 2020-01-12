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
import projekat.Predmet;
import projekat.Student;

public class DialogStudentiUPredmetu extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DialogStudentiUPredmetu(Predmet predmet) {
		setTitle("Studenti koji slusaju predmet");
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
		
		add(new JLabel("Studenti: "), gbc);
		
		DefaultListModel<Student> listModel = new DefaultListModel<Student>();
		ArrayList<Student> listaStudenti = predmet.getSpisakStudenata();
		
		for (Student student : listaStudenti) {
			listModel.addElement(student);
		}
		
		JList<Student> list = new JList<Student>(listModel);
		list.setBounds(100, 100, 75, 75);
		gbc.gridx = 1;
		add(list, gbc);
		
		JButton obrisi = new JButton("Obrisi");
		ActionListener obrisiAkcija = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int selektovanIndex = list.getSelectedIndex();
					if(selektovanIndex != -1) {
						listModel.remove(selektovanIndex);	
					}
					ArrayList<Student> studenti = new ArrayList<Student>();
					for (int i=0; i<listModel.size(); i++) {
						studenti.add(listModel.get(i));
					}
					predmet.setSpisakStudenata(studenti);
					
				}catch(Exception ex) {
					
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili studenta kojeg zelite da obrisete sa datog predmeta", 
							"Oznacite studenta", JOptionPane.OK_CANCEL_OPTION);
					
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
