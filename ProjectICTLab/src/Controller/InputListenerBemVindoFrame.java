package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.PesquisadorDAO;
import View.BemVindoFrame;
import View.MenuAdminFrame;
import View.MenuPesquisadorFrame;

public class InputListenerBemVindoFrame implements ActionListener {

	private BemVindoFrame menu;

	public InputListenerBemVindoFrame(BemVindoFrame menu) {
		this.menu = menu;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Sair")) {
			JOptionPane.showMessageDialog(null, "Saindo...");
			menu.dispose();
			System.exit(1);
		} else if (e.getActionCommand().equals("Entrar")) {
			if (menu.getUserTextField().getText().equals("admin")
					&& menu.getPasswordField().getText().equals("admin")) {
				menu.dispose();
				new MenuAdminFrame().setVisible(true);
			} else if (PesquisadorDAO.getInstance().existeLogin(menu.getUserTextField().getText(),
					menu.getPasswordField().getText())) {
				try {
					PesquisadorDAO.getInstance().estaLogado(menu.getUserTextField().getText());
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				menu.dispose();
				new MenuPesquisadorFrame().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Dados Incorretos!");
				menu.getUserTextField().setText(null);
				menu.getPasswordField().setText(null);
			}
		}
	}
}