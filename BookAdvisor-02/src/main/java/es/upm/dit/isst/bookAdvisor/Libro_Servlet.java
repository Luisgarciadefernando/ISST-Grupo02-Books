package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.AsignacionesLibreriasDAO;
import es.upm.dit.isst.bookAdvisor.dao.AsignacionesLibreriasDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.IntercambioTienenDAO;
import es.upm.dit.isst.bookAdvisor.dao.IntercambioTienenDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.ValoracionDAO;
import es.upm.dit.isst.bookAdvisor.dao.ValoracionDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.AsignacionesLibrerias;
import es.upm.dit.isst.bookAdvisor.model.IntercambioTienen;
import es.upm.dit.isst.bookAdvisor.model.Lector;
import es.upm.dit.isst.bookAdvisor.model.Libreria;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.Valoracion;

public class Libro_Servlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Libro.class);
		ObjectifyService.register(Valoracion.class);
		ObjectifyService.register(IntercambioTienen.class);
		ObjectifyService.register(AsignacionesLibrerias.class);


	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.getSession().removeAttribute("loTiene");;
		request.getSession().removeAttribute("asignacionlib");;

		
		LibroDAO dao = LibroDAOImpl.getInstancia();
		String id = request.getParameter("id");
		Libro libro = dao.readID(id);
		ValoracionDAO valoracionDao = ValoracionDAOImpl.getInstancia();
		Lector lector = (Lector) request.getSession().getAttribute("lector");
		List<Valoracion> v = valoracionDao.read();
		List<Valoracion> valoraciones = valoracionDao.readLibro(id);
		Valoracion v3 = null;
		request.getSession().removeAttribute("valoracion");
		
		Libreria libreria = (Libreria) request.getSession().getAttribute("libreria");
		
		AsignacionesLibreriasDAO asignacionesLibreriadao = AsignacionesLibreriasDAOImpl.getInstancia();
		List<AsignacionesLibrerias> asignacionesLibrerias = null;
		
		if(libreria!=null){
			System.out.println("AAAA");
			asignacionesLibrerias = asignacionesLibreriadao.readLibreria(libreria.getId());
		}
		
		
		IntercambioTienenDAO tienendao = IntercambioTienenDAOImpl.getInstancia();
		List<IntercambioTienen> tieneLector = null;
		if (lector!=null){

			tieneLector = tienendao.readUsuario(lector.getId());
		}
		 
		boolean loTiene = false;
		if(tieneLector != null) {

			for(IntercambioTienen i: tieneLector){
				if(i.getLibro().equals(libro.getId())) {
					loTiene = true;

				}
			}
			
		
		}
		
		AsignacionesLibrerias asignacionlibreria = null;
		if(asignacionesLibrerias!=null){

			for(AsignacionesLibrerias i: asignacionesLibrerias){
				if(i.getLibro().equals(libro.getId())) {
					loTiene = true;
					asignacionlibreria = i;

			}
			
			}
		}
		
		if(loTiene) {
			request.getSession().setAttribute("loTiene", "1");
			if(libreria!=null){
				request.getSession().setAttribute("asignacionlib", asignacionlibreria);
			}

		}
		
		
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
