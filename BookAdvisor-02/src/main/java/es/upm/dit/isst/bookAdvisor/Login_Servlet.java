package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.LectorDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Biblioteca;
import es.upm.dit.isst.bookAdvisor.model.Editorial;
import es.upm.dit.isst.bookAdvisor.model.Lector;
import es.upm.dit.isst.bookAdvisor.model.Libreria;

public class Login_Servlet extends HttpServlet{
	public void init() throws ServletException {
		ObjectifyService.register(Lector.class);
		ObjectifyService.register(Editorial.class);
		ObjectifyService.register(Biblioteca.class);
		ObjectifyService.register(Libreria.class);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		

		if(request.getSession().getAttribute("lector")!=null || request.getSession().getAttribute("editorial")!=null){
			response.sendRedirect("/libros");
		}
		else if(request.getUserPrincipal()!=null){
			Lector lector = new Lector(request.getUserPrincipal().getName(), request.getUserPrincipal().getName(), null);
			lector.setId(request.getUserPrincipal().getName());
			request.getSession().setAttribute("lector", lector);
			
			
			response.sendRedirect("/libros");
		}
		else {
			RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
			view.forward(request, response);
		}
		
	}
}
