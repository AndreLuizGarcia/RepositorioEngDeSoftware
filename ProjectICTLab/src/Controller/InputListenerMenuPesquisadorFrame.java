package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.EquipamentoDAO;
import Model.EventoDAO;
import Model.ProjetoDAO;
import View.BemVindoFrame;
import View.CadastroEquipamentoFrame;
import View.CadastroEventoFrame;
import View.CadastroProjetoFrame;
import View.ListarEquipamentoFrame;
import View.ListarEventosFrame;
import View.ListarProjetoFrame;
import View.MenuPesquisadorFrame;

public class InputListenerMenuPesquisadorFrame implements ActionListener {
	
	private MenuPesquisadorFrame menuPesquisador;

	public InputListenerMenuPesquisadorFrame(MenuPesquisadorFrame menuPesquisador) {
		this.menuPesquisador = menuPesquisador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("entrooou");
		
		System.out.println(e.getActionCommand());
		
		
		if(e.getActionCommand().equals("Voltar")){
			int i = JOptionPane.showConfirmDialog(null ,"Deseja voltar a tela de login?", 
					 "Saída",JOptionPane.YES_NO_OPTION);
					 if (i == JOptionPane.YES_OPTION ) {
						 	JOptionPane.showMessageDialog(null, "Você está sendo deslogado!");
						 	menuPesquisador.dispose();  
							new BemVindoFrame().setVisible(true);
					 }
		}else if(e.getActionCommand().equals("Sair")){
			JOptionPane.showMessageDialog(null, "Saindo...");
			menuPesquisador.dispose();
			System.exit(1);			
		}else if(e.getActionCommand().equals("Cadastrar Evento")){
			menuPesquisador.dispose();
			new CadastroEventoFrame().setVisible(true);
		}else if(e.getActionCommand().equals("Cadastrar Equipamento")){
			menuPesquisador.dispose();
			new CadastroEquipamentoFrame().setVisible(true);		
		}else if(e.getActionCommand().equals("Cadastrar Projeto")){
			menuPesquisador.dispose();
			new CadastroProjetoFrame().setVisible(true);		
		}else if(e.getActionCommand().equals("Listar Evento")){
			if(EventoDAO.getInstance().existeEvento()){
				menuPesquisador.dispose();
				new ListarEventosFrame().setVisible(true);
			}else JOptionPane.showMessageDialog(null, "Não ha nenhum evento para ser listado!!");
		}else if(e.getActionCommand().equals("Listar Equipamento")){
			if(EquipamentoDAO.getInstance().existeEquipamento()){
				menuPesquisador.dispose();
				new ListarEquipamentoFrame().setVisible(true);
			}else JOptionPane.showMessageDialog(null, "Não ha nenhum equipamento para ser listado!!");
		}else if(e.getActionCommand().equals("Listar Projeto")){
			if(ProjetoDAO.getInstance().existeProjeto()){
				menuPesquisador.dispose();
				new ListarProjetoFrame().setVisible(true);
			}else JOptionPane.showMessageDialog(null, "Não ha nenhum projeto para ser listado!!");
			
		}
	}

}
