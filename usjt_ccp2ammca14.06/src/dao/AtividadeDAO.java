package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Atividade;


public class AtividadeDAO {
	public int inserir (Atividade atividade) throws SQLException {
		String sqlInsert = "INSERT INTO Atividade(tema_id,descricao, formato_entrega, numero, dt_inicio, dt_fim) VALUES (?, ?, ?, ?, ?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, atividade.getTemaID());
			stm.setString(2, atividade.getAtvDescricao());
			stm.setString(3, atividade.getAtvFormato());
			stm.setInt(4, atividade.getAtv_numero());
			stm.setDate(5, new java.sql.Date(atividade.getDataInicio().getTime()));
			stm.setDate(6,  new java.sql.Date(atividade.getDataFinal().getTime()));
		
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					atividade.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return atividade.getId();
	}
	
	public int excluir(Atividade atividade) {
		String sqlDelete = "DELETE FROM Atividade WHERE id= ?";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, atividade.getId());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return atividade.getId();

	}
	
	public Atividade atualizar(Atividade atividade) {
		String sqlUpdate = "UPDATE Atividade set  tema_id=?, descricao=?, formato_entrega=?, numero=?, dt_inicio=?, dt_fim=? WHERE id=?";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, atividade.getTemaID());
			stm.setString(2, atividade.getAtvDescricao());
			stm.setString(3, atividade.getAtvFormato());
			stm.setInt(4, atividade.getAtv_numero());
			stm.setDate(5, new java.sql.Date(atividade.getDataInicio().getTime()));
			stm.setDate(6,  new java.sql.Date(atividade.getDataFinal().getTime()));
			stm.setInt(7, atividade.getId());
			
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return atividade;

	}
	
	public Atividade carregar(int id) {
		Atividade atividade=new Atividade();
		atividade.setId(id);
		String sqlSelect = "SELECT tema_id,descricao, formato_entrega, numero, dt_inicio, dt_fim, titulo FROM atividade INNER JOIN tema ON Atividade.tema_id=tema.id WHERE atividade.id =?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1,atividade.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					atividade.setTemaID(rs.getInt("tema_id"));
					atividade.setAtvDescricao(rs.getString("descricao"));
					atividade.setAtvFormato(rs.getString("formato_entrega"));
					atividade.setAtv_numero(rs.getInt("numero"));
					atividade.setDataInicio(rs.getDate("dt_inicio"));
					atividade.setDataFinal(rs.getDate("dt_fim"));
					atividade.setTitulo(rs.getString("titulo"));
				} else {
					atividade.setId(-1);
					atividade.setAtvDescricao(null);
					atividade.setAtvFormato(null);
					atividade.setAtv_numero(0);
					atividade.setDataInicio(null);
					atividade.setDataFinal(null);
					atividade.setTitulo(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return atividade;
	}
	
	public ArrayList<Atividade> listarTodos(String chave) {
		Atividade atividade;
		ArrayList<Atividade> lista = new ArrayList<>();
		String sqlSelect = "SELECT atividade.id, tema_id,descricao, formato_entrega, numero, dt_inicio, dt_fim, titulo FROM Atividade INNER JOIN tema ON Atividade.tema_id=tema.id where upper(descricao) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					atividade = new Atividade();
					atividade.setId(rs.getInt("id"));
					atividade.setTemaID(rs.getInt("tema_id"));
					atividade.setAtvDescricao(rs.getString("descricao"));
					atividade.setAtvFormato(rs.getString("formato_entrega"));
					atividade.setAtv_numero(rs.getInt("numero"));
					atividade.setDataInicio(rs.getDate("dt_inicio"));
					atividade.setDataFinal(rs.getDate("dt_fim"));
					atividade.setTitulo(rs.getString("titulo"));
					lista.add(atividade);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<Atividade> listarTodos() {
		Atividade atividade;
		ArrayList<Atividade> lista = new ArrayList<>();
		String sqlSelect = "SELECT  atividade.id,tema_id,descricao, formato_entrega, numero, dt_inicio, dt_fim,titulo FROM Atividade INNER JOIN tema ON Atividade.tema_id = tema.id;";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					atividade = new Atividade();
					atividade.setId(rs.getInt("id"));
					atividade.setTemaID(rs.getInt("tema_id"));
					atividade.setAtvDescricao(rs.getString("descricao"));
					atividade.setAtvFormato(rs.getString("formato_entrega"));
					atividade.setAtv_numero(rs.getInt("numero"));
					atividade.setDataInicio(rs.getDate("dt_inicio"));
					atividade.setDataFinal(rs.getDate("dt_fim"));
					atividade.setTitulo(rs.getString("titulo"));
					lista.add(atividade);
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