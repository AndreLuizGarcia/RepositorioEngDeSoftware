package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.LoginUser;
import Model.Pesquisador;
import Model.PesquisadorDAO;
import View.CadastroPesquisadorFrame;
import View.MenuAdminFrame;

public class InputListenerCadastroPesquisadorFrame implements ActionListener {

	private CadastroPesquisadorFrame cadastroPesquisador;

	public InputListenerCadastroPesquisadorFrame(CadastroPesquisadorFrame cadastroPesquisador) {
		this.cadastroPesquisador = cadastroPesquisador;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			cadastroPesquisador.dispose();
			new MenuAdminFrame().setVisible(true);
		} else if (e.getActionCommand().equals("Cancelar")) {
			cadastroPesquisador.getNomeField().setText(null);
			cadastroPesquisador.getEmailField().setText(null);
			cadastroPesquisador.getBiografiaField().setText(null);
			cadastroPesquisador.getLattesField().setText(null);
			cadastroPesquisador.getLinkedinField().setText(null);
			cadastroPesquisador.getLoginField().setText(null);
			cadastroPesquisador.getPasswordField().setText(null);			
		} else if (e.getActionCommand().equals("Cadastrar")) {
			if (cadastroPesquisador.getNomeField().getText().equals("")
					|| cadastroPesquisador.getEmailField().getText().equals("")
					|| cadastroPesquisador.getBiografiaField().getText().equals("")
					|| cadastroPesquisador.getLattesField().getText().equals("")
					|| cadastroPesquisador.getLinkedinField().getText().equals("")
					|| cadastroPesquisador.getLoginField().getText().equals("")
					|| cadastroPesquisador.getPasswordField().getText().equals(""))					
			{
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			}  else if (PesquisadorDAO.getInstance().isValidString(cadastroPesquisador.getNomeField().getText())){
				JOptionPane.showMessageDialog(null, "Insira apenas letras no campo Nome", "Erro!",JOptionPane.ERROR_MESSAGE);
			} else if (PesquisadorDAO.getInstance().isValidEmail(cadastroPesquisador.getEmailField().getText())){
				JOptionPane.showMessageDialog(null, "Insira um email valido no campo Email. Formato: nome@seuservidor.com", "Erro!",JOptionPane.ERROR_MESSAGE);
			} else if (PesquisadorDAO.getInstance().isValidUrl(cadastroPesquisador.getLattesField().getText())){
				JOptionPane.showMessageDialog(null, "Insira um link valido no campo Lattes. Formato: www.seusite.com", "Erro!",JOptionPane.ERROR_MESSAGE);
			} else if (PesquisadorDAO.getInstance().isValidUrl(cadastroPesquisador.getLinkedinField().getText())){
				JOptionPane.showMessageDialog(null, "Insira um link valido no campo LinkedIN. Formato: www.seusite.com", "Erro!",JOptionPane.ERROR_MESSAGE);
			} else if (PesquisadorDAO.getInstance().existeLoginCadastro(cadastroPesquisador.getLoginField().getText(),cadastroPesquisador.getNomeField().getText())){
				JOptionPane.showMessageDialog(null, "Este Login/Nome já exite, escolha outro!!", "Erro!", JOptionPane.ERROR_MESSAGE);
			}else {
				
				LoginUser loginUser = new LoginUser();
				loginUser.setLogin(cadastroPesquisador.getLoginField().getText());
				loginUser.setSenha(cadastroPesquisador.getPasswordField().getText());
				
				
				Pesquisador pesquisador = new Pesquisador();
				
				pesquisador.setNome(cadastroPesquisador.getNomeField().getText());
				pesquisador.setBiografia(cadastroPesquisador.getBiografiaField().getText());
				pesquisador.setEmail(cadastroPesquisador.getEmailField().getText());
				pesquisador.setLattes(cadastroPesquisador.getLattesField().getText());
				pesquisador.setLinkedin(cadastroPesquisador.getLinkedinField().getText());
				pesquisador.setLoginUser(loginUser);
				
				try {
					PesquisadorDAO.getInstance().cadPesquisador(pesquisador);
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
					cadastroPesquisador.dispose();
					new MenuAdminFrame().setVisible(true);
				} catch (SQLException r) {
					JOptionPane.showMessageDialog(null, r.getMessage());
				}
			}
		}
	}
}