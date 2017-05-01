package es.upm.dit.isst.bookAdvisor.dao;

import java.util.List;

import es.upm.dit.isst.bookAdvisor.model.Valoracion;

public interface ValoracionDAO {
	
	public Valoracion create(double valoracion, String comentario, String lector, String libro, int estado, String lectorNombre);
	public List<Valoracion> read();
	public List<Valoracion> readLector(String lector);
	public List<Valoracion> readLibro(String libro);
	public Valoracion readID(String id);
	public Valoracion update(Valoracion valoracion);
	public Valoracion delete(Valoracion valoracion);

}
