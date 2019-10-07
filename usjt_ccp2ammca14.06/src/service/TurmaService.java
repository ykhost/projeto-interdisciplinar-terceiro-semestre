package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.TurmaDAO;
import model.Turma;

public class TurmaService {

	private TurmaDAO dao = new TurmaDAO();

	public int inserir(Turma turma) throws SQLException {
		return dao.inserir(turma);
	}
	public int deletar(Turma turma) throws SQLException {
		 return dao.deletar(turma);
	}
	public Turma atualizar(Turma turma) throws SQLException {
		 return dao.atualizar(turma);
	}
	public Turma carregar(int id) throws SQLException{
		return dao.carregar(id);
	}
	public ArrayList<Turma> listarTodos(String chave) {
		return dao.listarTodos(chave);
	}
	public ArrayList<Turma> listarTodos() {
		return dao.listarTodos();
	}
}