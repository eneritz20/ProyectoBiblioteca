package modelo;

public abstract class Recurso {

    private String id;
    private String titulo;
    private int anio;
    private boolean disponible;

    public Recurso(String id, String titulo, int anio, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.disponible = disponible;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnio() {
        return anio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
