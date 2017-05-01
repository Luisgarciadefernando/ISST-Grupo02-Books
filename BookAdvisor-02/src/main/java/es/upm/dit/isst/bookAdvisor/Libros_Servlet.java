package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.LibroDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Libro;

public class Libros_Servlet  extends HttpServlet  {
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Libro.class);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		LibroDAO dao = LibroDAOImpl.getInstancia();
		
		
		List<Libro> libros = dao.read();
		
		/*
		dao.create("El Se�or de los anillos", "------", "Fantas�a", "J R R Tolkien", 0, "anillo.jpg");
		dao.create("El ni�o con el pijama de rayas", "", "Drama", "John Boyne", 0, "pijama.jpg");
		dao.create("Los pilares de la tierra", "....", "Ficci�n", "Ken Follet", 0, "pilares.jpg");
		 */
		if(request.getParameter("busqueda")!=null){
			String busqueda = request.getParameter("busqueda");
			busqueda = busqueda.toLowerCase();
			Pattern pat = Pattern.compile(".*"+busqueda+".*");
			
			Iterator<Libro> libroIt = libros.iterator();
			while (libroIt.hasNext()) {
			   Libro libro = libroIt.next();
			   if(libro.getTitulo()!= null) {
				   Matcher mat = pat.matcher(libro.getTitulo().toLowerCase());
			     	if(!mat.matches()){
			     		libroIt.remove();
			     	}
				}
			   else {
				   libroIt.remove();
			   }
			   Matcher mat = pat.matcher(libro.getTitulo());
			     if(!mat.matches()){
			    	libroIt.remove();
			     }
			}
		}
		if(request.getParameter("novedades")!=null){
			  Collections.sort(libros, new Comparator<Libro>() {
			        @Override
			        public int compare(Libro o1, Libro o2) {
			            // TODO Auto-generated method stub
			            return o1.getFecha().compareTo(o2.getFecha());
			        }
			    });
			  Collections.reverse(libros);
		}
		
		if(request.getParameter("recomendados")!=null){
			  Collections.sort(libros, new Comparator<Libro>() {
			        @Override
			        public int compare(Libro o1, Libro o2) {
			            // TODO Auto-generated method stub
			            return Double.compare(o1.getValoracion(), o2.getValoracion());
			        }
			    });
			  Collections.reverse(libros);
		}
		
		request.getSession().setAttribute("libros", libros);
		RequestDispatcher view = request.getRequestDispatcher("libros.jsp");
		view.forward(request, response);
	}
}