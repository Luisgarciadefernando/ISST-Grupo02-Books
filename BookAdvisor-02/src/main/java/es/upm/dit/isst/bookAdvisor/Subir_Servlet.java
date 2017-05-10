package es.upm.dit.isst.bookAdvisor;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.bookAdvisor.dao.AutorDAO;
import es.upm.dit.isst.bookAdvisor.dao.AutorDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.Autor;
import es.upm.dit.isst.bookAdvisor.model.Libro;


public class Subir_Servlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Libro.class);
		ObjectifyService.register(Autor.class);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String titulo = req.getParameter("titulo");
		String autor = req.getParameter("autor");
		String resumen = req.getParameter("resumen");
		String genero = req.getParameter("genero");

		String imagen = "no-disponible.jpg";
		
		LibroDAO dao = LibroDAOImpl.getInstancia();
		AutorDAO autorDao = AutorDAOImpl.getInstancia();
		
//		Map<String, List<BlobKey>> blobs = BlobstoreServiceFactory.getBlobstoreService().getUploads(req);
//		List<BlobKey> blobKeys = blobs.get("file");
//		if (blobKeys == null || blobKeys.isEmpty() || blobKeys.get(0) == null) {
//			resp.sendError(1200);
//		}
//		else {
//			imagen = blobKeys.get(0).getKeyString();
//		}
//		
		
		dao.create(titulo, resumen, genero, autor, 0, imagen);
		
		if(autorDao.readNombre(autor).size()==0){
			autorDao.create(autor);
		}
		
		resp.sendRedirect("/libros");
	}

	


		
}
