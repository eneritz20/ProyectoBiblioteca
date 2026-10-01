package modelo;

public class Usuario {

    private String id;
    private String nombre;
    private String correo;

    public Usuario(String id, String nombre, String correo) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID del usuario no puede ser nulo ni vacío.");
        }
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getId() {
        return id; // Nunca será null
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID del usuario no puede ser nulo ni vacío.");
        }
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{id='" + id + "', nombre='" + nombre + "', correo='" + correo + "'}";
    }
}
