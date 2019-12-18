package projekat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		
		setTitle("Studentska sluzba");
		
		ImageIcon img = new ImageIcon("Images/Icon5.png");
		Image image = img.getImage();
		Image newimg = image.getScaledInstance(330, 410,  java.awt.Image.SCALE_SMOOTH); //Podesavanje velicine ikonice.
		img = new ImageIcon(newimg);
		setIconImage(img.getImage());
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);     			//Gasi aplikaciju prilikom zatvaranje mainFrame-a.
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimenzijaEkrana = toolkit.getScreenSize();
		setSize(new Dimension(dimenzijaEkrana.width*3/4, dimenzijaEkrana.height*3/4));   //Podesavanje dimenzije ekrana.
		
		
		MyToolBar toolbar = new MyToolBar();
		toolbar.setSize(this.getSize().width, 100);
		add(toolbar, BorderLayout.NORTH);
		
		setLocationRelativeTo(null);
		
	}
	

}
