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
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dialozi.Util;
import tabela.PredmetiTabela;
import tabela.ProfesoriTabela;
import tabela.StudentiTabela;

public class MainFrame extends JFrame {

	private static MainFrame instance = null;
	private static final long serialVersionUID = 1L;

	private static JTabbedPane tabovi;
	private static MenuBar menu;

	private static StatusBar statusBar;
	private static MyToolBar toolbar;

	private static StudentiTabela tabelaStudenti;
	private static ProfesoriTabela tabelaProfesori;
	private static PredmetiTabela tabelaPredmeti;

	public static MainFrame getInstance() {

		if (instance == null) { // ako je klasa tek kreirana
			instance = new MainFrame(); // popuni je sa podacima
		}
		return instance;
	}

	private MainFrame() {

		setTitle("Studentska sluzba");

		ImageIcon img = new ImageIcon("Images/Icon5.png");
		Image image = img.getImage();
		Image newimg = image.getScaledInstance(330, 410, java.awt.Image.SCALE_SMOOTH); // Podesavanje velicine ikonice.
		img = new ImageIcon(newimg);
		setIconImage(img.getImage());

//		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);     			//Gasi aplikaciju prilikom zatvaranje mainFrame-a.

		menu = new MenuBar();
		setJMenuBar(menu);
		setVisible(true);

		statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				UIManager.put("OptionPane.yesButtonText", "Da");
				UIManager.put("OptionPane.noButtonText", "Ne");
				if (JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni da zelite da zatvorite aplikaciju?",
						"Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					Util.upisiPredmete(MyApp.predmeti);
					Util.upisiStudente(MyApp.studenti);
					Util.upisiProfesore(MyApp.profesori);
					System.exit(0);
				}else {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}

		});

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimenzijaEkrana = toolkit.getScreenSize();
		setSize(new Dimension(dimenzijaEkrana.width * 3 / 4, dimenzijaEkrana.height * 3 / 4)); // Podesavanje dimenzije
																								// ekrana.

		tabovi = new JTabbedPane();
		tabovi.addTab("Studenti", new JScrollPane(new StudentiTabela(MyApp.studenti)));
		tabelaProfesori = new ProfesoriTabela(MyApp.profesori);
		tabovi.addTab("Profesori", new JScrollPane(tabelaProfesori));
		tabelaPredmeti = new PredmetiTabela(MyApp.predmeti);
		tabovi.addTab("Predmeti", new JScrollPane(tabelaPredmeti));
		tabovi.addChangeListener(new ChangeListener() { // Ako se desila promena(selektovan drugi tab)

			@Override
			public void stateChanged(ChangeEvent e) {
				remove(toolbar);
				toolbar = new MyToolBar(); // Ponovo kreiranje toolbara
				add(toolbar, BorderLayout.NORTH);
			}
		});

		toolbar = new MyToolBar();
		add(toolbar, BorderLayout.NORTH);
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

	public static void refreshTabova() {

		int selektovaniIndex = tabovi.getSelectedIndex();

		tabovi.removeAll();
		tabovi.addTab("Studenti", new StudentiTabela(MyApp.studenti));
		tabelaProfesori = new ProfesoriTabela(MyApp.profesori);
		tabovi.addTab("Profesori", new JScrollPane(tabelaProfesori));
		tabelaPredmeti = new PredmetiTabela(MyApp.predmeti);
		tabovi.addTab("Predmeti", new JScrollPane(tabelaPredmeti));
		tabovi.setSelectedIndex(selektovaniIndex);

	}

	public static JTabbedPane getTabovi() {
		return tabovi;
	}

	public static void setTabovi(JTabbedPane tabovi) {
		MainFrame.tabovi = tabovi;
	}

	public static ProfesoriTabela getTabelaProfesori() {
		return tabelaProfesori;
	}

	public static void setTabelaProfesori(ProfesoriTabela tabelaProfesori) {
		MainFrame.tabelaProfesori = tabelaProfesori;
	}

	public static PredmetiTabela getTabelaPredmeti() {
		return tabelaPredmeti;
	}

	public static void setTabelaPredmeti(PredmetiTabela tabelaPredmeti) {
		MainFrame.tabelaPredmeti = tabelaPredmeti;
	}
}
