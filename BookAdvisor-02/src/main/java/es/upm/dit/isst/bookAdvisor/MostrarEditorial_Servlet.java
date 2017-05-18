package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.EditorialDAO;
import es.upm.dit.isst.bookAdvisor.dao.EditorialDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.AsignacionesEditorialesDAO;
import es.upm.dit.isst.bookAdvisor.dao.AsignacionesEditorialesDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.AsignacionesEditoriales;
import es.upm.dit.isst.bookAdvisor.model.Editorial;

public class MostrarEditorial_Servlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Editorial.class);
		ObjectifyService.register(AsignacionesEditoriales.class);

	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		EditorialDAO dao = EditorialDAOImpl.getInstancia();
		AsignacionesEditorialesDAO adao = AsignacionesEditorialesDAOImpl.getInstancia();
		String id = request.getParameter("id");
		Editorial editorial = dao.readId(id);
		
		List<AsignacionesEditoriales> asignacionesEditorial = new ArrayList<AsignacionesEditoriales>();
		asignacionesEditorial = adao.readEditorialId(id);
		request.getSession().setAttribute("editorialBuscada", editorial);
		request.getSession().setAttribute("asignacionesEditorial", asignacionesEditorial);
		
		RequestDispatcher view = request.getRequestDispatcher("editorialListado.jsp");
		view.forward(request, response);
	}
	
}
