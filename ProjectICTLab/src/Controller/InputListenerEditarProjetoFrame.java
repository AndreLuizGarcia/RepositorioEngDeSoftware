package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Projeto;
import Model.ProjetoDAO;
import View.EditarProjetoFrame;
import View.MenuAdminFrame;
import View.MenuPesquisadorFrame;

public class InputListenerEditarProjetoFrame implements ActionListener {

	private EditarProjetoFrame editarProjeto;
	private Projeto p;

	public InputListenerEditarProjetoFrame(EditarProjetoFrame editarProjeto, Projeto p) {
		this.p = p;
		this.editarProjeto = editarProjeto;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			editarProjeto.dispose();
			new MenuPesquisadorFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			editarProjeto.getNomeField().setText(null);
			editarProjeto.getStatusField().setText(null);
		} else if (e.getActionCommand().equals("Atualizar")) {
			if (editarProjeto.getNomeField().getText().equals("")
					|| editarProjeto.getStatusField().getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			} else if (ProjetoDAO.getInstance().isValidString(editarProjeto.getNomeField().getText())
					||ProjetoDAO.getInstance().isValidString(editarProjeto.getStatusField().getText())) 
			{
				JOptionPane.showMessageDialog(null, "Insira apenas letras no campo Nome e status!", "Erro!",
						JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Dica: Nessa fase de implementação, "
						+ "não aceitamos espaços entre as palavras. \nVocê pode fazer a separação das"
						+ " palavras juntando as e sempre colocando \na proxima com inicial maiscula: "
						+ "Casa Amarela ->CasaAmarela.");
			} else {
				Projeto projeto = new Projeto();
				
				projeto.setNome(editarProjeto.getNomeField().getText());
				projeto.setStatusDoProjeto(editarProjeto.getStatusField().getText());

				try {
					ProjetoDAO.getInstance().editarProjeto(projeto, p);
					JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
					editarProjeto.dispose();
					new MenuAdminFrame().setVisible(true);
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		}
	}

}
