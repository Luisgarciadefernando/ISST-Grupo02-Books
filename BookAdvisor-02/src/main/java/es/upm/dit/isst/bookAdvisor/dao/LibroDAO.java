package es.upm.dit.isst.bookAdvisor.dao;

import java.util.List;

import es.upm.dit.isst.bookAdvisor.model.Libro;

public interface LibroDAO {
	public Libro create(String titulo, String resumen, String genero, String autor,String traductor,int isbn, int estado, String imagen);
	public List<Libro> readAutor(String autor);
	public List<Libro> readTraductor(String traductor);
	public List<Libro> read();
	public List<Libro> readTitulo(String titulo);
	public List<Libro> readGenero(String genero);
	public List<Libro> readEstado(int estado);
	public List<Libro> readIsbn(int isbn);
	public Libro readID(String id);
	public Libro update(Libro libro);
	public Libro delete(Libro libro);
	
}
