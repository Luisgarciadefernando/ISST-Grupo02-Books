package es.upm.dit.isst.bookAdvisor.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class AsignacionesLibrerias implements Serializable{
	private static final long serialVersionUID = 01L;
	@Id
	private String id; 
	@Index 
	private String libreria;
	@Index 
	private String libro;
	@Index 
	private double precio;
	@Index 
	private String formato;
	
	public AsignacionesLibrerias(){
		
	}
	
	public AsignacionesLibrerias(String libreria, String libro, double precio, String formato){
		this.id = java.util.UUID.randomUUID().toString();
		this.libreria = libreria;
		this.libro = libro;
		this.precio = precio;
		this.formato = formato;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLibreria() {
		return libreria;
	}

	public void setLibreria(String libreria) {
		this.libreria = libreria;
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
