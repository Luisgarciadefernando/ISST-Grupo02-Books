package es.upm.dit.isst.bookAdvisor.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import java.io.Serializable;

@Entity
public class IntercambioTienen {
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 01L;
	@Id
	private String id; 
	@Index 
	private String libro;
	@Index
	private String usuario; 
	
	public IntercambioTienen(){}
	
	public IntercambioTienen(String libro, String usuario){
		this.id = java.util.UUID.randomUUID().toString();
		this.libro = libro;
		this.usuario = usuario;
	}
}
