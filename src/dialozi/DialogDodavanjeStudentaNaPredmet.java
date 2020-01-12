package dialozi;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projekat.Predmet;
import projekat.Student;

public class DialogDodavanjeStudentaNaPredmet extends JDialog{

	private static final long serialVersionUID = 1L;
	
	public DialogDodavanjeStudentaNaPredmet(int idx) {
		
		setTitle("Dodavanje studenta na predmet");
		setSize(new Dimension(400, 200));
		setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("Izaberi studenta: "),gbc);
		gbc.gridx = 1; 
		JTextField poljeBrojIndeksa=new JTextField();
		poljeBrojIndeksa.setMaximumSize(new Dimension(250,25));
		poljeBrojIndeksa.setMinimumSize(new Dimension(250,25));
		poljeBrojIndeksa.setPreferredSize(new Dimension(250,25));
		
		add(poljeBrojIndeksa,gbc);
		
		JButton dodajStudenta = new JButton("Dodaj");
		ActionListener dodajStudentaAkcija = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ArrayList<Student> studenti=Util.ucitajStudente();
				for(Student student: studenti) {
				if(poljeBrojIndeksa.getText().equalsIgnoreCase(student.getBrojIndeksa())) { //prolazimo kroz studente i trazimo uneti broj indeksa
					
					
				}
				
				}
			}
		};
		
		gbc.gridx=0;
		gbc.gridy=2;
		dodajStudenta.addActionListener(dodajStudentaAkcija);
		add(dodajStudenta,gbc);
		
		
		
		JButton odustani = new JButton("Odustani");
		ActionListener odustaniAkcija = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}
		};
		odustani.addActionListener(odustaniAkcija);
		gbc.gridx=1;
		add(odustani,gbc);
		
		setVisible(true);
	}

}
