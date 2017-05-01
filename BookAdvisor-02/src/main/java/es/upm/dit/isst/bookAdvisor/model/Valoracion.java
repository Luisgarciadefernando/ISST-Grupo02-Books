package es.upm.dit.isst.bookAdvisor.model;

import java.io.Serializable;
import java.util.Date;

import com.googlecode.objectify.annotation.*;

@Entity
public class Valoracion implements Serializable{

	@Id
	String id;
	@Index
	double valoracion;
	@Index
	String comentario;
	@Index
	String lector;
	@Index
	String libro;
	@Index
	Date fecha;
	@Index
	int estado;
	@Index
	String lectorNombre;
	
	

	public Valoracion(){}
	
	public Valoracion(double valoracion, String comentario, String lector, String libro, int estado, String lectorNombre){
		this.id = java.util.UUID.randomUUID().toString();
		this.valoracion = valoracion;
		this.comentario = comentario;
		this.lector = lector;
		this.libro = libro;
		this.estado = estado;
		this.lectorNombre = lectorNombre;
	}

	public int getEstado() {
		return estado;
	}
	public String getLectorNombre() {
		return lectorNombre;
	}

	public void setLectorNombre(String lectorNombre) {
		this.lectorNombre = lectorNombre;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getLector() {
		return lector;
	}

	public void setLector(String lector) {
		this.lector = lector;
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
