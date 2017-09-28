package View;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class menuFrame extends JFrame {

	private static final long serialVersionUID = 3074294217185216200L;
	private JMenuBar menuBar;
	private JMenu mnDepartamentos;
	private JMenu mnProjetos;
	private JMenu mnColaboradores;
	private JMenuItem mntmCadastrar;
	private JMenuItem mntmConsultar;
	private JMenu mnEquipamentos;
	private JMenu mnEventos;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JMenu mnHome;
	private JSeparator separator_4;
	private JMenuItem mntmQuemSomos;
	private JMenuItem mntmNewMenuItem;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private PanelQuemSomos panel1  = new PanelQuemSomos();
	
	private static menuFrame instance;
	
	
	public static menuFrame getInstance(){
		if (instance == null)
			instance = new menuFrame();
		
		return instance;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		menuFrame.getInstance().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public menuFrame() {
		setTitle("ICT Lab");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getSeparator_6());
			menuBar.add(getMnHome());
			menuBar.add(getSeparator_4());
			menuBar.add(getMnDepartamentos());
			menuBar.add(getSeparator_3());
			menuBar.add(getMnProjetos());
			menuBar.add(getSeparator_2());
			menuBar.add(getMnColaboradores());
			menuBar.add(getSeparator_1());
			menuBar.add(getMnEquipamentos());
			menuBar.add(getSeparator());
			menuBar.add(getMnEventos());
			menuBar.add(getSeparator_7());
		}
		return menuBar;
	}

	private JMenu getMnDepartamentos() {
		if (mnDepartamentos == null) {
			mnDepartamentos = new JMenu("Departamentos");
			mnDepartamentos.add(getMntmCadastrar());
			mnDepartamentos.add(getMntmConsultar());
		}
		return mnDepartamentos;
	}

	private JMenu getMnProjetos() {
		if (mnProjetos == null) {
			mnProjetos = new JMenu("Projetos");
		}
		return mnProjetos;
	}

	private JMenu getMnColaboradores() {
		if (mnColaboradores == null) {
			mnColaboradores = new JMenu("Pesquisadores");
		}
		return mnColaboradores;
	}

	private JMenuItem getMntmCadastrar() {
		if (mntmCadastrar == null) {
			mntmCadastrar = new JMenuItem("Cadastrar");
			mntmCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Hello World!!");

				}
			});
		}
		return mntmCadastrar;
	}

	private JMenuItem getMntmConsultar() {
		if (mntmConsultar == null) {
			mntmConsultar = new JMenuItem("Consultar");
		}
		return mntmConsultar;
	}

	private JMenu getMnEquipamentos() {
		if (mnEquipamentos == null) {
			mnEquipamentos = new JMenu("Equipamentos");
		}
		return mnEquipamentos;
	}

	private JMenu getMnEventos() {
		if (mnEventos == null) {
			mnEventos = new JMenu("Eventos");
		}
		return mnEventos;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
		}
		return separator;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setOrientation(SwingConstants.VERTICAL);
		}
		return separator_1;
	}

	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setOrientation(SwingConstants.VERTICAL);
		}
		return separator_2;
	}

	private JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
			separator_3.setOrientation(SwingConstants.VERTICAL);
		}
		return separator_3;
	}

	private JMenu getMnHome() {
		if (mnHome == null) {
			mnHome = new JMenu("Home");
			mnHome.add(getMntmQuemSomos());
			mnHome.add(getSeparator_5());
			mnHome.add(getMntmNewMenuItem());
		}
		return mnHome;
	}

	private JSeparator getSeparator_4() {
		if (separator_4 == null) {
			separator_4 = new JSeparator();
			separator_4.setOrientation(SwingConstants.VERTICAL);
		}
		return separator_4;
	}

	private JMenuItem getMntmQuemSomos() {
		if (mntmQuemSomos == null) {
			mntmQuemSomos = new JMenuItem("Quem Somos");
			mntmQuemSomos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println(menuFrame.getInstance());
					menuFrame.getInstance().getContentPane().add(panel1);
					
				}
			});
		}
		return mntmQuemSomos;
	}

	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Sair");
		}
		return mntmNewMenuItem;
	}

	private JSeparator getSeparator_5() {
		if (separator_5 == null) {
			separator_5 = new JSeparator();
		}
		return separator_5;
	}

	private JSeparator getSeparator_6() {
		if (separator_6 == null) {
			separator_6 = new JSeparator();
			separator_6.setOrientation(SwingConstants.VERTICAL);
		}
		return separator_6;
	}

	private JSeparator getSeparator_7() {
		if (separator_7 == null) {
			separator_7 = new JSeparator();
			separator_7.setOrientation(SwingConstants.VERTICAL);
		}
		return separator_7;
	}
}
