package model;

public class PaginaException extends Exception 
{
	private String titulo;
	private String substitulo;
	
	public PaginaException (String mensagem)
	{
		super(mensagem);
	}
	
	public PaginaException (String substitulo, String mensagem)
	{
		super(mensagem);
		setSubtitulo(substitulo);	
	}
	
	public PaginaException (String titulo, String substitulo, String mensagem)
	{
		super(mensagem);
		setTitulo(titulo);
		setSubtitulo(substitulo);	
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setSubtitulo(String subtitulo) {
		this.substitulo = subtitulo;
	}
	
	public String getSubtitulo() {
		return this.substitulo;
	}
}
