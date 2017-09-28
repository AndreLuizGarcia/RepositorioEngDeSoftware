package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;

import Model.Projeto;
import Model.ProjetoDAO;
import View.EditarProjetoFrame;
import View.ListarProjetoFrame;
import View.MenuPesquisadorFrame;

public class InputListenerListarProjetoFrame implements ActionListener {

	private ListarProjetoFrame listarProjeto;
	private JFileChooser fileChooser;
	private BancoDeDados banco;

	public InputListenerListarProjetoFrame(ListarProjetoFrame listarProjeto,BancoDeDados banco) {
		this.listarProjeto = listarProjeto;
		this.banco = banco;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			listarProjeto.dispose();
			new MenuPesquisadorFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Remover")) {
			if (listarProjeto.getList().getSelectedIndex() != -1) {
				String[] campos = listarProjeto.getList().getSelectedValue().split(" ");
				try {
					ProjetoDAO.getInstance().deleteProjeto(campos[0]);
					listarProjeto.refreshList();
					JOptionPane.showMessageDialog(null, "Deletado!");
					if(listarProjeto.getList().getSelectedIndex() == -1){
						listarProjeto.dispose();
						new MenuPesquisadorFrame().setVisible(true);
					}
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		} else if (e.getActionCommand().equals("Editar")) {
			if (listarProjeto.getList().getSelectedIndex() != -1) {
				String[] campos = listarProjeto.getList().getSelectedValue().split(" ");
				Projeto p = ProjetoDAO.getInstance().getProjeto(campos[0]);
				listarProjeto.dispose();
				new EditarProjetoFrame(p).setVisible(true);
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
