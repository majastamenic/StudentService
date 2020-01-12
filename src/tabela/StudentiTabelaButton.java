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

	// dugme koje se iscrtava
	private JButton renderButton;
// referenca na tabelu
	private JTable table;

public StudentiTabelaButton(JTable table, int column) {
// povezivanje sa tabelom
this.table = table;
// nacin iscrtavanje celije
this.table.getColumnModel().getColumn(11).setCellRenderer(this);
this.table.addMouseListener(this);

// dugme koje ce biti iscrtavanp
this.renderButton = new JButton("Prikazi");

this.renderButton.addActionListener(new ActionListener() {
	// mozemo odavde pozvati nas kontroler da se nesto smisleno odradi
	@Override
	public void actionPerformed(ActionEvent e) {
		Student student = null;
		String brojIndeksa = (String) table.getValueAt(table.getSelectedRow(), 6);			// 6 da dobijemo broj indeksa
		
		for (Student stud : MyApp.getStudenti()) {
			if (stud.getBrojIndeksa().equals(brojIndeksa)) {
				student=stud;
				break;
			}
		}
		
		DialogPredmetiUStudentu predmetiKojeSlusa= new DialogPredmetiUStudentu(student);
	}
});

}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
// U ovom primeru, sva dugmad ce imati isti ispis,
// za promenu ispisa mozemo koristi vrednost parametra value
		//return new IgraciTablePanel(this.renderButton, 50, 50);
		MyButtonPanel mbp = new MyButtonPanel(this.renderButton, value);
		return mbp;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if (table.getSelectedColumn() == 11) {
			Student student = null;
			int kolona = 0;
			for (int i = 0; i < table.getColumnCount(); i++) {
				if (table.getColumnName(i).equals("Broj indeksa")) {
					kolona = i;
					break;
				}
			}
			String brojIndeksa = (String) table.getValueAt(table.getSelectedRow(), kolona);			
			
			for (Student s : MyApp.getStudenti()) {
				if (s.getBrojIndeksa().equals(brojIndeksa)) {
					student = s;
					break;
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

