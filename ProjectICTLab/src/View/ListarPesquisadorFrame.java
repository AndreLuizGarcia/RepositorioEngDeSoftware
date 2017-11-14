package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controller.BancoDeDados;
import Controller.InputListenerListarPesquisadorFrame;
import Imagens.JBackground;
import Model.PesquisadorDAO;
import java.awt.Color;

public class ListarPesquisadorFrame extends JFrame {

	private static final long serialVersionUID = -892712667754648073L;
	private JButton btnEditar;
	private JButton btnGerarRelatrio;
	private JButton btnRemover;
	private JButton btnVoltar;
	private JPanel contentPane_1;
	private JList<String> list;
	private InputListenerListarPesquisadorFrame listenerPesquisador;
	private JPanel listPanel;
	private JScrollPane scrollPane;
	private JLabel lblListarPesquisador;

	public ListarPesquisadorFrame() {
		setTitle("Listar Pesquisador");
		initialize();
		listenerPesquisador = new InputListenerListarPesquisadorFrame(this, BancoDeDados.getInstance());
		inicializarListeners();
	}
	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			btnEditar.setBounds(147, 243, 89, 23);
		}
		return btnEditar;
	}
	
	private JButton getBtnGerarRelatrio() {
		if (btnGerarRelatrio == null) {
			btnGerarRelatrio = new JButton("Gerar Relat\u00F3rio");
			btnGerarRelatrio.setBounds(10, 243, 127, 23);
		}
		return btnGerarRelatrio;
	}
	private JButton getBtnRemover() {
		if (btnRemover == null) {
			btnRemover = new JButton("Remover");
			btnRemover.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnRemover.setBounds(246, 243, 89, 23);
		}
		return btnRemover;
	}
	private JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(345, 243, 89, 23);
		}
		return btnVoltar;
	}
	public JList<String> getList() {
		if (list == null) {
			list = new JList<String>(PesquisadorDAO.getInstance().getAllPesquisador());
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
			listPanel.setBounds(67, 83, 317, 150);
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
	
	private void inicializarListeners(){
		getBtnEditar().addActionListener(listenerPesquisador);
		getBtnGerarRelatrio().addActionListener(listenerPesquisador);
		getBtnRemover().addActionListener(listenerPesquisador);
		getBtnVoltar().addActionListener(listenerPesquisador);
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
		contentPane_1.add(getBtnGerarRelatrio());
		contentPane_1.add(getBtnVoltar());
		contentPane_1.add(getBtnEditar());
		contentPane_1.add(getBtnRemover());
		contentPane_1.add(getListPanel());
		contentPane_1.add(getLblListarPesquisador());
		
	}
	private JLabel getLblListarPesquisador() {
		if (lblListarPesquisador == null) {
			lblListarPesquisador = new JLabel("Listar Pesquisador");
			lblListarPesquisador.setForeground(Color.WHITE);
			lblListarPesquisador.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblListarPesquisador.setBounds(134, 22, 201, 39);
		}
		return lblListarPesquisador;
	}
}
