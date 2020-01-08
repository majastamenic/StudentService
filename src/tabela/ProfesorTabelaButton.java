package tabela;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import dialozi.DialogPredmetiUProfesoru;
import projekat.MyApp;
import projekat.Profesor;

public class ProfesorTabelaButton implements MouseListener, TableCellRenderer{
	private JButton renderButton;
	private JTable table;
	
	public ProfesorTabelaButton(JTable table, int column) {
		this.table = table;
		this.table.getColumnModel().getColumn(10).setCellRenderer(this);
		this.table.addMouseListener(this);
		
		this.renderButton = new JButton("Prikazi");
		this.renderButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Profesor profesor = null;
				Long brojLicneKarte = (Long) table.getValueAt(table.getSelectedRow(), 7);
				
				for(Profesor p:MyApp.getProfesori()) {
					if(p.getBrojLicneKarte() == brojLicneKarte) {
						profesor = p;
						break;
					}
				}
				
				DialogPredmetiUProfesoru predmetiNaKojimaPredaje = new DialogPredmetiUProfesoru(profesor);
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(table.getSelectedColumn() == 10) {
			Profesor profesor = null;
			int kolona = 0;
			for(int i=0; i<table.getColumnCount(); i++) {
				if(table.getColumnName(i).equals("Broj licne karte")) {
					kolona = i;
					break;
				}
			}
			Long brojLicneKarte = (Long) table.getValueAt(table.getSelectedRow(), kolona);
			for(Profesor p: MyApp.getProfesori()) {
				if(p.getBrojLicneKarte()==brojLicneKarte) {
					profesor = p;
					break;
				}
			}
			DialogPredmetiUProfesoru predmetiNaKojimaPredaje = new DialogPredmetiUProfesoru(profesor);
		}	
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return new MyButtonPanel(this.renderButton, value);
	}
}
