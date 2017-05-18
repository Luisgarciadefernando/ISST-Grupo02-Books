package es.upm.dit.isst.bookAdvisor.dao;

import java.util.Date;
import java.util.List;

import es.upm.dit.isst.bookAdvisor.model.Biblioteca;
import es.upm.dit.isst.bookAdvisor.model.BookCrossing;

public interface BookCrossingDAO {
	
	public BookCrossing create(String lector, String libro,String direccion, String informacion, boolean encontrado, Date fecha);
	public BookCrossing readId(String Id);
	public List<BookCrossing> read();
	public List<BookCrossing> readLector(String lector);
	public List<BookCrossing> readLibro(String libro);
	public List<BookCrossing> readEncontrado(boolean encontrado);
	public BookCrossing delete(BookCrossing bookcrossing);
	public BookCrossing update (BookCrossing bookcrossing);
	public List<BookCrossing> readDireccion(String direccion);


}

