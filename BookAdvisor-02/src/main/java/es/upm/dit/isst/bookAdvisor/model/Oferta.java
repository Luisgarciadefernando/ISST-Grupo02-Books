package es.upm.dit.isst.bookAdvisor.model;


import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Oferta implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	String id;
	@Index
	int descuento;
	@Index
	String cupon;
	@Index
	Libreria libreria;
	@Index
	String titulo;
	@Index
	String descripcion;
	@Index
	String caducidad;
	@Index
	int estado;
	
	public Oferta() {}
	
	public Oferta (int descuento, String cupon, Libreria libreria, String titulo, String descripcion, String caducidad, int estado){
		this.id = java.util.UUID.randomUUID().toString();
		this.descuento = descuento;
		this.cupon = cupon;
		this.libreria = libreria;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.caducidad = caducidad;
		this.estado = estado;
	}
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public String getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}
	
	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public String getId() {
		return id;
	}
	
	
	public String getCupon() {
		return cupon;
	}

	public void setCupon(String cupon) {
		this.cupon = cupon;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Libreria getLibreria() {
		return libreria;
	}

	public void setLibreria(Libreria libreria) {
		this.libreria = libreria;
	}
	
}
