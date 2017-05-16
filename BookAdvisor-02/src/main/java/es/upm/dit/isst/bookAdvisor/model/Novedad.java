package es.upm.dit.isst.bookAdvisor.model;


import java.io.Serializable;
import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import es.upm.dit.isst.bookAdvisor.model.AsignacionesEditoriales;

@Entity
public class Novedad implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	String id;
	@Index
	Libro libro;
	@Index
	AsignacionesEditoriales asignacionesEditoriales;
	@Index
	int estado;
	
	public Novedad() {}
	
	public Novedad (Libro libro, AsignacionesEditoriales asignacionesEditoriales, int estado){
		this.id = java.util.UUID.randomUUID().toString();
		this.libro = libro;
		this.asignacionesEditoriales = asignacionesEditoriales;
		this.estado = estado;
	}
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public String getId() {
		return id;
	}
	
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AsignacionesEditoriales getAsignacionesEditoriales() {
		return asignacionesEditoriales;
	}

	public void setAsignacionesEditoriales(AsignacionesEditoriales asignacionesEditoriales) {
		this.asignacionesEditoriales = asignacionesEditoriales;
	}
	
}