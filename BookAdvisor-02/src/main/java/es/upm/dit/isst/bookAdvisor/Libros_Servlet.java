package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;
import java.util.ArrayList;
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

import es.upm.dit.isst.bookAdvisor.dao.AutorDAO;
import es.upm.dit.isst.bookAdvisor.dao.AutorDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Autor;
import es.upm.dit.isst.bookAdvisor.model.Libro;

public class Libros_Servlet  extends HttpServlet  {
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Libro.class);
		ObjectifyService.register(Autor.class);

	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		LibroDAO dao = LibroDAOImpl.getInstancia();
		
		
		List<Libro> libros = dao.readEstado(1);
		
		
		/*dao.create("El Se�or de los anillos", "Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non  mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.", "Fantas�a", "J R R Tolkien", 0, "anillo.jpg");
		dao.create("El ni�o con el pijama de rayas", "Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non  mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.", "Drama", "John Boyne", 0, "pijama.jpg");
		dao.create("Los pilares de la tierra", "Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non  mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.", "Ficci�n", "Ken Follet", 0, "pilares.jpg");
		 */
		List<Libro> librosBusqueda = new ArrayList<Libro>();
	    if(request.getParameter("busqueda")!=null){
	      String busqueda = request.getParameter("busqueda");
	      busqueda = busqueda.toLowerCase();
	      Pattern pat = Pattern.compile(".*"+busqueda+".*");
	      
	      Iterator<Libro> libroIt = libros.iterator();
	      while (libroIt.hasNext()) {
	         Libro libro = libroIt.next();
	         if(libro.getTitulo()!= null) {
	           Matcher mat = pat.matcher(libro.getTitulo().toLowerCase());
	             if(mat.matches()){
	               //libroIt.remove();
	               librosBusqueda.add(libro);
	             }
	        }
	        
	      }
	      libros=librosBusqueda;
	    }
	    
	    List<Libro> librosGenero = new ArrayList<Libro>();
	    if(request.getParameter("genero")!=null){
	    	String gen = request.getParameter("genero");
	    	gen = gen.toLowerCase();
		    Pattern genero = Pattern.compile(".*"+gen+".*");
		    
		    Iterator<Libro> libroIt = libros.iterator();
		      while (libroIt.hasNext()) {
		         Libro libro = libroIt.next();
		         if(libro.getGenero()!= null) {
		           Matcher mat = genero.matcher(libro.getGenero().toLowerCase());
		             if(mat.matches()){
		               //libroIt.remove();
		               librosGenero.add(libro);
		             }
		        }
		        
		      }
		      libros=librosGenero;
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
		
		AutorDAO autordao = AutorDAOImpl.getInstancia();
		
		List<Libro> librosautor = new ArrayList<Libro>();
		if(request.getParameter("autor")!=null){
			
			String autorId = request.getParameter("autor");
			Autor a = autordao.readId(autorId);
			for(Libro l: libros){
				
				if(l.getAutor()!=null && l.getAutor().equals(a.getNombre())){
					librosautor.add(l);
				}
			}
			request.getSession().setAttribute("libros", librosautor);
		}
		RequestDispatcher view = request.getRequestDispatcher("libros.jsp");
		view.forward(request, response);
	}
}
