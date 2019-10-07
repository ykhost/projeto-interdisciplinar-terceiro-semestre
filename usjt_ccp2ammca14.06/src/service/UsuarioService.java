package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

	UsuarioDAO dao = new UsuarioDAO();
	
	public void inserir(Usuario user) {
		dao.inserir(user);
	}
	
	public void atualizar(Usuario user){
		dao.atualizar(user);
	}
	
	public void excluir(int codigoInt){
		dao.excluir(codigoInt);
	}
	
	public Usuario carregar(int id){
		return dao.carregar(id);
	}
	public int carregarIdentificadorProfessor() {
		return dao.carregarIdentificadorProfessor();
	}
	public int carregarIdentificadorAluno() {
		return dao.carregarIdentificadorAluno();
	}
	
	public boolean loginAluno(String email, String senha) {
		return dao.LoginAluno(email, senha);
	}
	
	public boolean loginProfessor(String email, String senha) {
		return dao.LoginProfessor(email, senha);
	}

	public Usuario logar(String email, String password) {
		return dao.logar(email, password);
		
		
	}
}
