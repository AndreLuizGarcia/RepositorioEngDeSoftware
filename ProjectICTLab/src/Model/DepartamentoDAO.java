package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import Controller.BancoDeDados;

public class DepartamentoDAO {

	private static DepartamentoDAO departamento;

	public static DepartamentoDAO getInstance() {
		if (departamento == null) {
			departamento = new DepartamentoDAO();
		}
		return departamento;
	}

	private static PreparedStatement ps = null;
	private static ResultSet resultSet = null;

	public boolean isValidString(String nome) {
		// String pattern = "[a-zA-Z ]+";
		String pattern = "^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$";// nao posso colocar espaco pq na hora de editar eu faco split e 
																 // com os espacos da problema															
		if (nome.matches(pattern)) {
			return false; // se só tiver letra retorna falso e nao entra no if do input					
		} else
			return true;
	}

	public void cadDepartamento(Departamento departamento) throws SQLException {
		if (BancoDeDados.getInstance().estaConectado()) {
			String sql;
			int id = 0;

			sql = "Select idPesquisador from pesquisador where nome =?";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, departamento.getResponsavel());
			resultSet = ps.executeQuery();

			while (resultSet.next()) {
				id = resultSet.getInt("idPesquisador");
			}
			
			sql = "INSERT INTO departamento (nomeDepartamento,descrição,idresponsavel) VALUES (?,?,?)";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, departamento.getNome());
			ps.setString(2, departamento.getDescricao());
			ps.setInt(3, id);
			ps.executeUpdate();
		}
	}

	public void editarDepartamento(Departamento departamento, Departamento d) throws SQLException {
		
		String sql;
		int id = 0;

		sql = "Select idPesquisador from pesquisador where nome =?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, departamento.getResponsavel());
		resultSet = ps.executeQuery();

		while (resultSet.next()) {
			id = resultSet.getInt("idPesquisador");
		}		
		
		sql = "UPDATE departamento SET nomeDepartamento = ?, descrição = ?, idresponsavel = ? WHERE nomeDepartamento = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, departamento.getNome());
		ps.setString(2, departamento.getDescricao());
		ps.setInt(3, id);
		ps.setString(4, d.getNome());
		ps.executeUpdate();
	}

	public void deleteDepartamento(String nome) throws SQLException {
		String sql = "DELETE FROM departamento WHERE nomeDepartamento = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, nome);
		ps.executeUpdate();
	}
	
	public DefaultListModel<String> getAllDepartamento() { // para listar departamentos
		DefaultListModel<String> model = null;
		try {
			model = new DefaultListModel<String>();
			String sql = "SELECT nomeDepartamento, descrição, nome as responsavel FROM departamento inner join pesquisador "
					+ "where departamento.idResponsavel = pesquisador.idPesquisador";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				model.addElement(resultSet.getString("nomeDepartamento") + " " + resultSet.getString("responsavel")
						+ " " + resultSet.getString("descrição"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+"bbbbbbb");
		}
		return model;
	}

	public Departamento getDepartamento(String nome) {
		Departamento d = null;
		try {
			String sql = "SELECT nomeDepartamento, descrição, "
					+ "nome as responsavel FROM departamento inner join pesquisador "
					+ "where departamento.idResponsavel = pesquisador.idPesquisador";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			resultSet = ps.executeQuery();

			while (resultSet.next()) {
				d = new Departamento();
				d.setNome(resultSet.getString("nomeDepartamento"));
				d.setDescricao(resultSet.getString("descrição"));
				d.setResponsavel(resultSet.getString("responsavel"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+"ccccc");
		}
		return d;
	}

	public boolean existeDepartamento() {

		if (BancoDeDados.getInstance().estaConectado()) {
			try {
				String query = "SELECT nomeDepartamento FROM departamento";
				ps = BancoDeDados.getInstance().getConnection().prepareStatement(query);
				resultSet = ps.executeQuery();
				while (resultSet.next()) {
					return true;
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage()+"aaaaaa", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return false;
	}

	public ArrayList<Departamento> getPDFAllDepartamentos() {
		ArrayList<Departamento> array = null;
		try {
			array = new ArrayList<Departamento>();
			String query = "SELECT nomeDepartamento, descrição, nome as responsavel FROM departamento inner join pesquisador "
					+ "where departamento.idResponsavel = pesquisador.idPesquisador";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(query);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Departamento d = new Departamento();
				d.setNome(resultSet.getString("nomeDepartamento"));
				d.setDescricao(resultSet.getString("descrição"));
				d.setResponsavel(resultSet.getString("responsavel"));

				array.add(d);
			}
			return array;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+"ddddd", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
}