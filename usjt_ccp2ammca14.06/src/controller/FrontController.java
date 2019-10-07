package controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PaginaException;
import model.ServletDeflector;
import model.Usuario;

@WebServlet("/controller.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Map<String, int[] > mapaPermisoes = new HashMap<String, int[] >()
	{	
		private static final long serialVersionUID = 1L; 
		{
	        put ("CriarTurma", new int[] {  2 });
	        put ("CriarAtividade", new int[] { 1, 2 });
	        put ("CriarTema", new int[] { 1, 2 });
	        
	        put ("EditarTurma", new int[] { 2 }); 
	        put ("EditarAtividade", new int[] { 1, 2 }); 
	        put ("EditarTema", new int[] { 1, 2 });
	        
	        put ("AlterarTurma", new int[] { 2 }); 
	        put ("AlterarAtividade", new int[] { 1, 2 }); 
	        put ("AlterarTema", new int[] { 1, 2 }); 
		}
	};
	
	
    protected void service(HttpServletRequest request, HttpServletResponse response)
    {   	
    	String pagina = "/WEB-INF/view/error.jsp";
    	try 
    	{
    		HttpSession a = request.getSession();
    		System.out.println("Servlet Chamado");
    		
    		boolean redirecionado = false;
    		
    		String command = request.getParameter("command");
    		if (a.getAttribute("usuario") != null && command != null)
    		{
    			if (command.equals("Login"))
    			{
    				System.out.println("|SERVELT|: Usu�rio sendo redirecionado da pagina de login para index por j� estar logado !");
    				pagina = "index.jsp";
    				
    				redirecionado = true;
    			}
    		}
    		
    		if (!redirecionado)
    		{
    			if (mapaPermisoes.containsKey(command))
    			{
    				int[] permissao = mapaPermisoes.get(command);
    				Usuario user = (Usuario) a.getAttribute("usuario");
    				int nivelAtual = user.getIdentificador();
    				boolean permitido = false;
    				
    				for(int cr : permissao)
    				{
    					if (nivelAtual == cr)
    					{
    						
    						System.out.println("|FILTER-PERMISS�O|: Acesso permitido a a��o: " + command + ", usu�rio tem permiss�o " + nivelAtual);
    						permitido = true;
    						break;
    					}
    				}
    				
    				if (!permitido)
    				{
    					
    					System.out.println("|FILTER-PERMISS�O|: Acesso negado a a��o: " + command + ", usu�rio tem permiss�o " + nivelAtual);
    					
    					throw new PaginaException("STOP!", "Falha de autentifica��o", "Voc� n�o tem permiss�o para acessar este conte�do.");
    				}
    			}
    			
    			Class<?> Action = Class.forName("command."+command);
    			ServletDeflector enviar = (ServletDeflector) Action.newInstance();
    		
    			pagina = enviar.executar(request, response);
    		}
    	}
    	catch (ClassNotFoundException | IllegalAccessException | InstantiationException | PaginaException e) 
    	{
    		request.setAttribute("erro", new PaginaException("ERRO 404 - RIP :(", "P�gina n�o encontrada !", "Desculpe, mas n�o existe esta p�gina no qual est� tentando acessar."));
    	} 
    	
    	try
    	{
    		request.getRequestDispatcher(pagina).forward(request, response);
    	}
    	catch (ServletException | IOException e) 
    	{	// Falha no Dispatcher.
			e.printStackTrace();
		} 
    	
    }
}
