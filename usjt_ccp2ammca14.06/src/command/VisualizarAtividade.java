package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Atividade;
import model.ServletDeflector;
import service.AtividadeService;

public class VisualizarAtividade implements ServletDeflector {
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
	{	
		AtividadeService ps = new AtividadeService();
		Atividade atividade= new Atividade();
		
		String	pId	=	request.getParameter("id");
		int		id	=	-1;

		try 
		{
			id = Integer.parseInt(pId);
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		
		atividade.setId(id);
		
		try 
		{
			atividade= ps.carregar(atividade.getId());
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
				
		request.setAttribute("atividade", atividade);

		return "VisualizarAtividade.jsp";
	}

}


