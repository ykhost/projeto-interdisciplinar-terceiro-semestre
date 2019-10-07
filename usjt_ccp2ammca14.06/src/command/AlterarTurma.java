package command;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ServletDeflector;
import model.Tema;
import model.Turma;
import service.TemaService;
import service.TurmaService;

public	class	AlterarTurma	implements	ServletDeflector{

	@Override
	public	String	executar(HttpServletRequest request, HttpServletResponse response)
	{
		Turma 			turma	=	new	Turma();
		TurmaService 	ps		= 	new TurmaService();
		Tema 			tema	= 	new Tema();
		TemaService 	ts		=	new TemaService();
		
		String	pId				=	request.getParameter("id");
		String	pSigla			=	request.getParameter("sigla");
		String	pAnoLetivo		=	request.getParameter("ano_letivo");
		String	pSemestreLetivo	=	request.getParameter("semestre_letivo");
		String	pTemaId			=	request.getParameter("tema_id");
		
		int id 				= 	-1;
		int ano_letivo		= 	-1;
		int semestre_letivo = 	-1;
		int tema_id			=	-1;
		String semestre;
		
		try
		{
			id = Integer.parseInt(pId);
		}
		catch(NumberFormatException e) 
		{
			e.printStackTrace();
		}
		try
		{
			ano_letivo = Integer.parseInt(pAnoLetivo);
			semestre_letivo = Integer.parseInt(pSemestreLetivo);
			tema_id = Integer.parseInt(pTemaId);
		}
		catch (NumberFormatException e1)
		{
			e1.printStackTrace();
		}

		turma.setId(id);
		turma.setSigla(pSigla);
		turma.setAno_letivo(ano_letivo);
		turma.setSemestre_letivo(semestre_letivo);
		turma.setTema_id(tema_id);
		try
		{
			tema = ts.carregar(tema_id);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		turma.setTitulo(tema.getTitulo());
		try
		{
			ps.atualizar(turma);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		if(turma.getSemestre_letivo()==1)
		{
			semestre = "Primeiro Semestre";
		}else
		{
			semestre = "Segundo Semestre";
		}
		@SuppressWarnings("unchecked")
		ArrayList<Turma> lista = (ArrayList<Turma>) session
				.getAttribute("lista");
		
		lista.add(turma);
		session.setAttribute("lista", lista);
		request.setAttribute("semestre", semestre);
		request.setAttribute("turma", turma);

		return "VisualizarTurma.jsp";
	}
}


