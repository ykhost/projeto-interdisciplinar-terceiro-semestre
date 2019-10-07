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



public class CriarTurma implements ServletDeflector {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
	{
		Turma turma = new Turma();
		TurmaService ps = new TurmaService();
		Tema tema = new Tema();
		TemaService ts = new TemaService();
		
		String	pSigla			=	request.getParameter("sigla");
		String	pAnoLetivo		=	request.getParameter("ano_letivo");
		String	pSemestreLetivo	=	request.getParameter("semestre_letivo");
		String	pTemaId			=	request.getParameter("tema_id");

		int ano_letivo 		=	-1;
		int semestre_letivo =	-1;
		int tema_id			=	-1;
		String semestre;

		try {
			ano_letivo		=	Integer.parseInt(pAnoLetivo);
			semestre_letivo	=	Integer.parseInt(pSemestreLetivo);
			tema_id			= 	Integer.parseInt(pTemaId);
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		}
		turma.setSigla(pSigla);
		turma.setAno_letivo(ano_letivo);
		turma.setSemestre_letivo(semestre_letivo);
		turma.setTema_id(tema_id);
		
		HttpSession session	=	request.getSession();

		try
		{
			ps.inserir(turma);
		}catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		try {
			tema = ts.carregar(tema_id);
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		turma.setTitulo(tema.getTitulo());
		
		if(turma.getSemestre_letivo()==1)
		{
			semestre = "Primeiro Semestre";
		}else
		{
			semestre = "Segundo Semestre";
		}
		request.setAttribute("semestre", semestre);
		ArrayList<Turma>	lista	=	new	ArrayList<>();
		lista.add(turma);
		session.setAttribute("lista", lista);
		
		return "ConsultarTurma.jsp";
		
	}		
}


