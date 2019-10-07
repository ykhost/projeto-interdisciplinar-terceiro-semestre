package service;
import java.util.List;

import dao.ProfessorDAO;
import model.Professor;
public class ProfessorService {
	ProfessorDAO dao;
	
	public ProfessorService() {
		dao = new ProfessorDAO();
	}
	
	public List<Professor> listarProfessores() {
		return dao.carregarTodosProf();
	}
	
	
}
