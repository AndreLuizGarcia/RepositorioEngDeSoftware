package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;

import Model.Pesquisador;
import Model.PesquisadorDAO;
import View.EditarPesquisadorFrame;
import View.ListarPesquisadorFrame;
import View.MenuAdminFrame;

public class InputListenerListarPesquisadorFrame implements ActionListener {

	private ListarPesquisadorFrame listarPesquisador;
	private JFileChooser fileChooser;
	private BancoDeDados banco;

	public InputListenerListarPesquisadorFrame(ListarPesquisadorFrame listarPesquisador,BancoDeDados banco) {
		this.listarPesquisador = listarPesquisador;
		this.banco = banco;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			listarPesquisador.dispose();
			new MenuAdminFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Remover")) {
			if (listarPesquisador.getList().getSelectedIndex() != -1) {
				String[] campos = listarPesquisador.getList().getSelectedValue().split(" ");
				try {
					System.out.println("campos[2] = " + campos[0]);
					PesquisadorDAO.getInstance().deletePesquisador(campos[0]);
					listarPesquisador.refreshList();
					JOptionPane.showMessageDialog(null, "Deletado!");
					if(listarPesquisador.getList().getSelectedIndex() == -1){
						listarPesquisador.dispose();
						new MenuAdminFrame().setVisible(true);
					}
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		} else if (e.getActionCommand().equals("Editar")) {
			if (listarPesquisador.getList().getSelectedIndex() != -1) {
				String[] campos = listarPesquisador.getList().getSelectedValue().split(" ");
				System.out.println(campos[0]);
				Pesquisador p = PesquisadorDAO.getInstance().getPesquisador(campos[0]);
				listarPesquisador.dispose();
				new EditarPesquisadorFrame(p).setVisible(true);
			} else
				JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
		} else if (e.getActionCommand().equals("Gerar Relatório")) {
			fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Escolha um local para salvar");
			int retorno = fileChooser.showSaveDialog(null);
			if(retorno == JFileChooser.APPROVE_OPTION){
				String path = String.valueOf(fileChooser.getSelectedFile());
				GerarPDF gerarPDF = new GerarPDF(banco, path);
				try {
					gerarPDF.gerarRelatorioPoder();
				} catch (IOException | DocumentException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
