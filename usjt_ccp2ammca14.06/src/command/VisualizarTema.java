package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ServletDeflector;
import model.Tema;
import service.TemaService;

public class VisualizarTema implements ServletDeflector {
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
	{

		String pId = request.getParameter("id");

		int id = -1;
		try 
		{
			id	=	Integer.parseInt(pId);
		}catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		Tema tema=new Tema();
		TemaService ps = new TemaService();
		
		tema.setId(id);
		try 
		{
			tema= ps.carregar(tema.getId());
		}catch(SQLException e) 
		{
			e.printStackTrace();
		}
				
		request.setAttribute("tema", tema);		
		return "VisualizarTema.jsp";
	}
		
	

}
