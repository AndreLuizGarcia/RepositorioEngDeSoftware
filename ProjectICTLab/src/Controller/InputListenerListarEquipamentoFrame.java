package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;

import Model.Equipamento;
import Model.EquipamentoDAO;
import View.EditarEquipamentoFrame;
import View.ListarEquipamentoFrame;
import View.MenuPesquisadorFrame;

public class InputListenerListarEquipamentoFrame implements ActionListener {

	private ListarEquipamentoFrame listarEquipamento;
	private JFileChooser fileChooser;
	private BancoDeDados banco;

	public InputListenerListarEquipamentoFrame(ListarEquipamentoFrame listarEquipamentoFrame, BancoDeDados banco) {
		this.listarEquipamento = listarEquipamentoFrame;
		this.banco = banco;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			listarEquipamento.dispose();
			new MenuPesquisadorFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Remover")) {
			if (listarEquipamento.getList().getSelectedIndex() != -1) {
				int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover?", "Saída",
						JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					if (listarEquipamento.getList().getSelectedIndex() != -1) {
						String[] campos = listarEquipamento.getList().getSelectedValue().split(" -- ");
						try {
							EquipamentoDAO.getInstance().deleteEquipamento(campos[0]);
							listarEquipamento.refreshList();
							JOptionPane.showMessageDialog(null, "Deletado!");
							if (listarEquipamento.getList().getSelectedIndex() == -1) {
								listarEquipamento.dispose();
								new MenuPesquisadorFrame().setVisible(true);
							}
						} catch (SQLException r) {
							JOptionPane.showMessageDialog(null, r.getMessage());
						}
					}
				} else
					JOptionPane.showMessageDialog(null, "Nenhum elemento selecionado.");
			}
		} else if (e.getActionCommand().equals("Editar")) {
			if (listarEquipamento.getList().getSelectedIndex() != -1) {
				String[] campos = listarEquipamento.getList().getSelectedValue().split(" -- ");

				int aux = 0;

				System.out.println("campos[0]" + campos[0]);
				System.out.println("campos[1]" + campos[1]);
				System.out.println("campos[2]" + campos[2]);
				System.err.println("oioioio");
				System.err.println(campos.length);
				while (aux != campos.length) {
					System.err.println(campos[aux]);
					aux++;
				}

				Equipamento equip = EquipamentoDAO.getInstance().getEquipamento(campos[0]);
				System.out.println(equip.getNome());
				listarEquipamento.dispose();
				new EditarEquipamentoFrame(equip).setVisible(true);
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
					gerarPDF.gerarRelatorioEquipamento();
				} catch (IOException | DocumentException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
