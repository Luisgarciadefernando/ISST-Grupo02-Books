package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.AsignacionesLibreriasDAO;
import es.upm.dit.isst.bookAdvisor.dao.AsignacionesLibreriasDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.IntercambioTienenDAO;
import es.upm.dit.isst.bookAdvisor.dao.IntercambioTienenDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LectorDAO;
import es.upm.dit.isst.bookAdvisor.dao.LectorDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LibreriaDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibreriaDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.AsignacionesLibrerias;
import es.upm.dit.isst.bookAdvisor.model.IntercambioTienen;
import es.upm.dit.isst.bookAdvisor.model.Lector;
import es.upm.dit.isst.bookAdvisor.model.Libreria;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.Valoracion;

public class Disponibilidad_Servlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Libro.class);
		ObjectifyService.register(Lector.class);
		ObjectifyService.register(Libreria.class);
		ObjectifyService.register(AsignacionesLibrerias.class);

		ObjectifyService.register(Valoracion.class);
		ObjectifyService.register(IntercambioTienen.class);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		IntercambioTienenDAO intercambioDAO = IntercambioTienenDAOImpl.getInstancia();
		LectorDAO lectordao = LectorDAOImpl.getInstancia();
		List<Lector> lectores = lectordao.read();
		LibroDAO librodao = LibroDAOImpl.getInstancia();
		LibreriaDAO libdao = LibreriaDAOImpl.getInstancia();
		AsignacionesLibreriasDAO asigLibreriasDao = AsignacionesLibreriasDAOImpl.getInstancia();
		
		if(request.getParameter("libro")!=null && request.getParameter("intercambio")!=null){
			String libroId = request.getParameter("libro");
			Libro libro = librodao.readID(libroId);
			List<IntercambioTienen> listaIntercambio = intercambioDAO.readLibro(libroId);
			List<Lector> usuariosTienen = new ArrayList<Lector>();
			for(IntercambioTienen i: listaIntercambio){
				Lector lector = lectordao.readID(i.getUsuario());
				usuariosTienen.add(lector);
			}
			request.getSession().setAttribute("usuarios", usuariosTienen);
			request.getSession().setAttribute("libro", libro);
			RequestDispatcher view = request.getRequestDispatcher("usuarios.jsp");
			view.forward(request, response);
			
		}
		if(request.getParameter("libro")!=null && request.getParameter("librerias")!=null){
			String libro = request.getParameter("libro");
			List<AsignacionesLibrerias> asignacionesLibrerias = asigLibreriasDao.readLibro(libro);
			List<Libreria> librerias = new ArrayList<Libreria>();
			
			for(int i=0; i<asignacionesLibrerias.size();i++){
				AsignacionesLibrerias a = asignacionesLibrerias.get(i);
				Libreria l = libdao.readId(a.getLibreria());
				librerias.add(l);
				
			}
			request.getSession().setAttribute("librerias", librerias);

			RequestDispatcher view = request.getRequestDispatcher("librerias.jsp");
			view.forward(request, response);
		}
	}
}
