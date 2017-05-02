package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout_Servlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
			request.getSession().invalidate();
			response.sendRedirect("/index.jsp");
		
	}
}
