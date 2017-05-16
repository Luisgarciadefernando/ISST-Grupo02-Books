package es.upm.dit.isst.bookAdvisor.dao;

import java.util.Date;
import java.util.List;

import com.googlecode.objectify.Key;

import static com.googlecode.objectify.ObjectifyService.ofy;

import es.upm.dit.isst.bookAdvisor.model.AsignacionesEditoriales;
import es.upm.dit.isst.bookAdvisor.model.Editorial;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.Novedad;

public class NovedadDAOImpl implements NovedadDAO{
	private static NovedadDAOImpl instancia;
	private	NovedadDAOImpl () {
	}
	public static NovedadDAOImpl getInstancia() {
		if (instancia == null)
			instancia= new NovedadDAOImpl();
		return instancia;
	}
	@Override
	public Novedad create(Libro libro, AsignacionesEditoriales asignacionesEditoriales, int estado) {
		// TODO Auto-generated method stub
		Novedad novedad = new Novedad(libro, asignacionesEditoriales, estado);
		ofy().save().entity(novedad).now();
		return novedad;
	}

	@Override
	public List<Novedad> read() {
		// TODO Auto-generated method stub
		return ofy().load().type(Novedad.class).list(); 
	}
	
	@Override
	public List<Novedad> readLibro(Libro libro) {
		// TODO Auto-generated method stub
		return ofy().load().type(Novedad.class).filter("libro", libro).list();
	}

	@Override
	public List<Novedad> readAsignacionesEditoriales(AsignacionesEditoriales asignacionesEditoriales) {
		// TODO Auto-generated method stub
		return ofy().load().type(Novedad.class).filter("asignacionesEditoriales", asignacionesEditoriales).list();
	}

	@Override
	public Novedad update(Novedad novedad) {
		// TODO Auto-generated method stub
		ofy().save().entity(novedad).now();
		return novedad; 
	}

	@Override
	public Novedad delete(Novedad novedad) {
		// TODO Auto-generated method stub
		ofy().delete().entity(novedad).now();
		return novedad; 
	}
	
	@Override
	public Novedad readID(String id) {
		// Novedad Auto-generated method stub
		
		return ofy().load().type(Novedad.class).filterKey(Key.create(Novedad.class,id)).first().now();
		
	}
	
	@Override
	public void deleteAll() {
		List<Novedad> novedades = ofy().load().type(Novedad.class).list();
		for(int i=0; i<novedades.size(); i++){
			Novedad novedad = novedades.get(i);
			ofy().delete().entity(novedad).now();
		}
	}

}