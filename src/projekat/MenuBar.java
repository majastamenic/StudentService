package projekat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import dialozi.DialogDodavanjePredmeta;
import dialozi.DialogDodavanjeProfesora;
import dialozi.DialogDodavanjeStudenta;



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


		file.add(novi);
		novi.setIcon(new ImageIcon("ikonice/icons8-plus-24.png"));
		
		file.addSeparator();
		file.add(zatvori);
		zatvori.setIcon(new ImageIcon("ikonice/icons8-delete-20.png"));
		


		JMenu edit = new JMenu("Edit");
		
		edit.setMnemonic(KeyEvent.VK_E);
		JMenuItem edit1 = new JMenuItem("Edit");
		edit1.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		JMenuItem delete = new JMenuItem("Delete");
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