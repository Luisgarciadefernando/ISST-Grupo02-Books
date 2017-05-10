package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.BookCrossingDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.BookCrossing;
import es.upm.dit.isst.bookAdvisor.model.Lector;
import es.upm.dit.isst.bookAdvisor.model.Libro;

public class BookCrossing_Servlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(BookCrossing.class);
		ObjectifyService.register(Lector.class);
		ObjectifyService.register(Libro.class);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getSession().getAttribute("lector")!=null){
			List<BookCrossing> bookcrossing = BookCrossingDAOImpl.getInstancia().readEncontrado(false);
			
			req.setAttribute("bookcrossinglist", bookcrossing);
		
			RequestDispatcher view = req.getRequestDispatcher("bookcrossing.jsp");
			view.forward(req,resp);
		}
		else {
			resp.sendError(404, "Tienes que estar logueado");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if( req.getSession().getAttribute("lector")!=null) {
			Lector lector = (Lector) req.getSession().getAttribute("lector");
			if(req.getParameter("crear")!=null && req.getSession().getAttribute("libro")!=null){
				String direccion = req.getParameter("direccion");
				String informacion = req.getParameter("info");
				;
				Libro libro = (Libro) req.getSession().getAttribute("libro");
			
				BookCrossing b =BookCrossingDAOImpl.getInstancia().create(lector.getId(), libro.getId(), direccion, informacion, false, new Date());
				String mensaje = "El código es: "+b.getId();
				
				req.getSession().setAttribute("mensaje", mensaje);
			}
			if(req.getParameter("encontrado")!=null){
				String codigo = req.getParameter("codigo");
				BookCrossing b = BookCrossingDAOImpl.getInstancia().readId(codigo);
				if(b!=null){
					b.setEncontrado(true);
					b.setLector(lector.getId());
					BookCrossingDAOImpl.getInstancia().update(b);
					req.getSession().setAttribute("mensaje", "Código válido");
				}
				else {
					req.getSession().setAttribute("mensaje", "Código no válido");
				}
			}
			resp.sendRedirect("/bookcrossing");
		}
		else {
			resp.sendError(404, "Tienes que estar logueado");
		}
		
		
	}
	
	
	
}
