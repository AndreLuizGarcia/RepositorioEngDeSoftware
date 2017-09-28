package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;

import Model.Departamento;
import Model.DepartamentoDAO;
import View.EditarDepartamentoFrame;
import View.ListarDepartamentoFrame;
import View.MenuAdminFrame;

public class InputListenerListarDepartamentoFrame implements ActionListener {

	private ListarDepartamentoFrame listarDepartamento;
	private JFileChooser fileChooser;
	private BancoDeDados banco;

	public InputListenerListarDepartamentoFrame(ListarDepartamentoFrame listarDepartamento,BancoDeDados banco) {
		this.listarDepartamento = listarDepartamento;
		this.banco = banco;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			listarDepartamento.dispose();
			new MenuAdminFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Remover")) {
			if (listarDepartamento.getList().getSelectedIndex() != -1) {
				String[] campos = listarDepartamento.getList().getSelectedValue().split(" ");
				try {
					System.out.println("campos[2] = " + campos[0]);
					DepartamentoDAO.getInstance().deleteDepartamento(campos[0]);
					listarDepartamento.refreshList();
					JOptionPane.showMessageDialog(null, "Deletado!");
					if(listarDepartamento.getList().getSelectedIndex() == -1){
						listarDepartamento.dispose();
						new MenuAdminFrame().setVisible(true);
					}
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		} else if (e.getActionCommand().equals("Editar")) {
			if (listarDepartamento.getList().getSelectedIndex() != -1) {
				String[] campos = listarDepartamento.getList().getSelectedValue().split(" ");
				System.out.println(campos[0]);
				Departamento d = DepartamentoDAO.getInstance().getDepartamento(campos[0]);
				listarDepartamento.dispose();
				new EditarDepartamentoFrame(d).setVisible(true);
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
