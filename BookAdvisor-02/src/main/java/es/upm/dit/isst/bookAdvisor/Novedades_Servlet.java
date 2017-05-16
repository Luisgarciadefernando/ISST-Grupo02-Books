package es.upm.dit.isst.bookAdvisor;

import java.util.Collections;
import java.util.Comparator;
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
import es.upm.dit.isst.bookAdvisor.dao.NovedadDAO;
import es.upm.dit.isst.bookAdvisor.dao.NovedadDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Lector;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.Novedad;

public class Novedades_Servlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Novedad.class);	
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {
		NovedadDAO dao = NovedadDAOImpl.getInstancia();
		
		List<Novedad> novedades = dao.read();
		
		Collections.sort(novedades, new Comparator<Novedad>() {
	        @Override
	        public int compare(Novedad n1, Novedad n2) {
	            // TODO Auto-generated method stub
	            return n1.getAsignacionesEditoriales().getFecha().compareTo(n2.getAsignacionesEditoriales().getFecha());
	        }
	    });
		Collections.reverse(novedades);
		
		request.getSession().setAttribute("novedades", novedades);
		
		RequestDispatcher view = request.getRequestDispatcher("novedades.jsp");
		view.forward(request, response);
		
	}
	
}
