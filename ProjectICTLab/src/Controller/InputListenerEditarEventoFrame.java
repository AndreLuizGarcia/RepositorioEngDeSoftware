package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Evento;
import Model.EventoDAO;
import View.EditarEventoFrame;
import View.MenuPesquisadorFrame;

public class InputListenerEditarEventoFrame implements ActionListener {

	private EditarEventoFrame editarEvento;
	private Evento event;

	public InputListenerEditarEventoFrame(EditarEventoFrame editarEventoFrame, Evento event) {
		this.event = event;
		this.editarEvento = editarEventoFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			editarEvento.dispose();
			new MenuPesquisadorFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			editarEvento.getNomeTextArea().setText(null);
			editarEvento.getDataTextArea().setText(null);
			editarEvento.getLocalTextArea().setText(null);
		} else if (e.getActionCommand().equals("Atualizar")) {
			if (editarEvento.getNomeTextArea().getText().equals("")
					|| editarEvento.getDataTextArea().getText().equals("")
					|| editarEvento.getLocalTextArea().getText().equals("")) 
			{
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			} else if (EventoDAO.getInstance().isValidString(editarEvento.getNomeTextArea().getText())) 
			{
				JOptionPane.showMessageDialog(null, "Insira apenas letras no campo Nome e local!", "Erro!",
						JOptionPane.ERROR_MESSAGE);
			}else if (EventoDAO.getInstance().isValidDate(editarEvento.getDataTextArea().getText())){
				JOptionPane.showMessageDialog(null, "Insira uma data válida! Formato: dd/mm/aaaa","Erro!",JOptionPane.ERROR_MESSAGE);
			} else {
				Evento evento = new Evento();
				
				evento.setData(editarEvento.getDataTextArea().getText());
				evento.setLocal(editarEvento.getLocalTextArea().getText());
				evento.setNome(editarEvento.getNomeTextArea().getText());
				evento.setResponsavel(editarEvento.getResponsavelChoice().getSelectedItem());

				try {
					EventoDAO.getInstance().editarEvento(evento, event);
					JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
					editarEvento.dispose();
					new MenuPesquisadorFrame().setVisible(true);
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		}
	}

}
