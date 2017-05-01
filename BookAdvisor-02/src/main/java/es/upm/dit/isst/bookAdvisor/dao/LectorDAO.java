package es.upm.dit.isst.bookAdvisor.dao;

import java.util.List;

import es.upm.dit.isst.bookAdvisor.model.Lector;

public interface LectorDAO {
	
	public Lector create(String email, String nombre, String contrasena);
	public List<Lector> read();
	public Lector readEmail(String email);
	public List<Lector> readNombre(String nombre);
	public Lector readID(String id);
	public Lector update(Lector lector);
	public Lector delete(Lector lector);
}
