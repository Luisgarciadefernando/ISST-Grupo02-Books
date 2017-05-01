package es.upm.dit.isst.bookAdvisor.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Lector implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	@Index
	private String email;
	@Index
	private String nombre;
	@Index
	private String contrasena;
	public Lector(){}

	public Lector(String email, String nombre, String contrasena){
		this.id = java.util.UUID.randomUUID().toString();
		this.email = email;
		this.nombre = nombre;
		this. contrasena = contrasena;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
