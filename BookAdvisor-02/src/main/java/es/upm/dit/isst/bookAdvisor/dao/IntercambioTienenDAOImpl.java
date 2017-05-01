package es.upm.dit.isst.bookAdvisor.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.googlecode.objectify.Key;

import es.upm.dit.isst.bookAdvisor.model.IntercambioTienen;
import es.upm.dit.isst.bookAdvisor.model.Lector;
import es.upm.dit.isst.bookAdvisor.model.Libro;

public class IntercambioTienenDAOImpl implements IntercambioTienenDAO{
	private static IntercambioTienenDAOImpl instancia;
	private IntercambioTienenDAOImpl () {
	}
	public static IntercambioTienenDAOImpl getInstancia() {
		if (instancia == null)
			instancia= new IntercambioTienenDAOImpl();
		return instancia;
	}
	@Override
	public List<IntercambioTienen> read() {
		// TODO Auto-generated method stub
		
		return ofy().load().type(IntercambioTienen.class).list();
	}

	@Override
	public IntercambioTienen create(String libro, String usuario) {
		// TODO Auto-generated method sub
		IntercambioTienen intercambio = new IntercambioTienen(libro, usuario);
		ofy().save().entity(intercambio).now();
		return intercambio;
	}

	@Override
	public List<IntercambioTienen> readLibro(String libro) {
		// TODO Auto-generated method stub
		return ofy().load().type(IntercambioTienen.class).filter("libro", libro).list();
	}

	@Override
	public List<IntercambioTienen> readUsuario(String usuario) {
		// TODO Auto-generated method stub
		return ofy().load().type(IntercambioTienen.class).filter("usuario", usuario).list();
	}

	@Override
	public IntercambioTienen readId(String id) {
		// TODO Auto-generated method stub
		return ofy().load().type(IntercambioTienen.class).filterKey(Key.create(IntercambioTienen.class,id)).first().now();
	}

	@Override
	public IntercambioTienen update(IntercambioTienen intercambioTienen) {
		// TODO Auto-generated method stub
		ofy().save().entity(intercambioTienen).now();
		return intercambioTienen;
	}

	@Override
	public IntercambioTienen delete(IntercambioTienen intercambioTienen) {
		// TODO Auto-generated method stub
		ofy().delete().entity(intercambioTienen).now();
		return intercambioTienen;
	}

}
