package dialozi;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import projekat.MainFrame;
import projekat.MyApp;
import projekat.Predmet;

public class DialogUklanjanjeProfesoraSaPredmet extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DialogUklanjanjeProfesoraSaPredmet(int indexUModelu){
		setLocationRelativeTo(null);
		String sifra = MyApp.getPredmeti().get(indexUModelu).getSifra();
		
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				UIManager.put("OptionPane.yesButtonText", "Da");
				UIManager.put("OptionPane.noButtonText", "Ne");
				
				ImageIcon icon = new ImageIcon("Images/deleteDialog.png");
				Image img = icon.getImage();
				Image newimg = img.getScaledInstance(40, 45, java.awt.Image.SCALE_SMOOTH); // Podesavanje velicine ikonice.
				icon = new ImageIcon(newimg);
				if(JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da zelite da uklonite profesora sa predmeta?",
					"Potvrda o brisanju profesora sa predmeta", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, icon) == JOptionPane.YES_OPTION) {
					Predmet.uklanjanjeProfesora(MyApp.getPredmeti().get(indexUModelu).getPredmetniProfesor(), sifra);
					MainFrame.refreshTabova();
				}
				dispose();		
			}
		});
		setVisible(true);
	}
}
