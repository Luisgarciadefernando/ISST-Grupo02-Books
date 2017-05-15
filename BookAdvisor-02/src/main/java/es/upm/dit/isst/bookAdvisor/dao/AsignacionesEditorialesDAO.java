package es.upm.dit.isst.bookAdvisor.dao;

import java.util.Date;
import java.util.List;

import es.upm.dit.isst.bookAdvisor.model.Editorial;
import es.upm.dit.isst.bookAdvisor.model.Libro;
import es.upm.dit.isst.bookAdvisor.model.AsignacionesEditoriales;

public interface AsignacionesEditorialesDAO {
	public AsignacionesEditoriales create(Libro libro, Editorial editorial, String editorialId, String formato, String idioma, int estado);
	public List<AsignacionesEditoriales> readLibro(Libro libro);
	public List<AsignacionesEditoriales> read();
	public List<AsignacionesEditoriales> readEditorial(Editorial editorial);
	public List<AsignacionesEditoriales> readFormato(String formato);
	public List<AsignacionesEditoriales> readIdioma(String idioma);
	public List<AsignacionesEditoriales> readEditorialId(String editorialId);
	public List<AsignacionesEditoriales> readFecha(Date fecha);
	public AsignacionesEditoriales readID(String id);
	public AsignacionesEditoriales update(AsignacionesEditoriales asignacionesEditoriales);
	public AsignacionesEditoriales delete(AsignacionesEditoriales asignacionesEditoriales);
	public void deleteAll();
	
}