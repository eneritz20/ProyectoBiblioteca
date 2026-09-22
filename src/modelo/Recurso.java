package modelo;

import java.util.Date;

public abstract class Recurso {

	private int id;
	private String titulo;
	private Date año;
	private boolean estado;

	public Recurso(int id, String titulo, Date año, boolean estado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.año = año;
		this.estado = estado;
	}

}
