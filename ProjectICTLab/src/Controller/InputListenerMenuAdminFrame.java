package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.DepartamentoDAO;
import Model.PesquisadorDAO;
import View.BemVindoFrame;
import View.CadastroDepartamentoFrame;
import View.CadastroPesquisadorFrame;
import View.ListarDepartamentoFrame;
import View.ListarPesquisadorFrame;
import View.MenuAdminFrame;

public class InputListenerMenuAdminFrame implements ActionListener {
	
	private MenuAdminFrame menuAdmin;

	public InputListenerMenuAdminFrame(MenuAdminFrame menuAdmin) {
		this.menuAdmin = menuAdmin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Voltar")){
			int i = JOptionPane.showConfirmDialog(null ,"Deseja voltar a tela de login?", 
					 "Saída",JOptionPane.YES_NO_OPTION);
					 if (i == JOptionPane.YES_OPTION ) {
						 	JOptionPane.showMessageDialog(null, "Você está sendo deslogado!");
							menuAdmin.dispose();  
							new BemVindoFrame().setVisible(true);
					 }
		}else if(e.getActionCommand().equals("Sair")){
			JOptionPane.showMessageDialog(null, "Saindo...");
			menuAdmin.dispose();
			System.exit(1);			
		}else if(e.getActionCommand().equals("Cadastrar Pesquisador")){
			menuAdmin.dispose();
			new CadastroPesquisadorFrame().setVisible(true);
		}else if(e.getActionCommand().equals("Cadastrar Departamento")){
			menuAdmin.dispose();
			new CadastroDepartamentoFrame().setVisible(true);		
		}else if(e.getActionCommand().equals("Listar Pesquisador")){
			if(PesquisadorDAO.getInstance().existePesquisador()){
				menuAdmin.dispose();
				new ListarPesquisadorFrame().setVisible(true);
			}else JOptionPane.showMessageDialog(null, "Não ha nenhum pesquisador para ser listado!!");
		}else if(e.getActionCommand().equals("Listar Departamento")){
			if(DepartamentoDAO.getInstance().existeDepartamento()){
				menuAdmin.dispose();
				new ListarDepartamentoFrame().setVisible(true);
			}else JOptionPane.showMessageDialog(null, "Não ha nenhum departamento para ser listado!!");
			
		}
	}

}
