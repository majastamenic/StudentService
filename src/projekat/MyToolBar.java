package projekat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import dialozi.DialogBrisanjePredmeta;
import dialozi.DialogBrisanjeProfesora;
import dialozi.DialogBrisanjeStudenta;
import dialozi.DialogDodavanjePredmeta;
import dialozi.DialogDodavanjeProfesora;
import dialozi.DialogDodavanjeStudenta;
import dialozi.DialogDodavanjeStudentaNaPredmet;
import dialozi.DialogDodavanjeProfesoraNaPredmet;
import dialozi.DialogIzmenaPredmeta;
import dialozi.DialogIzmenaProfesora;
import dialozi.DialogIzmenaStudenta;


public class MyToolBar extends JToolBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		//Dugme za dodavanje studenta/profesora/predmeta
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
//		btnDodavanje.setFocusable(true);
//		btnDodavanje.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent ke) {
//				if(ke.getKeyCode() == KeyEvent.VK_N) {
//					String selektovano = MainFrame.getSelectedTab();
//					if (selektovano.equals("predmet")) {
//						DialogDodavanjePredmeta dialogDodavanjePredmeta = new DialogDodavanjePredmeta();
//
//					}
//					else if(selektovano.equals("student")) {
//						DialogDodavanjeStudenta dialogDodavanjeStudenta = new DialogDodavanjeStudenta();
//
//					}else {
//						DialogDodavanjeProfesora dialogDodavanjeProfesora = new DialogDodavanjeProfesora();
//					}
//
//
//				}
//			}
//		});
		add(btnDodavanje);
		
		//Dugme za izmenu selektovanog studenta/profesora/predmeta.
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
						//Prosledjujemo indexUModelu da bi smo znali koji predmet je selektovan.
						int indexUModelu = MainFrame.getTabelaPredmeti().convertRowIndexToModel(MainFrame.getTabelaPredmeti().getSelectedRow());
						DialogIzmenaPredmeta dialogIzmenaPredmeta = new DialogIzmenaPredmeta(indexUModelu);
					}catch(Exception ex){
						//Ukoliko nijedan predmet nije selektovan.

						UIManager.put("OptionPane.okButtonText", "OK");
						ImageIcon icon1 = new ImageIcon("Images/error.png");
						Image img1 = icon1.getImage();
						Image newimg1 = img1.getScaledInstance(40, 45, java.awt.Image.SCALE_SMOOTH);
						icon1 = new ImageIcon(newimg1);
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili predmet na koji zelite da  izmenite.",
								"Greska", JOptionPane.OK_CANCEL_OPTION, icon1);
					}
                }
				else if(selektovano.equals("student")) {
					int idx =MainFrame.getTabelaStudenti().getSelectedRow();
					if(idx==-1) {
                    	JOptionPane.showMessageDialog(null, "morate selektovati red koji zelite da izmenite");
                    	return;
					}

					DialogIzmenaStudenta dialogIzmenaStudenta = new DialogIzmenaStudenta(idx);
				}else {
					int idx =MainFrame.getTabelaProfesori().getSelectedRow();
					if(idx==-1) {
                    	JOptionPane.showMessageDialog(null, "morate selektovati red koji zelite da izmenite");
                    	return;
					}
					DialogIzmenaProfesora dialogIzmenaProfesora = new DialogIzmenaProfesora(idx);
				}

			}
		});
		
		add(btnIzmena);
		
		//Dugme za brisanje selektovanog studenta/profesora/predmeta.
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
						//Potvrda za brisanje selektovanog predmeta.
						UIManager.put("OptionPane.yesButtonText", "Da");
						UIManager.put("OptionPane.noButtonText", "Ne");
						ImageIcon icon = new ImageIcon("Images/deleteDialog.png");
						Image img = icon.getImage();
						Image newimg = img.getScaledInstance(40, 45, java.awt.Image.SCALE_SMOOTH); 		// Podesavanje velicine ikonice.
						icon = new ImageIcon(newimg);

