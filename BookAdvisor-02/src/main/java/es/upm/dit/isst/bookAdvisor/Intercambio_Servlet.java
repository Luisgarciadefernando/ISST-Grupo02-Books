package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.IntercambioTienenDAO;
import es.upm.dit.isst.bookAdvisor.dao.IntercambioTienenDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.IntercambioTienen;
import es.upm.dit.isst.bookAdvisor.model.Lector;

public class Intercambio_Servlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(IntercambioTienen.class);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 
		if (request.getParameter("tengo") != null && request.getParameter("libro")!=null && request.getSession().getAttribute("lector")!=null) {
			IntercambioTienenDAO tienendao = IntercambioTienenDAOImpl.getInstancia();
			Lector lector = (Lector) request.getSession().getAttribute("lector");
			List<IntercambioTienen> tieneLector = tienendao.readUsuario(lector.getId());
			boolean loTiene = false;
			if(tieneLector != null) {
			
				for(IntercambioTienen i: tieneLector){
					if(i.getLibro().equals(request.getParameter("libro"))) {
						loTiene = true;
						
					}
				}
				
				if(!loTiene) {
					
					tienendao.create(request.getParameter("libro"), lector.getId());
				}
			}
			
			response.sendRedirect("/libro?id="+request.getParameter("libro"));
		}
	}
	

}
