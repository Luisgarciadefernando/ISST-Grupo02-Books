package es.upm.dit.isst.bookAdvisor.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class AsignacionesBibliotecas implements Serializable{
	private static final long serialVersionUID = 01L;
	@Id
	private String id; 
	@Index 
	private String biblioteca;
	@Index 
	private String libro;
	@Index 
	private String formato;
	
	public AsignacionesBibliotecas(){
		
	}
	
	public AsignacionesBibliotecas(String biblioteca, String libro, String formato){
		this.id = java.util.UUID.randomUUID().toString();
		this.biblioteca = biblioteca;
		this.libro = libro;
		this.formato = formato;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(String biblioteca) {
		this.biblioteca = biblioteca;
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
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