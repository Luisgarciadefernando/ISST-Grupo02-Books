package es.upm.dit.isst.bookAdvisor.dao;


import java.util.List;

import es.upm.dit.isst.bookAdvisor.model.Libreria;

public interface LibreriaDAO {

		public Libreria create(String nombre, String localizacion, String url, String email, String descripcion, String contrasena, String imagen, boolean confirmado);
		public Libreria readNombre(String nombre);
		public List<Libreria> read();
		public Libreria readId(String id);
		public List<Libreria> readLocalizacion(String localizacion);
		public List<Libreria> readUrl(String url);
		public Libreria readEmail(String email);
		public List<Libreria> readConfirmado(boolean confirmado);
		public List<Libreria> readDescripcion(String descripcion);
		public Libreria update(Libreria libreria);
		public Libreria delete(Libreria libreria);
		public void deleteAll();
}
