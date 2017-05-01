package es.upm.dit.isst.bookAdvisor.dao;

import java.util.List;

import es.upm.dit.isst.bookAdvisor.model.AsignacionesLibrerias;

public interface AsignacionesLibreriasDAO {
	
	public AsignacionesLibrerias create(String libreria, String libro, double precio, String formato);
	public List<AsignacionesLibrerias> read();
	public List<AsignacionesLibrerias> readLibreria(String libreria);
	public List<AsignacionesLibrerias> readLibro(String libro);
	public List<AsignacionesLibrerias> readFormato(String formato);
	public AsignacionesLibrerias readID(String id);
	public AsignacionesLibrerias delete(AsignacionesLibrerias a);
	public AsignacionesLibrerias update(AsignacionesLibrerias a);
	
}
