package es.upm.dit.isst.bookAdvisor.dao;

import java.util.Date;
import java.util.List;

import com.googlecode.objectify.Key;

import static com.googlecode.objectify.ObjectifyService.ofy;

import es.upm.dit.isst.bookAdvisor.model.Libreria;
import es.upm.dit.isst.bookAdvisor.model.Oferta;

public class OfertaDAOImpl implements OfertaDAO{
	private static OfertaDAOImpl instancia;
	private	OfertaDAOImpl () {
	}
	public static OfertaDAOImpl getInstancia() {
		if (instancia == null)
			instancia= new OfertaDAOImpl();
		return instancia;
	}
	@Override
	public Oferta create(int descuento, String cupon, Libreria libreria, String titulo, String descripcion, String caducidad) {
		// TODO Auto-generated method stub
		Oferta oferta = new Oferta(descuento, cupon, libreria, titulo, descripcion, caducidad);
		ofy().save().entity(oferta).now();
		return oferta;
	}

	@Override
	public List<Oferta> read() {
		// TODO Auto-generated method stub
		return ofy().load().type(Oferta.class).list(); 
	}

	@Override
	public List<Oferta> readTitulo(String titulo) {
		// TODO Auto-generated method stub
		return ofy().load().type(Oferta.class).filter("titulo", titulo).list();
	}
	@Override
	public List<Oferta> readDescuento(int descuento) {
		// TODO Auto-generated method stub
		return ofy().load().type(Oferta.class).filter("descuento", descuento).list();
	}

	@Override
	public List<Oferta> readDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return ofy().load().type(Oferta.class).filter("descripcion", descripcion).list();
	}

	@Override
	public List<Oferta> readLibreria(Libreria libreria) {
		// TODO Auto-generated method stub
		return ofy().load().type(Oferta.class).filter("libreria", libreria).list();
	}

	@Override
	public Oferta update(Oferta oferta) {
		// TODO Auto-generated method stub
		ofy().save().entity(oferta).now();
		return oferta; 
	}

	@Override
	public Oferta delete(Oferta oferta) {
		// TODO Auto-generated method stub
		ofy().delete().entity(oferta).now();
		return oferta; 
	}
	@Override
	public List<Oferta> readCaducidad(Date caducidad) {
		// TODO Auto-generated method stub
		return ofy().load().type(Oferta.class).filter("caducidad", caducidad).list();
	}
	@Override
	public Oferta readID(String id) {
		// TODO Auto-generated method stub
		
		return ofy().load().type(Oferta.class).filterKey(Key.create(Oferta.class,id)).first().now();
		
	}
	
	@Override
	public void deleteAll() {
		List<Oferta> ofertas = ofy().load().type(Oferta.class).list();
		for(int i=0; i<ofertas.size(); i++){
			Oferta oferta = ofertas.get(i);
			ofy().delete().entity(oferta).now();
		}
	}

}