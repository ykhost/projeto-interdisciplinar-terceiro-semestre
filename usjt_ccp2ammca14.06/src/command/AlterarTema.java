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

public class AlterarTema implements ServletDeflector{
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
	{
		Tema		tema	=	new	Tema();
		TemaService	ps		=	new	TemaService();
		
		String	pId			=	request.getParameter("id");
		String	pTitulo		=	request.getParameter("titulo");
		String	pIntroducao	=	request.getParameter("introducao");
		String	pRequisitos	=	request.getParameter("requisitos"); 
		String	pDtCadastro	=	request.getParameter("dtCadastro");
		
		int id = -1;
		Date dateAux = null;
		
		try 
		{
			id = Integer.parseInt(pId);
		}catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		try 
		{
			dateAux = sdf.parse(pDtCadastro);
		} catch (ParseException e1) 
		{	
			e1.printStackTrace();
		}
		
		tema.setId(id);
		tema.setTitulo(pTitulo);
		tema.setIntroducao(pIntroducao);
		tema.setRequisitos(pRequisitos);
		tema.setDtCadastro(dateAux);
		
		HttpSession session = request.getSession();
		try
		{
			ps.atualizar(tema);
		}
		catch(SQLException e)
		{
			e.printStackTrace(); //Noncompliant
		}
	
		@SuppressWarnings("unchecked")
		
		
		
		ArrayList<Tema> lista = (ArrayList<Tema>) session
				.getAttribute("lista");
		int pos = busca(tema, lista);
		lista.remove(pos);
		lista.add(pos, tema);
		
		session.setAttribute("lista", lista);
		request.setAttribute("tema", tema);
		
		return "VisualizarTema.jsp";
	}
	
	public int busca(Tema t, ArrayList<Tema> lista)
	{
		Tema to;
		for(int i = 0; i < lista.size(); i++)
		{
			to = lista.get(i);
			if(to.getId() == t.getId())
			{
				return i;
			}
		}
		return -1;	
	}
}
