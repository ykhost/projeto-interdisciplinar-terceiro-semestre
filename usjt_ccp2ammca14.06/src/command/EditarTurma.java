package command;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ServletDeflector;
import model.Tema;
import model.Turma;
import service.TemaService;
import service.TurmaService;

public class EditarTurma implements ServletDeflector {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
	{
		TemaService	ts	=	new	TemaService();
		Turma	turma	=	new	Turma();
		TurmaService ps	=	new	TurmaService();
		
		String pId = request.getParameter("id");

		int id = -1;

		try
		{
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		turma.setId(id);
		
		ArrayList<Tema> lista	=	null;
		HttpSession session		= 	request.getSession();
		
		lista	=	ts.listarTodos();

		try 
		{
			turma	=	ps.carregar(turma.getId());
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		session.setAttribute("lista",lista);
		request.setAttribute("turma",turma);
		
		return ("EditarTurma.jsp");
		
	}
		
	}


