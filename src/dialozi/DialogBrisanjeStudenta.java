package dialozi;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import projekat.MainFrame;
import projekat.MyApp;
import projekat.Student;

public class DialogBrisanjeStudenta extends JDialog{

	private static final long serialVersionUID = 1L;

	public DialogBrisanjeStudenta(int indexUModelu) {
		setTitle("Brisanje studenta");
		setSize(new Dimension(600, 150));
		setLocationRelativeTo(null);
		GridBagConstraints g=new GridBagConstraints();
		setLayout(new GridBagLayout());
		
		String brojIndeksa=MyApp.getStudenti().get(indexUModelu).getBrojIndeksa(); //uzima broj indeksa selektovanog studenta
		
		
		g.gridx=0;
		g.gridy=0;
		JLabel labelaSigurnosti=new JLabel("Da li ste sigurni da zelite da obrisete studenta sa ovim brojem indeksa:"+brojIndeksa+"?");
		add(labelaSigurnosti,g);
		
		JButton da=new JButton("Da");
		JButton ne=new JButton("Ne");
		
		da.setSize(new Dimension(30, 30));
		ne.setSize(new Dimension(30, 30));
		setLocationRelativeTo(null);
		setVisible(true);
		
		da.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Student.brisanjeStudenta(MyApp.getStudenti().get(indexUModelu).getBrojIndeksa()); //poziva se metoda brisanje za selektovanog studenta sa tim brojem indeksa
				MainFrame.refreshTabova();
				dispose();
				
			}
		});
		
		
		g.gridx=1;
		g.gridy=2;
		add(da,g);
		
		ne.addActionListener(new ActionListener() { //ako kliknemo ne dijalog se zatvori
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		g.gridx=2;
		add(ne,g);
		setVisible(true);
	}
}
