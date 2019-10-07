package model;

public class Turma{
	private int id;
	private String sigla;
	private int ano_letivo;
	private int semestre_letivo;
	private int tema_id;
	private String titulo;
	
	

	public Turma(int id, String sigla, int ano_letivo, int semestre_letivo, int tema_id, String titulo) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.ano_letivo = ano_letivo;
		this.semestre_letivo = semestre_letivo;
		this.tema_id = tema_id;
	}
	
	public Turma(){
		
		
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getAno_letivo() {
		return ano_letivo;
	}

	public void setAno_letivo(int ano_letivo) {
		this.ano_letivo = ano_letivo;
	}

	public int getSemestre_letivo() {
		return semestre_letivo;
	}

	public void setSemestre_letivo(int semestre_letivo) {
		this.semestre_letivo = semestre_letivo;
	}

	public int getTema_id() {
		return tema_id;
	}

	public void setTema_id(int tema_id) {
		this.tema_id = tema_id;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (ano_letivo != other.ano_letivo)
			return false;
		if (id != other.id)
			return false;
		if (semestre_letivo != other.semestre_letivo)
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		if (tema_id != other.tema_id)
			return false;
		return true;
	}
	
}
	
	
	
	
	