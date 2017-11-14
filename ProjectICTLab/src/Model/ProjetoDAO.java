package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import Controller.BancoDeDados;

public class ProjetoDAO {

	private static ProjetoDAO projeto;

	public static ProjetoDAO getInstance() {
		if (projeto == null) {
			projeto = new ProjetoDAO();
		}
		return projeto;
	}

	private static PreparedStatement ps = null;
	private static ResultSet resultSet = null;
	private static ResultSet result = null;

	public boolean isValidString(String nome) {
		String pattern = "[a-zA-Z ]+";
		// String pattern = "^[a-zA-Z¡¬√¿«… Õ”‘’⁄‹·‚„‡ÁÈÍÌÛÙı˙¸]*$";// nao posso
		// colocar espaco pq na hora de editar eu faco split e
		// com os espacos da problema
		if (nome.matches(pattern)) {
			return false; // se sÛ tiver letra retorna falso e nao entra no if
							// do input
		} else
			return true;
	}

	public void cadProjeto(Projeto projeto) throws SQLException {
		if (BancoDeDados.getInstance().estaConectado()) {
			int idProjeto = 0, idPesquisador = 0;
			String sql;
			sql = "INSERT INTO projeto (nome,statusdoprojeto) VALUES (?,?)";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, projeto.getNome());
			ps.setString(2, projeto.getStatusDoProjeto());
			ps.executeUpdate();

			int aux = 0, tam;
			tam = projeto.getPesquisadores().size();

			sql = "select idprojeto from projeto where nome = ?";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, projeto.getNome());
			resultSet = ps.executeQuery();

			while (resultSet.next()) {
				idProjeto = resultSet.getInt("idprojeto");
			}

			while (tam != aux) {
				System.out.println(projeto.getPesquisadores().get(aux));

				sql = "select idPesquisador from pesquisador where nome = ?";
				ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
				ps.setString(1, projeto.getPesquisadores().get(aux));
				resultSet = ps.executeQuery();

				while (resultSet.next()) {
					idPesquisador = resultSet.getInt("idPesquisador");
				}

				sql = "INSERT INTO pesquisadorhasprojeto (idprojeto,idpesquisador) values(?,?)";
				ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
				ps.setInt(1, idProjeto);
				ps.setInt(2, idPesquisador);
				ps.executeUpdate();

				aux++;
			}
		}
	}

	public void editarProjeto(Projeto projeto, Projeto p) throws SQLException {
		String sql = "UPDATE projeto SET nome = ?, statusdoprojeto = ? WHERE nome = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, projeto.getNome());
		ps.setString(2, projeto.getStatusDoProjeto());
		ps.setString(3, p.getNome());
		ps.executeUpdate();
	}

	public void deleteProjeto(String nome) throws SQLException {
		String sql = "DELETE FROM projeto WHERE nome = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, nome);
		ps.executeUpdate();
	}

	public DefaultListModel<String> getAllProjeto() { // para listar usuarios
		
		int idprojeto = 0;
		
		DefaultListModel<String> model = null;
		try {
			model = new DefaultListModel<String>();
			String sql = "SELECT distinct nome, statusdoprojeto, idprojeto FROM projeto";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			resultSet = ps.executeQuery();	

			while (resultSet.next()) {
				idprojeto = resultSet.getInt("idprojeto");
				
				sql = "select pesquisador.nome from pesquisador inner join pesquisadorhasprojeto"	
						+" on pesquisadorhasprojeto.idPesquisador = pesquisador.idPesquisador" 
						+ " where pesquisadorhasprojeto.idProjeto = ?";
				
						ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
						ps.setInt(1, idprojeto);
						
						result = ps.executeQuery();
				while(result.next())
					model.addElement(resultSet.getString("nome") + " -- " + resultSet.getString("statusdoprojeto") 
										+ " -- " + result.getString("nome"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return model;
	}

	public Projeto getProjeto(String nome) {
		Projeto p = null;
		try {
			String sql = "SELECT nome, statusdoprojeto FROM projeto where nome = ?";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, nome);
			resultSet = ps.executeQuery();

			while (resultSet.next()) {
				p = new Projeto();
				p.setNome(resultSet.getString("Nome"));
				p.setStatusDoProjeto(resultSet.getString("statusdoprojeto"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return p;
	}

	public boolean existeProjeto() {

		if (BancoDeDados.getInstance().estaConectado()) {
			try {
				String query = "SELECT nome FROM projeto";
				ps = BancoDeDados.getInstance().getConnection().prepareStatement(query);
				resultSet = ps.executeQuery();
				while (resultSet.next()) {
					return true;
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return false;
	}

	public ArrayList<Projeto> getPDFAllProjeto() {
		ArrayList<Projeto> array = null;
		try {
			array = new ArrayList<Projeto>();
			String query = "select nome,statusdoprojeto from projeto";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(query);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Projeto p = new Projeto();
				p.setNome(resultSet.getString("Nome"));
				p.setStatusDoProjeto(resultSet.getString("statusdoprojeto"));

				array.add(p);
			}
			return array;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
}