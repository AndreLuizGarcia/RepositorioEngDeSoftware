package View;

import java.awt.Choice;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.InputListenerCadastroEventoFrame;
import Imagens.JBackground;
import Model.PesquisadorDAO;

public class CadastroEventoFrame extends JFrame {

	private static final long serialVersionUID = 3073056939507372613L;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane_1;
	private JTextField dataField;
	private InputListenerCadastroEventoFrame listenerCadastroEvento;
	private JTextField nomeField;
    private JLabel lblCadastroPesquisador;
    private JLabel lblNome;
    private JLabel lblEmail;
    private JLabel lblBiografia;
    private Choice responsavelChoice;
    private JLabel lblLocal;
    private JTextField localField;

	public CadastroEventoFrame() {
		setTitle("Cadastro Evento");
		initialize();
		listenerCadastroEvento = new InputListenerCadastroEventoFrame(this);
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
	public JTextField getDataField() {
		if (dataField == null) {
			dataField = new JTextField();
			dataField.setBounds(173, 143, 86, 20);
			dataField.setColumns(10);
		}
		return dataField;
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
		getBtnCadastrar().addActionListener(listenerCadastroEvento);
		getBtnCancelar().addActionListener(listenerCadastroEvento);
		getBtnVoltar().addActionListener(listenerCadastroEvento);
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
		contentPane_1.add(getDataField());
        contentPane_1.add(getLblCadastroPesquisador());
        contentPane_1.add(getLblNome());
        contentPane_1.add(getLblEmail());
        contentPane_1.add(getLblBiografia());
		contentPane_1.add(getResponsavelChoice());
		contentPane_1.add(getLblLocal());
		contentPane_1.add(getLocalField());
	}
	private JLabel getLblCadastroPesquisador() {
		if (lblCadastroPesquisador == null) {
			lblCadastroPesquisador = new JLabel("Cadastro Evento");
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
			lblBiografia = new JLabel("Data:");
			lblBiografia.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBiografia.setBounds(77, 135, 74, 33);
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
	private JLabel getLblLocal() {
		if (lblLocal == null) {
			lblLocal = new JLabel("Local:");
			lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLocal.setBounds(77, 160, 74, 33);
		}
		return lblLocal;
	}
	public JTextField getLocalField() {
		if (localField == null) {
			localField = new JTextField();
			localField.setColumns(10);
			localField.setBounds(173, 168, 86, 20);
		}
		return localField;
	}
}
