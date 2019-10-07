package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.TemaDAO;
import model.Tema;


public class TemaService {
	private TemaDAO dao = new TemaDAO();
	
	public int incluir (Tema tema) throws SQLException{
		return dao.inserir(tema);
	}
	public void excluir (int id) throws SQLException{
		dao.deletar(id);
	}
	public Tema atualizar (Tema tema) throws SQLException{
		return 	dao.atualizar(tema);
		 
	}
	public Tema carregar (int id) throws SQLException{
		return dao.carregar(id);
	}
	public ArrayList<Tema> listarTodos(String chave) {
		return dao.listarTodos(chave);
	}
	public ArrayList<Tema> listarTodos() {
		return dao.listarTodos();
    }
}
