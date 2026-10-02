package modelo;

import java.util.Date;

public class Videojuego extends Recurso {

	private String plataforma;
	private String pegi;

	public Videojuego(int id, String titulo, Date anio, boolean estado, String plataforma, String pegi) {
		super(id, titulo, anio, estado);
		this.plataforma = plataforma;
		this.pegi = pegi;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getPegi() {
		return pegi;
	}

	public void setPegi(String pegi) {
		this.pegi = pegi;
	}

	@Override
	public String toString() {
		return super.toString() + " | Plataforma: " + plataforma + " | PEGI: " + pegi;
	}

}
