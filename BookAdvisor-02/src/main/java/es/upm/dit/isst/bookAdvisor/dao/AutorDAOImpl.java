package es.upm.dit.isst.bookAdvisor.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.googlecode.objectify.Key;

import es.upm.dit.isst.bookAdvisor.model.AsignacionesLibrerias;
import es.upm.dit.isst.bookAdvisor.model.Autor;
import es.upm.dit.isst.bookAdvisor.model.Editorial;

public class AutorDAOImpl implements AutorDAO {
	
	private static AutorDAOImpl instancia;
	
	private AutorDAOImpl () {
	}
	public static AutorDAOImpl getInstancia() {
		if (instancia == null)
			instancia= new AutorDAOImpl();
		return instancia;
	}

	@Override
	public Autor readId(String id) {
		// TODO Auto-generated method stub
		return ofy().load().type(Autor.class).filterKey(Key.create(Autor.class,id)).first().now();

	}

	@Override
	public Autor create(String nombre) {
		
		Autor autor = new Autor(nombre);
		ofy().save().entity(autor).now();
		return autor;
	}

	@Override
	public List<Autor> read() {
		
		return ofy().load().type(Autor.class).list();
	}

	@Override
	public List<Autor> readNombre(String nombre) {
		
		return ofy().load().type(Autor.class).filter("nombre", nombre).list();
	}

	@Override
	public Autor update(Autor autor) {
		
		ofy().save().entity(autor).now();
		return autor; 
	}

	@Override
	public Autor delete(Autor autor) {
		
		ofy().delete().entity(autor).now();
		return autor;
	}

	@Override
	public void deleteAll() {
		
		List<Autor> autores = ofy().load().type(Autor.class).list();
		for(Autor autor: autores){
			ofy().delete().entity(autor).now();
		}
	}	
}
