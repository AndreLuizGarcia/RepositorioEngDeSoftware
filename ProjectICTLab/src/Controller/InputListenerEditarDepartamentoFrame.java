package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Departamento;
import Model.DepartamentoDAO;
import View.EditarDepartamentoFrame;
import View.MenuAdminFrame;

public class InputListenerEditarDepartamentoFrame implements ActionListener {

	private EditarDepartamentoFrame editarDepartamento;
	private Departamento d;

	public InputListenerEditarDepartamentoFrame(EditarDepartamentoFrame editarDepartamento, Departamento d) {
		this.d = d;
		this.editarDepartamento = editarDepartamento;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			editarDepartamento.dispose();
			new MenuAdminFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			editarDepartamento.getNomeTextArea().setText(null);
			editarDepartamento.getDescricaoTextArea().setText(null);
		} else if (e.getActionCommand().equals("Atualizar")) {
			if (editarDepartamento.getNomeTextArea().getText().equals("")
					|| editarDepartamento.getDescricaoTextArea().getText().equals("")) 
			{
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			} else if (DepartamentoDAO.getInstance().isValidString(editarDepartamento.getNomeTextArea().getText())) 
			{
				JOptionPane.showMessageDialog(null, "Insira apenas letras no campo Nome e Descrição!", "Erro!",
						JOptionPane.ERROR_MESSAGE);
			} else {
				Departamento departamento = new Departamento();
				
				departamento.setNome(editarDepartamento.getNomeTextArea().getText());
				departamento.setDescricao(editarDepartamento.getDescricaoTextArea().getText());
				departamento.setResponsavel(editarDepartamento.getResponsavelChoice().getSelectedItem());

				try {
					DepartamentoDAO.getInstance().editarDepartamento(departamento, d);
					JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
					editarDepartamento.dispose();
					new MenuAdminFrame().setVisible(true);
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		}
	}

}
