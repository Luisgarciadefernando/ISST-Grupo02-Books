package es.upm.dit.isst.bookAdvisor.dao;

import java.util.List;
import com.googlecode.objectify.Key;

import static com.googlecode.objectify.ObjectifyService.ofy;

import es.upm.dit.isst.bookAdvisor.model.Lector;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.Valoracion;

public class ValoracionDAOImpl implements ValoracionDAO {

	private static ValoracionDAOImpl instancia;
	private	ValoracionDAOImpl () {
	}
	public static ValoracionDAOImpl getInstancia() {
		if (instancia == null)
			instancia= new ValoracionDAOImpl();
		return instancia;
	}
	
	@Override
	public Valoracion create(double valoracion, String comentario, String lector, String libro, int estado, String lectorNombre) {
		// TODO Auto-generated method stub
		Valoracion val = new Valoracion(valoracion, comentario, lector, libro, estado, lectorNombre);
		ofy().save().entity(val).now();
		return null;
	}

	@Override
	public List<Valoracion> read() {
		// TODO Auto-generated method stub
		return ofy().load().type(Valoracion.class).list(); 
	}

	@Override
	public List<Valoracion> readLector(String lector) {
		// TODO Auto-generated method stub
		return ofy().load().type(Valoracion.class).filter("lector", lector).list();
		

	}

	
	@Override
	public List<Valoracion> readLibro(String libro) {
		// TODO Auto-generated method stub
		return ofy().load().type(Valoracion.class).filter("libro", libro).list();
	}

	@Override
	public Valoracion readID(String id) {
		// TODO Auto-generated method stub
		return ofy().load().type(Valoracion.class).filterKey(Key.create(Libro.class,id)).first().now();
	}

	@Override
	public Valoracion update(Valoracion valoracion) {
		// TODO Auto-generated method stub
		ofy().save().entity(valoracion).now();
		return valoracion; 
	}

	@Override
	public Valoracion delete(Valoracion valoracion) {
		// TODO Auto-generated method stub
		ofy().delete().entity(valoracion).now();
		return valoracion;
	}

}
