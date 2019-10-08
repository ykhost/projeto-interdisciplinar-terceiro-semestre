package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import model.Tema;


public class TemaDAO {
	
	//Metodo para inserir tema no banco de dados.
	public int inserir (Tema tema){
		String sqlInsert = "INSERT INTO Tema(dt_cadastro, titulo, introducao, requisitos) VALUES (?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setDate(1, new java.sql.Date(tema.getDtCadastro().getTime()));
			stm.setString(2, tema.getTitulo());
			stm.setString(3, tema.getIntroducao());
			stm.setString(4,tema.getRequisitos());
		
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					tema.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tema.getId();
	}
	
	//Metodo para deletar tema atraves do id.
	public void deletar (int id){
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM Turma WHERE id = ?");){
					ps.setInt(1, id);
					ps.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	
	//Metodo para atualizar tema utilizando o id como chave.
	public Tema atualizar(Tema tema) {
		String sqlUpdate = "UPDATE Tema set titulo=?, introducao=?, requisitos=? WHERE id=?";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, tema.getTitulo());
			stm.setString(2, tema.getIntroducao());
			stm.setString(3, tema.getRequisitos());
			stm.setInt(4, tema.getId());

			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tema;

	}
	
	//Metodo para carregar todos os temas
	public Tema carregar(int id) {
		Tema tema= new Tema();
		tema.setId(id);
		String sqlSelect = "SELECT dt_cadastro, titulo, introducao, requisitos FROM tema WHERE tema.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1,tema.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					tema.setDtCadastro(rs.getDate("dt_cadastro"));
					tema.setTitulo(rs.getString("titulo"));
					tema.setIntroducao(rs.getString("introducao"));
					tema.setRequisitos(rs.getString("requisitos"));
				
				} else {
					tema.setId(-1);
					tema.setDtCadastro(null);
					tema.setTitulo(null);
					tema.setIntroducao(null);
					tema.setRequisitos(null);
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return tema;
	}
	
	//Metodo listar todos os metos atraves de uma chave de busca.
	public ArrayList<Tema> listarTodos(String chave) {
		Tema tema= new Tema();
		ArrayList<Tema> lista = new ArrayList <> ();
		String sql = "SELECT id, dt_cadastro, titulo, introducao, requisitos FROM Tema where upper(titulo) like ?";
		//try with resources
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					tema = new Tema();
					tema.setId(rs.getInt("id"));
					tema.setDtCadastro(rs.getDate("dt_cadastro"));
					tema.setTitulo(rs.getString("titulo"));
					tema.setIntroducao(rs.getString("introducao"));
					tema.setRequisitos(rs.getString("requisitos"));
					lista.add(tema);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	//Metodo para listar todos os temas em uma arraylist
	public ArrayList<Tema> listarTodos() {
		Tema tema= new Tema();
		ArrayList<Tema> lista = new ArrayList <> ();
		String sql = "SELECT id, dt_cadastro, titulo, introducao, requisitos FROM Tema ";
		//try with resources
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sql);) {
		
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					tema = new Tema();
					tema.setId(rs.getInt("id"));
					tema.setDtCadastro(rs.getDate("dt_cadastro"));
					tema.setTitulo(rs.getString("titulo"));
					tema.setIntroducao(rs.getString("introducao"));
					tema.setRequisitos(rs.getString("requisitos"));
					lista.add(tema);
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