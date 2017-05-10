package es.upm.dit.isst.bookAdvisor.dao;

import java.util.List;
import static com.googlecode.objectify.ObjectifyService.ofy;
import java.util.List;
import com.googlecode.objectify.Key;

import es.upm.dit.isst.bookAdvisor.model.Biblioteca;
import es.upm.dit.isst.bookAdvisor.model.Libreria;
import es.upm.dit.isst.bookAdvisor.model.Libro;

public class LibreriaDAOImpl implements LibreriaDAO{
	private static LibreriaDAOImpl instancia;
	
	private LibreriaDAOImpl () {
	}
	public static LibreriaDAOImpl getInstancia() {
		if (instancia == null)
			instancia= new LibreriaDAOImpl();
		return instancia;
	}

	@Override
	public Libreria create(String nombre, String localizacion, String url, String email, String descripcion, String contrasena, String imagen, boolean confirmado) {
		Libreria libreria = new Libreria(nombre, localizacion, url, email, descripcion, contrasena, imagen, confirmado);
		ofy().save().entity(libreria).now();
		return libreria;
	}

	@Override
	public Libreria readNombre(String nombre) {
		if (nombre != null || nombre != "") {
			Libreria libreria = ofy().load().type(Libreria.class).filterKey(Key.create(Libreria.class, nombre)).first().now();
			return libreria;
		}
		return null;
	}

	@Override
	public List<Libreria> read() {
		List<Libreria> librerias = ofy().load().type(Libreria.class).list();
		return librerias;
	}

	@Override
	public List<Libreria> readLocalizacion(String localizacion) {
		if (localizacion == null || localizacion == "") {
			return null;
		}
		List<Libreria> librerias = ofy().load().type(Libreria.class).filter("localizacion", localizacion).list();
		return librerias;
	}

	@Override
	public List<Libreria> readUrl(String url) {
		if (url == null || url == "") {
			return null;
		}
		List<Libreria> librerias = ofy().load().type(Libreria.class).filter("url", url).list();
		return librerias;
	}
	
	@Override
	public List<Libreria> readConfirmado(boolean confirmado) {
		List<Libreria> librerias = ofy().load().type(Libreria.class).filter("confirmado", confirmado).list();
		return librerias;
	}

	@Override
	public Libreria readEmail(String email) {
		List<Libreria> librerias = ofy().load().type(Libreria.class).filter("email", email).list();
		if(librerias.size()>0){
			return librerias.get(0);
		}
		else {
			return null;

		}
	}
	
	@Override
	public List<Libreria> readDescripcion(String descripcion) {
		if (descripcion == null || descripcion == "") {
			return null;
		}
		List<Libreria> librerias = ofy().load().type(Libreria.class).filter("descripcion", descripcion).list();
		return librerias;
	}

	@Override
	public Libreria readId(String id) {
		// TODO Auto-generated method stub
		return ofy().load().type(Libreria.class).filterKey(Key.create(Libreria.class,id)).first().now();
	}
	@Override
	public Libreria update(Libreria libreria) {
		ofy().save().entity(libreria).now();
		return libreria;
	}

	@Override
	public Libreria delete(Libreria libreria) {
		ofy().delete().entity(libreria).now();
		return libreria;
	}

	@Override
	public void deleteAll() {
		List<Libreria> librerias = ofy().load().type(Libreria.class).list();
		for(int i=0; i<librerias.size(); i++){
			Libreria libreria = librerias.get(i);
			ofy().delete().entity(libreria).now();
		}
	}

}
