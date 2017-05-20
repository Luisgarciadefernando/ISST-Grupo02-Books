package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.LibroDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.ValoracionDAO;
import es.upm.dit.isst.bookAdvisor.dao.ValoracionDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Lector;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.Valoracion;

public class Valoracion_Servlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Valoracion.class);
		ObjectifyService.register(Libro.class);

	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		if(request.getSession().getAttribute("lector")!=null){
			double valoracion = Integer.parseInt(request.getParameter("valoracionUser"));
			String comentario = request.getParameter("comentario");
			String libroID = request.getParameter("libro");
			Lector user = (Lector)request.getSession().getAttribute("lector");
			String lectorID = user.getId();
			String lectorNombre = user.getNombre();
			ValoracionDAO dao = ValoracionDAOImpl.getInstancia();
			dao.create(valoracion, comentario, lectorID, libroID, 0, lectorNombre);
			LibroDAO daoLibro = LibroDAOImpl.getInstancia();
			Libro libro = daoLibro.readID(libroID);
			int nVeces = libro.getVecesValorado();
			double valLibro = libro.getValoracion();
			double valTotal = valLibro*nVeces + valoracion;
			nVeces++;
			double valNueva = valTotal/nVeces;
			
			valNueva = Math.rint(valNueva*100)/100;
			
			libro.setValoracion(valNueva);
			libro.setVecesValorado(nVeces);
			daoLibro.update(libro);
			response.sendRedirect("/libro?id="+libroID);
			
		}
	}
}