//						Dialog za potvrdu brisanja selektovanog predmeta rucno napravljen.
//						DialogBrisanjePredmeta brisanjeSelektovanogPredmeta = new DialogBrisanjePredmeta(indexUModelu);

						if(JOptionPane.showConfirmDialog(MainFrame.getInstance(),"Da li ste sigurni da zelite da obrisete selektovani predmet?",
								"Brisanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon)==JOptionPane.YES_OPTION){
							Predmet.brisanjePredmeta(MyApp.getPredmeti().get(indexUModelu).getSifra());
							MainFrame.refreshTabova();
						}

					}catch(Exception ex){
//						Ukoliko nijedan predmet nije selektovan.

						UIManager.put("OptionPane.okButtonText", "OK");
						UIManager.put("OptionPane.cancelButtonText", "Otkazi");
						ImageIcon icon1 = new ImageIcon("Images/error.png");
						Image img1 = icon1.getImage();
						Image newimg1 = img1.getScaledInstance(40, 45, java.awt.Image.SCALE_SMOOTH);
						icon1 = new ImageIcon(newimg1);

						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili predmet koji zelite da izbrisete.",
								"Greska", JOptionPane.OK_CANCEL_OPTION, icon1);
					}

				}else if(selektovano.equals("student")) {
					int indexUModelu =MainFrame.getTabelaStudenti().getSelectedRow();
					if(indexUModelu==-1) {
                    	JOptionPane.showMessageDialog(null, "morate selektovati red koji zelite da izbrisete");
                    	return;
					}
					DialogBrisanjeStudenta brisanje = new DialogBrisanjeStudenta(indexUModelu);

				} else if(selektovano.equals("profesor")) {
//					Ako je selektovan profesor izbrisi ga.
					try {
						int indexUModelu = MainFrame.getTabelaProfesori().convertRowIndexToModel(MainFrame.getTabelaProfesori().getSelectedRow());
						UIManager.put("OptionPane.yesButtonText", "Da");
						UIManager.put("OptionPane.noButtonText", "Ne");
						ImageIcon icon = new ImageIcon("Images/deleteDialog.png");
						Image img = icon.getImage();
						Image newimg = img.getScaledInstance(40, 45, java.awt.Image.SCALE_SMOOTH); 		// Podesavanje velicine ikonice.
						icon = new ImageIcon(newimg);

//						Dialog za brisanje selektovanog profesora rucno napravljen.
//						DialogBrisanjeProfesora brisanjeSelektovanogProfesora = new DialogBrisanjeProfesora(indexUModelu);

						if(JOptionPane.showConfirmDialog(MainFrame.getInstance(),"Da li ste sigurni da zelite da obrisete selektovanog profesora?",
								"Brisanje profesora", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon)==JOptionPane.YES_OPTION){
							Profesor.brisanjeProfesora(MyApp.getProfesori().get(indexUModelu).getBrojLicneKarte());
							MainFrame.refreshTabova();
						}
//					U slucaju da nije selektovan nijedan profesora.
					}catch(Exception ex) {
						UIManager.put("OptionPane.okButtonText", "OK");
						UIManager.put("OptionPane.cancelButtonText", "Otkazi");
						ImageIcon icon1 = new ImageIcon("Images/error.png");
						Image img1 = icon1.getImage();
						Image newimg1 = img1.getScaledInstance(40, 45, java.awt.Image.SCALE_SMOOTH);
						icon1 = new ImageIcon(newimg1);

						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili profesora kojeg zelite da izbrisete.",
								"Greska", JOptionPane.OK_CANCEL_OPTION, icon1);
					}
				}


			}
		});
		add(btnBrisanje);
		
		String selektovano = MainFrame.getSelectedTab();
//		Dodavanje JButton-a za dodavanje predmetnog profesora na predmet i brisanje predmetnog profesora sa predmeta.
		if(selektovano.equals("predmet")) {
			JButton btnDodavanjeProfesoraNaPredmet = new JButton();

			btnDodavanjeProfesoraNaPredmet.setToolTipText("Dodavanje profesora na predmet");
			ImageIcon img3 = new ImageIcon("Images/dodavanje_profesora.png");
			btnDodavanjeProfesoraNaPredmet.setIcon(new ImageIcon(img3.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));

			btnDodavanjeProfesoraNaPredmet.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int indexUModelu = MainFrame.getTabelaPredmeti().convertRowIndexToModel((MainFrame.getTabelaPredmeti().getSelectedRow()));
						DialogDodavanjeProfesoraNaPredmet dodavanjeProfesora = new DialogDodavanjeProfesoraNaPredmet(indexUModelu);
					}catch(Exception ex){
//						Slucaj kada korisnik hoce da doda predmetnog profesora a nije oznacio predmet.
						UIManager.put("OptionPane.okButtonText", "OK");
						UIManager.put("OptionPane.cancelButtonText", "Otkazi");
						ImageIcon icon1 = new ImageIcon("Images/error.png");
						Image img1 = icon1.getImage();
						Image newimg1 = img1.getScaledInstance(40, 45, java.awt.Image.SCALE_SMOOTH);
						icon1 = new ImageIcon(newimg1);

						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili predmet na koji zelite da dodate profesora",
								"Greska", JOptionPane.OK_CANCEL_OPTION, icon1);
					}
				}
			});
			add(btnDodavanjeProfesoraNaPredmet);

