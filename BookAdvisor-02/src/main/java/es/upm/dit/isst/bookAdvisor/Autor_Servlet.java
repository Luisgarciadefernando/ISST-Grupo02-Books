package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;
import java.util.ArrayList;
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
import es.upm.dit.isst.bookAdvisor.model.Autor;

public class Autor_Servlet extends HttpServlet{
	
	public void init() throws ServletException {
		ObjectifyService.register(Autor.class);	
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {
		
		AutorDAO Aut_dao = AutorDAOImpl.getInstancia();
		
//		Autor autor1 = dao.create("Brown Dan");
//		Autor autor2 = dao.create("Boyne John");
//		Autor autor3 = dao.create("Buzz Michael");
		
		List<Autor> autores = Aut_dao.read();
		List<Autor> listaAutores = new ArrayList<Autor>();
		
		if(request.getParameter("letra")!=null) {
			String letra = request.getParameter("letra");
			letra = letra.toLowerCase();
			Pattern pat = Pattern.compile(letra+".*");

			for(Autor a: autores){

				if(a.getNombre()!=null){
					Matcher mat = pat.matcher(a.getNombre().toLowerCase());
					if(mat.matches()){
						listaAutores.add(a);
					}
				}
			}
		}
		
		request.getSession().setAttribute("autores", listaAutores);
		
		
		RequestDispatcher view = request.getRequestDispatcher("autores.jsp");
		view.forward(request, response);
		
	}

}
