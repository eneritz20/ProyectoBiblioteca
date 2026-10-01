package modelo;

public class Libro extends Recurso {

    private String autor;
    private int paginas;

    public Libro(String id, String titulo, int anio, String autor, int paginas) {
        super(id, titulo, anio, true); // disponible por defecto
        this.autor = autor;
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }

    @Override
    public String toString() {
        return "Libro{id='" + getId() + "', titulo='" + getTitulo() + "', año=" + getAnio() +
                ", disponible=" + isDisponible() + ", autor='" + autor + "', paginas=" + paginas + "}";
    }
}
