package projekat;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import dialozi.DialogBrisanjePredmeta;
import dialozi.DialogBrisanjeStudenta;
import dialozi.DialogDodavanjePredmeta;
import dialozi.DialogDodavanjeProfesora;
import dialozi.DialogDodavanjeStudenta;
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
		
		JButton btnIzmena = new JButton("Izmena");
		btnIzmena.setIcon(new ImageIcon("Images/switch.png"));
		ImageIcon img1 = new ImageIcon("Images/switch.png");
		btnIzmena.setIcon(new ImageIcon(img1.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		btnIzmena.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selektovano = MainFrame.getSelectedTab();
				if (selektovano.equals("predmet")) {
					DialogIzmenaPredmeta dialogIzmenaPredmeta = new DialogIzmenaPredmeta();
				}
				else if(selektovano.equals("student")) {
					DialogIzmenaStudenta dialogIzmenaStudenta = new DialogIzmenaStudenta();
				}else {
					DialogIzmenaProfesora dialogIzmenaProfesora = new DialogIzmenaProfesora();
				}
				
			}
		});
		
		add(btnIzmena);
		
		JButton btnBrisanje = new JButton("Brisanje");
		btnBrisanje.setIcon(new ImageIcon("Images/delete.png"));
		ImageIcon img2 = new ImageIcon("Images/delete.png");
		btnBrisanje.setIcon(new ImageIcon(img2.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		btnBrisanje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selektovano = MainFrame.getSelectedTab();
				if (selektovano.equals("predmet")) {
					
					int indexUModelu = MainFrame.getTabelaPredmeti().convertRowIndexToModel((MainFrame.getTabelaPredmeti().getSelectedRow()));
					
					DialogBrisanjePredmeta brisanje = new DialogBrisanjePredmeta(indexUModelu);
					
				}else if(selektovano.equals("student")) {
					
					int idx = MainFrame.getTabelaStudenti().convertRowIndexToModel((MainFrame.getTabelaStudenti().getSelectedRow()));
					
					DialogBrisanjeStudenta brisanjeStudenta = new DialogBrisanjeStudenta(idx);
				}
					
			}
		});
		add(btnBrisanje);
		
		addSeparator(getMaximumSize());
		JTextField tekst = new JTextField();
		tekst.setSize(new Dimension(20, 20));
		add(tekst);
		
		JButton btnPretraga= new JButton("Pretraga");
		btnPretraga.setIcon(new ImageIcon("Images/pretrazivanje2.png"));
		ImageIcon img3 = new ImageIcon("Images/pretrazivanje2.png");
		btnPretraga.setIcon(new ImageIcon(img3.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		add(btnPretraga);
		
		
		setVisible(true);
	}
	
	
}
