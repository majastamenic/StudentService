package projekat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import dialozi.Util;
import tabela.PredmetiTabela;
import tabela.ProfesoriTabela;

public class MainFrame extends JFrame {

	/**
	private MenuBar menu;
	public MainFrame() {
		
		menu=new MenuBar();
		setJMenuBar(menu);
	}
	 */
	
	private static MainFrame instance = null;
	private static final long serialVersionUID = 1L;
	
	private static JTabbedPane tabovi;
	
	public static MainFrame getInstance() {
	
		if (instance == null) {	// ako je klasa tek kreirana
			instance = new MainFrame();	// popuni je sa podacima
		}
		return instance;
	}
	private MenuBar menu;
	private MainFrame() {
		
		setTitle("Studentska sluzba");
		
		ImageIcon img = new ImageIcon("Images/Icon5.png");
		Image image = img.getImage();
		Image newimg = image.getScaledInstance(330, 410,  java.awt.Image.SCALE_SMOOTH); //Podesavanje velicine ikonice.
		img = new ImageIcon(newimg);
		setIconImage(img.getImage());
		
//		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);     			//Gasi aplikaciju prilikom zatvaranje mainFrame-a.
		
		menu=new MenuBar();
		setJMenuBar(menu);
		addWindowListener(new java.awt.event.WindowAdapter(){
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni da zelite da zatvorite aplikaciju?", "Zatvaranje aplikacije", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        	Util.upisiPredmete(MyApp.predmeti);
		        	Util.upisiProfesore(MyApp.profesori);
		            System.exit(0);
		        }
		    }
			
		});
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimenzijaEkrana = toolkit.getScreenSize();
		setSize(new Dimension(dimenzijaEkrana.width*3/4, dimenzijaEkrana.height*3/4));   //Podesavanje dimenzije ekrana.
		
		
		MyToolBar toolbar = new MyToolBar();
		toolbar.setSize(this.getSize().width, 100);
		add(toolbar, BorderLayout.NORTH);
		
		tabovi = new JTabbedPane();
		tabovi.addTab("Studenti", new JTable());
		tabovi.addTab("Profesori", new JScrollPane(new ProfesoriTabela(MyApp.profesori)));
		tabovi.addTab("Predmeti", new JScrollPane(new PredmetiTabela(MyApp.predmeti)));
		add(tabovi);
		setLocationRelativeTo(null);
		
	}
	
	public static String getSelectedTab() {
		int i = tabovi.getSelectedIndex();
		if (i == 0) {
			return "student";
		} else if (i == 1) {
			return "profesor";
		} else {
			return "predmet";
		}
	}
}
