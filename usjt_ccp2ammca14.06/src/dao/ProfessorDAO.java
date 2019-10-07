package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Professor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProfessorDAO {
	public List<Professor> carregarTodosProf() {
		
		List<Professor> listaProfessores = new ArrayList<>();
		String sqlSelect = "select pf.professor_id, us.nome from Professor pf inner join Usuario us on pf.professor_id = us.id";
		
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) 
				{
					int id = rs.getInt("professor_id");
					String nome = rs.getString("nome");

					Professor prof = new Professor(id, nome);
					

					listaProfessores.add(prof);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return listaProfessores;
	}
}
