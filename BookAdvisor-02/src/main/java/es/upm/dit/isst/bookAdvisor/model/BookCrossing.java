package es.upm.dit.isst.bookAdvisor.model;

import java.io.Serializable;
import java.util.Date;

import com.googlecode.objectify.annotation.*;

@Entity
public class BookCrossing implements Serializable{
	private static final long serialVersionUID = 01L;
	@Id
	private String id; 
	@Index 
	private String lector;
	@Index 
	private String libro;
	
	private String direccion;
	private String informacion;

	@Index
	private boolean encontrado;
	@Index
	private Date fecha;
	
	public BookCrossing(){
		
	}
	
	public BookCrossing(String lector, String libro, String direccion,String informacion, boolean encontrado, Date fecha){
		this.id = java.util.UUID.randomUUID().toString().split("-")[0];
		this.libro = libro;
		this.direccion = direccion;
		this.lector=lector;
		this.encontrado=encontrado;
		this.fecha = fecha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public boolean isEncontrado() {
		return encontrado;
	}

	public void setEncontrado(boolean encontrado) {
		this.encontrado = encontrado;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
