package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PaginaException;

/**
 * Servlet Filter implementation class FrontServletFilter
 */
@WebFilter("/controller.do")
public class FrontServletFilter implements Filter {
  
	// Lista de permissão de acesso não estando logado.
	private final String loginListaActions[] = { "Login" };
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		Boolean permitido = false;
		String command = request.getParameter("command");
		
		HttpSession sessao = request.getSession();
		if (sessao.getAttribute("usuario") == null)
		{
			if (command != null)
			{
				for (String listaPermicao : loginListaActions)
				{
					if (listaPermicao.equals(command))
					{
						permitido = true;
						break;
					}
				}
			}
		}
		else
		{	//Usuário logado
			permitido = true;
		}
		
		if (!permitido)
		{
			System.out.println("|FILTER-SERVLET|: Tentativa de chamada não autorizada no Servelt ("+ request.getServletPath() +"?command="+ command +") negada !");
			
			request.setAttribute("erro", new PaginaException("STOP!", "Falha de autentificação", "Você não tem permissão para acessar este conteúdo."));
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}
}
