package View;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.InputListenerCadastroEquipamentoFrame;
//import Control.InputListenerCadastroAmigosMarioFrame;
import Imagens.JBackground;

public class CadastroEquipamentoFrame extends JFrame {

	private static final long serialVersionUID = 3073056939507372613L;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane_1;
	private JTextField descricaoField;
	private InputListenerCadastroEquipamentoFrame listenerCadastroEquipamento;
	private JTextField nomeField;
    private JLabel lblCadastroPesquisador;
    private JLabel lblNome;
    private JLabel lblEmail;
    private JLabel lblBiografia;
    private JTextField tomboField;

	public CadastroEquipamentoFrame() {
		setTitle("Cadastro Equipamento");
		initialize();
		listenerCadastroEquipamento = new InputListenerCadastroEquipamentoFrame(this);
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
	public JTextField getDescricaoField() {
		if (descricaoField == null) {
			descricaoField = new JTextField();
			descricaoField.setBounds(173, 143, 86, 58);
			descricaoField.setColumns(10);
		}
		return descricaoField;
	}
	public JTextField getNomeField() {
		if (nomeField == null) {
			nomeField = new JTextField();
			nomeField.setBounds(173, 92, 86, 20);
			nomeField.setColumns(10);
		}
		return nomeField;
	}
	private void inicializarListeners() {
		getBtnCadastrar().addActionListener(listenerCadastroEquipamento);
		getBtnCancelar().addActionListener(listenerCadastroEquipamento);
		getBtnVoltar().addActionListener(listenerCadastroEquipamento);
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
		contentPane_1.add(getBtnCadastrar());
		contentPane_1.add(getBtnCancelar());
		contentPane_1.add(getBtnVoltar());
		contentPane_1.add(getDescricaoField());
        contentPane_1.add(getLblCadastroPesquisador());
        contentPane_1.add(getLblNome());
        contentPane_1.add(getLblEmail());
        contentPane_1.add(getLblBiografia());
		contentPane_1.add(getTomboField());
	}
	private JLabel getLblCadastroPesquisador() {
		if (lblCadastroPesquisador == null) {
			lblCadastroPesquisador = new JLabel("Cadastro Equipamento");
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
			lblEmail = new JLabel("Tombo:");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblEmail.setBounds(77, 111, 103, 33);
		}
		return lblEmail;
	}
	private JLabel getLblBiografia() {
		if (lblBiografia == null) {
			lblBiografia = new JLabel("Descri\u00E7\u00E3o:");
			lblBiografia.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBiografia.setBounds(77, 143, 74, 33);
		}
		return lblBiografia;
	}
	public JTextField getTomboField() {
		if (tomboField == null) {
			tomboField = new JTextField();
			tomboField.setColumns(10);
			tomboField.setBounds(173, 119, 86, 20);
		}
		return tomboField;
	}
}
