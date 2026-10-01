package modelo;

import java.util.Date;

public abstract class Recurso {

    private int id;
    private String titulo;
    private Date anio;
    private boolean estado;

    public Recurso(int id, String titulo, Date anio, boolean estado) {
        this.id = id;
        this.titulo = titulo;
        this.anio =anio;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
    	return "ID: " + id + " | Título: " + titulo + " | Año: " + new java.text.SimpleDateFormat("yyyy").format(anio)
    			+ " | Estado: " + (estado ? "DISPONIBLE" : "PRESTADO");
    }
    
}