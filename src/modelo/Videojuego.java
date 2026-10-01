package modelo;

public class Videojuego extends Recurso {

    private String plataforma;
    private String pegi;

    public Videojuego(String id, String titulo, int anio, String plataforma, String pegi) {
        super(id, titulo, anio, true);
        this.plataforma = plataforma;
        this.pegi = pegi;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public String getPegi() {
        return pegi;
    }

    @Override
    public String toString() {
        return "Videojuego{id='" + getId() + "', titulo='" + getTitulo() + "', año=" + getAnio() +
                ", disponible=" + isDisponible() + ", plataforma='" + plataforma +
                "', pegi='" + pegi + "'}";
    }
}
