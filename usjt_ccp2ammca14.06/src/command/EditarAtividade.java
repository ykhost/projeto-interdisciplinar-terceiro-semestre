package command;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Atividade;
import model.ServletDeflector;
import model.Tema;
import service.AtividadeService;
import service.TemaService;

public class EditarAtividade implements ServletDeflector {
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
	{
		Atividade atividade= new Atividade();
		TemaService ts = new TemaService();
		
		String pId = request.getParameter("id");
		int id = -1;
		
		try	
		{
			id = Integer.parseInt(pId);
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		atividade.setId(id);
			
		ArrayList<Tema> lista	=	null;
		HttpSession session		=	request.getSession();
		AtividadeService ps		=	new AtividadeService();

		lista = ts.listarTodos();
		try 
		{
			atividade	=	ps.carregar(atividade.getId());
		}catch(SQLException e) 
		{
			e.printStackTrace();
		}
		session.setAttribute("lista", lista);
		request.setAttribute("atividade", atividade);
		
		return "EditarAtividade.jsp";
	}

}
