package command;
//Classe que executa a alteração da atividade selecionada.
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

public class AlterarAtividade implements ServletDeflector {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	@Override
	
	public String executar(HttpServletRequest request, HttpServletResponse response){
		//Pegando as requisições do usuario
		String pId = request.getParameter("id");
		String pTemaId = request.getParameter("tema_id");
		String pAtvDescricao = request.getParameter("atvDescricao");
		String pAtvFormato = request.getParameter("atvFormato");
		String pAtv_numero = request.getParameter("atv_numero");
		String pDataInicio = request.getParameter("dataInicio");
		String pDataFinal = request.getParameter("dataFinal");
		int id = -1;
		int temaID=-1;
		int atv_numero=-1;
		Date dateAux = null;
		Date dateCon = null;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}
		try {
			temaID = Integer.parseInt(pTemaId);
			atv_numero=Integer.parseInt(pAtv_numero);
		} catch (NumberFormatException e1) {

		}
		
		try {
			dateAux = sdf.parse(pDataInicio);
			dateCon = sdf.parse(pDataFinal);
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		//Inserindo os dados no model
		Atividade atividade= new Atividade();
		Tema      tema     =new Tema();
		atividade.setId(id);
		atividade.setTemaID(temaID);
		atividade.setAtvDescricao(pAtvDescricao);
		atividade.setAtvFormato(pAtvFormato);
		atividade.setAtv_numero(atv_numero);
		atividade.setDataInicio(dateAux);
		atividade.setDataFinal(dateCon);
		//Instanciar as classe atividades service e tema service
		AtividadeService ps = new AtividadeService();
		TemaService      ts = new TemaService();
		try
		{
			tema = ts.carregar(temaID);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		atividade.setTitulo(tema.getTitulo());
		try {
			ps.atualizar(atividade);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		@SuppressWarnings("unchecked")
		//ArrayList para armazenar as atividades em uma lista para ser reutilizado na proxima interface.
		ArrayList<Atividade> lista = (ArrayList<Atividade>) session
				.getAttribute("lista");
		lista.add(atividade);
		session.setAttribute("lista", lista);
		request.setAttribute("atividade", atividade);

		return "VisualizarAtividade.jsp";
	}
}


