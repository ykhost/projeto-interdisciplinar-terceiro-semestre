package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ServletDeflector;
import model.Tema;
import service.TemaService;

public class CargaTurma implements ServletDeflector{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
	{
		TemaService		ts		=	new TemaService();
		ArrayList<Tema>	lista	=	null;
		HttpSession session		= 	request.getSession();
		
		lista = ts.listarTodos();
		session.setAttribute("lista",lista);
		
		return "cadastroTurma.jsp";
		
	}

}
