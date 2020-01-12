package dialozi;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projekat.MainFrame;
import projekat.MyApp;
import projekat.Profesor;

public class DialogIzmenaProfesora extends JDialog{

	private static final long serialVersionUID = 1L;
	
	public DialogIzmenaProfesora(int idx) {
		
		setTitle("Izmena profesora");
		setSize(new Dimension(600, 500));
		
		Profesor profesor=MyApp.getProfesori().get(idx);
		GridBagConstraints g=new GridBagConstraints();
		setLayout(new GridBagLayout());
		
		g.gridx=0;
		g.gridy=0;
		JLabel labelaIme=new JLabel("Ime:");
		add(labelaIme,g);
		JTextField poljeIme=new JTextField(profesor.getIme());//postavljanje vrednosti koja je bila u selektovanom profesoru u tekst polje
		g.gridx=1;
		poljeIme.setMaximumSize(new Dimension(250,25));
		poljeIme.setMinimumSize(new Dimension(250,25));
		poljeIme.setPreferredSize(new Dimension(250,25));

		add(poljeIme,g);
		
		g.gridx=0;
		g.gridy=1;
		JLabel labelaPrezime=new JLabel("Prezime:");
		add(labelaPrezime,g);
		JTextField poljePrezime=new JTextField(profesor.getPrezime());
		g.gridx=1;
		poljePrezime.setMaximumSize(new Dimension(250,25));
		poljePrezime.setMinimumSize(new Dimension(250,25));
		poljePrezime.setPreferredSize(new Dimension(250,25));

		add(poljePrezime,g);
		
		g.gridx=0;
		g.gridy=2;
		JLabel labelaDatRodj=new JLabel("Datum rodjenja:");
		add(labelaDatRodj,g);
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		JTextField poljeDatRodj=new JTextField(sdf.format(profesor.getDatumRodjenja()));
		g.gridx=1;
		poljeDatRodj.setMaximumSize(new Dimension(250,25));
		poljeDatRodj.setMinimumSize(new Dimension(250,25));
		poljeDatRodj.setPreferredSize(new Dimension(250,25));

		add(poljeDatRodj,g);
		
		g.gridx=0;
		g.gridy=3;
		JLabel labelaAdresa=new JLabel("Adresa stanovanja:  ");
		add(labelaAdresa,g);
		JTextField poljeAdresaSt=new JTextField(profesor.getAdresaStanovanja());
		g.gridx=1;
		poljeAdresaSt.setMaximumSize(new Dimension(250,25));
		poljeAdresaSt.setMinimumSize(new Dimension(250,25));
		poljeAdresaSt.setPreferredSize(new Dimension(250,25));

		add(poljeAdresaSt,g);
		
		g.gridx=0;
		g.gridy=4;
		JLabel labelaTelefon=new JLabel("Telefon:");
		add(labelaTelefon,g);
		JTextField poljeTelefon=new JTextField(profesor.getTelefon());
		g.gridx=1;
		poljeTelefon.setMaximumSize(new Dimension(250,25));
		poljeTelefon.setMinimumSize(new Dimension(250,25));
		poljeTelefon.setPreferredSize(new Dimension(250,25));

		add(poljeTelefon,g);
		
		g.gridx=0;
		g.gridy=5;
		JLabel labelaEmail=new JLabel("Email:");
		add(labelaEmail,g);
		JTextField poljeEmail=new JTextField(profesor.getEmail());
		g.gridx=1;
		poljeEmail.setMaximumSize(new Dimension(250,25));
		poljeEmail.setMinimumSize(new Dimension(250,25));
		poljeEmail.setPreferredSize(new Dimension(250,25));

		add(poljeEmail,g);
		
		g.gridx=0;
		g.gridy=6;
		JLabel labelaAdresaKancelarije=new JLabel("Adresa kancelarije:  ");
		add(labelaAdresaKancelarije,g);
		JTextField poljeAdresaKn=new JTextField(profesor.getAdresaKancelarije());
		g.gridx=1;
		poljeAdresaKn.setMaximumSize(new Dimension(250,25));
		poljeAdresaKn.setMinimumSize(new Dimension(250,25));
		poljeAdresaKn.setPreferredSize(new Dimension(250,25));

		add(poljeAdresaKn,g);
		
		g.gridx=0;
		g.gridy=7;
		JLabel labelaBrojLicneKarte=new JLabel("Broj licne karte:  ");
		add(labelaBrojLicneKarte,g);
		JTextField poljeBrojLicneKarte=new JTextField(profesor.getBrojLicneKarte());
		g.gridx=1;
		poljeBrojLicneKarte.setMaximumSize(new Dimension(250,25));
		poljeBrojLicneKarte.setMinimumSize(new Dimension(250,25));
		poljeBrojLicneKarte.setPreferredSize(new Dimension(250,25));

		add(poljeBrojLicneKarte,g);
		
		g.gridx=0;
		g.gridy=8;
		JLabel labelaTitula=new JLabel("Titula:  ");
		add(labelaTitula,g);
		JTextField poljeTitula=new JTextField(profesor.getTitula());
		g.gridx=1;
		poljeTitula.setMaximumSize(new Dimension(250,25));
		poljeTitula.setMinimumSize(new Dimension(250,25));
		poljeTitula.setPreferredSize(new Dimension(250,25));

		add(poljeTitula,g);
		
		g.gridx=0;
		g.gridy=9;
		JLabel labelaZvanje=new JLabel("Zvanje:  ");
		add(labelaZvanje,g);
		JTextField poljeZvanje=new JTextField(profesor.getZvanje());
		g.gridx=1;
		poljeZvanje.setMaximumSize(new Dimension(250,25));
		poljeZvanje.setMinimumSize(new Dimension(250,25));
		poljeZvanje.setPreferredSize(new Dimension(250,25));

		add(poljeZvanje,g);
		
		JButton odustani=new JButton("Odustani");
		JButton sacuvaj=new JButton("Sacuvaj");
		
		ActionListener sacuvajKliknuto=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Profesor profesor=new Profesor();
				String ime=poljeIme.getText();
				String prezime=poljePrezime.getText();
				Date datRodj;
				try {
					datRodj = new SimpleDateFormat("dd-MM-yyyy").parse(poljeDatRodj.getText());
					profesor.setDatumRodjenja(datRodj);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				String adresaStanovanja=poljeAdresaSt.getText();
				String telefon=poljeTelefon.getText();
				String email=poljeEmail.getText();
				String adresaKanc=poljeAdresaKn.getText();
				String brLK=poljeBrojLicneKarte.getText();
				String titula=poljeTitula.getText();
				String zvanje= poljeZvanje.getText();
				
				
				profesor.setIme(ime);
				profesor.setPrezime(prezime);
				
				profesor.setAdresaStanovanja(adresaStanovanja);
				profesor.setTelefon(telefon);
				profesor.setEmail(email);
				profesor.setAdresaKancelarije(adresaKanc);
				profesor.setBrojLicneKarte(brLK);
				profesor.setTitula(titula);
				profesor.setZvanje(zvanje);
				
				Profesor.izmenaProfesora(profesor);
				
				MainFrame.refreshTabova();
				dispose();
			}
		};
		
