package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class BancoDeDados {

	private static BancoDeDados banco;

	public static BancoDeDados getInstance() {
		if (banco == null) {
			banco = new BancoDeDados();
		}
		return banco;
	}

	private Connection connection = null;

	public Connection getConnection() {
		return connection;
	}

	public BancoDeDados() {

	}

	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/ict?characterEncoding=UTF-8&useSSL=false";
		String usuario = "root";
		String senha = "root";

		try {
			connection = DriverManager.getConnection(servidor, usuario, senha);
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean estaConectado() {
		if (connection != null) {
			return true;
		} else {
			return false;
		}
	}
}