//			Brisanje predmetnog profesora.
			JButton btnBrisanjeProfesoraSaPredmeta = new JButton();
			btnBrisanjeProfesoraSaPredmeta.setToolTipText("Brisanje profesora sa predmeta");
			ImageIcon img4 = new ImageIcon("Images/deleteMan.png");
			btnBrisanjeProfesoraSaPredmeta.setIcon(new ImageIcon(img4.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
			btnBrisanjeProfesoraSaPredmeta.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int indexUModelu = MainFrame.getTabelaPredmeti().convertRowIndexToModel((MainFrame.getTabelaPredmeti().getSelectedRow()));
//						Rucno napravljen dialog za uklanjanje profesora sa predmeta.
//						DialogUklanjanjeProfesoraSaPredmet uklanjaneProfesora = new DialogUklanjanjeProfesoraSaPredmet(indexUModelu);

						UIManager.put("OptionPane.yesButtonText", "Da");
						UIManager.put("OptionPane.noButtonText", "Ne");
						UIManager.put("OptionPane.cancelButtonText", "Otkazi");
						ImageIcon icon = new ImageIcon("Images/deleteDialog.png");
						Image img = icon.getImage();
						Image newimg = img.getScaledInstance(40, 45, java.awt.Image.SCALE_SMOOTH);
						icon = new ImageIcon(newimg);

						if(MyApp.getPredmeti().get(indexUModelu).getPredmetniProfesor()==null) {	//Slucaj kada korisnik pokusa da obrise predmetnog profesora koji ne postoji.

							ImageIcon icon1 = new ImageIcon("Images/error.png");
							Image img1 = icon1.getImage();
							Image newimg1 = img1.getScaledInstance(40, 45, java.awt.Image.SCALE_SMOOTH);
							icon1 = new ImageIcon(newimg1);

							JOptionPane.showMessageDialog(MainFrame.getInstance(), "Selektovani predmet nema premetnog profesora.",
									"Greska", JOptionPane.OK_OPTION, icon1);
						}
	//					Ukoliko korisnik potvrdi brisanje predmetnog profesora
						else if(JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da zelite da uklonite profesora sa predmeta?",
								"Potvrda o brisanju profesora sa predmeta", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, icon) == JOptionPane.YES_OPTION) {
							String sifra = MyApp.getPredmeti().get(indexUModelu).getSifra();
	//						Pozivamo metodu klase Predmet za brisanje predmetnog profesora.
							Predmet.uklanjanjeProfesora(MyApp.getPredmeti().get(indexUModelu).getPredmetniProfesor(), sifra);
							MainFrame.refreshTabova();
						}


					}catch(Exception ex) {
	//					Ukoliko korisnik nije selektovao predmet.
						UIManager.put("OptionPane.okButtonText", "OK");
						ImageIcon icon1 = new ImageIcon("Images/error.png");
						Image img1 = icon1.getImage();
						Image newimg1 = img1.getScaledInstance(40, 45, java.awt.Image.SCALE_SMOOTH);
						icon1 = new ImageIcon(newimg1);

						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste oznacili predmet na kome zelite da uklonite profesora.",
								"Greska", JOptionPane.OK_CANCEL_OPTION, icon1);
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
					int idx = MainFrame.getTabelaPredmeti().convertRowIndexToModel((MainFrame.getTabelaPredmeti().getSelectedRow()));;
					DialogDodavanjeStudentaNaPredmet dodavanjeStudenta = new DialogDodavanjeStudentaNaPredmet(idx);
				}
			});
			add(btnDodavanjeStudentaNaPredmet);

//			JButton btnUklanjanjeStudentaSaPredmeta = new JButton();
//			btnUklanjanjeStudentaSaPredmeta.setToolTipText("Uklanjanje studenta sa predmeta");
//			ImageIcon slika1 = new ImageIcon("ikonice/icons8-remove-administrator-20.png");
//			btnUklanjanjeStudentaSaPredmeta.setIcon(new ImageIcon(slika1.getImage().getScaledInstance(20,20, java.awt.Image.SCALE_SMOOTH)));
//			btnUklanjanjeStudentaSaPredmeta.addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					DialogUklanjanjeStudentaSaPredmeta uklanjanjeStudenta = new DialogUklanjanjeStudentaSaPredmeta();
//				}
//			});
//			add(btnUklanjanjeStudentaSaPredmeta);
		}

//		TextFile zauzima 1/3 toolbar-a
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimenzijaEkrana = toolkit.getScreenSize();
		addSeparator(new Dimension((int) (dimenzijaEkrana.getWidth()/3), 20));			// 1/3 separator
		JTextField tekst = new JTextField();
		tekst.setToolTipText("Kljuc:vrednost; kljuc1:vrednost1;...");

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
