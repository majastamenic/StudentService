package projekat;

import java.awt.event.KeyEvent;


import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = -7863806568418316202L;

	public MenuBar() {

		JMenu file = new JMenu("File");
		JMenuItem novi = new JMenuItem("New");
		JMenuItem zatvori = new JMenuItem("Close");


		file.add(novi);
		novi.setIcon(new ImageIcon("icons8-plus-24.png"));
		novi.setMnemonic(KeyEvent.VK_N);
		file.addSeparator();
		file.add(zatvori);
		zatvori.setIcon(new ImageIcon("icons8-delete-20.png"));
		zatvori.setMnemonic(KeyEvent.VK_C);


		JMenu edit = new JMenu("Edit");
		JMenuItem edit1 = new JMenuItem("Edit");
		JMenuItem delete = new JMenuItem("Delete");
		
		edit.add(edit1);
		edit1.setIcon(new ImageIcon("icons8-edit-20.png"));
		edit1.setMnemonic(KeyEvent.VK_E);
		edit.addSeparator();
		edit.add(delete);
		delete.setIcon(new ImageIcon("icons8-delete-bin-20.png"));
		delete.setMnemonic(KeyEvent.VK_D);
		
		JMenu help = new JMenu("Help");
		JMenuItem help1 = new JMenuItem("Help");
			
		help.add(help1);
		help.addSeparator();
		JMenuItem about = new JMenuItem("About");
		help.add(about);

		help1.setIcon(new ImageIcon("icons8-help-20.png"));
		help1.setMnemonic(KeyEvent.VK_H);
		about.setIcon(new ImageIcon("icons8-about-20.png"));
		about.setMnemonic(KeyEvent.VK_A);

		

		add(file);
		add(edit);
		add(help);

	}

}