		KeyListener popunjavanje=new KeyListener() { //zabrana stiskanja dugmeta ako nisu uneti svi podaci
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(poljeIme.getText().trim().isEmpty()|| poljePrezime.getText().trim().isEmpty()|| poljeAdresaSt.getText().trim().isEmpty()||
						poljeTelefon.getText().trim().isEmpty()||poljeEmail.getText().trim().isEmpty()||poljeAdresaKn.getText().trim().isEmpty()||
						poljeBrojLicneKarte.getText().trim().isEmpty()||poljeTitula.getText().trim().isEmpty()||poljeZvanje.getText().trim().isEmpty()) {
					sacuvaj.setEnabled(false);
				}else
					sacuvaj.setEnabled(true);
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		poljeIme.addKeyListener(popunjavanje);
		poljePrezime.addKeyListener(popunjavanje);
		poljeAdresaSt.addKeyListener(popunjavanje);
		poljeTelefon.addKeyListener(popunjavanje);
		poljeEmail.addKeyListener(popunjavanje);
		poljeAdresaKn.addKeyListener(popunjavanje);
		poljeBrojLicneKarte.addKeyListener(popunjavanje);
		poljeTitula.addKeyListener(popunjavanje);
		poljeZvanje.addKeyListener(popunjavanje);
		
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
