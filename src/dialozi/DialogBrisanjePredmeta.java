package dialozi;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;

import projekat.MainFrame;
import projekat.MyApp;
import projekat.Predmet;

public class DialogBrisanjePredmeta extends JDialog{
	
	/**
	 * NE KORISTI SE - RUCNO RADJEN DIALOG ZA POTVRDU BRISANJA PREDMETA
	 */
	private static final long serialVersionUID = 1L;

	public DialogBrisanjePredmeta(int indexUModelu) {
		
		setTitle("Brisanje predmeta");
		setSize(new Dimension(400, 200));
		setLocationRelativeTo(null);
		
		ImageIcon img = new ImageIcon("Images/Icon5.png");
		Image image = img.getImage();
		Image newimg = image.getScaledInstance(330, 410, java.awt.Image.SCALE_SMOOTH); // Podesavanje velicine ikonice.
		img = new ImageIcon(newimg);
		setIconImage(img.getImage());
		
		String sifra = MyApp.getPredmeti().get(indexUModelu).getSifra();
		String nazivPredmeta = MyApp.getPredmeti().get(indexUModelu).getNaziv();
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JTextArea tekst = new JTextArea("Da li ste sigurni da zelite da izbrisete predmet sa sifrom:"+sifra+" i nazivom: "+nazivPredmeta+"?");
	    tekst.setSize(400, 40);
		tekst.setLineWrap(true);
	    tekst.setEditable(false);
		
		add(tekst);
		
		JButton da = new JButton("Da");
		da.setSize(new Dimension(20, 20));
		JButton ne = new JButton("Ne");
		ne.setSize(new Dimension(20, 20));
		
		
		da.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Predmet.brisanjePredmeta(MyApp.getPredmeti().get(indexUModelu).getSifra());
				MainFrame.refreshTabova();
				dispose();
				
			}
		});
		
		gbc.insets = new Insets(20, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(da, gbc);
		ne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		gbc.gridx = 2;
		add(ne, gbc);
		setVisible(true);
	}

}
