package es.upm.dit.isst.bookAdvisor.model;


import java.io.Serializable;
import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class AsignacionesEditoriales implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	String id;
	@Index
	Libro libro;
	@Index
	Editorial editorial;
	@Index
	String editorialId;
	@Index
	String formato;
	@Index
	String idioma;
	@Index
	Date fecha;
	@Index
	int estado;
	
	public AsignacionesEditoriales() {}
	
	public AsignacionesEditoriales (Libro libro, Editorial editorial, String editorialId, String formato, String idioma, int estado){
		this.id = java.util.UUID.randomUUID().toString();
		this.libro = libro;
		this.editorial = editorial;
		this.editorialId = editorialId;
		this.formato = formato;
		this.idioma = idioma;
		this.fecha = new Date();
		this.estado = estado;
	}
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getEditorialId() {
		return editorialId;
	}

	public void setEditorialId(String editorialId) {
		this.editorialId = editorialId;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
}