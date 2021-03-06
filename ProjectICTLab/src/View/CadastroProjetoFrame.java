package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.InputListenerCadastroProjetoFrame;
//import Control.InputListenerCadastroAmigosMarioFrame;
import Imagens.JBackground;
import Model.PesquisadorDAO;

public class CadastroProjetoFrame extends JFrame {

	private static final long serialVersionUID = 3073056939507372613L;
	private JButton btnAtualizar;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JPanel contentPane_1;
	private InputListenerCadastroProjetoFrame listenerCadastroProjeto;
	private JTextField nomeField;
    private JLabel lblCadastroProjeto;
    private JLabel lblNome;
    private JLabel lblEmail;
    private JTextField statusField;
    private JPanel listPanel;
	private JScrollPane scrollPane;
	private JList<String> list;
	private JLabel lblPesquisadoresEnvolvidos;

	public CadastroProjetoFrame() {
		setTitle("Cadastro Projeto");
		initialize();
		listenerCadastroProjeto = new InputListenerCadastroProjetoFrame(this);
		inicializarListeners();
	}
	private JButton getBtnAtualizar() {
		if (btnAtualizar == null) {
			btnAtualizar = new JButton("Cadastrar");
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
			nomeField = new JTextField();
			nomeField.setBounds(215, 92, 86, 20);
			nomeField.setColumns(10);
		}
		return nomeField;
	}
	private void inicializarListeners() {
		getBtnAtualizar().addActionListener(listenerCadastroProjeto);
		getBtnCancelar().addActionListener(listenerCadastroProjeto);
		getBtnVoltar().addActionListener(listenerCadastroProjeto);
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
        contentPane_1.add(getLblCadastroProjeto());
        contentPane_1.add(getLblNome());
        contentPane_1.add(getLblEmail());
		contentPane_1.add(getStatusField());
		contentPane_1.add(getListPanel());
		contentPane_1.add(getLblPesquisadoresEnvolvidos());
	}
	private JLabel getLblCadastroProjeto() {
		if (lblCadastroProjeto == null) {
			lblCadastroProjeto = new JLabel("Cadastro Projeto");
			lblCadastroProjeto.setForeground(Color.WHITE);
			lblCadastroProjeto.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCadastroProjeto.setBounds(132, 23, 227, 39);
		}
		return lblCadastroProjeto;
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
			lblEmail = new JLabel("Status do Projeto:");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblEmail.setBounds(77, 111, 128, 33);
		}
		return lblEmail;
	}
	public JTextField getStatusField() {
		if (statusField == null) {
			statusField = new JTextField();
			statusField.setColumns(10);
			statusField.setBounds(215, 119, 86, 20);
		}
		return statusField;
	}
	
	public JList<String> getList() {
		if (list == null) {
			list = new JList<String>(PesquisadorDAO.getInstance().getAllPesquisadoresChoice());
			list.setBounds(71, 82, 285, 150);
		}
		return list;
	}
	
	public void refreshList(){
		list.setModel(PesquisadorDAO.getInstance().getAllPesquisador());
	}
	
	private JPanel getListPanel() {
		if (listPanel == null) {
			listPanel = new JPanel();			
			listPanel.setBounds(215, 149, 169, 84);
			listPanel.setLayout(new BorderLayout(0, 0));
			listPanel.add(getScrollPane());
		}
		return listPanel;
	}
	 
	private JScrollPane getScrollPane(){
		if(scrollPane == null){
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}
	private JLabel getLblPesquisadoresEnvolvidos() {
		if (lblPesquisadoresEnvolvidos == null) {
			lblPesquisadoresEnvolvidos = new JLabel("Pesquisadores:");
			lblPesquisadoresEnvolvidos.setForeground(Color.WHITE);
			lblPesquisadoresEnvolvidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPesquisadoresEnvolvidos.setBounds(77, 155, 128, 33);
		}
		return lblPesquisadoresEnvolvidos;
	}
}
