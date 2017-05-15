package es.upm.dit.isst.bookAdvisor;

import java.util.List;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.LectorDAO;
import es.upm.dit.isst.bookAdvisor.dao.LectorDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LibreriaDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibreriaDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Lector;
import es.upm.dit.isst.bookAdvisor.model.Libreria;

public class Librerias_Servlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Libreria.class);	
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {
		LibreriaDAO dao = LibreriaDAOImpl.getInstancia();
		
//		Libreria libreria1 = dao.create("Libreria Le", "c/ Paseo de la Casetellana", "http://www.libreriale.es", "email1", "Esta es una libreria de noseque y de nosecuantos", "1", "libreria1.png");
//		Libreria libreria2 = dao.create("Nosecuantitos", "c/ Paseo de la Habana", "http://www.google.es", "email2", "Esta es otra libreria de noseque y de nosecuantos", "1", "libreria2.jpeg");
//		Libreria libreria3 = dao.create("Libreria3", "c/ de la Piruleta", "http://www.marca.com", "email3", "Esta es una mas libreria de noseque y de nosecuantos", "1", "libreria3.jpeg");
//		dao.deleteAll();
		List<Libreria> librerias = dao.read();

		request.getSession().setAttribute("libro", null);
		request.getSession().setAttribute("asignacionesLibrerias", null);
		request.getSession().setAttribute("librerias", librerias);
		
		RequestDispatcher view = request.getRequestDispatcher("librerias.jsp");
		view.forward(request, response);
		
	}
	
}
