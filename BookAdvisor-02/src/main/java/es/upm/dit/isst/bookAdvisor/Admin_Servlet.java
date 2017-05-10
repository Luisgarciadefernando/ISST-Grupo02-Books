package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.BibliotecaDAO;
import es.upm.dit.isst.bookAdvisor.dao.BibliotecaDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.EditorialDAO;
import es.upm.dit.isst.bookAdvisor.dao.EditorialDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.IntercambioTienenDAO;
import es.upm.dit.isst.bookAdvisor.dao.IntercambioTienenDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LectorDAO;
import es.upm.dit.isst.bookAdvisor.dao.LectorDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LibreriaDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibreriaDAOImpl;
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
			else if(request.getParameter("usuariosPendientes")!=null) {
				LibreriaDAO libreriaDao = LibreriaDAOImpl.getInstancia();
				List<Libreria> libreriasPendientes = libreriaDao.readConfirmado(false);
				request.getSession().setAttribute("libreriasPendientes", libreriasPendientes);
				EditorialDAO editorialDao = EditorialDAOImpl.getInstancia();
				List<Editorial> editorialesPendientes = editorialDao.readConfirmado(false);
				request.getSession().setAttribute("editorialesPendientes", editorialesPendientes);
				BibliotecaDAO bibliotecaDao = BibliotecaDAOImpl.getInstancia();
				List<Biblioteca> bibliotecasPendientes = bibliotecaDao.readConfirmado(false);
				request.getSession().setAttribute("bibliotecasPendientes", bibliotecasPendientes);
				RequestDispatcher view = request.getRequestDispatcher("usuariosPendientes.jsp");
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
		LibreriaDAO libreriaDao = LibreriaDAOImpl.getInstancia();
		BibliotecaDAO bibliotecaDao = BibliotecaDAOImpl.getInstancia();
		EditorialDAO editorialDao = EditorialDAOImpl.getInstancia();
		
		if(request.getParameter("libroId")!=null){
			libro = librodao.readID(request.getParameter("libroId"));
		}
		String resumen = request.getParameter("resumen");
		String autor = request.getParameter("autor");
		String titulo = request.getParameter("titulo");
		String localizacion = request.getParameter("localizacion");
		String descripcion = request.getParameter("descripcion");
		String url = request.getParameter("url");
		String email = request.getParameter("email");
		String nombre = request.getParameter("nombre");
		
		if(request.getSession().getAttribute("admin")!=null){
			if(request.getParameter("rechazar")!=null){
				librodao.delete(libro);
				response.sendRedirect("/admin");
			}
			if(request.getParameter("aceptar")!=null){
				libro.setAutor(autor);
				libro.setTitulo(titulo);
				libro.setResumen(resumen);
				libro.setEstado(1);
				librodao.update(libro);
				response.sendRedirect("/admin");
				
			}
			if(request.getParameter("aceptarLibreria")!=null){
				String id = request.getParameter("libreriaId");
				Libreria libreria = libreriaDao.readId(id);
				libreria.setEmail(email);
				libreria.setDescripcion(descripcion);
				libreria.setLocalizacion(localizacion);
				libreria.setNombre(nombre);
				libreria.setConfirmado(true);
				libreriaDao.update(libreria);
				response.sendRedirect("/admin?usuariosPendientes=true");
			}
			if(request.getParameter("rechazarLibreria")!=null){
				String id = request.getParameter("libreriaId");
				Libreria libreria = libreriaDao.readId(id);
				libreriaDao.delete(libreria);
				response.sendRedirect("/admin?usuariosPendientes=true");
			}
			if(request.getParameter("aceptarBiblioteca")!=null){
				String id = request.getParameter("bibliotecaId");
				Biblioteca biblioteca = bibliotecaDao.readId(id);
				biblioteca.setEmail(email);
				biblioteca.setUrl(url);
				biblioteca.setDescripcion(descripcion);
				biblioteca.setLocalizacion(localizacion);
				biblioteca.setNombre(nombre);
				biblioteca.setConfirmado(true);
				bibliotecaDao.update(biblioteca);
				response.sendRedirect("/admin?usuariosPendientes=true");
			}
			if(request.getParameter("rechazarBiblioteca")!=null){
				String id = request.getParameter("bibliotecaId");
				Biblioteca biblioteca = bibliotecaDao.readId(id);
				bibliotecaDao.delete(biblioteca);
				response.sendRedirect("/admin?usuariosPendientes=true");
			}
			if(request.getParameter("aceptarEditorial")!=null){
				String id = request.getParameter("editorialId");
				Editorial editorial = editorialDao.readId(id);
				editorial.setEmail(email);
				editorial.setNombre(nombre);
				editorial.setConfirmado(true);
				editorialDao.update(editorial);
				response.sendRedirect("/admin?usuariosPendientes=true");
			}
			if(request.getParameter("rechazarEditorial")!=null){
				String id = request.getParameter("editorialId");
				Editorial editorial = editorialDao.readId(id);
				editorialDao.delete(editorial);
				response.sendRedirect("/admin?usuariosPendientes=true");
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
				response.sendRedirect("/admin");
			}
		}
	}
	
}
