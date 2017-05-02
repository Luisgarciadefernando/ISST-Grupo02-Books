package es.upm.dit.isst.bookAdvisor;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.LibreriaDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibreriaDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.OfertaDAO;
import es.upm.dit.isst.bookAdvisor.dao.OfertaDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Libreria;
import es.upm.dit.isst.bookAdvisor.model.Oferta;

public class Ofertas_Servlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Oferta.class);	
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {
		
		OfertaDAO ofertaDao = OfertaDAOImpl.getInstancia();
		LibreriaDAO libreriaDao = LibreriaDAOImpl.getInstancia();
//		ofertaDao.deleteAll();
//		Libreria libreria1 = libreriaDao.create("Libreria Le", "c/ Paseo de la Casetellana", "http://www.libreriale.es", "email1", "Esta es una libreria de noseque y de nosecuantos", "1234", "libreria1.png");
//		Libreria libreria2 = libreriaDao.create("Nosecuantitos", "c/ Paseo de la Habana", "http://www.google.es", "email2", "Esta es otra libreria de noseque y de nosecuantos", "1234", "libreria2.jpeg");
//		Libreria libreria3 = libreriaDao.create("Libreria3", "c/ de la Piruleta", "http://www.marca.com", "email3", "Esta es una mas libreria de noseque y de nosecuantos", "1234", "libreria3.jpeg");
//		List <Libreria> librerias = libreriaDao.read();
//		Libreria libreria1 = librerias.get(0);
//		Libreria libreria2 = librerias.get(1);
//		Libreria libreria3 = librerias.get(2);
//		
//		Oferta oferta1 = ofertaDao.create(30, "BOOKADVISOR02", libreria1, "Descuento en libros de aventuras", "Descuento de blalabla y noseque nosecuantos", "2 de junio del 2017");
//		Oferta oferta2 = ofertaDao.create(50, null, libreria2, "Segunda unidad al 50%", "Descuento de blalabla y noseque nosecuantos", "30 de mayo del 2017");
//		Oferta oferta3 = ofertaDao.create(70, "BOOKS02", libreria3, "Liquidación", "Descuento de blalabla y noseque nosecuantos", "1 de Julio del 2017");
		
		List<Oferta> ofertas = ofertaDao.read();
		
		request.getSession().setAttribute("ofertas", ofertas);
		
		RequestDispatcher view = request.getRequestDispatcher("ofertas.jsp");
		view.forward(request, response);
		
	}
	
}
