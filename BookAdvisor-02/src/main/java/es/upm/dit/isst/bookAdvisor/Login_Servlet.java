package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login_Servlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher view = request.getRequestDispatcher("login.jsp");

		if(request.getSession().getAttribute("lector")!=null || request.getSession().getAttribute("editorial")!=null){
			view = request.getRequestDispatcher("/libros");
		}
		view.forward(request, response);
	}
}
