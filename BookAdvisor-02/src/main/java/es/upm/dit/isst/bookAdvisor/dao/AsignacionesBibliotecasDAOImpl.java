package es.upm.dit.isst.bookAdvisor.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;
import java.util.List;
import com.googlecode.objectify.Key;

import es.upm.dit.isst.bookAdvisor.model.AsignacionesBibliotecas;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.Valoracion;

public class AsignacionesBibliotecasDAOImpl implements AsignacionesBibliotecasDAO {
	private static AsignacionesBibliotecasDAOImpl instancia;
	private AsignacionesBibliotecasDAOImpl () {
	}
	public static AsignacionesBibliotecasDAOImpl getInstancia() {
		if (instancia == null)
			instancia= new AsignacionesBibliotecasDAOImpl();
		return instancia;
	}
	
	@Override
	public AsignacionesBibliotecas create(String biblioteca, String libro, String formato) {
		AsignacionesBibliotecas a = new AsignacionesBibliotecas(biblioteca, libro, formato);
		ofy().save().entity(a).now();
		return a;
	}

	@Override
	public List<AsignacionesBibliotecas> read() {
		return ofy().load().type(AsignacionesBibliotecas.class).list();
	}

	@Override
	public List<AsignacionesBibliotecas> readBiblioteca(String biblioteca) {
		return ofy().load().type(AsignacionesBibliotecas.class).filter("biblioteca", biblioteca).list();
	}

	@Override
	public List<AsignacionesBibliotecas> readLibro(String libro) {
		return ofy().load().type(AsignacionesBibliotecas.class).filter("libro", libro).list();
	}

	@Override
	public List<AsignacionesBibliotecas> readFormato(String formato) {
		return ofy().load().type(AsignacionesBibliotecas.class).filter("formato", formato).list();
	}

	@Override
	public AsignacionesBibliotecas readID(String id) {
		return ofy().load().type(AsignacionesBibliotecas.class).filterKey(Key.create(AsignacionesBibliotecas.class,id)).first().now();
	}

	@Override
	public AsignacionesBibliotecas delete(AsignacionesBibliotecas a) {
		ofy().delete().entity(a).now();
		return a;
	}

	@Override
	public AsignacionesBibliotecas update(AsignacionesBibliotecas a) {
		ofy().save().entity(a).now();
		return a;
	}
	

}
