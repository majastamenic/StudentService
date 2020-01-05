package dialozi;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projekat.MainFrame;
import projekat.MyApp;
import projekat.Predmet;
import projekat.Profesor;
import projekat.Student;

public class DialogIzmenaStudenta extends JDialog{

	private static final long serialVersionUID = 1L;

	public DialogIzmenaStudenta(int idx) {
		
		setTitle("Izmena studenta");
		setSize(new Dimension(600, 500));
		
		Student student = MyApp.getStudenti().get(idx);
		GridBagConstraints g=new GridBagConstraints();
		setLayout(new GridBagLayout());
		
		g.gridx=0;
		g.gridy=0;
		JLabel labelaIme=new JLabel("Ime:");
		add(labelaIme,g);
		JTextField poljeIme=new JTextField(student.getIme());
		g.gridx=1;
		poljeIme.setMaximumSize(new Dimension(250,25));
		poljeIme.setMinimumSize(new Dimension(250,25));
		poljeIme.setPreferredSize(new Dimension(250,25));

		add(poljeIme,g);
		
		g.gridx=0;
		g.gridy=1;
		JLabel labelaPrezime=new JLabel("Prezime:");
		add(labelaPrezime,g);
		JTextField poljePrezime=new JTextField(student.getPrezime());
		g.gridx=1;
		poljePrezime.setMaximumSize(new Dimension(250,25));
		poljePrezime.setMinimumSize(new Dimension(250,25));
		poljePrezime.setPreferredSize(new Dimension(250,25));

		add(poljePrezime,g);
		
		g.gridx=0;
		g.gridy=2;
		JLabel labelaDatRodj=new JLabel("Datum rodjenja:  ");
		add(labelaDatRodj,g);
		JTextField poljeDatRodj=new JTextField();
		g.gridx=1;
		poljeDatRodj.setMaximumSize(new Dimension(250,25));
		poljeDatRodj.setMinimumSize(new Dimension(250,25));
		poljeDatRodj.setPreferredSize(new Dimension(250,25));

		add(poljeDatRodj,g);
		
		g.gridx=0;
		g.gridy=3;
		JLabel labelaAdresa=new JLabel("Adresa stanovanja:  ");
		add(labelaAdresa,g);
		JTextField poljeAdresaSt=new JTextField(student.getAdresaStanovanja());
		g.gridx=1;
		poljeAdresaSt.setMaximumSize(new Dimension(250,25));
		poljeAdresaSt.setMinimumSize(new Dimension(250,25));
		poljeAdresaSt.setPreferredSize(new Dimension(250,25));

		add(poljeAdresaSt,g);
		
		g.gridx=0;
		g.gridy=4;
		JLabel labelaTelefon=new JLabel("Telefon:");
		add(labelaTelefon,g);
		JTextField poljeTelefon=new JTextField(student.getTelefon());
		g.gridx=1;
		poljeTelefon.setMaximumSize(new Dimension(250,25));
		poljeTelefon.setMinimumSize(new Dimension(250,25));
		poljeTelefon.setPreferredSize(new Dimension(250,25));

		add(poljeTelefon,g);
		
		g.gridx=0;
		g.gridy=5;
		JLabel labelaEmail=new JLabel("Email:");
		add(labelaEmail,g);
		JTextField poljeEmail=new JTextField(student.getEmail());
		g.gridx=1;
		poljeEmail.setMaximumSize(new Dimension(250,25));
		poljeEmail.setMinimumSize(new Dimension(250,25));
		poljeEmail.setPreferredSize(new Dimension(250,25));

		add(poljeEmail,g);
		
		g.gridx=0;
		g.gridy=6;
		JLabel labelaBrojIndeksa=new JLabel("Broj indeksa:  ");
		add(labelaBrojIndeksa,g);
		JTextField poljeBrojIndeksa=new JTextField(student.getBrojIndeksa());
		g.gridx=1;
		poljeBrojIndeksa.setMaximumSize(new Dimension(250,25));
		poljeBrojIndeksa.setMinimumSize(new Dimension(250,25));
		poljeBrojIndeksa.setPreferredSize(new Dimension(250,25));

		add(poljeBrojIndeksa,g);
		
		g.gridx=0;
		g.gridy=7;
		JLabel labelaDatumUpisa=new JLabel("Datum upisa:  ");
		add(labelaDatumUpisa,g);
		JTextField poljeDatumUpisa=new JTextField();
		g.gridx=1;
		poljeDatumUpisa.setMaximumSize(new Dimension(250,25));
		poljeDatumUpisa.setMinimumSize(new Dimension(250,25));
		poljeDatumUpisa.setPreferredSize(new Dimension(250,25));

		add(poljeDatumUpisa,g);
		
		g.gridx=0;
		g.gridy=8;
		JLabel labelaTrenutnaGodina=new JLabel("Trenutna godina:  ");
		add(labelaTrenutnaGodina,g);
		JTextField poljeTrenutnaGodina=new JTextField(Integer.toString(student.getGodinaStudija()));
		g.gridx=1;
		poljeTrenutnaGodina.setMaximumSize(new Dimension(250,25));
		poljeTrenutnaGodina.setMinimumSize(new Dimension(250,25));
		poljeTrenutnaGodina.setPreferredSize(new Dimension(250,25));

		add(poljeTrenutnaGodina,g);
		

		g.gridx=0;
		g.gridy=10;
		JLabel labelaProsecnaOcena=new JLabel("Prosecna ocena:  ");
		add(labelaProsecnaOcena,g);
		JTextField poljeProsecnaOcena=new JTextField(Double.toString(student.getProsecnaOcena()));
		g.gridx=1;
		poljeProsecnaOcena.setMaximumSize(new Dimension(250,25));
		poljeProsecnaOcena.setMinimumSize(new Dimension(250,25));
		poljeProsecnaOcena.setPreferredSize(new Dimension(250,25));

		add(poljeProsecnaOcena,g);
		JButton odustani=new JButton("Odustani");
		JButton sacuvaj=new JButton("Sacuvaj");
		
		ActionListener sacuvajKliknuto=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Student student=new Student();
				
				String ime=poljeIme.getText();
				String prezime=poljePrezime.getText();
				Date datRodj;
				Date datUpis;
				try {
					datUpis = new SimpleDateFormat("dd/MM/yyyy").parse(poljeDatumUpisa.getText());
					datRodj = new SimpleDateFormat("dd/MM/yyyy").parse(poljeDatRodj.getText());
					student.setDatumUpisa(datUpis);
					student.setDatumRodjenja(datRodj);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String adresaSt=poljeAdresaSt.getText();
				String telefon=poljeTelefon.getText();
				String email=poljeEmail.getText();
				String brojIndeksa=poljeBrojIndeksa.getText();
				Integer godStud=Integer.parseInt(poljeTrenutnaGodina.getText());
				Double prosOc=Double.parseDouble(poljeProsecnaOcena.getText());
				
				student.setIme(ime);
				student.setPrezime(prezime);
				student.setAdresaStanovanja(adresaSt);
				student.setTelefon(telefon);
				student.setEmail(email);
				student.setBrojIndeksa(brojIndeksa);
				student.setGodinaStudija(godStud);
				student.setProsecnaOcena(prosOc);
				
				Student.izmenaStudenta(student);
				
				MainFrame.refreshTabova();
				dispose();
			}
		};
		
		sacuvaj.addActionListener(sacuvajKliknuto);
		
		g.gridx=1;
		g.gridy=11;
		add(sacuvaj,g);
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		g.gridx=0;
		g.gridy=11;
		add(odustani,g);
		setLocationRelativeTo(null);
		setVisible(true);
}
}
