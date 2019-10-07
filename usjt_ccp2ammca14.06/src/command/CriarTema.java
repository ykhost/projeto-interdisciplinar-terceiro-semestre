package command;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ServletDeflector;
import model.Tema;
import service.TemaService;

public class CriarTema implements ServletDeflector {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
	{
		Tema 		tema	=	new	Tema();
		TemaService	ps		=	new	TemaService();
		
		String pTitulo 		=	request.getParameter("titulo");
		String pIntroducao 	=	request.getParameter("introducao");
		String pRequisitos 	=	request.getParameter("requisitos"); 
		String pDtCadastro 	=	request.getParameter("dtCadastro");
		HttpSession	session	=	request.getSession();
		
		Date dateAux = null;
		
		try {
			dateAux = sdf.parse(pDtCadastro);
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		tema.setTitulo(pTitulo);
		tema.setIntroducao(pIntroducao);
		tema.setRequisitos(pRequisitos);
		tema.setDtCadastro(dateAux);
		
		try 
		{
			ps.incluir(tema);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		ArrayList<Tema> lista = new ArrayList<>();
		
		lista.add(tema);
		session.setAttribute("lista", lista);
		return "ConsultarTema.jsp";
	}
}
