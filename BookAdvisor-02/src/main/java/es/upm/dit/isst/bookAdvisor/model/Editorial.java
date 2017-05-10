package es.upm.dit.isst.bookAdvisor.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Editorial implements Serializable {

	private static final long serialVersionUID = 01L;
	@Id
	private String id; 
	@Index 
	private String nombre;
	@Index 
	private String email;
	@Index
	private String contrasena;
	@Index
	private boolean confirmado;
	private String imagen;
	
	public Editorial(){}

	public Editorial(String nombre, String email, String contrasena, boolean confirmado, String imagen) {
		this.id = java.util.UUID.randomUUID().toString();
		this.nombre = nombre;
		this.email = email;
		this.confirmado = confirmado;
		this.contrasena = contrasena;
		this.imagen = imagen;
	}

	public String getId() {
		return id;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}
	public boolean getConfirmado() {
		return confirmado;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}