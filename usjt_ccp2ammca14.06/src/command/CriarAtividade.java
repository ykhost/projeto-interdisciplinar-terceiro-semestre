package command;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Atividade;
import model.ServletDeflector;
import model.Tema;
import service.AtividadeService;
import service.TemaService;

public class CriarAtividade implements ServletDeflector {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
	{
		Atividade 			atividade	=	new	Atividade();
		AtividadeService 	ps 			=	new	AtividadeService();
        Tema                tema        =   new Tema();
        TemaService         ts          =   new TemaService();
		String	pTemaId			=	request.getParameter("tema_id");
		String	pAtvDescricao	=	request.getParameter("atvDescricao");
		String	pAtvFormato		=	request.getParameter("atvFormato");
		String	pAtv_numero		=	request.getParameter("atv_numero");
		String	pDataInicio		=	request.getParameter("dataInicio");
		String	pDataFinal		=	request.getParameter("dataFinal");

		
		int		temaID		=	-1;
		int		atv_numero	=	-1;
		Date	dateAux 	=	null;
		Date	dateCon 	=	null;

		try
		{
			temaID		=	Integer.parseInt(pTemaId);
			atv_numero	=	Integer.parseInt(pAtv_numero);
		} 
		catch(NumberFormatException	e1)
		{

		}
		try
		{
			dateAux = sdf.parse(pDataInicio);
			dateCon = sdf.parse(pDataFinal);
		}
		catch(ParseException e1)
		{	
			e1.printStackTrace();
		}
		
		

		atividade.setTemaID(temaID);
		atividade.setAtvDescricao(pAtvDescricao);
		atividade.setAtvFormato(pAtvFormato);
		atividade.setAtv_numero(atv_numero);
		atividade.setDataInicio(dateAux);
		atividade.setDataFinal(dateCon);
		
		HttpSession session = request.getSession();

		try 
		{
			ps.inserir(atividade);
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		try {
			tema = ts.carregar(temaID);
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		atividade.setTitulo(tema.getTitulo());
		ArrayList<Atividade>	lista	=	new	ArrayList<>();
		lista.add(atividade);
		session.setAttribute("lista", lista);
		
		return "ConsultarAtividade.jsp";
	}

}


