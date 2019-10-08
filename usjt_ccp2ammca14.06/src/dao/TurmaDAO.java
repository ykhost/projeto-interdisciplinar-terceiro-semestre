package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Turma;

public class TurmaDAO {
	//Metodo para inserir turma ao banco de dados
	public int inserir (Turma turma) throws SQLException {
		String sqlInsert = "INSERT INTO Turma(sigla, ano_letivo,semestre_letivo,tema_id) VALUES (?, ?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, turma.getSigla());
			stm.setInt(2, turma.getAno_letivo());
			stm.setInt(3, turma.getSemestre_letivo());
			stm.setInt(4,turma.getTema_id());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					turma.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return turma.getId();
	}
	//Metodo para deletar turma atraves do id.
	public int deletar (Turma turma) throws SQLException {
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM Turma WHERE id = ?");){
					ps.setInt(1, turma.getId());
					ps.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return turma.getId();
	}
	//Metodo para atualizar turma atraves do id
	public Turma atualizar (Turma turma) throws SQLException {
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement("UPDATE Turma SET sigla=?, ano_letivo=?,semestre_letivo=?, tema_id=? WHERE id = ?");){
					ps.setString(1, turma.getSigla());
					ps.setInt(2, turma.getAno_letivo());
					ps.setInt(3, turma.getSemestre_letivo());
					ps.setInt(4,turma.getTema_id());
					ps.setInt(5, turma.getId());
					ps.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return turma;
	}
	//Metodo para listar todas as turmas
	public Turma carregar(int id) {
		Turma turma=new Turma();
		turma.setId(id);
		String sqlSelect = "SELECT sigla, ano_letivo,semestre_letivo,tema_id, titulo FROM turma INNER JOIN tema ON turma.tema_id=tema.id WHERE turma.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, turma.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					turma.setSigla(rs.getString("sigla"));
					turma.setAno_letivo(rs.getInt("ano_letivo"));
					turma.setSemestre_letivo(rs.getInt("semestre_letivo"));
					turma.setTema_id(rs.getInt("tema_id"));
					turma.setTitulo(rs.getString("titulo"));
				} else {
					turma.setId(-1);
					turma.setSigla(null);
					turma.setAno_letivo(-1);
					turma.setSemestre_letivo(-1);
					turma.setTema_id(-1);
					turma.setTitulo(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return turma;
	}
	//Metodo para pesquisar turmas atraves de uma chave de busca
	public ArrayList<Turma> listarTodos(String chave) {
		Turma turma= new Turma();
		
		ArrayList<Turma> lista = new ArrayList <> ();
		String sql = "SELECT turma.id, sigla, ano_letivo,semestre_letivo,tema_id, titulo FROM Turma INNER JOIN tema ON turma.tema_id=tema.id where upper(sigla) like ? ";
		//try with resources
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					turma = new Turma();
					turma.setId(rs.getInt("id"));
					turma.setSigla(rs.getString("sigla"));
					turma.setAno_letivo(rs.getInt("ano_letivo"));
					turma.setSemestre_letivo(rs.getInt("semestre_letivo"));
					turma.setTema_id(rs.getInt("tema_id"));
					turma.setTitulo(rs.getString("titulo"));
					lista.add(turma);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	
	}
	//Metodo para listar todas a turmas em uma ArrayList
	public ArrayList<Turma> listarTodos() {
		Turma turma= new Turma();
		
		ArrayList<Turma> lista = new ArrayList <> ();
		String sql = " SELECT turma.id, sigla, ano_letivo,semestre_letivo,tema_id,titulo FROM Turma INNER JOIN tema ON turma.tema_id=tema.id; ";
		//try with resources
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sql);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					turma = new Turma();
					turma.setId(rs.getInt("id"));
					turma.setSigla(rs.getString("sigla"));
					turma.setAno_letivo(rs.getInt("ano_letivo"));
					turma.setSemestre_letivo(rs.getInt("semestre_letivo"));
					turma.setTema_id(rs.getInt("tema_id"));
					turma.setTitulo(rs.getString("titulo"));
					lista.add(turma);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	
	}
	
}

