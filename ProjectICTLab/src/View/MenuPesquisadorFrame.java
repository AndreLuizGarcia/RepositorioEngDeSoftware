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

import Controller.InputListenerMenuPesquisadorFrame;
//import Control.InputListenerMenuAdminFrame;
import Imagens.JBackground;

public class MenuPesquisadorFrame extends JFrame {

	private static final long serialVersionUID = -4253126942024484618L;
	private JButton btnCadastrarEvento;
	private JButton btnListarEvento;
	private JButton btnSair;
	private JButton btnVoltar;
	private JPanel contentPane_1;
	private InputListenerMenuPesquisadorFrame listenerMenuPesquisador;
	private JLabel lblMenuDoAdministrador;
	private JButton btnCadastrarEquipamento;
	private JButton btnListarEquipamento;
	private JButton btnCadastrarProjeto;
	private JButton btnListarProjeto;

	public MenuPesquisadorFrame() {
		setResizable(false);
		setAutoRequestFocus(false);
		setTitle("Menu Pesquisador");
		initialize();
		listenerMenuPesquisador = new InputListenerMenuPesquisadorFrame(this);
		inicializarListeners();
	}
	
	private void inicializarListeners(){
		getBtnCadastrarEvento().addActionListener(listenerMenuPesquisador);
		getBtnCadastrarEquipamento().addActionListener(listenerMenuPesquisador);
		getBtnCadastrarProjeto().addActionListener(listenerMenuPesquisador);
		getBtnListarEquipamento().addActionListener(listenerMenuPesquisador);
		getBtnListarEvento().addActionListener(listenerMenuPesquisador);
		getButton_1().addActionListener(listenerMenuPesquisador);
		getBtnSair().addActionListener(listenerMenuPesquisador);
		getBtnVoltar().addActionListener(listenerMenuPesquisador);	
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
		contentPane_1.add(getBtnCadastrarEvento());
		contentPane_1.add(getBtnListarEvento());
		contentPane_1.add(getBtnVoltar());
		contentPane_1.add(getBtnSair());
		contentPane_1.add(getLblMenuDoAdministrador());
		contentPane_1.add(getBtnCadastrarEquipamento());
		contentPane_1.add(getBtnListarEquipamento());
		contentPane_1.add(getBtnCadastrarProjeto());
		contentPane_1.add(getButton_1());
	}
	
	private JButton getBtnCadastrarEvento() {
		if (btnCadastrarEvento == null) {
			btnCadastrarEvento = new JButton("Cadastrar Evento");
			btnCadastrarEvento.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnCadastrarEvento.setBounds(28, 82, 169, 23);
		}
		return btnCadastrarEvento;
	}

	private JButton getBtnListarEvento() {
		if (btnListarEvento == null) {
			btnListarEvento = new JButton("Listar Evento");
			btnListarEvento.setBounds(240, 82, 169, 23);
		}
		return btnListarEvento;
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
			btnVoltar.setBounds(72, 238, 89, 23);
		}
		return btnVoltar;
	}
	private JLabel getLblMenuDoAdministrador() {
		if (lblMenuDoAdministrador == null) {
			lblMenuDoAdministrador = new JLabel("Menu do Pesquisador");
			lblMenuDoAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblMenuDoAdministrador.setBounds(118, 11, 221, 39);
		}
		return lblMenuDoAdministrador;
	}
	private JButton getBtnCadastrarEquipamento() {
		if (btnCadastrarEquipamento == null) {
			btnCadastrarEquipamento = new JButton("Cadastrar Equipamento");
			btnCadastrarEquipamento.setBounds(28, 128, 169, 23);
		}
		return btnCadastrarEquipamento;
	}
	private JButton getBtnListarEquipamento() {
		if (btnListarEquipamento == null) {
			btnListarEquipamento = new JButton("Listar Equipamento");
			btnListarEquipamento.setBounds(240, 128, 169, 23);
		}
		return btnListarEquipamento;
	}
	private JButton getBtnCadastrarProjeto() {
		if (btnCadastrarProjeto == null) {
			btnCadastrarProjeto = new JButton("Cadastrar Projeto");
			btnCadastrarProjeto.setBounds(28, 177, 169, 23);
		}
		return btnCadastrarProjeto;
	}
	private JButton getButton_1() {
		if (btnListarProjeto == null) {
			btnListarProjeto = new JButton("Listar Projeto");
			btnListarProjeto.setBounds(240, 177, 169, 23);
		}
		return btnListarProjeto;
	}
}
