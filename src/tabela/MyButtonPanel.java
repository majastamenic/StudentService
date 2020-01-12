package tabela;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

public class MyButtonPanel extends JPanel{
	
	Object value;
	public MyButtonPanel() {
		
	}
	public MyButtonPanel(Component c, Object value) {
		this();
		this.value = value;
		c.setPreferredSize(new Dimension(120, 15));
		GridBagConstraints gc=new GridBagConstraints();
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.gridx=0;
		gc.gridy=0;
		add(c, gc);					//dodaj dugme na panel
	}

}
