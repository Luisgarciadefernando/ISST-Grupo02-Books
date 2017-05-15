package es.upm.dit.isst.bookAdvisor.dao;

import java.util.Date;
import java.util.List;

import es.upm.dit.isst.bookAdvisor.model.Editorial;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.Novedad;

public interface NovedadDAO {
	public Novedad create(Libro libro, Editorial editorial, String formato, String idioma, Date fecha, int estado);
	public List<Novedad> readLibro(Libro libro);
	public List<Novedad> read();
	public List<Novedad> readEditorial(Editorial editorial);
	public List<Novedad> readFormato(String formato);
	public List<Novedad> readIdioma(String idioma);
	public List<Novedad> readFecha(Date fecha);
	public Novedad readID(String id);
	public Novedad update(Novedad novedad);
	public Novedad delete(Novedad novedad);
	public void deleteAll();
	
}