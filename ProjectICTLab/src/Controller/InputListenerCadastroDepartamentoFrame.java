package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Departamento;
import Model.DepartamentoDAO;
import View.CadastroDepartamentoFrame;
import View.MenuAdminFrame;

public class InputListenerCadastroDepartamentoFrame implements ActionListener {

	private CadastroDepartamentoFrame cadastroDepartamento;

	public InputListenerCadastroDepartamentoFrame(CadastroDepartamentoFrame cadastroDepartamento) {
		this.cadastroDepartamento = cadastroDepartamento;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			cadastroDepartamento.dispose();
			new MenuAdminFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			cadastroDepartamento.getNomeField().setText(null);
			cadastroDepartamento.getDescricaoField().setText(null);
		} else if (e.getActionCommand().equals("Cadastrar")) {
			if (cadastroDepartamento.getNomeField().getText().equals("")
					|| cadastroDepartamento.getDescricaoField().getText().equals("")) 
			{
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			} else if (cadastroDepartamento.getResponsavelChoice().getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null,
						"Você precisa cadastrar um pesquisador antes de cadastrar um departamento!");
			} else if (DepartamentoDAO.getInstance().isValidString(cadastroDepartamento.getNomeField().getText())) {
				JOptionPane.showMessageDialog(null, "Insira apenas letras no campo Nome e Descrição!", "Erro!",
						JOptionPane.ERROR_MESSAGE);
				cadastroDepartamento.getNomeField().setText(null);
				cadastroDepartamento.getDescricaoField().setText(null);
			} else {

				Departamento departamento = new Departamento();

				departamento.setNome(cadastroDepartamento.getNomeField().getText());
				departamento.setDescricao(cadastroDepartamento.getDescricaoField().getText());
				departamento.setResponsavel(cadastroDepartamento.getResponsavelChoice().getSelectedItem());

				try {
					DepartamentoDAO.getInstance().cadDepartamento(departamento);
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
					cadastroDepartamento.dispose();
					new MenuAdminFrame().setVisible(true);
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		}
	}
}