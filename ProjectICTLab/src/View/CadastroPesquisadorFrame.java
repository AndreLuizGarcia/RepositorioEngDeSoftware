package View;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.InputListenerCadastroPesquisadorFrame;
import Imagens.JBackground;

public class CadastroPesquisadorFrame extends JFrame {

	private static final long serialVersionUID = 3073056939507372613L;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane_1;
	private JTextField emailField;
	private JTextField biografiaField;
	private InputListenerCadastroPesquisadorFrame listenerCadastroPesquisador;
	private JTextField nomeField;
    private JLabel lblCadastroPesquisador;
    private JLabel lblNome;
    private JLabel lblEmail;
    private JLabel lblBiografia;
    private JLabel lblLattes;
    private JLabel lblLinkedin;
    private JTextField linkedinField;
    private JTextField lattesField;
    private JLabel lblLogin;
    private JLabel lblSenha;
    private JTextField loginField;
    private JPasswordField passwordField;

	public CadastroPesquisadorFrame() {
		setTitle("Cadastro Pesquisador");
		initialize();
		listenerCadastroPesquisador = new InputListenerCadastroPesquisadorFrame(this);
		inicializarListeners();
	}
	private JButton getBtnCadastrar() {
		if (btnCadastrar == null) {
			btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.setBounds(26, 238, 103, 23);
		}
		return btnCadastrar;
	}
	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(173, 238, 108, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(320, 238, 103, 23);
		}
		return btnVoltar;
	}
	public JTextField getEmailField() {
		if (emailField == null) {
			emailField = new JTextField();
			emailField.setBounds(143, 119, 86, 20);
			emailField.setColumns(10);
		}
		return emailField;
	}
	public JTextField getBiografiaField() {
		if (biografiaField == null) {
			biografiaField = new JTextField();
			biografiaField.setBounds(143, 143, 86, 58);
			biografiaField.setColumns(10);
		}
		return biografiaField;
	}
	public JTextField getNomeField() {
		if (nomeField == null) {
			nomeField = new JTextField();
			nomeField.setBounds(143, 92, 86, 20);
			nomeField.setColumns(10);
		}
		return nomeField;
	}
	private void inicializarListeners() {
		getBtnCadastrar().addActionListener(listenerCadastroPesquisador);
		getBtnCancelar().addActionListener(listenerCadastroPesquisador);
		getBtnVoltar().addActionListener(listenerCadastroPesquisador);
	}
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		new JPanel();
		contentPane_1 = new JBackground("Fundo1.jpg");
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		setLocationRelativeTo(null);
		contentPane_1.setLayout(null);
		contentPane_1.add(getNomeField());
		contentPane_1.add(getEmailField());
		contentPane_1.add(getBtnCadastrar());
		contentPane_1.add(getBtnCancelar());
		contentPane_1.add(getBtnVoltar());
		contentPane_1.add(getBiografiaField());
        contentPane_1.add(getLblCadastroPesquisador());
        contentPane_1.add(getLblNome());
        contentPane_1.add(getLblEmail());
        contentPane_1.add(getLblBiografia());
        contentPane_1.add(getLblLattes());
        contentPane_1.add(getLblLinkedin());
        contentPane_1.add(getLinkedinField());
        contentPane_1.add(getLattesField());
		contentPane_1.add(getLblLogin());
		contentPane_1.add(getLblSenha());
		contentPane_1.add(getLoginField());
		contentPane_1.add(getPasswordField());
	}
	private JLabel getLblCadastroPesquisador() {
		if (lblCadastroPesquisador == null) {
			lblCadastroPesquisador = new JLabel("Cadastro Pesquisador");
			lblCadastroPesquisador.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCadastroPesquisador.setBounds(132, 23, 201, 39);
		}
		return lblCadastroPesquisador;
	}
	private JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Nome:");
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNome.setBounds(77, 84, 74, 33);
		}
		return lblNome;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email:");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblEmail.setBounds(77, 111, 74, 33);
		}
		return lblEmail;
	}
	private JLabel getLblBiografia() {
		if (lblBiografia == null) {
			lblBiografia = new JLabel("Biografia:");
			lblBiografia.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBiografia.setBounds(77, 143, 74, 33);
		}
		return lblBiografia;
	}
	private JLabel getLblLattes() {
		if (lblLattes == null) {
			lblLattes = new JLabel("Lattes:");
			lblLattes.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLattes.setBounds(259, 86, 55, 28);
		}
		return lblLattes;
	}
	private JLabel getLblLinkedin() {
		if (lblLinkedin == null) {
			lblLinkedin = new JLabel("LinkedIN:");
			lblLinkedin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLinkedin.setBounds(259, 116, 74, 28);
		}
		return lblLinkedin;
	}
	public JTextField getLinkedinField() {
		if (linkedinField == null) {
			linkedinField = new JTextField();
			linkedinField.setColumns(10);
			linkedinField.setBounds(337, 119, 86, 20);
		}
		return linkedinField;
	}
	public JTextField getLattesField() {
		if (lattesField == null) {
			lattesField = new JTextField();
			lattesField.setColumns(10);
			lattesField.setBounds(337, 84, 86, 20);
		}
		return lattesField;
	}
	private JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel("Login:");
			lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLogin.setBounds(259, 143, 55, 28);
		}
		return lblLogin;
	}
	private JLabel getLblSenha() {
		if (lblSenha == null) {
			lblSenha = new JLabel("Senha:");
			lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblSenha.setBounds(260, 172, 55, 28);
		}
		return lblSenha;
	}
	public JTextField getLoginField() {
		if (loginField == null) {
			loginField = new JTextField();
			loginField.setColumns(10);
			loginField.setBounds(337, 149, 86, 20);
		}
		return loginField;
	}
	public JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(337, 178, 86, 20);
		}
		return passwordField;
	}
}
