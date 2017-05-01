package es.upm.dit.isst.bookAdvisor.dao;

import java.util.List;

import com.googlecode.objectify.Key;

import static com.googlecode.objectify.ObjectifyService.ofy;

import es.upm.dit.isst.bookAdvisor.model.Libro;

public class LibroDAOImpl implements LibroDAO{
	private static LibroDAOImpl instancia;
	private	LibroDAOImpl () {
	}
	public static LibroDAOImpl getInstancia() {
		if (instancia == null)
			instancia= new LibroDAOImpl();
		return instancia;
	}
	@Override
	public Libro create(String titulo, String resumen, String genero, String autor, int estado, String imagen) {
		// TODO Auto-generated method stub
		Libro libro = new Libro(titulo, resumen, genero, autor, estado, imagen);
		ofy().save().entity(libro).now();
		return libro;
	}

	@Override
	public List<Libro> read() {
		// TODO Auto-generated method stub
		return ofy().load().type(Libro.class).list(); 
	}

	@Override
	public List<Libro> readTitulo(String titulo) {
		// TODO Auto-generated method stub
		return ofy().load().type(Libro.class).filter("titulo", titulo).list();
	}

	@Override
	public List<Libro> readGenero(String genero) {
		// TODO Auto-generated method stub
		return ofy().load().type(Libro.class).filter("genero", genero).list();
	}

	@Override
	public List<Libro> readEstado(int estado) {
		// TODO Auto-generated method stub
		return ofy().load().type(Libro.class).filter("estado", estado).list();
	}

	@Override
	public Libro update(Libro libro) {
		// TODO Auto-generated method stub
		ofy().save().entity(libro).now();
		return libro; 
	}

	@Override
	public Libro delete(Libro libro) {
		// TODO Auto-generated method stub
		ofy().delete().entity(libro).now();
		return libro; 
	}
	@Override
	public List<Libro> readAutor(String autor) {
		// TODO Auto-generated method stub
		return ofy().load().type(Libro.class).filter("autor", autor).list();
	}
	@Override
	public Libro readID(String id) {
		// TODO Auto-generated method stub
		
		return ofy().load().type(Libro.class).filterKey(Key.create(Libro.class,id)).first().now();
		
	}

}
