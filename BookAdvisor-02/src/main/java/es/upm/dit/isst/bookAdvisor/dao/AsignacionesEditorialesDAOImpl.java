package es.upm.dit.isst.bookAdvisor.dao;

import java.util.Date;
import java.util.List;

import com.googlecode.objectify.Key;

import static com.googlecode.objectify.ObjectifyService.ofy;

import es.upm.dit.isst.bookAdvisor.model.Editorial;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.AsignacionesEditoriales;

public class AsignacionesEditorialesDAOImpl implements AsignacionesEditorialesDAO{
	private static AsignacionesEditorialesDAOImpl instancia;
	private	AsignacionesEditorialesDAOImpl () {
	}
	public static AsignacionesEditorialesDAOImpl getInstancia() {
		if (instancia == null)
			instancia= new AsignacionesEditorialesDAOImpl();
		return instancia;
	}
	@Override
	public AsignacionesEditoriales create(Libro libro, Editorial editorial, String editorialId, String formato, String idioma, int estado) {
		// TODO Auto-generated method stub
		AsignacionesEditoriales asignacionesEditoriales = new AsignacionesEditoriales(libro, editorial, editorialId, formato, idioma, estado);
		ofy().save().entity(asignacionesEditoriales).now();
		return asignacionesEditoriales;
	}

	@Override
	public List<AsignacionesEditoriales> read() {
		// TODO Auto-generated method stub
		return ofy().load().type(AsignacionesEditoriales.class).list(); 
	}

	@Override
	public List<AsignacionesEditoriales> readFormato(String formato) {
		// TODO Auto-generated method stub
		return ofy().load().type(AsignacionesEditoriales.class).filter("formato", formato).list();
	}
	
	@Override
	public List<AsignacionesEditoriales> readEditorialId(String editorialId) {
		// TODO Auto-generated method stub
		return ofy().load().type(AsignacionesEditoriales.class).filter("editorialId", editorialId).list();
	}
	
	@Override
	public List<AsignacionesEditoriales> readLibro(Libro libro) {
		// TODO Auto-generated method stub
		return ofy().load().type(AsignacionesEditoriales.class).filter("libro", libro).list();
	}

	@Override
	public List<AsignacionesEditoriales> readIdioma(String idioma) {
		// TODO Auto-generated method stub
		return ofy().load().type(AsignacionesEditoriales.class).filter("idioma", idioma).list();
	}

	@Override
	public List<AsignacionesEditoriales> readEditorial(Editorial editorial) {
		// TODO Auto-generated method stub
		return ofy().load().type(AsignacionesEditoriales.class).filter("editorial", editorial).list();
	}

	@Override
	public AsignacionesEditoriales update(AsignacionesEditoriales novedad) {
		// TODO Auto-generated method stub
		ofy().save().entity(novedad).now();
		return novedad; 
	}

	@Override
	public AsignacionesEditoriales delete(AsignacionesEditoriales asignacionesEditoriales) {
		// TODO Auto-generated method stub
		ofy().delete().entity(asignacionesEditoriales).now();
		return asignacionesEditoriales; 
	}
	@Override
	public List<AsignacionesEditoriales> readFecha(Date fecha) {
		// TODO Auto-generated method stub
		return ofy().load().type(AsignacionesEditoriales.class).filter("fecha", fecha).list();
	}
	@Override
	public AsignacionesEditoriales readID(String id) {
		// Novedad Auto-generated method stub
		
		return ofy().load().type(AsignacionesEditoriales.class).filterKey(Key.create(AsignacionesEditoriales.class,id)).first().now();
		
	}
	
	@Override
	public void deleteAll() {
		List<AsignacionesEditoriales> asignacionesEditoriales = ofy().load().type(AsignacionesEditoriales.class).list();
		for(int i=0; i<asignacionesEditoriales.size(); i++){
			AsignacionesEditoriales a = asignacionesEditoriales.get(i);
			ofy().delete().entity(a).now();
		}
	}

}