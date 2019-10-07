package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ServletDeflector;
import model.Turma;
import service.TurmaService;

public class ListarTurmaBuscar implements ServletDeflector {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
	{
		TurmaService ps = new TurmaService();
		
		String chave = request.getParameter("data[search]");	
		ArrayList<Turma> lista = null;
		HttpSession session = request.getSession();
		
		if (chave != null && chave.length() > 0) 
		{
			lista = ps.listarTodos(chave);
		}else 
		{
			lista = ps.listarTodos();
		}
		session.setAttribute("lista", lista);

		return "ConsultarTurma.jsp";

	}
		
}


