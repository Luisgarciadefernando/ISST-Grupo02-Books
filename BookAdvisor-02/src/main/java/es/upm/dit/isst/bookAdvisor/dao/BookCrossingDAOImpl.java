package es.upm.dit.isst.bookAdvisor.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.Date;
import java.util.List;

import com.googlecode.objectify.Key;

import es.upm.dit.isst.bookAdvisor.model.BookCrossing;
import es.upm.dit.isst.bookAdvisor.model.Libreria;
import es.upm.dit.isst.bookAdvisor.model.Oferta;

public class BookCrossingDAOImpl implements BookCrossingDAO{
	public static BookCrossingDAOImpl instancia;
	private BookCrossingDAOImpl(){
	
	}
	public static BookCrossingDAOImpl getInstancia(){
		if(instancia==null)
			instancia = new BookCrossingDAOImpl();
		return instancia;
	}
	
	@Override
	public BookCrossing create(String lector, String libro,String informacion, String direccion, boolean encontrado, Date fecha) {
		// TODO Auto-generated method stub
		BookCrossing b = new BookCrossing(lector,libro,direccion, informacion,encontrado,fecha);
		ofy().save().entity(b).now();
		return b;
	}

	@Override
	public List<BookCrossing> read() {
		// TODO Auto-generated method stub
		return ofy().load().type(BookCrossing.class).list(); 
	}
	@Override
	public BookCrossing readId(String Id) {
		// TODO Auto-generated method stub
		return ofy().load().type(BookCrossing.class).filterKey(Key.create(BookCrossing.class,Id)).first().now();
	}

	@Override
	public List<BookCrossing> readLector(String lector) {
		// TODO Auto-generated method stub
		return ofy().load().type(BookCrossing.class).filter("lector", lector).list();
	}

	@Override
	public List<BookCrossing> readLibro(String libro) {
		// TODO Auto-generated method stub
		 return ofy().load().type(BookCrossing.class).filter("libro", libro).list();
	}

	@Override
	public List<BookCrossing> readEncontrado(boolean encontrado) {
		// TODO Auto-generated method stub
		return ofy().load().type(BookCrossing.class).filter("encontrado", encontrado).list();
	}

	@Override
	public BookCrossing delete(BookCrossing bookcrossing) {
		// TODO Auto-generated method stub
		ofy().delete().entity(bookcrossing).now();
		return bookcrossing;
	}

	@Override
	public BookCrossing update(BookCrossing bookcrossing) {
		// TODO Auto-generated method stub
		ofy().save().entity(bookcrossing).now();
		return bookcrossing;
	}

}
