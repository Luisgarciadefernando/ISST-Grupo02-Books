package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.upm.dit.isst.bookAdvisor.dao.NovedadDAO;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.AsignacionesEditorialesDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.AsignacionesEditorialesDAO;
import es.upm.dit.isst.bookAdvisor.model.AsignacionesEditoriales;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.Editorial;

public class AsignaEditorial_Servlet extends HttpServlet{
	public void init() throws ServletException {
		ObjectifyService.register(AsignacionesEditoriales.class);	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AsignacionesEditorialesDAO asigDao = AsignacionesEditorialesDAOImpl.getInstancia();
		LibroDAO libroDao = LibroDAOImpl.getInstancia();
		System.out.println("AAAAAAAAAAAAAAAAA");
		if (request.getParameter("idioma") != null && request.getParameter("formato") != null && request.getParameter("tengo") != null && request.getParameter("libro")!=null && request.getSession().getAttribute("editorial")!=null){
			System.out.println("BBBBBBBBBBBBBBBBB");
			String idioma = request.getParameter("idioma");
			String formato = request.getParameter("formato");
			String libroId = request.getParameter("libro");
			Libro libro = libroDao.readID(libroId);
			Editorial editorial = (Editorial) request.getSession().getAttribute("editorial");
			String editorialId = editorial.getId();
			AsignacionesEditoriales a = asigDao.create(libro, editorial, editorialId, formato, idioma, 0);
			asigDao.update(a);
			System.out.println(a);
			System.out.println(a.getFormato());
			System.out.println(a.getIdioma());
			System.out.println(a.getLibro().getTitulo());
			System.out.println(a.getEditorial().getNombre());
			System.out.println(editorialId);
			System.out.println(a.getEditorial().getId());
			response.sendRedirect("/mostrarEditorial?id="+editorial.getId());
		}
	
	}
	
	

}
