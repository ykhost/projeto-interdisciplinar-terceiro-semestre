package model;

public class Professor {
	private String matricula;
	private int perfil;
	private String nome, email;
	private int id;

	public Professor(int id, String matricula, String nome, String email, int perfil) {

		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.perfil = perfil;

	}
	
	public Professor(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Professor(int id) {
		this.id = id;
	}

	public Professor() {

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
