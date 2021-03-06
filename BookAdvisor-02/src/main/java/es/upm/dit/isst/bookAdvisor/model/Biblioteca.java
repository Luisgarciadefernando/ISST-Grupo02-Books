package es.upm.dit.isst.bookAdvisor.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Biblioteca implements Serializable {
	private static final long serialVersionUID = 01L;
	@Id
	private String id; 
	@Index 
	private String nombre;
	@Index 
	private String localizacion;
	@Index 
	private String url;
	@Index 
	private String email;
	@Index 
	private String descripcion;
	private String imagen;
	private String contrasena;
	@Index
	private boolean confirmado;
	
	public Biblioteca(){}
	public Biblioteca(String nombre, String localizacion, String url, String email, String descripcion, String contrasena, String imagen, boolean confirmado) {
		this.nombre = nombre;
		this.localizacion = localizacion;
		this.url = url;
		this.email = email;
		this.descripcion = descripcion;
		this.contrasena = contrasena;
		this.imagen = imagen;
		this.confirmado = confirmado;
		this.id = java.util.UUID.randomUUID().toString();
	}
	
	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}
	public boolean getConfirmado() {
		return confirmado;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.imagen = descripcion;
	}
	
}