package es.upm.dit.isst.bookAdvisor.dao;

import java.util.List;

import es.upm.dit.isst.bookAdvisor.model.IntercambioTienen;


public interface IntercambioTienenDAO {

		public List<IntercambioTienen> read();
		public IntercambioTienen create(String libro, String usuario);
		public List<IntercambioTienen> readLibro(String libro);
		public List <IntercambioTienen> readUsuario(String usuario);
		public IntercambioTienen readId(String id);
		public IntercambioTienen update(IntercambioTienen intercambioTienen);
		public IntercambioTienen delete(IntercambioTienen intercambioTienen);
}
