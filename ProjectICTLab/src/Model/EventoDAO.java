package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import Controller.BancoDeDados;

public class EventoDAO {

	private static EventoDAO evento;

	public static EventoDAO getInstance() {
		if (evento == null) {
			evento = new EventoDAO();
		}
		return evento;
	}

	private static PreparedStatement ps = null;
	private static ResultSet resultSet = null;

	public boolean isValidString(String nome) {
		String pattern = "[a-zA-Z ]+";
		//String pattern = "^[a-zA-Z¡¬√¿«… Õ”‘’⁄‹·‚„‡ÁÈÍÌÛÙı˙¸]*$";// nao posso colocar espaco pq na hora de editar eu faco split e 
																 // com os espacos da problema															
		if (nome.matches(pattern)) {
			return false; // se sÛ tiver letra retorna falso e nao entra no if do input					
		} else
			return true;
	}
	
	public boolean isValidDate(String date) {
        String pattern = "\\d{2}/\\d{2}/\\d{4}";
        if(date.matches(pattern)){
        	return false;   //se sÛ tiver numero retorna falso e nao entra no if do input
        } else return true;
    }

	public void cadEvento(Evento evento) throws SQLException {
		if (BancoDeDados.getInstance().estaConectado()) {
			String sql,id = null;
			
			sql = "Select idPesquisador from pesquisador where nome =?";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, evento.getResponsavel());
			resultSet = ps.executeQuery();

			while (resultSet.next()) {
				id = resultSet.getString("idPesquisador");
			}
			
			sql = "INSERT INTO eventos (nome,dataEvento,localEvento,idResponsavel) VALUES (?,?,?,?)";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, evento.getNome());
			ps.setString(2, evento.getData());
			ps.setString(3, evento.getLocal());
			ps.setString(4, id);
			ps.executeUpdate();
		}
	}

	public void editarEvento(Evento evento, Evento e) throws SQLException {
		String sql,id = null;
		
		sql = "Select idPesquisador from pesquisador where nome =?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, evento.getResponsavel());
		resultSet = ps.executeQuery();

		while (resultSet.next()) {
			id = resultSet.getString("idPesquisador");
		}
		
		sql = "UPDATE eventos SET nome = ?, dataEvento = ?, localEvento = ?, idResponsavel = ? WHERE nome = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, evento.getNome());
		ps.setString(2, evento.getData());
		ps.setString(3, evento.getLocal());
		ps.setString(4, id);
		ps.setString(5, e.getNome());
		ps.executeUpdate();
	}

	public void deleteEvento(String nome) throws SQLException {
		String sql = "DELETE FROM eventos WHERE nome = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, nome);
		ps.executeUpdate();
	}
	
	public DefaultListModel<String> getAllEvento() { // para listar eventos
		DefaultListModel<String> model = null;
		try {
			model = new DefaultListModel<String>();
			String sql = "SELECT eventos.nome, dataEvento, localEvento, pesquisador.nome as responsavel FROM eventos,pesquisador where idResponsavel = idPesquisador;";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				model.addElement(resultSet.getString("nome") + " -- " + resultSet.getString("dataEvento")
						+ " -- " + resultSet.getString("localEvento") + " -- " + resultSet.getString("responsavel"));
				System.out.println("result set nome == " + resultSet.getString("nome") );
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return model;
	}

	public Evento getEvento(String nome) {
		Evento e = null;
		try {
			String sql = "SELECT eventos.nome, dataEvento, localEvento, pesquisador.nome as responsavel FROM eventos, pesquisador where eventos.nome = ? and idResponsavel = idPesquisador;";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, nome);
			resultSet = ps.executeQuery();

			while (resultSet.next()) {
				e = new Evento();
				e.setNome(resultSet.getString("nome"));
				e.setData(resultSet.getString("dataEvento"));
				e.setLocal(resultSet.getString("localEvento"));
				e.setResponsavel(resultSet.getString("responsavel"));
			}
		} catch (SQLException f) {
			JOptionPane.showMessageDialog(null, f.getMessage());
		}
		return e;
	}

	public boolean existeEvento() {

		if (BancoDeDados.getInstance().estaConectado()) {
			try {
				String query = "SELECT nome FROM eventos";
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

	public ArrayList<Evento> getPDFAllEvento() {
		ArrayList<Evento> array = null;
		try {
			array = new ArrayList<Evento>();
			String query = "SELECT eventos.nome, dataEvento, localEvento, pesquisador.nome as responsavel FROM eventos,pesquisador where idResponsavel = idPesquisador;";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(query);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Evento e = new Evento();
				e.setNome(resultSet.getString("nome"));
				e.setData(resultSet.getString("dataEvento"));
				e.setLocal(resultSet.getString("localEvento"));
				e.setResponsavel(resultSet.getString("responsavel"));

				array.add(e);
			}
			return array;
		} catch (SQLException f) {
			JOptionPane.showMessageDialog(null, f.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
}