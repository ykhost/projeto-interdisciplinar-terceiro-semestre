package command;

import java.sql.SQLException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ServletDeflector;
import model.Tema;
import service.TemaService;

public class EditarTema implements ServletDeflector {

	@Override
	public	String	executar(HttpServletRequest request, HttpServletResponse response)
	{
		String pId	=	request.getParameter("id");
		int id		=	-1;
		try {
			id	=	Integer.parseInt(pId);
		} catch(NumberFormatException e) 
		{
			e.printStackTrace();
		}
		Tema tema=new Tema();
		tema.setId(id);
		
		TemaService ts = new TemaService();

		try 
		{
			tema	=	ts.carregar(id);
		}catch(SQLException e) 
		{
			e.printStackTrace();
		}
		request.setAttribute("tema",tema);	
		
		return "EditarTema.jsp";
	}

}
