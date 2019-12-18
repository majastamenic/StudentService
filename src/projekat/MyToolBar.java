package projekat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class MyToolBar extends JToolBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		JButton btnDodavanje = new JButton("Dodavanje");
		// btnDodavanje.addActionListener(new DodavanjePredmetaActionListener());
		ImageIcon img = new ImageIcon("Images/dodavanje.png");
		btnDodavanje.setIcon(new ImageIcon(img.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));	// smanjivanje ikonice
		btnDodavanje.setSize(1000, getHeight());
		btnDodavanje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				if (oznacenStudent) {
//					
//				} else if (oznacenProfesor) {
//					dodavanjeProfesoraActionListener();
//				}

				DialogDodavanjePredmeta dialogDodavanjePredmeta = new DialogDodavanjePredmeta();
				
			}
		});
		add(btnDodavanje);
		
		JButton btnIzmena = new JButton("Izmena");
		btnIzmena.setIcon(new ImageIcon("Images/izmena.png"));
		ImageIcon img1 = new ImageIcon("Images/izmena.png");
		btnIzmena.setIcon(new ImageIcon(img1.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		add(btnIzmena);
		
		JButton btnBrisanje = new JButton("Brisanje");
		btnBrisanje.setIcon(new ImageIcon("Images/delete.png"));
		ImageIcon img2 = new ImageIcon("Images/delete.png");
		btnBrisanje.setIcon(new ImageIcon(img2.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		add(btnBrisanje);
		
		addSeparator(getMaximumSize());
		JTextField tekst = new JTextField();
		tekst.setSize(new Dimension(20, 20));
		add(tekst);
		
		JButton btnPretraga= new JButton("Pretraga");
		btnPretraga.setIcon(new ImageIcon("Images/pretrazivanje.png"));
		ImageIcon img3 = new ImageIcon("Images/pretrazivanje.png");
		btnPretraga.setIcon(new ImageIcon(img3.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		add(btnPretraga);
		
		
		setVisible(true);
	}
}
