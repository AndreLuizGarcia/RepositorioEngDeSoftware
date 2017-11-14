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
			}  else if (PesquisadorDAO.getInstance().isValidString(editarPesquisador.getNomeTextArea().getText())){
				JOptionPane.showMessageDialog(null, "Insira apenas letras no campo Nome", "Erro!",JOptionPane.ERROR_MESSAGE);
			} else if (PesquisadorDAO.getInstance().isValidEmail(editarPesquisador.getEmailTextArea().getText())){
				JOptionPane.showMessageDialog(null, "Insira um email valido no campo Email. Formato: nome@seuservidor.com", "Erro!",JOptionPane.ERROR_MESSAGE);
			} else if (PesquisadorDAO.getInstance().isValidUrl(editarPesquisador.getLattesTextArea().getText())){
				JOptionPane.showMessageDialog(null, "Insira um link valido no campo Lattes. Formato: www.seusite.com", "Erro!",JOptionPane.ERROR_MESSAGE);
			} else if (PesquisadorDAO.getInstance().isValidUrl(editarPesquisador.getLinkedinTextArea().getText())){
				JOptionPane.showMessageDialog(null, "Insira um link valido no campo LinkedIN. Formato: www.seusite.com", "Erro!",JOptionPane.ERROR_MESSAGE);
			}else {
				
				Pesquisador pesquisador = new Pesquisador();
				
				pesquisador.setNome(editarPesquisador.getNomeTextArea().getText());
				pesquisador.setBiografia(editarPesquisador.getBiografiaTextArea().getText());
				pesquisador.setEmail(editarPesquisador.getEmailTextArea().getText());
				pesquisador.setLattes(editarPesquisador.getLattesTextArea().getText());
				pesquisador.setLinkedin(editarPesquisador.getLinkedinTextArea().getText());
				
				try {
					PesquisadorDAO.getInstance().editarPesquisador(pesquisador,p);
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
					editarPesquisador.dispose();
					new MenuAdminFrame().setVisible(true);
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		}
	}

}
