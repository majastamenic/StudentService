package projekat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import dialozi.DialogBrisanjePredmeta;
import dialozi.DialogBrisanjeStudenta;
import dialozi.DialogBrisanjeProfesora;
import dialozi.DialogDodavanjePredmeta;
import dialozi.DialogDodavanjeProfesora;
import dialozi.DialogDodavanjeStudenta;
import dialozi.DialogDodavanjeStudentaNaPredmet;
import dialozi.DialogDodavanjeProfesoraNaPredmet;
import dialozi.DialogIzmenaPredmeta;
import dialozi.DialogIzmenaProfesora;
import dialozi.DialogIzmenaStudenta;
import dialozi.DialogUklanjanjeProfesoraSaPredmet;
import dialozi.DialogUklanjanjeStudentaSaPredmeta;

public class MyToolBar extends JToolBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		JButton btnDodavanje = new JButton("Dodavanje");
		ImageIcon img = new ImageIcon("Images/dodavanje.png");
		btnDodavanje.setIcon(new ImageIcon(img.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));	// smanjivanje ikonice
		btnDodavanje.setSize(1000, getHeight());
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
                    int indexUModelu = MainFrame.getTabelaPredmeti().convertRowIndexToModel(MainFrame.getTabelaPredmeti().getSelectedRow());
                    DialogIzmenaPredmeta dialogIzmenaPredmeta = new DialogIzmenaPredmeta(indexUModelu);

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
					
					int indexUModelu = MainFrame.getTabelaPredmeti().convertRowIndexToModel((MainFrame.getTabelaPredmeti().getSelectedRow()));
					
					DialogBrisanjePredmeta brisanje = new DialogBrisanjePredmeta(indexUModelu);
					
				}else if(selektovano.equals("student")) {
					int indexUModelu = MainFrame.getTabelaStudenti().convertRowIndexToModel((MainFrame.getTabelaStudenti().getSelectedRow()));
					DialogBrisanjeStudenta brisanje = new DialogBrisanjeStudenta(indexUModelu);
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
					DialogDodavanjeProfesoraNaPredmet dodavanjeProfesora = new DialogDodavanjeProfesoraNaPredmet();
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
					DialogUklanjanjeProfesoraSaPredmet uklanjanjeProfesora = new DialogUklanjanjeProfesoraSaPredmet();

				}
			});
			add(btnBrisanjeProfesoraSaPredmeta);
			
			JButton btnDodavanjeStudentaNaPredmet = new JButton();
			btnDodavanjeStudentaNaPredmet.setToolTipText("Dodavanje studenta na predmet");
			ImageIcon slika = new ImageIcon("ikonice/icons8-student-registration-20");
			btnDodavanjeStudentaNaPredmet.setIcon(new ImageIcon(slika.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH)));
			btnDodavanjeStudentaNaPredmet.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DialogDodavanjeStudentaNaPredmet dodavanjeStudenta = new DialogDodavanjeStudentaNaPredmet();
				}
			});
			add(btnDodavanjeStudentaNaPredmet);
			
			JButton btnUklanjanjeStudentaSaPredmeta = new JButton();
			btnUklanjanjeStudentaSaPredmeta.setToolTipText("Uklanjanje studenta sa predmeta");
			ImageIcon slika1 = new ImageIcon("ikonice/icons8-remove-administrator-20");
			btnUklanjanjeStudentaSaPredmeta.setIcon(new ImageIcon(slika.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH)));
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
		tekst.setSize(new Dimension(20, 20));
		add(tekst);
		
		tekst.setMaximumSize(new Dimension((int) (dimenzijaEkrana.getWidth()/3), 40));
		add(tekst, BorderLayout.LINE_END);

		JButton btnPretraga= new JButton();
		btnPretraga.setIcon(new ImageIcon("Images/pretrazivanje2.png"));
		ImageIcon img3 = new ImageIcon("Images/pretrazivanje2.png");
		btnPretraga.setIcon(new ImageIcon(img3.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		btnPretraga.setToolTipText("Pretraga");
		add(btnPretraga);
		
		
		setVisible(true);
	}
	
	
}
