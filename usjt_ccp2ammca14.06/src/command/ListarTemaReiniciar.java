package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ServletDeflector;

public class ListarTemaReiniciar implements ServletDeflector {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		session.setAttribute("lista", null);

		return "ConsultarTema.jsp";
	}
		
	}


