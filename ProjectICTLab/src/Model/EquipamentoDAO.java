package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import Controller.BancoDeDados;

public class EquipamentoDAO {

	private static EquipamentoDAO equipamento;

	public static EquipamentoDAO getInstance() {
		if (equipamento == null) {
			equipamento = new EquipamentoDAO();
		}
		return equipamento;
	}

	private static PreparedStatement ps = null;
	private static ResultSet resultSet = null;

	public boolean isValidString(String nome) {
		// String pattern = "[a-zA-Z ]+";
		String pattern = "^[a-zA-Z¡¬√¿«… Õ”‘’⁄‹·‚„‡ÁÈÍÌÛÙı˙¸]*$";// nao posso colocar espaco pq na hora de editar eu faco split e 
																 // com os espacos da problema															
		if (nome.matches(pattern)) {
			return false; // se sÛ tiver letra retorna falso e nao entra no if do input					
		} else
			return true;
	}
	
	public boolean isValidInt(String tombo) {
        String pattern = "^[0-9]*$";
        if(tombo.matches(pattern)){
        	return false;   //se sÛ tiver numero retorna falso e nao entra no if do input
        } else return true;
    }

	public void cadEquipamento(Equipamento equipamento) throws SQLException {
		if (BancoDeDados.getInstance().estaConectado()) {
			String sql;
			
			sql = "INSERT INTO equipamento (nomeEquipamento,descricao,tombo) VALUES (?,?,?)";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, equipamento.getNome());
			ps.setString(2, equipamento.getDescricao());
			ps.setString(3, equipamento.getTombo());
			ps.executeUpdate();
		}
	}

	public void editarEquipamento(Equipamento equipamento, Equipamento e) throws SQLException {
		String sql;
		
		sql = "UPDATE equipamento SET nomeEquipamento = ?, descricao = ?, tombo = ? WHERE nomeEquipamento = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, equipamento.getNome());
		ps.setString(2, equipamento.getDescricao());
		ps.setString(3, equipamento.getTombo());
		ps.setString(4, e.getNome());
		ps.executeUpdate();
	}

	public void deleteEquipamento(String nome) throws SQLException {
		String sql = "DELETE FROM equipamento WHERE nomeEquipamento = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, nome);
		ps.executeUpdate();
	}
	
	public DefaultListModel<String> getAllEquipamento() { // para listar departamentos
		DefaultListModel<String> model = null;
		try {
			model = new DefaultListModel<String>();
			String sql = "SELECT nomeEquipamento, descricao, tombo FROM equipamento";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				model.addElement(resultSet.getString("nomeEquipamento") + " " + resultSet.getString("descricao")
						+ " " + resultSet.getString("tombo"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return model;
	}

	public Equipamento getEquipamento(String nome) {
		Equipamento e = null;
		try {
			String sql = "SELECT nomeEquipamento, descricao,tombo FROM equipamento where nomeEquipamento = ?";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, nome);
			resultSet = ps.executeQuery();

			while (resultSet.next()) {
				e = new Equipamento();
				e.setNome(resultSet.getString("nomeEquipamento"));
				e.setDescricao(resultSet.getString("descricao"));
				e.setTombo(resultSet.getString("tombo"));
			}
		} catch (SQLException f) {
			JOptionPane.showMessageDialog(null, f.getMessage()+"ccccc");
		}
		return e;
	}

	public boolean existeEquipamento() {

		if (BancoDeDados.getInstance().estaConectado()) {
			try {
				String query = "SELECT nomeEquipamento FROM equipamento";
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

	public ArrayList<Equipamento> getPDFAllEquipamento() {
		ArrayList<Equipamento> array = null;
		try {
			array = new ArrayList<Equipamento>();
			String query = "SELECT nomeEquipamento, descricao, tombo FROM equipamento";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(query);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Equipamento e = new Equipamento();
				e.setNome(resultSet.getString("nomeEquipamento"));
				e.setDescricao(resultSet.getString("descricao"));
				e.setTombo(resultSet.getString("tombo"));

				array.add(e);
			}
			return array;
		} catch (SQLException f) {
			JOptionPane.showMessageDialog(null, f.getMessage()+"ddddd", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
}