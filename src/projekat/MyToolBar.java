package projekat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import dialozi.DialogBrisanjeStudenta;
import dialozi.DialogDodavanjePredmeta;
import dialozi.DialogDodavanjeProfesora;
import dialozi.DialogDodavanjeStudenta;
import dialozi.DialogDodavanjeStudentaNaPredmet;
import dialozi.DialogDodavanjeProfesoraNaPredmet;
import dialozi.DialogIzmenaPredmeta;
import dialozi.DialogIzmenaProfesora;
import dialozi.DialogIzmenaStudenta;
import dialozi.DialogUklanjanjeStudentaSaPredmeta;

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
						UIManager.put("OptionPane.okButtonText", "OK");
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili predmet na koji zelite da  izmenite.",
								"Oznacite predmet", JOptionPane.OK_CANCEL_OPTION);
					}
                }
				else if(selektovano.equals("student")) {
					int idx = MainFrame.getTabelaStudenti().convertRowIndexToModel((MainFrame.getTabelaStudenti().getSelectedRow()));

					DialogIzmenaStudenta dialogIzmenaStudenta = new DialogIzmenaStudenta(idx);
				}else {
					int idx = MainFrame.getTabelaProfesori().convertRowIndexToModel(MainFrame.getTabelaProfesori().getSelectedRow());
					DialogIzmenaProfesora dialogIzmenaProfesora = new DialogIzmenaProfesora(idx);
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
						UIManager.put("OptionPane.yesButtonText", "Da");
						UIManager.put("OptionPane.noButtonText", "Ne");
						if(JOptionPane.showConfirmDialog(MainFrame.getInstance(),"Da li ste sigurni da zelite da obrisete selektovani predmet?",
								"Brisanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
							Predmet.brisanjePredmeta(MyApp.getPredmeti().get(indexUModelu).getSifra());
							MainFrame.refreshTabova();
							dispose();
						}
					}catch(Exception ex){
						UIManager.put("OptionPane.okButtonText", "OK");
						UIManager.put("OptionPane.cancelButtonText", "Otkazi");
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili predmet koji zelite da izbrisete.",
								"Oznacite predmet", JOptionPane.OK_CANCEL_OPTION);
					}
				}else if(selektovano.equals("student")) {
					int indexUModelu = MainFrame.getTabelaStudenti().convertRowIndexToModel((MainFrame.getTabelaStudenti().getSelectedRow()));
					DialogBrisanjeStudenta brisanje = new DialogBrisanjeStudenta(indexUModelu);
				} else if(selektovano.equals("profesor")) {
					try {
						int indexUModelu = MainFrame.getTabelaProfesori().convertRowIndexToModel(MainFrame.getTabelaProfesori().getSelectedRow());
						UIManager.put("OptionPane.yesButtonText", "Da");
						UIManager.put("OptionPane.noButtonText", "Ne");
						if(JOptionPane.showConfirmDialog(MainFrame.getInstance(),"Da li ste sigurni da zelite da obrisete selektovanog profesora?",
								"Brisanje profesora", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
							Profesor.brisanjeProfesora(MyApp.getProfesori().get(indexUModelu).getBrojLicneKarte());
							MainFrame.refreshTabova();
							dispose();
						}
					}catch(Exception ex) {
						UIManager.put("OptionPane.okButtonText", "OK");
						UIManager.put("OptionPane.cancelButtonText", "Otkazi");
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili profesora kojeg zelite da izbrisete.",
								"Oznacite predmet", JOptionPane.OK_CANCEL_OPTION);
					}
				}


			}

			private void dispose() {
				// TODO Auto-generated method stub

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
						UIManager.put("OptionPane.okButtonText", "OK");
						UIManager.put("OptionPane.cancelButtonText", "Otkazi");
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili predmet na koji zelite da dodate profesora",
								"Oznacite predmet", JOptionPane.OK_CANCEL_OPTION);
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
						UIManager.put("OptionPane.yesButtonText", "Da");
						UIManager.put("OptionPane.noButtonText", "Ne");
						UIManager.put("OptionPane.cancelButtonText", "Otkazi");
						if(JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da zelite da uklonite profesora sa predmeta?",
								"Potvrda o brisanju profesora sa predmeta", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
							String sifra = MyApp.getPredmeti().get(indexUModelu).getSifra();
							Predmet.uklanjanjeProfesora(MyApp.getPredmeti().get(indexUModelu).getPredmetniProfesor(), sifra);
							MainFrame.refreshTabova();
						}


					}catch(Exception ex) {
						UIManager.put("OptionPane.okButtonText", "OK");
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili predmet na kome zelite da uklonite profesora",
								"Oznacite predmet", JOptionPane.OK_CANCEL_OPTION);
					}

				}
			});
			add(btnBrisanjeProfesoraSaPredmeta);

			JButton btnDodavanjeStudentaNaPredmet = new JButton();
			btnDodavanjeStudentaNaPredmet.setToolTipText("Dodavanje studenta na predmet");
			ImageIcon slika = new ImageIcon("ikonice/icons8-student-registration-20.png");
			btnDodavanjeStudentaNaPredmet.setIcon(new ImageIcon(slika.getImage().getScaledInstance(20,20, java.awt.Image.SCALE_SMOOTH)));
			btnDodavanjeStudentaNaPredmet.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DialogDodavanjeStudentaNaPredmet dodavanjeStudenta = new DialogDodavanjeStudentaNaPredmet();
				}
			});
			add(btnDodavanjeStudentaNaPredmet);

			JButton btnUklanjanjeStudentaSaPredmeta = new JButton();
			btnUklanjanjeStudentaSaPredmeta.setToolTipText("Uklanjanje studenta sa predmeta");
			ImageIcon slika1 = new ImageIcon("ikonice/icons8-remove-administrator-20.png");
			btnUklanjanjeStudentaSaPredmeta.setIcon(new ImageIcon(slika1.getImage().getScaledInstance(20,20, java.awt.Image.SCALE_SMOOTH)));
			btnUklanjanjeStudentaSaPredmeta.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DialogUklanjanjeStudentaSaPredmeta uklanjanjeStudenta = new DialogUklanjanjeStudentaSaPredmeta();
				}
			});
			add(btnUklanjanjeStudentaSaPredmeta);
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
