package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ServletDeflector;
import model.Turma;
import service.TurmaService;

public class VisualizarTurma implements ServletDeflector 
{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
	{
		String pId = request.getParameter("id");
		int id = -1;
		String semestre;
		try 
		{
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) 
		{
			e.printStackTrace();
		}
		Turma turma = new Turma();
		turma.setId(id);
		TurmaService ps = new TurmaService();
		try 
		{
			turma= ps.carregar(turma.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(turma.getSemestre_letivo()==1)
		{
			semestre = "Primeiro Semestre";
		}else
		{
			semestre = "Segundo Semestre";
		}
		request.setAttribute("semestre", semestre);
		request.setAttribute("turma", turma);	
		return "VisualizarTurma.jsp";
	}

}
