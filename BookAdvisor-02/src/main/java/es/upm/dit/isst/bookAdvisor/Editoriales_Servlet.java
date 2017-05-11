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

import es.upm.dit.isst.bookAdvisor.dao.EditorialDAO;
import es.upm.dit.isst.bookAdvisor.dao.EditorialDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Editorial;

public class Editoriales_Servlet  extends HttpServlet{
	
	public void init() throws ServletException {
		ObjectifyService.register(Editorial.class);	
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {
		
		EditorialDAO Aut_dao = EditorialDAOImpl.getInstancia();
		

		
		List<Editorial> editoriales = Aut_dao.read();
		List<Editorial> listaEditoriales = new ArrayList<Editorial>();
		
		if(request.getParameter("letra")!=null) {
			String letra = request.getParameter("letra");
			letra = letra.toLowerCase();
			Pattern pat = Pattern.compile(letra+".*");

			for(Editorial a: editoriales){

				if(a.getNombre()!=null){
					Matcher mat = pat.matcher(a.getNombre().toLowerCase());
					if(mat.matches()){
						listaEditoriales.add(a);
					}
				}
			}
		}
		
		request.getSession().setAttribute("editoriales", listaEditoriales);
		
		
		RequestDispatcher view = request.getRequestDispatcher("editoriales.jsp");
		view.forward(request, response);
		
	}

}
