package tabela;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

public class MyButtonPanel extends JPanel{
	
	Object value;
	public MyButtonPanel() {
		setSize(200, 50);
		
	}
	public MyButtonPanel(Component c, Object value) {
		this();
		this.value = value;
//		c.setSize(100, 20);
		add(c);		//dodaj dugme na panel
	}

}
