package modelo;

import java.util.Date;

public class Videojuego extends Recurso {

	private String plataforma;
	private String pegi;

	public Videojuego(int id, String titulo, Date año, boolean estado, String plataforma, String pegi) {
		super(id, titulo, año, estado);
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

}
