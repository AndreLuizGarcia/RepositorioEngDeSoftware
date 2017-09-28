package View;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.InputListenerBemVindoFrame;
import Imagens.JBackground;

public class BemVindoFrame extends JFrame {

	private static final long serialVersionUID = -2101837181261778892L;
	private JButton btnEntrar;
	private JButton btnSair;
	private JPanel contentPane_1;
	private InputListenerBemVindoFrame listenerBemVindo;
	private JPasswordField passwordField;
	private JTextField userTextField;
	private JLabel label;
	private JLabel lblLogin;
	private JLabel lblSenha;
	
	public BemVindoFrame() {
		setResizable(false);
		setTitle("ICT Lab");
		initialize();
		listenerBemVindo = new InputListenerBemVindoFrame(this);
		inicializarListeners();		
	}
	
	private void inicializarListeners() {
		getBtnEntrar().addActionListener(listenerBemVindo);
		getBtnSair().addActionListener(listenerBemVindo);
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		//setBounds(0, 0, 838, 585);
		new JPanel();
		contentPane_1 = new JBackground("Fundo1.jpg");
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		setLocationRelativeTo(null);
		contentPane_1.setLayout(null);
		contentPane_1.add(getBtnEntrar());
		contentPane_1.add(getBtnSair());
		contentPane_1.add(getUserTextField());
		contentPane_1.add(getPasswordField());
		contentPane_1.add(getLabel());
		contentPane_1.add(getLblLogin());
		contentPane_1.add(getLblSenha());
	}	
	
	private JButton getBtnEntrar() {
		if (btnEntrar == null) {
			btnEntrar = new JButton("Entrar");
			btnEntrar.setBounds(103, 238, 89, 23);
		}
		return btnEntrar;
	}
	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton("Sair");
			btnSair.setBounds(245, 238, 89, 23);
		}
		return btnSair;
	}
	public JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(234, 167, 89, 20);
		}
		return passwordField;
	}
	public JTextField getUserTextField() {
		if (userTextField == null) {
			userTextField = new JTextField();
			userTextField.setBounds(234, 117, 86, 20);
			userTextField.setColumns(10);
		}
		return userTextField;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Bem-Vindo ao Software de Gerenciamento ICT Lab");
			label.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label.setBounds(25, 24, 383, 39);
		}
		return label;
	}
	private JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel("Login:");
			lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLogin.setBounds(161, 106, 55, 39);
		}
		return lblLogin;
	}
	private JLabel getLblSenha() {
		if (lblSenha == null) {
			lblSenha = new JLabel("Senha:");
			lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblSenha.setBounds(161, 159, 55, 39);
		}
		return lblSenha;
	}
}