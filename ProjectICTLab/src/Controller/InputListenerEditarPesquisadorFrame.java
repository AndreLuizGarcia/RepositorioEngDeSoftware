package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Pesquisador;
import Model.PesquisadorDAO;
import View.EditarPesquisadorFrame;
import View.MenuAdminFrame;

public class InputListenerEditarPesquisadorFrame implements ActionListener {

	private EditarPesquisadorFrame editarPesquisador;
	private Pesquisador p;

	public InputListenerEditarPesquisadorFrame(EditarPesquisadorFrame editarPesquisador, Pesquisador p) {
		this.p = p;
		this.editarPesquisador = editarPesquisador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			editarPesquisador.dispose();
			new MenuAdminFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			editarPesquisador.getNomeTextArea().setText(null);
			editarPesquisador.getEmailTextArea().setText(null);
			editarPesquisador.getBiografiaTextArea().setText(null);
			editarPesquisador.getLattesTextArea().setText(null);
			editarPesquisador.getLinkedinTextArea().setText(null);
		} else if (e.getActionCommand().equals("Atualizar")) {
			if (editarPesquisador.getNomeTextArea().getText().equals("")
					|| editarPesquisador.getEmailTextArea().getText().equals("")
					|| editarPesquisador.getBiografiaTextArea().getText().equals("")
					|| editarPesquisador.getLattesTextArea().getText().equals("")
					|| editarPesquisador.getLinkedinTextArea().getText().equals("")) 
			{
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			} else if (PesquisadorDAO.getInstance().isValidString(editarPesquisador.getNomeTextArea().getText())
					||PesquisadorDAO.getInstance().isValidString(editarPesquisador.getEmailTextArea().getText())
					||PesquisadorDAO.getInstance().isValidString(editarPesquisador.getBiografiaTextArea().getText())
					||PesquisadorDAO.getInstance().isValidString(editarPesquisador.getLattesTextArea().getText())
					||PesquisadorDAO.getInstance().isValidString(editarPesquisador.getLinkedinTextArea().getText())) 
			{
				JOptionPane.showMessageDialog(null, "Insira apenas letras nos campos!", "Erro!",
						JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Dica: Nessa fase de implementação, "
						+ "não aceitamos espaços entre as palavras. \nVocê pode fazer a separação das"
						+ " palavras juntando as e sempre colocando \na proxima com inicial maiscula: "
						+ "Casa Amarela ->CasaAmarela.");
			} else {
				Pesquisador pesquisador = new Pesquisador();
				
				pesquisador.setNome(editarPesquisador.getNomeTextArea().getText());
				pesquisador.setBiografia(editarPesquisador.getBiografiaTextArea().getText());
				pesquisador.setEmail(editarPesquisador.getEmailTextArea().getText());
				pesquisador.setLattes(editarPesquisador.getLattesTextArea().getText());
				pesquisador.setLinkedin(editarPesquisador.getLinkedinTextArea().getText());
				try {
					PesquisadorDAO.getInstance().editarPesquisador(pesquisador, p);
					JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
					editarPesquisador.dispose();
					new MenuAdminFrame().setVisible(true);
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		}
	}

}
