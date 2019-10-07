package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Atividade;
import model.ServletDeflector;
import service.AtividadeService;

public class ListarAtividadeBuscar implements ServletDeflector {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		AtividadeService ps = new AtividadeService();

		String chave = request.getParameter("data[search]");
		ArrayList<Atividade> lista = null;
		HttpSession session = request.getSession();

		if (chave != null && chave.length() > 0) {
			lista = ps.listarTodos(chave);
		} else {
			lista = ps.listarTodos();
		}
		session.setAttribute("lista", lista);

		return "ConsultarAtividade.jsp";

	}

}
