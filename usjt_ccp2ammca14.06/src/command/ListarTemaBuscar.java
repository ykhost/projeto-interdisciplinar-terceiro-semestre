package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ServletDeflector;
import model.Tema;
import service.TemaService;

public class ListarTemaBuscar implements ServletDeflector {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		TemaService ps = new TemaService();

		String chave = request.getParameter("data[search]");
		ArrayList<Tema> lista = null;
		HttpSession session = request.getSession();

		if (chave != null && chave.length() > 0) {
			lista = ps.listarTodos(chave);
		} else {
			lista = ps.listarTodos();
		}
		session.setAttribute("lista", lista);

		return "ConsultarTema.jsp";
		
	}

}
