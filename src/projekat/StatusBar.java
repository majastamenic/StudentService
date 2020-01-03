package projekat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class StatusBar extends JMenuBar{


	private static final long serialVersionUID = 1L;
	
	public StatusBar() {
		
		JPanel leviPanel=new JPanel();
		leviPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		leviPanel.setBackground(Color.GRAY);
		JLabel levaLabela=new JLabel("Studentska sluzba");
		
		levaLabela.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.RED));
		leviPanel.add(levaLabela, BorderLayout.NORTH);
		
		add(leviPanel);
		
		JPanel desniPanel=new JPanel();
		desniPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		desniPanel.setBackground(Color.GRAY);
		
		DateFormat datumFormat=new SimpleDateFormat("HH:mm     dd.MM.yyyy. ");
		JLabel desnaLabela=new JLabel(datumFormat.format(new Date()));
		desnaLabela.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.RED));
		desniPanel.add(desnaLabela);
		
		add(desniPanel);
	}

}
