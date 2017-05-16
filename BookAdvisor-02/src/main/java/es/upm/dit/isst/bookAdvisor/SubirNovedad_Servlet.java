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

import es.upm.dit.isst.bookAdvisor.dao.AsignacionesEditorialesDAO;
import es.upm.dit.isst.bookAdvisor.dao.AsignacionesEditorialesDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.AutorDAO;
import es.upm.dit.isst.bookAdvisor.dao.AutorDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAO;
import es.upm.dit.isst.bookAdvisor.dao.LibroDAOImpl;
import es.upm.dit.isst.bookAdvisor.dao.NovedadDAO;
import es.upm.dit.isst.bookAdvisor.dao.NovedadDAOImpl;
import es.upm.dit.isst.bookAdvisor.model.AsignacionesEditoriales;
import es.upm.dit.isst.bookAdvisor.model.Autor;
import es.upm.dit.isst.bookAdvisor.model.Editorial;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.Novedad;


public class SubirNovedad_Servlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Libro.class);
		ObjectifyService.register(Autor.class);
		ObjectifyService.register(AsignacionesEditoriales.class);
		ObjectifyService.register(Novedad.class);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String titulo = req.getParameter("titulo");
		String autor = req.getParameter("autor");
		String resumen = req.getParameter("resumen");
		String genero = req.getParameter("genero");
		String formato = req.getParameter("formato");
		String idioma = req.getParameter("idioma");
		Editorial editorial = (Editorial) req.getSession().getAttribute("editorial");
		String editorialId = editorial.getId();

		String imagen = "no-disponible.jpg";
		
		LibroDAO libroDao = LibroDAOImpl.getInstancia();
		AutorDAO autorDao = AutorDAOImpl.getInstancia();
		AsignacionesEditorialesDAO asigDao = AsignacionesEditorialesDAOImpl.getInstancia();
		NovedadDAO novedadDao = NovedadDAOImpl.getInstancia();
		
//		Map<String, List<BlobKey>> blobs = BlobstoreServiceFactory.getBlobstoreService().getUploads(req);
//		List<BlobKey> blobKeys = blobs.get("file");
//		if (blobKeys == null || blobKeys.isEmpty() || blobKeys.get(0) == null) {
//			resp.sendError(1200);
//		}
//		else {
//			imagen = blobKeys.get(0).getKeyString();
//		}
		
		Libro libro = libroDao.create(titulo, resumen, genero, autor, 0, imagen);
		
		if(autorDao.readNombre(autor).size()==0){
			autorDao.create(autor);
		}
		
		AsignacionesEditoriales asignacionesEditoriales = asigDao.create(libro, editorial, editorialId, formato, idioma, 0);
		novedadDao.create(libro, asignacionesEditoriales, 0);
	
		resp.sendRedirect("/novedades");
	}

	


		
}
