package View;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BemVindoFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7664216481805323788L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnEntrar;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BemVindoFrame frame = new BemVindoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BemVindoFrame() {
		initialize();
	}
	private void initialize() {
		setTitle("ICT Lab");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 337);
		contentPane = new JPanel();
		//contentPane = new JBackground("1.jpg");
		//contentPane = new JBackground("2.jpg");
		//contentPane = new JBackground("cerebro-ibm.jpg");
		contentPane = new JBackground("1234567.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTextField());
		contentPane.add(getTextField_1());
		contentPane.add(getBtnEntrar());
		contentPane.add(getBtnSair());
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(167, 147, 86, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(167, 208, 86, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JButton getBtnEntrar() {
		if (btnEntrar == null) {
			btnEntrar = new JButton("Entrar ");
			btnEntrar.setBounds(73, 254, 89, 23);
		}
		return btnEntrar;
	}
	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton("Sair");
			btnSair.setBounds(196, 254, 89, 23);
		}
		return btnSair;
	}
}
