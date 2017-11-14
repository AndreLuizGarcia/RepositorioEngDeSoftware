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

import Controller.InputListenerEditarEquipamentoFrame;
//import Control.InputListenerCadastroAmigosMarioFrame;
import Imagens.JBackground;
import Model.Equipamento;

public class EditarEquipamentoFrame extends JFrame {

	private static final long serialVersionUID = 3073056939507372613L;
	private JButton btnAtualizar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane_1;
    private JLabel lblCadastroPesquisador;
    private JLabel lblNome;
    private JLabel lblEmail;
    private JLabel lblBiografia;
    private JTextArea nomeTextArea;
    private JTextArea tomboTextArea;
    private JTextArea descricaoTextArea;
    private InputListenerEditarEquipamentoFrame listenerEditarEquipamento;
    private Equipamento e;

	public EditarEquipamentoFrame(Equipamento equip) {
		this.e = equip;
		setTitle("Editar Equipamento");
		initialize();
		listenerEditarEquipamento = new InputListenerEditarEquipamentoFrame(this,e);
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
		getBtnAtualizar().addActionListener(listenerEditarEquipamento);
		getBtnCancelar().addActionListener(listenerEditarEquipamento);
		getBtnVoltar().addActionListener(listenerEditarEquipamento);
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
		contentPane_1.add(getNomeTextArea());
		contentPane_1.add(getTomboTextArea());
		contentPane_1.add(getDescricaoTextArea());
	}
	private JLabel getLblCadastroPesquisador() {
		if (lblCadastroPesquisador == null) {
			lblCadastroPesquisador = new JLabel("Editar Equipamento");
			lblCadastroPesquisador.setForeground(Color.WHITE);
			lblCadastroPesquisador.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCadastroPesquisador.setBounds(132, 23, 227, 39);
		}
		return lblCadastroPesquisador;
	}
	private JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Nome:");
			lblNome.setForeground(Color.WHITE);
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNome.setBounds(77, 84, 74, 33);
		}
		return lblNome;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Tombo:");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblEmail.setBounds(77, 111, 103, 33);
		}
		return lblEmail;
	}
	private JLabel getLblBiografia() {
		if (lblBiografia == null) {
			lblBiografia = new JLabel("Descri\u00E7\u00E3o:");
			lblBiografia.setForeground(Color.WHITE);
			lblBiografia.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBiografia.setBounds(77, 136, 74, 33);
		}
		return lblBiografia;
	}
	public JTextArea getNomeTextArea() {
		if (nomeTextArea == null) {
			nomeTextArea = new JTextArea(e.getNome());
			nomeTextArea.setLineWrap(true);
			nomeTextArea.setBorder(new LineBorder(Color.BLACK));
			nomeTextArea.setBounds(173, 91, 86, 20);
		}
		return nomeTextArea;
	}
	public JTextArea getTomboTextArea() {
		if (tomboTextArea == null) {
			tomboTextArea = new JTextArea(e.getTombo());
			tomboTextArea.setLineWrap(true);
			tomboTextArea.setBorder(new LineBorder(Color.BLACK));
			tomboTextArea.setBounds(173, 117, 86, 20);
		}
		return tomboTextArea;
	}
	public JTextArea getDescricaoTextArea() {
		if (descricaoTextArea == null) {
			descricaoTextArea = new JTextArea(e.getDescricao());
			descricaoTextArea.setLineWrap(true);
			descricaoTextArea.setBorder(new LineBorder(Color.BLACK));
			descricaoTextArea.setBounds(173, 143, 86, 58);
		}
		return descricaoTextArea;
	}
}
