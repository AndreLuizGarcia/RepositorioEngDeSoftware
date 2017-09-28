package View;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.InputListenerEditarProjetoFrame;
//import Control.InputListenerCadastroAmigosMarioFrame;
import Imagens.JBackground;
import Model.Projeto;

public class EditarProjetoFrame extends JFrame {

	private static final long serialVersionUID = 3073056939507372613L;
	private JButton btnAtualizar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane_1;
	private InputListenerEditarProjetoFrame listenerEditarProjeto;
	private JTextField nomeField;
    private JLabel lblCadastroPesquisador;
    private JLabel lblNome;
    private JLabel lblEmail;
    private JTextField statusField;
    private Projeto p;

	public EditarProjetoFrame(Projeto p) {
		this.p = p;
		setTitle("Editar Projeto");
		initialize();
		listenerEditarProjeto = new InputListenerEditarProjetoFrame(this,p);
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
	public JTextField getNomeField() {
		if (nomeField == null) {
			nomeField = new JTextField(p.getNome());
			nomeField.setBounds(215, 92, 86, 20);
			nomeField.setColumns(10);
		}
		return nomeField;
	}
	private void inicializarListeners() {
		getBtnAtualizar().addActionListener(listenerEditarProjeto);
		getBtnCancelar().addActionListener(listenerEditarProjeto);
		getBtnVoltar().addActionListener(listenerEditarProjeto);
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
		contentPane_1.add(getBtnAtualizar());
		contentPane_1.add(getBtnCancelar());
		contentPane_1.add(getBtnVoltar());
        contentPane_1.add(getLblCadastroPesquisador());
        contentPane_1.add(getLblNome());
        contentPane_1.add(getLblEmail());
		contentPane_1.add(getStatusField());
	}
	private JLabel getLblCadastroPesquisador() {
		if (lblCadastroPesquisador == null) {
			lblCadastroPesquisador = new JLabel("Editar Projeto");
			lblCadastroPesquisador.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCadastroPesquisador.setBounds(132, 23, 227, 39);
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
			lblEmail = new JLabel("Status do Projeto:");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblEmail.setBounds(77, 111, 128, 33);
		}
		return lblEmail;
	}
	public JTextField getStatusField() {
		if (statusField == null) {
			statusField = new JTextField(p.getStatusDoProjeto());
			statusField.setColumns(10);
			statusField.setBounds(215, 119, 86, 20);
		}
		return statusField;
	}
}
