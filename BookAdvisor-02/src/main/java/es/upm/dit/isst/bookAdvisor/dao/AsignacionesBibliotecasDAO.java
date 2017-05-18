package es.upm.dit.isst.bookAdvisor.dao;

import java.util.List;

import es.upm.dit.isst.bookAdvisor.model.AsignacionesBibliotecas;

public interface AsignacionesBibliotecasDAO {
	
	public AsignacionesBibliotecas create(String biblioteca, String libro, String formato);
	public List<AsignacionesBibliotecas> read();
	public List<AsignacionesBibliotecas> readBiblioteca(String biblioteca);
	public List<AsignacionesBibliotecas> readLibro(String libro);
	public List<AsignacionesBibliotecas> readFormato(String formato);
	public AsignacionesBibliotecas readID(String id);
	public AsignacionesBibliotecas delete(AsignacionesBibliotecas a);
	public AsignacionesBibliotecas update(AsignacionesBibliotecas a);

}
