package tabela;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import dialozi.DialogStudentiUPredmetu;
import projekat.MyApp;
import projekat.Predmet;

public class PredmetiTableButton implements TableCellRenderer, MouseListener {

	// dugme koje se iscrtava
	private JButton renderButton;
// referenca na tabelu
	private JTable table;

public PredmetiTableButton(JTable table, int column) {
// povezivanje sa tabelom
this.table = table;
// nacin iscrtavanje celije
this.table.getColumnModel().getColumn(5).setCellRenderer(this);
this.table.addMouseListener(this);

// dugme koje ce biti iscrtavanp
this.renderButton = new JButton("Prikazi");

this.renderButton.addActionListener(new ActionListener() {
	// mozemo odavde pozvati nas kontroler da se nesto smisleno odradi
	@Override
	public void actionPerformed(ActionEvent e) {
		Predmet predmet = null;
		String sifraPredmeta = (String) table.getValueAt(table.getSelectedRow(), 0);			// 0-ti da dobijemo sifru predmeta
		
		for (Predmet p : MyApp.getPredmeti()) {
			if (p.getSifra().equals(sifraPredmeta)) {
				predmet = p;
				break;
			}
		}
		
		DialogStudentiUPredmetu studentiUPredmetu = new DialogStudentiUPredmetu(predmet);
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
		if (table.getSelectedColumn() == 5) {
			Predmet predmet = null;
			int kolona = 0;
			for (int i = 0; i < table.getColumnCount(); i++) {
				if (table.getColumnName(i).equals("Sifra")) {
					kolona = i;
					break;
				}
			}
			String sifraPredmeta = (String) table.getValueAt(table.getSelectedRow(), kolona);			
			
			for (Predmet p : MyApp.getPredmeti()) {
				if (p.getSifra().equals(sifraPredmeta)) {
					predmet = p;
					break;
				}
			}
//			System.out.println(predmet.getSifra());
			
//			JOptionPane.showMessageDialog(table, "Selektovan je igrac u redu: " + predmet.getNaziv());
			DialogStudentiUPredmetu studentiUPredmeti = new DialogStudentiUPredmetu(predmet);
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
