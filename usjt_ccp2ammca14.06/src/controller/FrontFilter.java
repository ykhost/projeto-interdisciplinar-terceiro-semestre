package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import model.Usuario;


@WebFilter("*.jsp")
public class FrontFilter implements Filter {

	private static final Map<String, int[] > mapaPermisoes = new HashMap<String, int[] >()
	{	// NÃO MEXA NA LÓGICA.
		private static final long serialVersionUID = 1L;

		{			
	       
	        put ("cadastroTema.jsp", new int[] {1,2});
	        put ("cadastroTurma.jsp", new int[] {2});
	        put ("cadastroAtividade.jsp", new int[] {1,2});
	        
	        put ("ConsultarTurma.jsp", new int[] { 2 });
	        put ("ConsultarTema.jsp", new int[] {1,2});
	        put ("ConsultarAtividade.jsp", new int[] {1,2});
	        
	        put ("EditarAtividade.jsp", new int[] {1,2});
	        put ("EditarTurma.jsp", new int[] {2});
	        put ("EditarTema.jsp", new int[] {1,2});
	        
	        put("VisualizarAtiviade.jsp", new int[] {1,2});
	        put("VisualizarTurma.jsp", new int[] {2});
	        put("VisualizarTema.jsp", new int[] {1,2});
	        
	        put("HomeAdm.jsp", new int[] {2});
	        put("HomeAluno.jsp", new int[] {0});
	        put("HomeProfessor", new int[] {1});
	        
	        put ("MenuAdministrador.jsp", new int[] { 2 });
	        put ("MenuProfessor.jsp", new int[] { 1 });
	        put ("MenuAluno.jsp", new int[] { 0 });
	       
	    }
	};
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		int index = request.getRequestURI().lastIndexOf("/") + 1;
		String pagina = request.getRequestURI().substring(index);
		
		System.out.println("|FILTER|: Página " + pagina + " chamada.");
		
		HttpSession a = request.getSession();
		if (a.getAttribute("usuario") == null)
		{
			if (!pagina.equals("login.jsp"))
			{	
				System.out.println("|FILTER|: Usuário redirecionado para login, sem permissão.");
				response.sendRedirect("loginErro.jsp");
				
				return;
			}
		}
		else if (pagina.equals("login.jsp")||pagina.equals("loginErro.jsp"))
		{
			System.out.println("|FILTER|: Usuario já está logado para acessar a pagina de login.");
			response.sendRedirect("index.jsp");
		}
		else
		{
			if (mapaPermisoes.containsKey(pagina))
			{
				int[] permissao = mapaPermisoes.get(pagina);
				Usuario user = (Usuario) a.getAttribute("usuario");
				int nivelAtual = user.getIdentificador();
				boolean permitido = false;
				
				for(int cr : permissao)
				{
					if (nivelAtual == cr)
					{
						// ACESSO PERMITIDO -- USUÁRIO TEM PERMISSÃO !
						
						System.out.println("|FILTER-PERMISSÃO|: Acesso permitido a página: " + pagina + ", usuário tem permissão " + nivelAtual);
						permitido = true;
						break;
					}
				}
				
				if (!permitido)
				{
					// ACESSO NEGADO -- USUÁRIO SEM PERMISSÃO !
					
					
					System.out.println("|FILTER-PERMISSÃO|: Acesso negado a página: " + pagina + ", usuário tem permissão " + nivelAtual);
					
					request.setAttribute("erro", new PaginaException("STOP!", "Falha de autentificação", "Você não tem permissão para acessar este conteúdo."));
					request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
					
					return;
				}
			}
		}
		
		chain.doFilter(request, response);	
	}
}
