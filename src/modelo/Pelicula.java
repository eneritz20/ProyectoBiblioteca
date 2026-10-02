package modelo;

import java.util.Date;

public class Pelicula extends Recurso {

	private String director;
	private double duracion;

	public Pelicula(int id, String titulo, Date anioo, boolean estado, String director, double duracion) {
		super(id, titulo, anioo, estado);
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

	@Override
	public String toString() {
		return super.toString() + " | Director: " + director + " | Duración: " + duracion + " min";
	}

}
