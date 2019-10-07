package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServletDeflector
{
	public abstract String executar(HttpServletRequest request,HttpServletResponse response);
}
