package Controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.PesquisadorDAO;
import View.BemVindoFrame;

public class Runner {
	public static void main(String[] args) {
		BancoDeDados.getInstance().conectar();
		
		if(BancoDeDados.getInstance().estaConectado()){
			try {
				PesquisadorDAO.getInstance().deslogarPesquisador();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			BemVindoFrame bvf = new BemVindoFrame();
			bvf.setVisible(true);
		}else JOptionPane.showMessageDialog(null, "Banco de Dados desconctao!");		
	}
}			