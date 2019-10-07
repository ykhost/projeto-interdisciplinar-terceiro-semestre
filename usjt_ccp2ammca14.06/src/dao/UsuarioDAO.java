package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {

	public int inserir(Usuario user) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "INSERT INTO usuario(nome, email, senha) VALUES (?, ?, ?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getSenha());
			ps.execute();
			String sqlQuery="Select last_insert_id() from Usuario";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();){
				if (rs.next()) {
						user.setId(rs.getInt(1));
					
					}
				stm2.execute();
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user.getId();
	}
	
	public void atualizar(Usuario user) {
		String sqlUpdate = "UPDATE usuario SET nome=?, email=?, senha=? WHERE id=?";
		
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, user.getNome());
			stm.setString(2, user.getEmail());
			stm.setString(3, user.getSenha());
			stm.setInt(4, user.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int codigoInt) {
		String sqlUpdate = "DELETE FROM usuario WHERE usuario_id = ?";
		
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, codigoInt);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Usuario carregar(int id) {
		Usuario user = new Usuario();
		user.setId(id);
		String sqlSelect = "SELECT nome, email, senha FROM usuario WHERE usuario_id = ?";
		
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, user.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					user.setNome(rs.getString("nome"));
					user.setSenha(rs.getString("senha"));
					user.setEmail(rs.getString("email"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return user;
	}
	public int carregarIdentificadorProfessor() {
		Usuario usuario = new Usuario();
		String sqlSelect = "select us.identificador, us.id, pf.professor_id from Usuario us\r\n" + 
				" inner join Professor pf \r\n" + 
				" on us.id = pf.professor_id";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setIdentificador(rs.getInt("identificador"));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return usuario.getIdentificador();
	}
	
	public int carregarIdentificadorAluno() {
		Usuario usuario = new Usuario();
		String sqlSelect = "select us.identificador, us.id, a.aluno_id from Usuario us\r\n" + 
				" inner join Aluno a\r\n" + 
				" on us.id = a.aluno_id";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setIdentificador(rs.getInt("identificador"));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return usuario.getIdentificador();
	}
	public boolean LoginAluno(String email, String senha) {
		String sql="select email, senha from usuario " + 
				"inner join aluno " + 
				"on aluno.aluno_id=usuario.id " + 
				"where email= ? and senha = ?";
		
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm=conn.prepareStatement(sql)){
				stm.setString(1, email);
				stm.setString(2, senha);
				
				try(ResultSet rs = stm.executeQuery()){
					if(rs.next()) {
						return true;
					}else {
						return false;
					}					
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public Usuario logar(String email, String password) {
		Usuario usuario = new Usuario();
		String sql = "Select * from Usuario Where email = ? and senha = ?";
		
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, email);
			stm.setString(2, password);
			
			try(ResultSet rs = stm.executeQuery()) {
				if(rs.next()) {
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setIdentificador(rs.getInt("identificador"));
					usuario.setEmail(rs.getString("email"));
					usuario.setSenha(rs.getString("senha"));
					
					return usuario;
				}
				else {
					return null;
				}
				
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}	
		
	}
	
	public boolean LoginProfessor(String email, String senha) {
		String sql="select email, senha from usuario " + 
				"inner join professor " + 
				"on professor.professor_id=usuario.id " + 
				"where email= ? and senha = ?";
				boolean check = false;
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm=conn.prepareStatement(sql)){
				stm.setString(1, email);
				stm.setString(2, senha);
				
				try(ResultSet rs = stm.executeQuery()){
					if(rs.next()) {
						check = true;
					}					
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
		
	}


}
