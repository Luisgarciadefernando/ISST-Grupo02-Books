package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

	
	private String hash(String passwordToHash) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		try {
			md.update(passwordToHash.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Change this to "UTF-16" if needed
		byte[] digest = md.digest();
		return byteArrayToHexString(digest);
		}
	private static String byteArrayToHexString(byte[] b) {
		  String result = "";
		  for (int i=0; i < b.length; i++) {
		    result +=
		          Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
		  }
		  return result;
		}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getSession().getAttribute("lector")!= null){
			
			if(request.getParameter("cambiarcontrasena")!=null || request.getParameter("cambiarnombre")!=null || request.getParameter("cambiaremail")!=null){
				
				Lector lectorPerfil = (Lector) request.getSession().getAttribute("lector");
				String nombre = request.getParameter("cambiarnombre");
				String email = request.getParameter("cambiaremail");
		
				String contrasenaAntigua = lectorPerfil.getContrasena();
				String contrasenaAntiguaPrueba ="";
		
				try {
					 contrasenaAntiguaPrueba = hash(request.getParameter("passAntigua"));
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(nombre =="" && email =="") {
					request.getSession().setAttribute("mensaje", "Introduzca un nuevo nombre de usuario");
			}
				
				if(contrasenaAntigua.equals(contrasenaAntiguaPrueba) && nombre !="" && email !="" ){
					
					
					String pass1 ="";
					String pass2 ="";
					try {
						 pass1 = hash(request.getParameter("passNueva"));
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						 pass2 = hash(request.getParameter("passNueva2"));
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(pass1.equals(pass2)){
						lectorPerfil.setContrasena(pass1);
						LectorDAOImpl.getInstancia().update(lectorPerfil);
						request.getSession().setAttribute("mensaje", "Contraseña modificada");
					}
					else {
						request.getSession().setAttribute("mensaje", "Error al modificar la contraseña");
					}
				}
				
				
				
				if(!contrasenaAntigua.equals(contrasenaAntiguaPrueba) && nombre !="" && email !=""){
					lectorPerfil.setNombre(nombre);
					lectorPerfil.setEmail(email);
					LectorDAOImpl.getInstancia().update(lectorPerfil);	
					request.getSession().setAttribute("mensaje", "Nombre de usuario actualizado");

				}

			} else{
				request.getSession().setAttribute("mensaje", "Error al modificar los datos");

			}
			response.sendRedirect("/usuario?id=1");
		}
	}
	
}

