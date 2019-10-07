package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.AtividadeDAO;
import model.Atividade;


public class AtividadeService {
	private AtividadeDAO dao = new AtividadeDAO();
	
	public int inserir (Atividade atividade) throws SQLException{
		return dao.inserir(atividade);
	}
	public int excluir (Atividade atividade) throws SQLException{
		 return dao.excluir(atividade);
	}
	public Atividade atualizar (Atividade atividade) throws SQLException{
		 return dao.atualizar(atividade);
		
	}
	public Atividade carregar (int id) throws SQLException{
		return dao.carregar(id);
	}
	public ArrayList<Atividade> listarTodos(String chave) {
		return dao.listarTodos(chave);
	}
	public ArrayList<Atividade> listarTodos(){
		return dao.listarTodos();
	}
}