package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;

import Model.Evento;
import Model.EventoDAO;
import View.EditarEventoFrame;
import View.ListarEventosFrame;
import View.MenuPesquisadorFrame;

public class InputListenerListarEventoFrame implements ActionListener {

	private ListarEventosFrame listarEvento;
	private JFileChooser fileChooser;
	private BancoDeDados banco;

	public InputListenerListarEventoFrame(ListarEventosFrame listarEvento, BancoDeDados banco) {
		this.listarEvento = listarEvento;
		this.banco = banco;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			listarEvento.dispose();
			new MenuPesquisadorFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Remover")) {
			if (listarEvento.getList().getSelectedIndex() != -1) {
				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover?", "Saída",
						JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {

					String[] campos = listarEvento.getList().getSelectedValue().split(" -- ");
					try {
						EventoDAO.getInstance().deleteEvento(campos[0]);
						listarEvento.refreshList();
						JOptionPane.showMessageDialog(null, "Deletado!");
						if (listarEvento.getList().getSelectedIndex() == -1) {
							listarEvento.dispose();
							new MenuPesquisadorFrame().setVisible(true);
						}
					} catch (SQLException r) {
						JOptionPane.showMessageDialog(null, r.getMessage());
					}
				} else
					JOptionPane.showMessageDialog(null, "Nenhum elemento selecionado.");
			}
		} else if (e.getActionCommand().equals("Editar")) {
			if (listarEvento.getList().getSelectedIndex() != -1) {
				String[] campos = listarEvento.getList().getSelectedValue().split(" -- ");
				Evento event = EventoDAO.getInstance().getEvento(campos[0]);
				listarEvento.dispose();

				System.out.println("campos[0]" + campos[0]);
				System.out.println("campos[1]" + campos[1]);
				System.out.println("campos[2]" + campos[2]);

				new EditarEventoFrame(event).setVisible(true);
			} else
				JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
		} else if (e.getActionCommand().equals("Gerar Relatório")) {
			fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Escolha um local para salvar");
			int retorno = fileChooser.showSaveDialog(null);
			if (retorno == JFileChooser.APPROVE_OPTION) {
				String path = String.valueOf(fileChooser.getSelectedFile());
				GerarPDF gerarPDF = new GerarPDF(banco, path);
				try {
					gerarPDF.gerarRelatorioEvento();
				} catch (IOException | DocumentException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
