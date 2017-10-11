package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import Controller.BancoDeDados;

public class PesquisadorDAO {

	private static PesquisadorDAO pesquisador;

	public static PesquisadorDAO getInstance() {
		if (pesquisador == null) {
			pesquisador = new PesquisadorDAO();
		}
		return pesquisador;
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
	
	public void estaLogado(String pesquisador) throws SQLException {
		if (BancoDeDados.getInstance().estaConectado()) {
			String sql;
			sql = "INSERT INTO estaLogado (nome) VALUES (?)";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, pesquisador);
			ps.executeUpdate();
		}
	}
	
	public void deslogarPesquisador() throws SQLException {
		String sql;
		sql = "delete from estaLogado where 1";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.executeUpdate();
	}

	public void cadPesquisador(Pesquisador pesquisador) throws SQLException {
		if (BancoDeDados.getInstance().estaConectado()) {
			String sql;
			sql = "INSERT INTO loginUser (login,senha) VALUES (?,?)";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, pesquisador.getLoginUser().getLogin());
			ps.setString(2, pesquisador.getLoginUser().getSenha());
			ps.executeUpdate();
			sql = "INSERT INTO pesquisador (nome,email,biografia,lattes,linkedin,idlogin) VALUES "
					+ "(?,?,?,?,?,(SELECT MAX(idlogin) FROM LoginUser))";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, pesquisador.getNome());
			ps.setString(2, pesquisador.getEmail());
			ps.setString(3, pesquisador.getBiografia());
			ps.setString(4, pesquisador.getLattes());
			ps.setString(5, pesquisador.getLinkedin());
			ps.executeUpdate();
		}
	}

	public void editarPesquisador(Pesquisador pesquisador, Pesquisador p) throws SQLException {
		String sql = "UPDATE Pesquisador SET nome = ?, email = ?, biografia = ?, lattes = ?, linkedin = ? WHERE nome = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, pesquisador.getNome());
		ps.setString(2, pesquisador.getEmail());
		ps.setString(3, pesquisador.getBiografia());
		ps.setString(4, pesquisador.getLattes());
		ps.setString(5, pesquisador.getLinkedin());
		ps.setString(6, p.getNome());
		ps.executeUpdate();
	}

	public void deletePesquisador(String nome) throws SQLException {
		String sql = "Select idlogin FROM pesquisador WHERE nome = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setString(1, nome);
		resultSet = ps.executeQuery();
		
		System.out.println(nome);
		
		int id = 0;
		
		while(resultSet.next()){
			id = resultSet.getInt("idLogin");
			System.out.println("id = " + id);
		}
		
		String b = "DELETE FROM pesquisador WHERE nome = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(b);
		ps.setString(1, nome);
		ps.executeUpdate();
			
		sql = "DELETE FROM loginuser WHERE idLogin = ?";
		ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
		ps.setInt(1, id);
		
		
		
		ps.executeUpdate();		
	}

	public DefaultListModel<String> getAllPesquisador() { // para listar usuarios
		DefaultListModel<String> model = null;
		try {
			model = new DefaultListModel<String>();
			String sql = "SELECT nome, email, biografia, lattes, linkedin FROM pesquisador";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				model.addElement(resultSet.getString("nome") + " " + resultSet.getString("email")
						+ " " + resultSet.getString("biografia") + " " + resultSet.getString("lattes") + " " + resultSet.getString("linkedin"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return model;
	}

	public Pesquisador getPesquisador(String nome) {
		Pesquisador p = null;
		try {
			String sql = "SELECT nome, email, biografia, lattes, linkedin FROM pesquisador where nome = ?";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, nome);
			resultSet = ps.executeQuery();

			while (resultSet.next()) {
				p = new Pesquisador();
				p.setNome(resultSet.getString("Nome"));
				p.setBiografia(resultSet.getString("biografia"));
				p.setEmail(resultSet.getString("email"));
				p.setLattes(resultSet.getString("lattes"));
				p.setLinkedin(resultSet.getString("linkedin"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+"fffffff");
		}
		return p;
	}

	public boolean existePesquisador() {

		if (BancoDeDados.getInstance().estaConectado()) {
			try {
				String query = "SELECT nome FROM pesquisador";
				ps = BancoDeDados.getInstance().getConnection().prepareStatement(query);
				resultSet = ps.executeQuery();
				while (resultSet.next()) {
					return true;
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage()+"dddddd", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return false;
	}

	public boolean existeLogin(String login, String senha) {

		if (BancoDeDados.getInstance().estaConectado()) {
			try {
				String query = "SELECT Login, senha FROM loginUser "
						+ "WHERE login = ? AND Senha = ?";
				ps = BancoDeDados.getInstance().getConnection().prepareStatement(query);
				ps.setString(1, login);
				ps.setString(2, senha);
				resultSet = ps.executeQuery();
				while (resultSet.next()) {
					return true;
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage()+"ccccc", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return false;
	}
	
	public boolean existeLoginCadastro(String login, String nome) {

		if (BancoDeDados.getInstance().estaConectado()) {
			try {
				int a=0,b=0;
				String query = "SELECT Login FROM loginUser WHERE login = ?";
				ps = BancoDeDados.getInstance().getConnection().prepareStatement(query);
				ps.setString(1, login);
				resultSet = ps.executeQuery();
				while (resultSet.next()) {
					a=1;
				}
				
				query = "SELECT nome FROM pesquisador WHERE nome = ?";
				ps = BancoDeDados.getInstance().getConnection().prepareStatement(query);
				ps.setString(1, nome);
				resultSet = ps.executeQuery();
				while (resultSet.next()) {
					b=1;
				}
				
				if(a == 1 || b == 1){
					return true;
				}
				
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage()+"bbbbbbb", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return false;
	}

	public ArrayList<Pesquisador> getPDFAllPesquisadores() {
		ArrayList<Pesquisador> array = null;
		try {
			array = new ArrayList<Pesquisador>();
			String query = "select nome,email,biografia,lattes,linkedin from pesquisador";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(query);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Pesquisador p = new Pesquisador();
				p.setNome(resultSet.getString("Nome"));
				p.setBiografia(resultSet.getString("biografia"));
				p.setEmail(resultSet.getString("email"));
				p.setLattes(resultSet.getString("lattes"));
				p.setLinkedin(resultSet.getString("linkedin"));

				array.add(p);
			}
			return array;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+"aaaaaaa", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	public String[] getAllPesquisadoresChoice() { // para listar usuarios
		String[] tabela = new String[20];
		int i =0;
		try {
			String sql = null;
			
//			sql = "SELECT Nome FROM pesquisador";
//			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
//			resultSet = ps.executeQuery();
//
//			while (resultSet.next()) {
//				nome = resultSet.getString("nome");
//			}

			sql = "SELECT nome FROM pesquisador ";
			ps = BancoDeDados.getInstance().getConnection().prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				tabela[i++]=resultSet.getString("nome");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return tabela;
	}
}