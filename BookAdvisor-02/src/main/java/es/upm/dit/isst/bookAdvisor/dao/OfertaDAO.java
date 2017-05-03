package es.upm.dit.isst.bookAdvisor.dao;

import java.util.Date;
import java.util.List;

import es.upm.dit.isst.bookAdvisor.model.Libreria;
import es.upm.dit.isst.bookAdvisor.model.Oferta;

public interface OfertaDAO {
	public Oferta create(int descuento, String cupon, Libreria libreria, String titulo, String descripcion, String caducidad, int estado);
	public List<Oferta> readDescuento(int descuento);
	public List<Oferta> read();
	public List<Oferta> readLibreria(Libreria libreria);
	public List<Oferta> readTitulo(String Titulo);
	public List<Oferta> readDescripcion(String descripcion);
	public List<Oferta> readCaducidad(Date caducidad);
	public Oferta readID(String id);
	public Oferta update(Oferta oferta);
	public Oferta delete(Oferta oferta);
	public void deleteAll();
	
}
