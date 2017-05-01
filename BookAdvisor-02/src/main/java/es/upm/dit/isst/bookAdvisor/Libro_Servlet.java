package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.LibroDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.ValoracionDAO;
import es.upm.dit.isst.bookAdvisor.dao.ValoracionDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Lector;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.Valoracion;

public class Libro_Servlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Libro.class);
		ObjectifyService.register(Valoracion.class);

	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		LibroDAO dao = LibroDAOImpl.getInstancia();
		String id = request.getParameter("id");
		Libro libro = dao.readID(id);
		ValoracionDAO valoracionDao = ValoracionDAOImpl.getInstancia();
		Lector lector = (Lector) request.getSession().getAttribute("lector");
		List<Valoracion> v = valoracionDao.read();
		List<Valoracion> valoraciones = valoracionDao.readLibro(id);
		Valoracion v3 = null;
		request.getSession().removeAttribute("valoracion");;

		
		for(Valoracion vi: v){
			if(lector!=null && vi.getLector().equals(lector.getId()) && vi.getLibro().equals(id)){
				v3 = vi;
			}

		}
		if(v3!=null){
			request.getSession().setAttribute("valoracion", v3);

		}
		request.getSession().setAttribute("valoraciones", valoraciones);

		request.getSession().setAttribute("libro", libro);
		RequestDispatcher view = request.getRequestDispatcher("libro.jsp");
		view.forward(request, response);
	}
	
}
