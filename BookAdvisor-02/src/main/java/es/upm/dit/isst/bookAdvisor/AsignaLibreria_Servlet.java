package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.upm.dit.isst.bookAdvisor.dao.AsignacionesLibreriasDAO;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.AsignacionesLibreriasDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.AsignacionesLibrerias;
import es.upm.dit.isst.bookAdvisor.model.Autor;
import es.upm.dit.isst.bookAdvisor.model.Libreria;

public class AsignaLibreria_Servlet extends HttpServlet{
	public void init() throws ServletException {
		ObjectifyService.register(AsignacionesLibrerias.class);	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AsignacionesLibreriasDAO asigDao = AsignacionesLibreriasDAOImpl.getInstancia();
		if (request.getParameter("precio") != null && request.getParameter("formato") != null && request.getParameter("tengo") != null && request.getParameter("libro")!=null && request.getSession().getAttribute("libreria")!=null){
			String precio = request.getParameter("precio");
			String formato = request.getParameter("formato");
			String libroId = request.getParameter("libro");
			Libreria libreria = (Libreria) request.getSession().getAttribute("libreria");
			
			asigDao.create(libreria.getId(), libroId, Double.parseDouble(precio), formato);
			response.sendRedirect("/libro?id="+libroId);
		}
	
	}
	
	

}
