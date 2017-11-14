package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.InputListenerMenuAdminFrame;
import Imagens.JBackground;

public class MenuAdminFrame extends JFrame {

	private static final long serialVersionUID = -4253126942024484618L;
	private JButton btnCadastrarPesquisador;
	private JButton btnListarPesquisador;
	private JButton btnSair;
	private JButton btnVoltar;
	private JPanel contentPane_1;
	private InputListenerMenuAdminFrame listenerMenuAdmin;
	private JLabel lblMenuDoAdministrador;
	private JButton btnCadastrarDepartamento;
	private JButton btnListarDepartamento;

	public MenuAdminFrame() {
		setResizable(false);
		setAutoRequestFocus(false);
		setTitle("Menu Administrador");
		initialize();
		listenerMenuAdmin = new InputListenerMenuAdminFrame(this);
		inicializarListeners();
	}
	
	private void inicializarListeners(){
		getBtnCadastrarPesquisador().addActionListener(listenerMenuAdmin);
		getBtnListarPesquisador().addActionListener(listenerMenuAdmin);
		getBtnCadastrarDepartamento().addActionListener(listenerMenuAdmin);
		getBtnListarDepartamento().addActionListener(listenerMenuAdmin);		
		getBtnSair().addActionListener(listenerMenuAdmin);
		getBtnVoltar().addActionListener(listenerMenuAdmin);	
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		new JPanel();
		contentPane_1 = new JBackground("Fundo1.jpg");
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		setLocationRelativeTo(null);
		contentPane_1.setLayout(null);
		contentPane_1.add(getBtnCadastrarPesquisador());
		contentPane_1.add(getBtnListarPesquisador());
		contentPane_1.add(getBtnVoltar());
		contentPane_1.add(getBtnSair());
		contentPane_1.add(getLblMenuDoAdministrador());
		contentPane_1.add(getBtnCadastrarDepartamento());
		contentPane_1.add(getBtnListarDepartamento());
	}
	
	private JButton getBtnCadastrarPesquisador() {
		if (btnCadastrarPesquisador == null) {
			btnCadastrarPesquisador = new JButton("Cadastrar Pesquisador");
			btnCadastrarPesquisador.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnCadastrarPesquisador.setBounds(20, 110, 194, 23);
		}
		return btnCadastrarPesquisador;
	}

	private JButton getBtnListarPesquisador() {
		if (btnListarPesquisador == null) {
			btnListarPesquisador = new JButton("Listar Pesquisador");
			btnListarPesquisador.setBounds(20, 157, 194, 23);
		}
		return btnListarPesquisador;
	}
	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton("Sair");
			btnSair.setBounds(288, 238, 89, 23);
		}
		return btnSair;
	}
	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBackground(new Color(255, 255, 255));
			btnVoltar.setBounds(90, 238, 89, 23);
		}
		return btnVoltar;
	}
	private JLabel getLblMenuDoAdministrador() {
		if (lblMenuDoAdministrador == null) {
			lblMenuDoAdministrador = new JLabel("Menu do Administrador");
			lblMenuDoAdministrador.setForeground(Color.WHITE);
			lblMenuDoAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblMenuDoAdministrador.setBounds(116, 37, 221, 39);
		}
		return lblMenuDoAdministrador;
	}
	private JButton getBtnCadastrarDepartamento() {
		if (btnCadastrarDepartamento == null) {
			btnCadastrarDepartamento = new JButton("Cadastrar Departamento");
			btnCadastrarDepartamento.setBounds(240, 110, 194, 23);
		}
		return btnCadastrarDepartamento;
	}
	private JButton getBtnListarDepartamento() {
		if (btnListarDepartamento == null) {
			btnListarDepartamento = new JButton("Listar Departamento");
			btnListarDepartamento.setBounds(240, 157, 194, 23);
		}
		return btnListarDepartamento;
	}
}
