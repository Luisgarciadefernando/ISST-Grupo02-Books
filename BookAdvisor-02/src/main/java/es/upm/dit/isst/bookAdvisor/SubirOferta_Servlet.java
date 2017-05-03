package es.upm.dit.isst.bookAdvisor;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.AutorDAO;
import es.upm.dit.isst.bookAdvisor.dao.AutorDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LibreriaDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibreriaDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.OfertaDAO;
import es.upm.dit.isst.bookAdvisor.dao.OfertaDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Autor;
import es.upm.dit.isst.bookAdvisor.model.Libreria;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.Oferta;


public class SubirOferta_Servlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Libro.class);
		ObjectifyService.register(Autor.class);
		ObjectifyService.register(Oferta.class);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String titulo = req.getParameter("titulo");
		String descuentoString = req.getParameter("descuento");
		int descuento = Integer.parseInt(descuentoString);
		String cupon = req.getParameter("cupon");
		String descripcion = req.getParameter("descripcion");
		String dia = req.getParameter("dia");
		String mes = req.getParameter("mes");
		String ano = req.getParameter("ano");
		
		String caducidad = dia + "/" + mes + "/" + ano;

		OfertaDAO ofertaDao = OfertaDAOImpl.getInstancia();
		
		if(req.getSession().getAttribute("libreria")!=null){
			Libreria libreria = (Libreria) req.getSession().getAttribute("libreria");
			ofertaDao.create(descuento, cupon, libreria, titulo, descripcion, caducidad, 0);
		}
		

		resp.sendRedirect("/ofertas");
	}
}
