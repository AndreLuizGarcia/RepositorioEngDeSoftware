package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Projeto;
import Model.ProjetoDAO;
import View.CadastroProjetoFrame;
import View.MenuPesquisadorFrame;

public class InputListenerCadastroProjetoFrame implements ActionListener {

	private CadastroProjetoFrame cadastroProjeto;

	public InputListenerCadastroProjetoFrame(CadastroProjetoFrame cadastroProjeto) {
		this.cadastroProjeto = cadastroProjeto;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			cadastroProjeto.dispose();
			new MenuPesquisadorFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			cadastroProjeto.getNomeField().setText(null);
			cadastroProjeto.getStatusField().setText(null);
		} else if (e.getActionCommand().equals("Cadastrar")) {
			if (cadastroProjeto.getNomeField().getText().equals("")
					||cadastroProjeto.getStatusField().getText().equals("")) 
			{
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			} else if (ProjetoDAO.getInstance().isValidString(cadastroProjeto.getNomeField().getText())
					||ProjetoDAO.getInstance().isValidString(cadastroProjeto.getStatusField().getText())) {
				JOptionPane.showMessageDialog(null, "Insira apenas letras no campo Nome e Status do Projeto !", "Erro!",
						JOptionPane.ERROR_MESSAGE);
			} else {

				Projeto projeto = new Projeto();
				
				projeto.setNome(cadastroProjeto.getNomeField().getText());
				projeto.setStatusDoProjeto(cadastroProjeto.getStatusField().getText());
				projeto.setPesquisadores(cadastroProjeto.getList().getSelectedValuesList());				
				
				try {
					ProjetoDAO.getInstance().cadProjeto(projeto);
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
					cadastroProjeto.dispose();
					new MenuPesquisadorFrame().setVisible(true);
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		}
	}
}