package es.upm.dit.isst.bookAdvisor.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.googlecode.objectify.Key;

import es.upm.dit.isst.bookAdvisor.model.Lector;
import es.upm.dit.isst.bookAdvisor.model.Libro;

public class LectorDAOImpl implements LectorDAO{
	private static LectorDAOImpl instancia;
	private LectorDAOImpl () {
	}
	public static LectorDAOImpl getInstancia() {
		if (instancia == null)
			instancia= new LectorDAOImpl();
		return instancia;
	}
	@Override
	public Lector create(String email, String nombre, String contrasena) {
		// TODO Auto-generated method stub
		Lector lector = new Lector(email, nombre, contrasena);
		ofy().save().entity(lector).now();
		return lector;
	}

	@Override
	public List<Lector> read() {
		// TODO Auto-generated method stub
		return ofy().load().type(Lector.class).list();
	}

	@Override
	public Lector readEmail(String email) {
		// TODO Auto-generated method stub
		List<Lector> lectores = ofy().load().type(Lector.class).filter("email", email).list();
		if (lectores.size()> 0){
			return lectores.get(0);
		}
		else {
			return null;
		}
	}

	@Override
	public List<Lector> readNombre(String nombre) {
		// TODO Auto-generated method stub
		return ofy().load().type(Lector.class).filter("nombre", nombre).list();
	}

	@Override
	public Lector readID(String id) {
		// TODO Auto-generated method stub
		 return ofy().load().type(Lector.class).filterKey(Key.create(Lector.class,id)).first().now();
	}

	@Override
	public Lector update(Lector lector) {
		// TODO Auto-generated method stub
		ofy().save().entity(lector).now();
		return lector; 
		
	}

	@Override
	public Lector delete(Lector lector) {
		// TODO Auto-generated method stub
		ofy().delete().entity(lector).now();
		return lector;
	}

}
