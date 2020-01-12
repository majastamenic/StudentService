package tabela;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import dialozi.DialogPredmetiUStudentu;
import dialozi.DialogStudentiUPredmetu;
import projekat.MyApp;
import projekat.Predmet;
import projekat.Student;

public class StudentiTabelaButton implements TableCellRenderer, MouseListener {

	
	private JButton renderButton; 	// dugme koje se iscrtava

	private JTable table;  // referenca na tabelu

public StudentiTabelaButton(JTable table, int column) {

this.table = table;  // povezivanje sa tabelom

this.table.getColumnModel().getColumn(11).setCellRenderer(this);  // nacin iscrtavanje celije
this.table.addMouseListener(this);


this.renderButton = new JButton("Prikazi");	// dugme koje ce biti iscrtavano

this.renderButton.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		Student student = null;	//gledamo koji je tacno student selektovan i uzimamo njegovu vrednost
		String brojIndeksa = (String) table.getValueAt(table.getSelectedRow(), 6);			// 6 da dobijemo broj indeksa
		
		for (Student stud : MyApp.getStudenti()) {
			if (stud.getBrojIndeksa().equals(brojIndeksa)) {
				student=stud;
				break;
			}
		}
		
		DialogPredmetiUStudentu predmetiKojeSlusa= new DialogPredmetiUStudentu(student); //pozivamo dijalog koji prikazuje predmete koje slusa
	}
});

}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
//svi dugmici imaju isti ispis
		MyButtonPanel mbp = new MyButtonPanel(this.renderButton, value);
		return mbp;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if (table.getSelectedColumn() == 11) {// ako kliknemo dugme koje je u poslednjoj koloni,trazimo koja je kolona broj indeksa jer je to kljuc
			Student student = null;
			int kolona = 0;
			for (int i = 0; i < table.getColumnCount(); i++) {
				if (table.getColumnName(i).equals("Broj indeksa")) {
					kolona = i;
					break;
				}
			}
			String brojIndeksa = (String) table.getValueAt(table.getSelectedRow(), kolona);	 		//uzimamo vrednost broja indeksa iz te kolone
			
			for (Student s : MyApp.getStudenti()) {
				if (s.getBrojIndeksa().equals(brojIndeksa)) {
					student = s;
					break;		//nadjemo studenta sa tim brojem indeksa i onda otvaramo njegov dijalog
				}
			}
			
			DialogPredmetiUStudentu predmetiKojeSlusa= new DialogPredmetiUStudentu(student);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
// ekplicitno navodimo da je editovanje celije je zavrseno
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}

