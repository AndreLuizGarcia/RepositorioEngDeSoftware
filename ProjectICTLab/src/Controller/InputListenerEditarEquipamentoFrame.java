package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Equipamento;
import Model.EquipamentoDAO;
import View.EditarEquipamentoFrame;
import View.MenuPesquisadorFrame;

public class InputListenerEditarEquipamentoFrame implements ActionListener {

	private EditarEquipamentoFrame editarEquipamento;
	private Equipamento equip;

	public InputListenerEditarEquipamentoFrame(EditarEquipamentoFrame editarEquipamento, Equipamento equip) {
		this.equip = equip;
		this.editarEquipamento = editarEquipamento;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			editarEquipamento.dispose();
			new MenuPesquisadorFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			editarEquipamento.getNomeTextArea().setText(null);
			editarEquipamento.getDescricaoTextArea().setText(null);
			editarEquipamento.getTomboTextArea().setText(null);
		} else if (e.getActionCommand().equals("Atualizar")) {
			if (editarEquipamento.getNomeTextArea().getText().equals("")
					|| editarEquipamento.getDescricaoTextArea().getText().equals("")
					|| editarEquipamento.getTomboTextArea().getText().equals("")) 
			{
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			} else if (EquipamentoDAO.getInstance().isValidString(editarEquipamento.getNomeTextArea().getText())
					||EquipamentoDAO.getInstance().isValidString(editarEquipamento.getDescricaoTextArea().getText())
					||EquipamentoDAO.getInstance().isValidInt(editarEquipamento.getTomboTextArea().getText())) 
			{
				JOptionPane.showMessageDialog(null, "Insira apenas letras no campo Nome, Descrição e apenas numeros no campo tombo !", "Erro!",
						JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Dica: Nessa fase de implementação, "
						+ "não aceitamos espaços entre as palavras. \nVocê pode fazer a separação das"
						+ " palavras juntando as e sempre colocando \na proxima com inicial maiscula: "
						+ "Casa Amarela ->CasaAmarela.");
			} else {
				Equipamento equipamento = new Equipamento();
				
				equipamento.setNome(editarEquipamento.getNomeTextArea().getText());
				equipamento.setDescricao(editarEquipamento.getDescricaoTextArea().getText());
				equipamento.setTombo(editarEquipamento.getTomboTextArea().getText());
				try {
					EquipamentoDAO.getInstance().editarEquipamento(equipamento, equip);
					JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
					editarEquipamento.dispose();
					new MenuPesquisadorFrame().setVisible(true);
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		}
	}

}
