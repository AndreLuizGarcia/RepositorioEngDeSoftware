package View;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.InputListenerEditarDepartamentoFrame;
//import Control.InputListenerCadastroAmigosMarioFrame;
import Imagens.JBackground;
import Model.Departamento;
import Model.PesquisadorDAO;

public class EditarDepartamentoFrame extends JFrame {

	private static final long serialVersionUID = 3073056939507372613L;
	private JButton btnAtualizar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane_1;
    private JLabel lblCadastroPesquisador;
    private JLabel lblNome;
    private JLabel lblEmail;
    private JLabel lblBiografia;
    private Choice responsavelChoice;
    private JTextArea nomeTextArea;
    private JTextArea descricaoTextArea;
	private InputListenerEditarDepartamentoFrame listenerEditarDepartamento;
	private Departamento d;

	public EditarDepartamentoFrame(Departamento d) {
		this.d=d;
		setTitle("Editar Departamento");
		initialize();
		listenerEditarDepartamento = new InputListenerEditarDepartamentoFrame(this, d);
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
		getBtnAtualizar().addActionListener(listenerEditarDepartamento);
		getBtnCancelar().addActionListener(listenerEditarDepartamento);
		getBtnVoltar().addActionListener(listenerEditarDepartamento);
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
		contentPane_1.add(getResponsavelChoice());
		contentPane_1.add(getNomeTextArea());
		contentPane_1.add(getDescricaoTextArea());
	}
	private JLabel getLblCadastroPesquisador() {
		if (lblCadastroPesquisador == null) {
			lblCadastroPesquisador = new JLabel("Editar Departamento");
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
			lblEmail = new JLabel("Respons\u00E1vel:");
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
	public Choice getResponsavelChoice() {
		if (responsavelChoice == null) {
			responsavelChoice = new Choice();
			String[] tabela = new String[20];
			tabela = PesquisadorDAO.getInstance().getAllPesquisadoresChoice();
			int i = 0;
			
			for(i=0;i<20;i++){
				if(tabela[i]==null)
					break;
				responsavelChoice.add(tabela[i]);
			}
			responsavelChoice.setBounds(173, 118, 86, 20);
		}
		return responsavelChoice;
	}
	public JTextArea getNomeTextArea() {
		if (nomeTextArea == null) {
			nomeTextArea = new JTextArea(d.getNome());
			nomeTextArea.setLineWrap(true);
			nomeTextArea.setBorder(new LineBorder(Color.BLACK));
			nomeTextArea.setBounds(173, 91, 86, 23);
		}
		return nomeTextArea;
	}
	public JTextArea getDescricaoTextArea() {
		if (descricaoTextArea == null) {
			descricaoTextArea = new JTextArea(d.getDescricao());
			descricaoTextArea.setLineWrap(true);
			descricaoTextArea.setBorder(new LineBorder(Color.BLACK));
			descricaoTextArea.setBounds(173, 143, 86, 23);
		}
		return descricaoTextArea;
	}
}
