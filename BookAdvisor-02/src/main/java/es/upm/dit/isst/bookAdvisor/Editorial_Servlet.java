package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import es.upm.dit.isst.bookAdvisor.dao.EditorialDAO;
import es.upm.dit.isst.bookAdvisor.dao.EditorialDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Editorial;

public class Editorial_Servlet extends HttpServlet  {
	
	public void init() throws ServletException {
		ObjectifyService.register(Editorial.class);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		EditorialDAO Edi_dao = EditorialDAOImpl.getInstancia();
		String email = request.getParameter("email");
		String nombre = request.getParameter("name");
		String pass1 = request.getParameter("password");
		String pass2 = request.getParameter("password2");
		String hash1="";
		String hash2="";
		String imagen = "img/no-disponible.jpg";
		
		
		try {
			hash1= hash(pass1);
		} catch (NoSuchAlgorithmException e) {		
			e.printStackTrace();
		}
		
		try {
			hash2= hash(pass2);
		} catch (NoSuchAlgorithmException e) {				
				e.printStackTrace();
		}
		
		Map<String, List<BlobKey>> blobs = BlobstoreServiceFactory.getBlobstoreService().getUploads(request);
		List<BlobKey> blobKeys = blobs.get("file");
		if (blobKeys == null || blobKeys.isEmpty() || blobKeys.get(0) == null) {
			response.sendError(1200);
		}
		else {
			ImagesService imagesService = ImagesServiceFactory.getImagesService();
			ServingUrlOptions servingOptions = ServingUrlOptions.Builder.withBlobKey(blobKeys.get(0));
	        String servingUrl = imagesService.getServingUrl(servingOptions);
			imagen = servingUrl;
		}
		
		Editorial editorial = Edi_dao.readEmail(email);
		List<Editorial> edit = Edi_dao.read();
		if(hash1==null || hash2==null || !hash1.equals(hash2)){
			request.getSession().setAttribute("mensaje","error en la contrase�a");
			response.sendRedirect("/registroEditorial");
			
		}
		
		else if (editorial != null){
			request.getSession().setAttribute("mensaje","editorial ya existente");
			response.sendRedirect("/registroEditorial");
		}
		else{
			Edi_dao.create(nombre, email, hash1, false, imagen);
			
			response.sendRedirect("/login");
		}
		
		
		
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher view = request.getRequestDispatcher("registroEditorial.jsp");
		view.forward(request,response);
	}
	
	private String hash(String passwordToHash) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		try {
			md.update(passwordToHash.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
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

