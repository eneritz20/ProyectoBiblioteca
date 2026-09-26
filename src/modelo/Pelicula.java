package modelo;

import java.util.Date;

public class Pelicula extends Recurso {

	private String director;
	private double duracion;
	
	public Pelicula(int id, String titulo, Date año, boolean estado, String director, double duracion) {
		super(id, titulo, año, estado);
		this.director = director;
		this.duracion = duracion;
	}

	public String getDirector() {
		return director;
	}
	

	public void setDirector(String director) {
		this.director = director;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	


	
	

}
