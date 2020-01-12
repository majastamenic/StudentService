package dialozi;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class DialogHelp extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7599009428466766369L;
	
	public DialogHelp() {
		// TODO Auto-generated constructor stub
	setTitle("Pomoc");
	setSize(new Dimension(600, 400));

	String string=new String("<html>"
			+ "-Aplikacija je namenjena da simulira rad studentske sluzbe."
			+ "<br>"
			+ "<br>"
			+ "-Poseduje tabove koji prikazuju studente, profesore i predmete koji se nalaze na sluzbi."
			+ "<br>"
			+ "<br>"
			+ "-Ukoliko zelimo da dodamo studenta/predmeta/profesora to mozemo uciniti pritiskom na prvo"
			+ "<br>"
			+ " dugme toolbara, odnosno koristeci precicu CTRL+N."
			+ "<br>"
			+ "<br>"
			+ "-Ukoliko zelimo da izmenimo studenta/predmeta/profesora to mozemo uciniti pritiskom na drugo"
			+ "<br>"
			+ " dugme toolbara, odnosno koristeci precicu CTRL+T. Takodje, pre izmene moramo selektovati"
			+ "<br>"
			+ " studenta/predmeta/profesora koje zelimo da izmenimo."
			+ "<br>"
			+ "<br>"
			+ "-Ukoliko zelimo da izbrisemo studenta/predmet/profesora to mozemo uciniti pritiskom na trece"
			+ "<br>"
			+ " dugme toolbara, odnosno koristeci precicu CTRL+D. Takodje, pre brisanja moramo selektovati"
			+ "<br>"
			+ " studenta/predmeta/profesora koje zelimo da izbrisemo."
			+ "<br>"
			+ "<br>"
			+ "-Pretraga studentske sluzbe se moze vrsiti u formatu kljucevi:vrednosti koji su odvojeni"
			+ "<br>"
			+ " znakom ; i pritiskom na dugme pretraga u desnom delu toolbara."
			+ "<br>"
			+ "<br>"
			+ "-U tabeli predmeti moze da se doda predmetni profesor pritiskom na cetvrto dugme toolbara"
			+ "<br>"
			+ " kada je selektovana tabela predmeti."
			+ "<br>"
			+ "<br>"
			+ "-U tabeli predmeti mogu da se dodaju studenti koji slusaju predmet pritiskom na sesto dugme"
			+ "<br>"
			+ " toolbara kada je selektovana tabela predmeti."
			+ "<br>"
			+ "<br>"
			+ "-U tabeli predmeti moze da se izbrise predmetni profesor pritiskom na peto dugme toolbara"
			+ "<br>"
			+ " kada je selektovana tabela predmeti. Takodje mora da se selektuje predmet pre brisanja"
			+ "<br>"
			+ " profesora."
			+ "<br>"
			+ "<br>"
			+ "-U tabeli predmeti moze da se izbrise student pritiskom na dugme koje se nalazi u poslednjoj"
			+ "<br>"
			+ " koloni tabele predmeti"
			+ "<br>"
			+ "<br>"
			+ "-Sortiranje studenta/predmet/profesora vrsi se pritiskom na dugme koje se nalazi sa desne strane"
			+ "<br>"
			+ " svakog imena kolone."
			+ "<br>"
			+ "<br>"
			+ "-Gasenje aplikacije vrsi se pritiskom na dugme u gornjem desnom uglu ili koriscenjem precice"
			+ "<br>"
			+ " CTRL+C."
			+ "<br>"
			+ "<br>"
			+ "-Liste kao sto su predmeti koje student slusa ili studenti koji slusaju predmet nalaze se u"
			+ "<br>"
			+ " poslednjoj koloni tabela studenti i predmeti i mogu se prikazati pritiskom na dugme prikazi."
			+ "<br>"
			+ "<br>"
			+ "-Dugme sacuvaj sluzi za cuvanje izmena/dodavanja i ukoliko podaci nisu dobro uneti bice onemoguceno."
			+ "<br>"
			+ "<br>"
			+ "-Dugme odustani sluzi za odustanak izmena/dodavanja."
			+ "<br>"
			+ "<br>"
			+"-Pritiskom na dugme ok/da potvrdjujete da se slazete sa ponudjenim akcijama."
			+ "<br>"
			+ "<br>"
			+ "-Pritiskom na dugme ne potvrdjujete da se ne slazete sa ponudjenim akcijama."
			+"</html>");
	
	JLabel tekst=new JLabel(string);
	
	JScrollPane skrolovanje=new JScrollPane(tekst);
	skrolovanje.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	
	add(skrolovanje,BorderLayout.CENTER);
	
	setLocationRelativeTo(null);
	setVisible(true);
	}
}