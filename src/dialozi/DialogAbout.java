package dialozi;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class DialogAbout extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DialogAbout() {
		setTitle("O aplikaciji");
		setSize(new Dimension(600, 400));

		String string=new String("<html>"
				+"Ovo je prva verzija aplikacije Studentska sluzba autora: Maja Stamenic i Nastasja Damjanac."
				+"<br>"
				+"<br>"
				+"Samo koriscenje aplikacije opisano je u delu help,kom se poze pristupiti preko precice CTRL+L."
				+"<br>"
				+"<br>"
				+"Podaci o autorima aplikacije:"
				+"<br>"
				+"<br>"
				+"Maja Stamenic, br. indeksa RA65/2017, rodjena je u Sarajevu 5.11.1998. Osnovnu, kao i srednju"
				+"<br>"
				+ "skolu pohadjala je u Novom Sadu. 2017.godine upisala je Fakultet tehnickih nauka, smer"
				+"<br>"
				+ " Racunarstvo i automatika."
				+"<br>"
				+"<br>"
				+"Nastasja Damjanac, br. indeksa RA638/2017, rodjena je u Novom Sadu 10.8.1998. Osnovnu, kao i"
				+"<br>"
				+ " srednju skolu pohadjala je u Novom Sadu. 2017.godine upisala je Fakultet tehnickih nauka,"
				+"<br>"
				+ " smer Racunarstvo i automatika."
				+"</html>");
		
		JLabel tekst=new JLabel(string);
		
		JScrollPane skrolovanje=new JScrollPane(tekst);
		skrolovanje.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		add(skrolovanje,BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setVisible(true);
		}
	}

