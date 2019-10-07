package model;

import java.util.Date;

public class Tema {
	private String titulo, introducao, requisitos;
	private int id;
	private Date dtCadastro; 
   	
	public Tema( Date dtCadastro,String titulo, String introducao, String requisitos) {
		super();
		this.dtCadastro = dtCadastro;
		this.titulo = titulo;
		this.introducao = introducao;
		this.requisitos = requisitos;

	}
	
	public Tema() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getIntroducao() {
		return introducao;
	}
	public void setIntroducao(String introducao) {
		this.introducao = introducao;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tema other = (Tema) obj;
		if (dtCadastro == null) {
			if (other.dtCadastro != null)
				return false;
		} else if (!dtCadastro.equals(other.dtCadastro))
			return false;
		if (id != other.id)
			return false;
		if (introducao == null) {
			if (other.introducao != null)
				return false;
		} else if (!introducao.equals(other.introducao))
			return false;
		if (requisitos == null) {
			if (other.requisitos != null)
				return false;
		} else if (!requisitos.equals(other.requisitos))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	
	
	
}
