package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Equipamento;
import Model.EquipamentoDAO;
import View.CadastroEquipamentoFrame;
import View.MenuPesquisadorFrame;

public class InputListenerCadastroEquipamentoFrame implements ActionListener {

	private CadastroEquipamentoFrame cadastroEquipamento;

	public InputListenerCadastroEquipamentoFrame(CadastroEquipamentoFrame cadastroEquipamento) {
		this.cadastroEquipamento = cadastroEquipamento;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			cadastroEquipamento.dispose();
			new MenuPesquisadorFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			cadastroEquipamento.getNomeField().setText(null);
			cadastroEquipamento.getDescricaoField().setText(null);
			cadastroEquipamento.getTomboField().setText(null);
		} else if (e.getActionCommand().equals("Cadastrar")) {
			if (cadastroEquipamento.getNomeField().getText().equals("")
					||cadastroEquipamento.getNomeField().getText().equals("")
					||cadastroEquipamento.getTomboField().getText().equals("")) 
			{
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			} else if (EquipamentoDAO.getInstance().isValidString(cadastroEquipamento.getNomeField().getText())
					||EquipamentoDAO.getInstance().isValidInt(cadastroEquipamento.getTomboField().getText())) {
				JOptionPane.showMessageDialog(null, "Insira apenas letras no campo Nome e Descrição e apenas números no campo tombo!", "Erro!",
						JOptionPane.ERROR_MESSAGE);
			} else {

				Equipamento equipamento = new Equipamento();
				
				equipamento.setNome(cadastroEquipamento.getNomeField().getText());
				equipamento.setDescricao(cadastroEquipamento.getDescricaoField().getText());
				equipamento.setTombo(cadastroEquipamento.getTomboField().getText());

				try {
					EquipamentoDAO.getInstance().cadEquipamento(equipamento);
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
					cadastroEquipamento.dispose();
					new MenuPesquisadorFrame().setVisible(true);
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		}
	}
}