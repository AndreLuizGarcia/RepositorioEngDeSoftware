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

import Controller.InputListenerEditarEventoFrame;
//import Control.InputListenerCadastroAmigosMarioFrame;
import Imagens.JBackground;
import Model.Evento;
import Model.PesquisadorDAO;

public class EditarEventoFrame extends JFrame {

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
    private JLabel lblLocal;
    private JTextArea nomeTextArea;
    private JTextArea dataTextArea;
    private JTextArea localTextArea;
    private InputListenerEditarEventoFrame listenerEditarEvento;
    private Evento evento;

	public EditarEventoFrame(Evento evento) {
		this.evento = evento;
		setTitle("Editar Evento");
		initialize();
		listenerEditarEvento = new InputListenerEditarEventoFrame(this,evento);
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
		getBtnAtualizar().addActionListener(listenerEditarEvento);
		getBtnCancelar().addActionListener(listenerEditarEvento);
		getBtnVoltar().addActionListener(listenerEditarEvento);
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
		contentPane_1.add(getLblLocal());
		contentPane_1.add(getNomeTextArea());
		contentPane_1.add(getDataTextArea());
		contentPane_1.add(getLocalTextArea());
	}
	private JLabel getLblCadastroPesquisador() {
		if (lblCadastroPesquisador == null) {
			lblCadastroPesquisador = new JLabel("Editar Evento");
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
			lblBiografia = new JLabel("Data:");
			lblBiografia.setForeground(Color.WHITE);
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
			lblLocal.setForeground(Color.WHITE);
			lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLocal.setBounds(77, 160, 74, 33);
		}
		return lblLocal;
	}
	public JTextArea getNomeTextArea() {
		if (nomeTextArea == null) {
			nomeTextArea = new JTextArea(evento.getNome());
			nomeTextArea.setLineWrap(true);
			nomeTextArea.setBorder(new LineBorder(Color.BLACK));
			nomeTextArea.setBounds(173, 91, 86, 20);
		}
		return nomeTextArea;
	}
	public JTextArea getDataTextArea() {
		if (dataTextArea == null) {
			dataTextArea = new JTextArea(evento.getData());
			dataTextArea.setLineWrap(true);
			dataTextArea.setBorder(new LineBorder(Color.BLACK));
			dataTextArea.setBounds(173, 142, 86, 20);
		}
		return dataTextArea;
	}
	public JTextArea getLocalTextArea() {
		if (localTextArea == null) {
			localTextArea = new JTextArea(evento.getLocal());
			localTextArea.setLineWrap(true);
			localTextArea.setBorder(new LineBorder(Color.BLACK));
			localTextArea.setBounds(173, 167, 86, 20);
		}
		return localTextArea;
	}
}
