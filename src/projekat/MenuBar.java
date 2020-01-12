package projekat;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import dialozi.DialogBrisanjePredmeta;
import dialozi.DialogBrisanjeProfesora;
import dialozi.DialogBrisanjeStudenta;
import dialozi.DialogDodavanjePredmeta;
import dialozi.DialogDodavanjeProfesora;
import dialozi.DialogDodavanjeStudenta;
import dialozi.DialogIzmenaPredmeta;
import dialozi.DialogIzmenaProfesora;
import dialozi.DialogIzmenaStudenta;



public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = -7863806568418316202L;

	public MenuBar() {

		JMenu file = new JMenu("File");
		
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem novi = new JMenuItem("New");
		novi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
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
		novi.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem zatvori = new JMenuItem("Close");
		zatvori.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		zatvori.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		file.add(novi);
		novi.setIcon(new ImageIcon("ikonice/icons8-plus-24.png"));
		
		file.addSeparator();
		file.add(zatvori);
		zatvori.setIcon(new ImageIcon("ikonice/icons8-delete-20.png"));
		


		JMenu edit = new JMenu("Edit");
		
		edit.setMnemonic(KeyEvent.VK_E);
		JMenuItem edit1 = new JMenuItem("Edit");
		edit1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String selektovano = MainFrame.getSelectedTab();
				if (selektovano.equals("predmet")) {
					try {
						int indexUModelu = MainFrame.getTabelaPredmeti().convertRowIndexToModel(MainFrame.getTabelaPredmeti().getSelectedRow());
						DialogIzmenaPredmeta dialogIzmenaPredmeta = new DialogIzmenaPredmeta(indexUModelu);
					}catch(Exception ex){
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
					int idx = MainFrame.getTabelaStudenti().convertRowIndexToModel((MainFrame.getTabelaStudenti().getSelectedRow()));
					
					DialogIzmenaStudenta dialogIzmenaStudenta = new DialogIzmenaStudenta(idx);
				}else {
					int idx = MainFrame.getTabelaProfesori().convertRowIndexToModel(MainFrame.getTabelaProfesori().getSelectedRow());
					DialogIzmenaProfesora dialogIzmenaProfesora = new DialogIzmenaProfesora(idx);
				}
				
			}
		});
		edit1.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		JMenuItem delete = new JMenuItem("Delete");
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selektovano = MainFrame.getSelectedTab();
				if (selektovano.equals("predmet")) {
					
					try {
						int indexUModelu = MainFrame.getTabelaPredmeti().convertRowIndexToModel((MainFrame.getTabelaPredmeti().getSelectedRow()));
						UIManager.put("OptionPane.yesButtonText", "Da");
						UIManager.put("OptionPane.noButtonText", "Ne");
						ImageIcon icon = new ImageIcon("Images/deleteDialog.png");
						Image img = icon.getImage();
						Image newimg = img.getScaledInstance(40, 45, java.awt.Image.SCALE_SMOOTH); 		
						icon = new ImageIcon(newimg);
						if(JOptionPane.showConfirmDialog(MainFrame.getInstance(),"Da li ste sigurni da zelite da obrisete selektovani predmet?",
								"Brisanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon)==JOptionPane.YES_OPTION){
							Predmet.brisanjePredmeta(MyApp.getPredmeti().get(indexUModelu).getSifra());
							MainFrame.refreshTabova();
							dispose();
						}
					}catch(Exception ex){
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
					int indexUModelu = MainFrame.getTabelaStudenti().convertRowIndexToModel((MainFrame.getTabelaStudenti().getSelectedRow()));
					DialogBrisanjeStudenta brisanje = new DialogBrisanjeStudenta(indexUModelu);
					
				} else if(selektovano.equals("profesor")) {

					try {
						int indexUModelu = MainFrame.getTabelaProfesori().convertRowIndexToModel(MainFrame.getTabelaProfesori().getSelectedRow());
						
						UIManager.put("OptionPane.yesButtonText", "Da");
						UIManager.put("OptionPane.noButtonText", "Ne");
						ImageIcon icon = new ImageIcon("Images/deleteDialog.png");
						Image img = icon.getImage();
						Image newimg = img.getScaledInstance(40, 45, java.awt.Image.SCALE_SMOOTH); 		// Podesavanje velicine ikonice.
						icon = new ImageIcon(newimg);
						
						if(JOptionPane.showConfirmDialog(MainFrame.getInstance(),"Da li ste sigurni da zelite da obrisete selektovanog profesora?",
								"Brisanje profesora", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon)==JOptionPane.YES_OPTION){
							Profesor.brisanjeProfesora(MyApp.getProfesori().get(indexUModelu).getBrojLicneKarte());
							MainFrame.refreshTabova();
							dispose();
						}
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

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		delete.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		edit.add(edit1);
		edit1.setIcon(new ImageIcon("ikonice/icons8-edit-20.png"));
		
		edit.addSeparator();
		edit.add(delete);
		delete.setIcon(new ImageIcon("ikonice/icons8-delete-bin-20.png"));
		
		
		JMenu help = new JMenu("Help");
		
		help.setMnemonic(KeyEvent.VK_H);
		JMenuItem help1 = new JMenuItem("Help");
		help1.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_L, ActionEvent.CTRL_MASK));
			
		help.add(help1);
		help.addSeparator();
		JMenuItem about = new JMenuItem("About");
		about.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		help.add(about);

		help1.setIcon(new ImageIcon("ikonice/icons8-help-20.png"));
	
		about.setIcon(new ImageIcon("ikonice/icons8-about-20.png"));

		

		add(file);
		add(edit);
		add(help);

	}

}