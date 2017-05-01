package es.upm.dit.isst.bookAdvisor.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Autor implements Serializable {
	
	private static final long serialVersionUID = 01L;
	@Id
	private String id; 
	@Index 
	private String nombre;
			
	public Autor(){}
	
	public Autor(String nombre) {
		
		this.id = java.util.UUID.randomUUID().toString();
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
