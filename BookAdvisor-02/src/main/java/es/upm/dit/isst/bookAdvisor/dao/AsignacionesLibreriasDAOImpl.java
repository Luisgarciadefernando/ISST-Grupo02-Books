package es.upm.dit.isst.bookAdvisor.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.googlecode.objectify.Key;

import es.upm.dit.isst.bookAdvisor.model.AsignacionesLibrerias;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.Valoracion;

public class AsignacionesLibreriasDAOImpl implements AsignacionesLibreriasDAO{
	private static AsignacionesLibreriasDAOImpl instancia;
	private AsignacionesLibreriasDAOImpl () {
	}
	public static AsignacionesLibreriasDAOImpl getInstancia() {
		if (instancia == null)
			instancia= new AsignacionesLibreriasDAOImpl();
		return instancia;
	}
	@Override
	public AsignacionesLibrerias create(String libreria, String libro, double precio, String formato) {
		// TODO Auto-generated method stub
		AsignacionesLibrerias a = new AsignacionesLibrerias(libreria, libro, precio, formato);
		ofy().save().entity(a).now();
		return a;
	}

	@Override
	public List<AsignacionesLibrerias> read() {
		// TODO Auto-generated method stub
		return ofy().load().type(AsignacionesLibrerias.class).list();
	}

	@Override
	public List<AsignacionesLibrerias> readLibreria(String libreria) {
		// TODO Auto-generated method stub
		return ofy().load().type(AsignacionesLibrerias.class).filter("libreria", libreria).list();

	}

	@Override
	public List<AsignacionesLibrerias> readLibro(String libro) {
		// TODO Auto-generated method stub
		return ofy().load().type(AsignacionesLibrerias.class).filter("libro", libro).list();
	}

	@Override
	public List<AsignacionesLibrerias> readFormato(String formato) {
		// TODO Auto-generated method stub
		return ofy().load().type(AsignacionesLibrerias.class).filter("formato", formato).list();

	}

	@Override
	public AsignacionesLibrerias readID(String id) {
		// TODO Auto-generated method stub
		return ofy().load().type(AsignacionesLibrerias.class).filterKey(Key.create(AsignacionesLibrerias.class,id)).first().now();

	}

	@Override
	public AsignacionesLibrerias delete(AsignacionesLibrerias a) {
		// TODO Auto-generated method stub
		ofy().delete().entity(a).now();
		return a;
	}

	@Override
	public AsignacionesLibrerias update(AsignacionesLibrerias a) {
		// TODO Auto-generated method stub
		ofy().save().entity(a).now();
		return a;
	}

}
