package command;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ServletDeflector;

public class CargaTema implements ServletDeflector{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
	{	
		String data;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		Date date = new Date(System.currentTimeMillis()); 
		data= dateFormat.format(date); 
		HttpSession	session 	= 	request.getSession();
		
		session.setAttribute("data", data);
		
		return "cadastroTema.jsp";
	}
}
