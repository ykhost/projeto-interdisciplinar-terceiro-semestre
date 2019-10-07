

package model;

import java.util.Date;

public class Atividade {
	private int id, temaID;
	private String atvDescricao, atvFormato;
	private int atv_numero;
	private Date dataInicio;
	private Date dataFinal;
	private String titulo;
	
	public Atividade (int id, int temaID, String atvDescricao, String atvFormato, int atv_numero,
			Date dataInicio, Date dataFinal) {
		setId(id);
		setTemaID(temaID);
		setAtvDescricao(atvDescricao);
		setAtvFormato(atvFormato);
		setAtv_numero(atv_numero);
		setDataInicio(dataInicio);
		setDataFinal(dataFinal);
	}
	
	public Atividade () {
		
		
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

	public String getAtvDescricao() {
		return atvDescricao;
	}

	public void setAtvDescricao(String atvDescricao) {
		this.atvDescricao = atvDescricao;
	}

	public String getAtvFormato() {
		return atvFormato;
	}

	public void setAtvFormato(String atvFormato) {
		this.atvFormato = atvFormato;
	}

	public int getAtv_numero() {
		return atv_numero;
	}

	public void setAtv_numero(int atv_numero) {
		this.atv_numero = atv_numero;
	}

	public Date getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public int getTemaID() {
		return temaID;
	}

	public void setTemaID(int temaID) {
		this.temaID = temaID;
	}
}