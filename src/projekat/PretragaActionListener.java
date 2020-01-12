package projekat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import tabela.PredmetiTabela;
import tabela.ProfesoriTabela;
import tabela.StudentiTabela;

public class PretragaActionListener implements ActionListener{

	private String tekst;
	
	public PretragaActionListener(String tekst) {
		this.tekst = tekst;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String selektovano = MainFrame.getSelectedTab();
		if (tekst.equals("")) {
			MainFrame.refreshTabova();
		}else if(tekst != null) {
			String[] string1 = tekst.split(";"); 
			String[] string2 = null;
			if (selektovano.equals("predmet")) {
				ArrayList<Predmet> listaRezultatPredmeti = MyApp.predmeti;
				for(int i=0; i<string1.length; i++) {
					try {	
						string2 = string1[i].split(":");
						String kljuc = string2[0].toLowerCase();
						String vrednost = string2[1].toLowerCase();
						
						if(kljuc.equals("sifra")) {
							ArrayList<Predmet> privremena = listaRezultatPredmeti;		//u njoj se nalazi dosadasnji rezultat
							listaRezultatPredmeti = new ArrayList<Predmet>();
							for(int j = 0; j<privremena.size(); j++) {
								if(privremena.get(j).getSifra().toLowerCase().contains(vrednost)) {
									listaRezultatPredmeti.add(privremena.get(j));
								}
							}
							
						} else if(kljuc.equals("naziv")) {
							ArrayList<Predmet> privremena = listaRezultatPredmeti;		
							listaRezultatPredmeti = new ArrayList<Predmet>();
							for(int j = 0; j<privremena.size(); j++) {
								if(privremena.get(j).getNaziv().toLowerCase().contains(vrednost)) {
									listaRezultatPredmeti.add(privremena.get(j));
								}
							}
						} else if(kljuc.equals("semestar")) {
							ArrayList<Predmet> privremena = listaRezultatPredmeti;		
							listaRezultatPredmeti = new ArrayList<Predmet>();
							for(int j = 0; j<privremena.size(); j++) {
								if(privremena.get(j).getSemestar() == Integer.parseInt(vrednost)) {
									listaRezultatPredmeti.add(privremena.get(j));
								}
							}
						} else if(kljuc.equals("godinastudija") || kljuc.equals("godina_studija") || kljuc.equals("godina")) {
							ArrayList<Predmet> privremena = listaRezultatPredmeti;		
							listaRezultatPredmeti = new ArrayList<Predmet>();
							for(int j = 0; j<privremena.size(); j++) {
								if(privremena.get(j).getGodinaStudija() == Integer.parseInt(vrednost)) {
									listaRezultatPredmeti.add(privremena.get(j));
								}
							}
						} else if(kljuc.equals("predmetniprofesor") || kljuc.equals("predmetni_profesor") || kljuc.equals("profesor")) {
							ArrayList<Predmet> privremena = listaRezultatPredmeti;		
							listaRezultatPredmeti = new ArrayList<Predmet>();
							for(int j = 0; j<privremena.size(); j++) {
								if(privremena.get(j).getPredmetniProfesor().getBrojLicneKarte().equals(vrednost)) {
									listaRezultatPredmeti.add(privremena.get(j));
								}
							}
						}
					} catch(Exception ex) {
						UIManager.put("OptionPane.okButtonText", "OK");
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Podaci za pretragu nisu uneti u trazenom formatu!", "Pogresan format", JOptionPane.OK_OPTION);
					}
				}
				
				MainFrame.getTabovi().remove(2);  			// index za tab profesori
				MainFrame.getTabovi().addTab("Predmeti", new JScrollPane(new PredmetiTabela(listaRezultatPredmeti)));
				MainFrame.getTabovi().setSelectedIndex(2);
//				MainFrame.setTabelaPredmeti(new PredmetiTabela(listaRezultatPredmeti));
				
			} else if (selektovano.equals("profesor")) {
				ArrayList<Profesor> listaRezultatProfesori = MyApp.profesori;
				for(int i=0; i<string1.length; i++) {
					try{ 
						string2 = string1[i].split(":");
						String kljuc = string2[0].toLowerCase();
						String vrednost = string2[1].toLowerCase();
					
					
					if(kljuc.equals("ime")) {
						ArrayList<Profesor> privremena = listaRezultatProfesori;
						listaRezultatProfesori = new ArrayList<Profesor>();
						for(int j = 0; j<privremena.size(); j++) {
							if(privremena.get(j).getIme().toLowerCase().contains(vrednost)) {
								listaRezultatProfesori.add(privremena.get(j));
							}
						}
						
					} else if(kljuc.equals("prezime")) {
						ArrayList<Profesor> privremena = listaRezultatProfesori;
						listaRezultatProfesori = new ArrayList<Profesor>();
						for(int j = 0; j<privremena.size(); j++) {
							if(privremena.get(j).getPrezime().toLowerCase().contains(vrednost)) {
								listaRezultatProfesori.add(privremena.get(j));
							}
						}
						
					} else if(kljuc.equals("datumrodjenja") || kljuc.equals("datum_rodjenja") || kljuc.equals("datum")) {
						final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						sdf.setTimeZone(TimeZone.getTimeZone("UTC"));   
						ArrayList<Profesor> privremena = listaRezultatProfesori;
						listaRezultatProfesori = new ArrayList<Profesor>();
						for(int j = 0; j<privremena.size(); j++) {
							Date privremeniDatum = sdf.parse(vrednost);
							if(privremena.get(j).getDatumRodjenja().equals(privremeniDatum)) {
								listaRezultatProfesori.add(privremena.get(j));
							}
						}
					} else if(kljuc.equals("adresastanovanja") || kljuc.equals("adresa_stanovanja") || kljuc.equals("adresas")) {
						ArrayList<Profesor> privremena = listaRezultatProfesori;
						listaRezultatProfesori = new ArrayList<Profesor>();
						for(int j = 0; j<privremena.size(); j++) {
							if(privremena.get(j).getAdresaStanovanja().toLowerCase().contains(vrednost)) {
								listaRezultatProfesori.add(privremena.get(j));
							}
						}
					} else if(kljuc.equals("telefon")) {
						ArrayList<Profesor> privremena = listaRezultatProfesori;
						listaRezultatProfesori = new ArrayList<Profesor>();
						for(int j = 0; j<privremena.size(); j++) {
							if(privremena.get(j).getTelefon().toLowerCase().contains(vrednost)) {
								listaRezultatProfesori.add(privremena.get(j));
							}
						}
					} else if(kljuc.equals("email") || kljuc.equals("e-mail")) {
						ArrayList<Profesor> privremena = listaRezultatProfesori;
						listaRezultatProfesori = new ArrayList<Profesor>();
						for(int j = 0; j<privremena.size(); j++) {
							if(privremena.get(j).getEmail().toLowerCase().contains(vrednost)) {
								listaRezultatProfesori.add(privremena.get(j));
							}
						}
					} else if(kljuc.equals("adresakancelarije") || kljuc.equals("adresa_kancelarije") || kljuc.equals("adesak")) {
						ArrayList<Profesor> privremena = listaRezultatProfesori;
						listaRezultatProfesori = new ArrayList<Profesor>();
						for(int j = 0; j<privremena.size(); j++) {
							if(privremena.get(j).getAdresaKancelarije().toLowerCase().contains(vrednost)) {
								listaRezultatProfesori.add(privremena.get(j));
							}
						}
					} else if(kljuc.equals("brojlicnekarte") || kljuc.equals("broj_licne_karte") || kljuc.equals("br.lk")) {
						ArrayList<Profesor> privremena = listaRezultatProfesori;
						listaRezultatProfesori = new ArrayList<Profesor>();
						for(int j = 0; j<privremena.size(); j++) {
							if(privremena.get(j).getBrojLicneKarte().contains(vrednost)) {
								listaRezultatProfesori.add(privremena.get(j));
							}
						}
					} else if(kljuc.equals("titula")) {
						ArrayList<Profesor> privremena = listaRezultatProfesori;
						listaRezultatProfesori = new ArrayList<Profesor>();
						for(int j = 0; j<privremena.size(); j++) {
							if(privremena.get(j).getTitula().toLowerCase().contains(vrednost)) {
								listaRezultatProfesori.add(privremena.get(j));
							}
						}
					} else if(kljuc.equals("zvanje")) {
						ArrayList<Profesor> privremena = listaRezultatProfesori;
						listaRezultatProfesori = new ArrayList<Profesor>();
						for(int j = 0; j<privremena.size(); j++) {
							if(privremena.get(j).getZvanje().toLowerCase().contains(vrednost)) {
								listaRezultatProfesori.add(privremena.get(j));
							}
						}
					} 
				} catch (Exception ex) {
					UIManager.put("OptionPane.okButtonText", "OK");
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Podaci za pretragu nisu uneti u trazenom formatu!",
							"Pogresan format", JOptionPane.OK_OPTION);
				}
				
			 }
				int selektovaniIndex = MainFrame.getTabovi().getSelectedIndex();
				
				MainFrame.getTabovi().removeAll();
				MainFrame.getTabovi().addTab("Studenti", new JScrollPane(new StudentiTabela(MyApp.studenti)));
				MainFrame.getTabovi().addTab("Profesori", new JScrollPane(new ProfesoriTabela(listaRezultatProfesori)));
				MainFrame.getTabovi().addTab("Predmeti", new JScrollPane(new PredmetiTabela(MyApp.predmeti)));
				MainFrame.getTabovi().setSelectedIndex(selektovaniIndex);
			
			
		}
			 else {
					ArrayList<Student> listaRezultatStudenti = MyApp.studenti;
					for(int i=0; i<string1.length; i++) {
						try{ 
							string2 = string1[i].split(":"); //splitujemo po : i dobijamo odvojene vrednosti kljuca i vrednosti
							String kljuc = string2[0].toLowerCase();
							String vrednost = string2[1].toLowerCase();
						
						
						if(kljuc.equals("ime")) { //proveravamo da li neki student ima datu unetu vrednost, ako ima dodajemo ga u rezultat
							ArrayList<Student> privremena = listaRezultatStudenti;
							listaRezultatStudenti = new ArrayList<Student>();
							for(int j = 0; j<privremena.size(); j++) {
								if(privremena.get(j).getIme().toLowerCase().contains(vrednost)) {
									listaRezultatStudenti.add(privremena.get(j));
								}
							}
							
						} else if(kljuc.equals("prezime")) { 
							ArrayList<Student> privremena = listaRezultatStudenti;
							listaRezultatStudenti = new ArrayList<Student>();
							for(int j = 0; j<privremena.size(); j++) {
								if(privremena.get(j).getPrezime().toLowerCase().contains(vrednost)) {
									listaRezultatStudenti.add(privremena.get(j));
								}
							}
							
						} else if(kljuc.equals("datumrodjenja") || kljuc.equals("datum_rodjenja") || kljuc.equals("datum")) {
							final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							sdf.setTimeZone(TimeZone.getTimeZone("UTC"));   
							ArrayList<Student> privremena = listaRezultatStudenti;
							listaRezultatStudenti = new ArrayList<Student>();
							for(int j = 0; j<privremena.size(); j++) {
								Date privremeniDatum = sdf.parse(vrednost);
								if(privremena.get(j).getDatumRodjenja().equals(privremeniDatum)) {
									listaRezultatStudenti.add(privremena.get(j));
								}
							}
						} else if(kljuc.equals("adresastanovanja") || kljuc.equals("adresa_stanovanja") || kljuc.equals("adresas")) { 
							ArrayList<Student> privremena = listaRezultatStudenti;
							listaRezultatStudenti = new ArrayList<Student>();
							for(int j = 0; j<privremena.size(); j++) {
								if(privremena.get(j).getAdresaStanovanja().toLowerCase().contains(vrednost)) {
									listaRezultatStudenti.add(privremena.get(j));
								}
							}
						} else if(kljuc.equals("telefon")) {
							ArrayList<Student> privremena = listaRezultatStudenti;
							listaRezultatStudenti = new ArrayList<Student>();
							for(int j = 0; j<privremena.size(); j++) {
								if(privremena.get(j).getTelefon().toLowerCase().contains(vrednost)) {
									listaRezultatStudenti.add(privremena.get(j));
								}
							}
						} else if(kljuc.equals("email") || kljuc.equals("e-mail")) {
							ArrayList<Student> privremena = listaRezultatStudenti;
							listaRezultatStudenti = new ArrayList<Student>();
							for(int j = 0; j<privremena.size(); j++) {
								if(privremena.get(j).getEmail().toLowerCase().contains(vrednost)) {
									listaRezultatStudenti.add(privremena.get(j));
								}
							}
						} else if(kljuc.equals("brojindeksa") || kljuc.equals("broj_indeksa") || kljuc.equals("brI")) {
							ArrayList<Student> privremena = listaRezultatStudenti;
							listaRezultatStudenti = new ArrayList<Student>();
							for(int j = 0; j<privremena.size(); j++) {
								if(privremena.get(j).getBrojIndeksa().toLowerCase().contains(vrednost)) {
									listaRezultatStudenti.add(privremena.get(j));
								}
							}
						} else if(kljuc.equals("datumupisa") || kljuc.equals("datum_upisa") || kljuc.equals("datumu")) {
							final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							sdf.setTimeZone(TimeZone.getTimeZone("UTC"));   
							ArrayList<Student> privremena = listaRezultatStudenti;
							listaRezultatStudenti = new ArrayList<Student>();
							for(int j = 0; j<privremena.size(); j++) {
								Date privremeniDatum = sdf.parse(vrednost);
								if(privremena.get(j).getDatumUpisa().equals(privremeniDatum)) {
									listaRezultatStudenti.add(privremena.get(j));
								}
							}
						}else if(kljuc.equals("godinastudija") || kljuc.equals("godina_studija") || kljuc.equals("godStud")) {
							ArrayList<Student> privremena = listaRezultatStudenti;
							listaRezultatStudenti = new ArrayList<Student>();
							for(int j = 0; j<privremena.size(); j++) {
								if(privremena.get(j).getGodinaStudija().toLowerCase().contains(vrednost)) {
									listaRezultatStudenti.add(privremena.get(j));
								}
							}
						} else if(kljuc.equals("prosecnaocena") || kljuc.equals("prosecna_ocena") || kljuc.equals("prosOc")) {
							ArrayList<Student> privremena = listaRezultatStudenti;		
							listaRezultatStudenti = new ArrayList<Student>();
							for(int j = 0; j<privremena.size(); j++) {
								if(privremena.get(j).getProsecnaOcena() == Double.parseDouble(vrednost)) {
									listaRezultatStudenti.add(privremena.get(j));
								}
							}
						}
					} catch (Exception ex) {
						UIManager.put("OptionPane.okButtonText", "OK");
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Podaci za pretragu nisu uneti u trazenom formatu!",
								"Pogresan format", JOptionPane.OK_OPTION);
					}
					
				 }
					int selektovaniIndex = MainFrame.getTabovi().getSelectedIndex(); //uzimamo tab koji je selektovan
					
					MainFrame.getTabovi().removeAll();//sklanjamo sve iz tabele
					MainFrame.getTabovi().addTab("Studenti", new JScrollPane(new StudentiTabela(listaRezultatStudenti))); //u studente ubacujemo samo studenta kome odgovaraju vrednosti iz pretrage
					MainFrame.getTabovi().addTab("Profesori", new JScrollPane(new ProfesoriTabela(MyApp.profesori)));//u ostale tabele vracamo sve
					MainFrame.getTabovi().addTab("Predmeti", new JScrollPane(new PredmetiTabela(MyApp.predmeti)));
					MainFrame.getTabovi().setSelectedIndex(selektovaniIndex);
				
				
			}
	  }	
	}
	
}
