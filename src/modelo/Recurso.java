package modelo;

import java.util.Date;

public abstract class Recurso {

    private int id;
    private String titulo;
    private Date año;
    private boolean estado;

    public Recurso(int id, String titulo, Date año, boolean estado) {
        this.id = id;
        this.titulo = titulo;
        this.año = año;
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

    public Date getAño() {
        return año;
    }

    public void setAño(Date año) {
        this.año = año;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}