package projekat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import dialozi.DialogBrisanjePredmeta;
import dialozi.DialogBrisanjeStudenta;
import dialozi.DialogBrisanjeProfesora;
import dialozi.DialogDodavanjePredmeta;
import dialozi.DialogDodavanjeProfesora;
import dialozi.DialogDodavanjeStudenta;
import dialozi.DialogDodavanjeProfesoraNaPredmet;
import dialozi.DialogIzmenaPredmeta;
import dialozi.DialogIzmenaProfesora;
import dialozi.DialogIzmenaStudenta;
import dialozi.DialogUklanjanjeProfesoraSaPredmet;

public class MyToolBar extends JToolBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		JButton btnDodavanje = new JButton();
		ImageIcon img = new ImageIcon("Images/dodavanje.png");
		btnDodavanje.setIcon(new ImageIcon(img.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));	// smanjivanje ikonice
		btnDodavanje.setToolTipText("Dodavanje");
		btnDodavanje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String selektovano = MainFrame.getSelectedTab();
				if (selektovano.equals("predmet")) {
					DialogDodavanjePredmeta dialogDodavanjePredmeta = new DialogDodavanjePredmeta();

				}
				else if(selektovano.equals("student")) {
					DialogDodavanjeStudenta dialogDodavanjeStudenta = new DialogDodavanjeStudenta();
				}else {
					DialogDodavanjeProfesora dialogDodavanjeProfesora = new DialogDodavanjeProfesora();
				}

				
			}
		});
		add(btnDodavanje);
		
		JButton btnIzmena = new JButton();
		btnIzmena.setIcon(new ImageIcon("Images/switch.png"));
		ImageIcon img1 = new ImageIcon("Images/switch.png");
		btnIzmena.setIcon(new ImageIcon(img1.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		btnIzmena.setToolTipText("Izmena");
		btnIzmena.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selektovano = MainFrame.getSelectedTab();
				if (selektovano.equals("predmet")) {
					try {
						int indexUModelu = MainFrame.getTabelaPredmeti().convertRowIndexToModel(MainFrame.getTabelaPredmeti().getSelectedRow());
						DialogIzmenaPredmeta dialogIzmenaPredmeta = new DialogIzmenaPredmeta(indexUModelu);
					}catch(Exception ex){
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili predmet na koji zelite da  izmenite.", "Oznacite predmet", JOptionPane.OK_CANCEL_OPTION);
					}
                }
				else if(selektovano.equals("student")) {
					DialogIzmenaStudenta dialogIzmenaStudenta = new DialogIzmenaStudenta();
				}else {
                    DialogIzmenaProfesora dialogIzmenaProfesora = new DialogIzmenaProfesora();
                }
			}
		});
		
		add(btnIzmena);
		
		JButton btnBrisanje = new JButton();
		btnBrisanje.setIcon(new ImageIcon("Images/delete.png"));
		ImageIcon img2 = new ImageIcon("Images/delete.png");
		btnBrisanje.setIcon(new ImageIcon(img2.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		btnBrisanje.setToolTipText("Brisanje");
		btnBrisanje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selektovano = MainFrame.getSelectedTab();
				if (selektovano.equals("predmet")) {
					try {
						int indexUModelu = MainFrame.getTabelaPredmeti().convertRowIndexToModel((MainFrame.getTabelaPredmeti().getSelectedRow()));
						DialogBrisanjePredmeta brisanje = new DialogBrisanjePredmeta(indexUModelu);
					}catch(Exception ex){
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili predmet na koji zelite da izbrisete", "Oznacite predmet", JOptionPane.OK_CANCEL_OPTION);
					}
				}else if(selektovano.equals("student")) {
					DialogBrisanjeStudenta dialogBrisanjeStudenta = new DialogBrisanjeStudenta();
				} else if(selektovano.equals("profesor")) {

					int indexUModelu = MainFrame.getTabelaProfesori().convertRowIndexToModel(MainFrame.getTabelaProfesori().getSelectedRow());

					DialogBrisanjeProfesora brisanje = new DialogBrisanjeProfesora(indexUModelu);
				}
					
			}
		});
		add(btnBrisanje);
		
		String selektovano = MainFrame.getSelectedTab();
		if(selektovano.equals("predmet")) {
			JButton btnDodavanjeProfesoraNaPredmet = new JButton();
			btnDodavanjeProfesoraNaPredmet.setToolTipText("Dodavanje profesora na predmet");
			ImageIcon img3 = new ImageIcon("Images/addMan.png");
			btnDodavanjeProfesoraNaPredmet.setIcon(new ImageIcon(img3.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
			btnDodavanjeProfesoraNaPredmet.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int indexUModelu = MainFrame.getTabelaPredmeti().convertRowIndexToModel((MainFrame.getTabelaPredmeti().getSelectedRow()));
						DialogDodavanjeProfesoraNaPredmet dodavanjeProfesora = new DialogDodavanjeProfesoraNaPredmet(indexUModelu);
					}catch(Exception ex){
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili predmet na koji zelite da dodate profesora", "Oznacite predmet", JOptionPane.OK_CANCEL_OPTION);
					}
				}
			});
			add(btnDodavanjeProfesoraNaPredmet);

			JButton btnBrisanjeProfesoraSaPredmeta = new JButton();
			btnBrisanjeProfesoraSaPredmeta.setToolTipText("Brisanje profesora sa predmeta");
			ImageIcon img4 = new ImageIcon("Images/deleteMan.png");
			btnBrisanjeProfesoraSaPredmeta.setIcon(new ImageIcon(img4.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
			btnBrisanjeProfesoraSaPredmeta.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int indexUModelu = MainFrame.getTabelaPredmeti().convertRowIndexToModel((MainFrame.getTabelaPredmeti().getSelectedRow()));
						//DialogUklanjanjeProfesoraSaPredmet uklanjaneProfesora = new DialogUklanjanjeProfesoraSaPredmet(indexUModelu);
						if(JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da zelite da uklonite profesora sa predmeta?",
								"Potvrda o brisanju profesora sa predmeta", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
							String sifra = MyApp.getPredmeti().get(indexUModelu).getSifra();
							Predmet.uklanjanjeProfesora(MyApp.getPredmeti().get(indexUModelu).getPredmetniProfesor(), sifra);
							MainFrame.refreshTabova();
						}
						
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili predmet na kome zelite da uklonite profesora", "Oznacite predmet", JOptionPane.OK_CANCEL_OPTION);
					}
					
				}
			});
			add(btnBrisanjeProfesoraSaPredmeta);
		}
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimenzijaEkrana = toolkit.getScreenSize();
		addSeparator(new Dimension((int) (dimenzijaEkrana.getWidth()/3), 20));			// 1/3 separator
		JTextField tekst = new JTextField();
		
		tekst.setMaximumSize(new Dimension((int) (dimenzijaEkrana.getWidth()/3), 40));
		add(tekst, BorderLayout.LINE_END);

		JButton btnPretraga= new JButton();
		btnPretraga.setIcon(new ImageIcon("Images/pretrazivanje2.png"));
		ImageIcon img3 = new ImageIcon("Images/pretrazivanje2.png");
		btnPretraga.setIcon(new ImageIcon(img3.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		btnPretraga.setToolTipText("Pretraga");
		
		btnPretraga.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PretragaActionListener pretragaAction = new PretragaActionListener(tekst.getText());	//poziv konstruktora za action listener jer mu je potrebna vrenost polja tekst za pretragu
				pretragaAction.actionPerformed(e);
				
			}
		});
		add(btnPretraga);
		
		
		setVisible(true);
	}
	
	
}
