package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Evento;
import Model.EventoDAO;
import View.CadastroEventoFrame;
import View.MenuPesquisadorFrame;

public class InputListenerCadastroEventoFrame implements ActionListener {

	private CadastroEventoFrame cadastroEvento;

	public InputListenerCadastroEventoFrame(CadastroEventoFrame cadastroEvento) {
		this.cadastroEvento = cadastroEvento;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			cadastroEvento.dispose();
			new MenuPesquisadorFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			cadastroEvento.getNomeField().setText(null);
			cadastroEvento.getDataField().setText(null);
			cadastroEvento.getLocalField().setText(null);
		} else if (e.getActionCommand().equals("Cadastrar")) {
			if (cadastroEvento.getNomeField().getText().equals("")
					|| cadastroEvento.getDataField().getText().equals("")
					|| cadastroEvento.getLocalField().getText().equals("")) 
			{
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			} else if (cadastroEvento.getResponsavelChoice().getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null,
						"Você precisa cadastrar um pesquisador antes de cadastrar um evento!");
			} else if (EventoDAO.getInstance().isValidString(cadastroEvento.getNomeField().getText())
					||EventoDAO.getInstance().isValidString(cadastroEvento.getLocalField().getText())
					||EventoDAO.getInstance().isValidInt(cadastroEvento.getDataField().getText())) {
				JOptionPane.showMessageDialog(null, "Insira apenas letras no campo Nome, local e apenas numeros no campo data!", "Erro!",
						JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Dica: Nessa fase de implementação, não aceitamos "
						+ "espaços entre as palavras. \nVocê pode fazer a separação das palavras "
						+ "juntando as e sempre colocando \na proxima com inicial maiscula: Casa Amarela ->CasaAmarela.");
			} else {

				Evento evento = new Evento();
				
				evento.setData(cadastroEvento.getDataField().getText());
				evento.setLocal(cadastroEvento.getLocalField().getText());
				evento.setNome(cadastroEvento.getNomeField().getText());
				evento.setResponsavel(cadastroEvento.getResponsavelChoice().getSelectedItem());

				try {
					EventoDAO.getInstance().cadEvento(evento);
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
					cadastroEvento.dispose();
					new MenuPesquisadorFrame().setVisible(true);
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		}
	}
}