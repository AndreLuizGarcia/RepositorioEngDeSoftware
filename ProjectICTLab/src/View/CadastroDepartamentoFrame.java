package View;

import java.awt.Choice;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.InputListenerCadastroDepartamentoFrame;
import Imagens.JBackground;
import Model.PesquisadorDAO;
import java.awt.Color;

public class CadastroDepartamentoFrame extends JFrame {

	private static final long serialVersionUID = 3073056939507372613L;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane_1;
	private JTextField descricaoField;
	private InputListenerCadastroDepartamentoFrame listenerCadastroDepartamentos;
	private JTextField nomeField;
    private JLabel lblCadastroPesquisador;
    private JLabel lblNome;
    private JLabel lblEmail;
    private JLabel lblBiografia;
    private Choice responsavelChoice;

	public CadastroDepartamentoFrame() {
		setTitle("Cadastro Departamento");
		initialize();
		listenerCadastroDepartamentos = new InputListenerCadastroDepartamentoFrame(this);
		inicializarListeners();
	}
	
	private void inicializarListeners() {
		getBtnCadastrar().addActionListener(listenerCadastroDepartamentos);
		getBtnCancelar().addActionListener(listenerCadastroDepartamentos);
		getBtnVoltar().addActionListener(listenerCadastroDepartamentos);
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
			descricaoField.setBounds(195, 143, 118, 64);
			descricaoField.setColumns(10);
		}
		return descricaoField;
	}
	public JTextField getNomeField() {
		if (nomeField == null) {
			nomeField = new JTextField();
			nomeField.setBounds(195, 92, 118, 20);
			nomeField.setColumns(10);
		}
		return nomeField;
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
		contentPane_1.add(getResponsavelChoice());
	}
	private JLabel getLblCadastroPesquisador() {
		if (lblCadastroPesquisador == null) {
			lblCadastroPesquisador = new JLabel("Cadastro Departamento");
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
			lblEmail = new JLabel("Respons\u00E1vel:");
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
			
			
			
			
			responsavelChoice.setBounds(195, 118, 118, 20);
		}
		return responsavelChoice;
	}
}
