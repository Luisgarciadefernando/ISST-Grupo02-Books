package es.upm.dit.isst.bookAdvisor.model;


import java.io.Serializable;
import java.util.Date;

import com.googlecode.objectify.annotation.*;

@Entity
public class Libro implements Serializable{

	@Id
	String id;
	@Index
	String titulo;
	@Index
	String resumen;
	@Index
	String genero;
	@Index
	String autor;
	@Index
	String traductor;
	@Index
	int isbn;
	@Index
	int estado;
	String imagen;
	@Index
	double valoracion;
	@Index
	Date fecha;
	@Index
	int vecesValorado;
	
	public Libro() {}
	
	public Libro (String titulo, String resumen, String genero, String autor, String traductor, int isbn, int estado, String imagen){
		this.id = java.util.UUID.randomUUID().toString();
		this.resumen = resumen;
		this.genero = genero;
		this.titulo = titulo;
		this.autor = autor;
		this.traductor = traductor;
		this.isbn = isbn;
		this.estado = estado;
		this.imagen = imagen;
		this.valoracion = 0;
		this.vecesValorado = 0;
		this.fecha = new Date();
	}

	public Date getFecha() {
		return fecha;
	}
	
	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	public String getId() {
		return id;
	}
	
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getTraductor() {
		return traductor;
	}

	public void setTraductor(String traductor) {
		this.traductor = traductor;
	}
	
	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getVecesValorado() {
		return vecesValorado;
	}

	public void setVecesValorado(int vecesValorado) {
		this.vecesValorado = vecesValorado;
	}
	
	
	
}
