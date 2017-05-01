package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.LectorDAO;
import es.upm.dit.isst.bookAdvisor.dao.LectorDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.ValoracionDAO;
import es.upm.dit.isst.bookAdvisor.dao.ValoracionDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Biblioteca;
import es.upm.dit.isst.bookAdvisor.model.Editorial;
import es.upm.dit.isst.bookAdvisor.model.Lector;
import es.upm.dit.isst.bookAdvisor.model.Libreria;
import es.upm.dit.isst.bookAdvisor.model.Valoracion;

public class Usuario_Servlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Lector.class);
		ObjectifyService.register(Valoracion.class);


	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("id")!=null){
			if(request.getSession().getAttribute("lector")!=null){
				Lector lector = (Lector) request.getSession().getAttribute("lector");
				if(lector.getId().equals(request.getParameter("id")) || request.getSession().getAttribute("admin")!=null){
					ValoracionDAO valoraciondao = ValoracionDAOImpl.getInstancia();
					List<Valoracion> valoraciones = valoraciondao.readLector(request.getParameter("id"));
					LectorDAO lectordao = LectorDAOImpl.getInstancia();
					Lector lectorPerfil = lectordao.readID(request.getParameter("id"));
					
					request.getSession().setAttribute("lectorPerfil", lectorPerfil);
					request.getSession().setAttribute("valoraciones", valoraciones);
					RequestDispatcher view = request.getRequestDispatcher("usuario.jsp");
					view.forward(request, response);
				}
				else {
					response.sendRedirect("/usuario?id="+lector.getId());
				}
			}
			else {
				response.sendError(404);
			}
		}
		else {
			response.sendError(404);
		}
	}

}
