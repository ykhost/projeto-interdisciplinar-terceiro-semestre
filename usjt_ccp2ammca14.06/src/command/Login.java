package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ServletDeflector;
import model.Usuario;
import service.UsuarioService;

public class Login implements ServletDeflector{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		UsuarioService sv = new UsuarioService();
		
		String email = request.getParameter("email");
		String senha = request.getParameter("password");
		String user = "usuario";
		final String paginaPadrao = "loginErro.jsp";
		Usuario usuario = sv.logar(email, senha);
		System.out.println("Email : " + email + "\nSenha: " + senha);
		
		if (email == null || senha == null || email.equals("") || senha.equals("")) 
		{
			return paginaPadrao;
		}
		else
		{
			if(usuario != null)
			{
				if(usuario.getIdentificador() == 2) 
				{
					HttpSession a = request.getSession();
					a.setAttribute(user, usuario);
					return "HomeAdm.jsp";
				}
				if(usuario.getIdentificador() == 1)
				{
					HttpSession a = request.getSession();
					a.setAttribute(user, usuario);
					return "HomeProfessor.jsp";
				}
				if(usuario.getIdentificador() == 0)
				{
					HttpSession a = request.getSession();
					a.setAttribute(user, usuario);
					return "HomeAluno.jsp";
				}
			}
			return paginaPadrao;
		}
	}
}
