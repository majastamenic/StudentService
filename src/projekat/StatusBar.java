package projekat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StatusBar extends JMenuBar{


	private static final long serialVersionUID = 1L;
	
	public StatusBar() {
		
		JPanel leviPanel=new JPanel();
		leviPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		leviPanel.setBackground(Color.GRAY);
		JLabel levaLabela=new JLabel("Studentska sluzba");
		
		
		leviPanel.add(levaLabela, BorderLayout.NORTH);
		
		add(leviPanel);
		
		JPanel desniPanel=new JPanel();
		desniPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		desniPanel.setBackground(Color.GRAY);
		JLabel desnaLabela=new JLabel();
		Timer timer=new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date datum= new Date();
				DateFormat datumFormat=new SimpleDateFormat("HH:mm:ss     dd.MM.yyyy. ");
				desnaLabela.setText(datumFormat.format(datum));
			}
		});
		timer.start();//omogucavanje vremena koje tece
		
		
		
		desniPanel.add(desnaLabela);
		
		add(desniPanel);
		
		
	}

}
