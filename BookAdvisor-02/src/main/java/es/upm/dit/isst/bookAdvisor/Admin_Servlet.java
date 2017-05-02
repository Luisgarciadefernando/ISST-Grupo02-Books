package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.IntercambioTienenDAO;
import es.upm.dit.isst.bookAdvisor.dao.IntercambioTienenDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LectorDAO;
import es.upm.dit.isst.bookAdvisor.dao.LectorDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.ValoracionDAO;
import es.upm.dit.isst.bookAdvisor.dao.ValoracionDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Biblioteca;
import es.upm.dit.isst.bookAdvisor.model.Editorial;
import es.upm.dit.isst.bookAdvisor.model.IntercambioTienen;
import es.upm.dit.isst.bookAdvisor.model.Lector;
import es.upm.dit.isst.bookAdvisor.model.Libreria;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.Valoracion;

public class Admin_Servlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Lector.class);
		ObjectifyService.register(Editorial.class);
		ObjectifyService.register(Biblioteca.class);
		ObjectifyService.register(Libreria.class);
		ObjectifyService.register(IntercambioTienen.class);
	    ObjectifyService.register(Valoracion.class);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("admin")!=null){
			
			if (request.getParameter("usuarios")!=null){
				LectorDAO lectordao = LectorDAOImpl.getInstancia();
				List<Lector> usuarios = lectordao.read();
				request.getSession().setAttribute("usuarios", usuarios);
				RequestDispatcher view = request.getRequestDispatcher("usuarios.jsp");
				view.forward(request, response);
			}
			else {
				LibroDAO librodao = LibroDAOImpl.getInstancia();
				List<Libro> librosPendientes = librodao.readEstado(0);
				
				request.getSession().setAttribute("librosPendientes", librosPendientes);
				
				RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
				view.forward(request, response);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LibroDAO librodao = LibroDAOImpl.getInstancia();
		Libro libro = null;
		
		LectorDAO lectordao = LectorDAOImpl.getInstancia();
		ValoracionDAO valoraciondao = ValoracionDAOImpl.getInstancia();
		IntercambioTienenDAO intercambiotienendao = IntercambioTienenDAOImpl.getInstancia();
		
		if(request.getParameter("libroId")!=null){
			libro = librodao.readID(request.getParameter("libroId"));
		}
		String resumen = request.getParameter("resumen");
		String autor = request.getParameter("autor");
		String titulo = request.getParameter("titulo");
		
		if(request.getSession().getAttribute("admin")!=null){
			if(request.getParameter("rechazar")!=null){
				librodao.delete(libro);
			}
			if(request.getParameter("aceptar")!=null){
				libro.setAutor(autor);
				libro.setTitulo(titulo);
				libro.setResumen(resumen);
				libro.setEstado(1);
				librodao.update(libro);
				
			}
			if(request.getParameter("eliminaUsuario")!=null){
				Lector usuarioEliminar = lectordao.readID(request.getParameter("usuarioAEliminar"));
				lectordao.delete(usuarioEliminar);
				List<Valoracion> v = null;
				List<IntercambioTienen> in = null;
				if(valoraciondao.readLector(request.getParameter("usuarioAEliminar")) != null){
					v = valoraciondao.readLector(request.getParameter("usuarioAEliminar"));
					for(Valoracion vi: v){
						valoraciondao.delete(vi);
					}
				}
				
				if(intercambiotienendao.readUsuario(request.getParameter("usuarioAEliminar"))!=null){
					in = intercambiotienendao.readUsuario(request.getParameter("usuarioAEliminar"));
					for (IntercambioTienen i : in){
						intercambiotienendao.delete(i);
					}
				}
			}
		}
		response.sendRedirect("/admin");
	}
	
}
