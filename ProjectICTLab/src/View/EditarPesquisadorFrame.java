package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.InputListenerEditarPesquisadorFrame;
//import Control.InputListenerCadastroAmigosMarioFrame;
import Imagens.JBackground;
import Model.Pesquisador;

public class EditarPesquisadorFrame extends JFrame {

	private static final long serialVersionUID = 3073056939507372613L;
	private JButton btnAtualizar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane_1;
    private JLabel lblCadastroPesquisador;
    private JLabel lblNome;
    private JLabel lblEmail;
    private JLabel lblBiografia;
    private JLabel lblLattes;
    private JLabel lblLinkedin;
    private JTextArea nomeTextArea;
    private JTextArea emailTextArea;
    private JTextArea biografiaTextArea;
    private JTextArea linkedinTextArea;
    private JTextArea lattesTextArea;
    private InputListenerEditarPesquisadorFrame listenerEditarPesquisador;
    private Pesquisador p;

	public EditarPesquisadorFrame(Pesquisador p) {
		this.p = p;
		setTitle("Editar Pesquisador");
		initialize();
		listenerEditarPesquisador = new InputListenerEditarPesquisadorFrame(this, p);
		inicializarListeners();
	}
	private JButton getBtnAtualizar() {
		if (btnAtualizar == null) {
			btnAtualizar = new JButton("Atualizar");
			btnAtualizar.setBounds(26, 238, 103, 23);
		}
		return btnAtualizar;
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
	private void inicializarListeners() {
		getBtnAtualizar().addActionListener(listenerEditarPesquisador);
		getBtnCancelar().addActionListener(listenerEditarPesquisador);
		getBtnVoltar().addActionListener(listenerEditarPesquisador);
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
		contentPane_1.add(getBtnAtualizar());
		contentPane_1.add(getBtnCancelar());
		contentPane_1.add(getBtnVoltar());
        contentPane_1.add(getLblCadastroPesquisador());
        contentPane_1.add(getLblNome());
        contentPane_1.add(getLblEmail());
        contentPane_1.add(getLblBiografia());
        contentPane_1.add(getLblLattes());
        contentPane_1.add(getLblLinkedin());
		contentPane_1.add(getNomeTextArea());
		contentPane_1.add(getEmailTextArea());
		contentPane_1.add(getBiografiaTextArea());
		contentPane_1.add(getLinkedinTextArea());
		contentPane_1.add(getLattesTextArea());
	}
	private JLabel getLblCadastroPesquisador() {
		if (lblCadastroPesquisador == null) {
			lblCadastroPesquisador = new JLabel("Editar Pesquisador");
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
	public JTextArea getNomeTextArea() {
		if (nomeTextArea == null) {
			nomeTextArea = new JTextArea(p.getNome());
			nomeTextArea.setLineWrap(true);
			nomeTextArea.setBorder(new LineBorder(Color.BLACK));
			nomeTextArea.setBounds(143, 88, 86, 20);
		}
		return nomeTextArea;
	}
	public JTextArea getEmailTextArea() {
		if (emailTextArea == null) {
			emailTextArea = new JTextArea(p.getEmail());
			emailTextArea.setLineWrap(true);
			emailTextArea.setBorder(new LineBorder(Color.BLACK));
			emailTextArea.setBounds(143, 112, 86, 20);
		}
		return emailTextArea;
	}
	public JTextArea getBiografiaTextArea() {
		if (biografiaTextArea == null) {
			biografiaTextArea = new JTextArea(p.getBiografia());
			biografiaTextArea.setLineWrap(true);
			biografiaTextArea.setBorder(new LineBorder(Color.BLACK));
			biografiaTextArea.setBounds(143, 138, 86, 58);
		}
		return biografiaTextArea;
	}
	public JTextArea getLinkedinTextArea() {
		if (linkedinTextArea == null) {
			linkedinTextArea = new JTextArea(p.getLinkedin());
			linkedinTextArea.setLineWrap(true);
			linkedinTextArea.setBorder(new LineBorder(Color.BLACK));
			linkedinTextArea.setBounds(330, 117, 86, 20);
		}
		return linkedinTextArea;
	}
	public JTextArea getLattesTextArea() {
		if (lattesTextArea == null) {
			lattesTextArea = new JTextArea(p.getLattes());
			lattesTextArea.setLineWrap(true);
			lattesTextArea.setBorder(new LineBorder(Color.BLACK));
			lattesTextArea.setBounds(329, 90, 86, 20);
		}
		return lattesTextArea;
	}
}
