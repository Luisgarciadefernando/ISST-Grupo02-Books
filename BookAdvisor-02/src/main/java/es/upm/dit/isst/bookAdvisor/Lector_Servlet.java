package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.LectorDAO;
import es.upm.dit.isst.bookAdvisor.dao.LectorDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Lector;
import es.upm.dit.isst.bookAdvisor.model.Libro;

public class Lector_Servlet extends HttpServlet  {
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Lector.class);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		LectorDAO dao = LectorDAOImpl.getInstancia();
		String email = request.getParameter("email");
		String nombre = request.getParameter("name");
		String pass1 = request.getParameter("password");
		String pass2 =  request.getParameter("password2");
		String hash1="";
		String hash2="";
		
		
		try {
			hash1= hash(pass1);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			hash2= hash(pass2);
		} catch (NoSuchAlgorithmException e) {				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		
		//Lector lector = dao.readEmail(email);
		Lector lector = dao.readEmail(email);
		List<Lector> lects = dao.read();
		if(hash1==null || hash2==null || !hash1.equals(hash2)){
			request.getSession().setAttribute("mensaje","error en la contrase�a");
			response.sendRedirect("/registroLector");
			
		}

		else if (lector != null){
			request.getSession().setAttribute("mensaje","usuario ya existente");
			response.sendRedirect("/registroLector");
		}
		else{
			dao.create(email, nombre, hash1);
			response.sendRedirect("/login");
		}
		
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher view = request.getRequestDispatcher("registroLector.jsp");
		view.forward(request,response);
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
}
