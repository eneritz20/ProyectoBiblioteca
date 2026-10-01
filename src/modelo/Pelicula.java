package modelo;

public class Pelicula extends Recurso {

    private String director;
    private int duracionMinutos;

    public Pelicula(String id, String titulo, int anio, String director, int duracionMinutos) {
        super(id, titulo, anio, true);
        this.director = director;
        this.duracionMinutos = duracionMinutos;
    }

    public String getDirector() {
        return director;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    @Override
    public String toString() {
        return "Pelicula{id='" + getId() + "', titulo='" + getTitulo() + "', año=" + getAnio() +
                ", disponible=" + isDisponible() + ", director='" + director +
                "', duración=" + duracionMinutos + " min}";
    }
}
