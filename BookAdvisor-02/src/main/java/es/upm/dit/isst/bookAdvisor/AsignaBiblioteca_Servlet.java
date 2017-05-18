package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.AsignacionesBibliotecasDAO;
import es.upm.dit.isst.bookAdvisor.dao.AsignacionesBibliotecasDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Autor;
import es.upm.dit.isst.bookAdvisor.model.AsignacionesBibliotecas;
import es.upm.dit.isst.bookAdvisor.model.Biblioteca;

public class AsignaBiblioteca_Servlet extends HttpServlet{
	public void init() throws ServletException {
		ObjectifyService.register(AsignacionesBibliotecas.class);	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AsignacionesBibliotecasDAO asigDao = AsignacionesBibliotecasDAOImpl.getInstancia();
		if (request.getParameter("formato") != null && request.getParameter("tengo") != null && request.getParameter("libro")!=null && request.getSession().getAttribute("biblioteca")!=null){
			String formato = request.getParameter("formato");
			String libroId = request.getParameter("libro");
			Biblioteca biblioteca = (Biblioteca) request.getSession().getAttribute("biblioteca");
			
			asigDao.create(biblioteca.getId(), libroId, formato);
			response.sendRedirect("/libro?id="+libroId);
		}
	}
}
