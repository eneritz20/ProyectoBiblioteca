package modelo;

import java.util.Date;

public class Libro extends Recurso {

	private String autor;
	private int numPaginas;

	public Libro(int id, String titulo, Date año, boolean estado, String autor, int numPaginas) {
		super(id, titulo, año, estado);
		this.autor = autor;
		this.numPaginas = numPaginas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

}