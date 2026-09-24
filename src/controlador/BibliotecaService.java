package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import src.Libro;
import src.Pelicula;
import src.Prestamo;
import src.Recurso;
import src.Usuario;
import src.Videojuego;

/**
 * Contiene las reglas de negocio de la biblioteca. Main solo debe pedir datos
 * al usuario y llamar a estos metodos.
 */
public class BibliotecaService {

    private final List<Usuario> usuarios = new ArrayList<Usuario>();
    private final List<Recurso> recursos = new ArrayList<Recurso>();
    private final List<Prestamo> prestamos = new ArrayList<Prestamo>();

    // -------------------- USUARIOS --------------------

    public void crearUsuario(int id, String nombre, String correo) {
        if (buscarUsuarioPorId(id) != null) {
            throw new IllegalArgumentException("Ya existe un usuario con ID " + id);
        }
        usuarios.add(new Usuario(id, nombre, correo));
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<Usuario>(usuarios);
    }

    public void modificarUsuario(int id, String nombre, String correo) {
        Usuario usuario = exigirUsuario(id);
        if (nombre != null && !nombre.trim().isEmpty()) {
            usuario.setNombre(nombre);
        }
        if (correo != null && !correo.trim().isEmpty()) {
            usuario.setCorreo(correo);
        }
    }

    public void eliminarUsuario(int id) {
        exigirUsuario(id);
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuario().equals(String.valueOf(id))
                    && "ACTIVO".equals(prestamo.getEstado())) {
                throw new IllegalStateException("No se puede eliminar: el usuario tiene prestamos activos");
            }
        }
        usuarios.remove(buscarUsuarioPorId(id));
    }

    // -------------------- RECURSOS --------------------

    public void crearRecurso(Recurso recurso) {
        if (recurso == null) {
            throw new IllegalArgumentException("El recurso no puede ser nulo");
        }
        if (buscarRecursoPorId(recurso.getId()) != null) {
            throw new IllegalArgumentException("Ya existe un recurso con ID " + recurso.getId());
        }
        recursos.add(recurso);
    }

    public Recurso buscarRecursoPorId(int id) {
        for (Recurso recurso : recursos) {
            if (recurso.getId() == id) {
                return recurso;
            }
        }
        return null;
    }

    public List<Recurso> listarRecursos() {
        return new ArrayList<Recurso>(recursos);
    }

    public List<Recurso> buscarPorTitulo(String texto) {
        List<Recurso> resultado = new ArrayList<Recurso>();
        if (texto == null) {
            return resultado;
        }
        String busqueda = texto.toLowerCase().trim();
        for (Recurso recurso : recursos) {
            if (recurso.getTitulo().toLowerCase().contains(busqueda)) {
                resultado.add(recurso);
            }
        }
        return resultado;
    }

    /** Modifica solo los campos que tengan un valor no vacio / distinto de null. */
    public void modificarRecurso(int id, String titulo, Date anio) {
        Recurso recurso = exigirRecurso(id);
        if (titulo != null && !titulo.trim().isEmpty()) {
            recurso.setTitulo(titulo);
        }
        if (anio != null) {
            recurso.setAño(anio);
        }
    }

    public void modificarLibro(int id, String autor, Integer numPaginas) {
        Recurso recurso = exigirRecurso(id);
        if (!(recurso instanceof Libro)) {
            throw new IllegalArgumentException("El recurso indicado no es un libro");
        }
        Libro libro = (Libro) recurso;
        if (autor != null && !autor.trim().isEmpty()) {
            libro.setAutor(autor);
        }
        if (numPaginas != null && numPaginas.intValue() > 0) {
            libro.setNumPaginas(numPaginas.intValue());
        }
    }

    public void modificarPelicula(int id, String director, Double duracion) {
        Recurso recurso = exigirRecurso(id);
        if (!(recurso instanceof Pelicula)) {
            throw new IllegalArgumentException("El recurso indicado no es una pelicula");
        }
        Pelicula pelicula = (Pelicula) recurso;
        if (director != null && !director.trim().isEmpty()) {
            pelicula.setDirector(director);
        }
        if (duracion != null && duracion.doubleValue() > 0) {
            pelicula.setDuracion(duracion.doubleValue());
        }
    }

    public void modificarVideojuego(int id, String plataforma, String pegi) {
        Recurso recurso = exigirRecurso(id);
        if (!(recurso instanceof Videojuego)) {
            throw new IllegalArgumentException("El recurso indicado no es un videojuego");
        }
        Videojuego videojuego = (Videojuego) recurso;
        if (plataforma != null && !plataforma.trim().isEmpty()) {
            videojuego.setPlataforma(plataforma);
        }
        if (pegi != null && !pegi.trim().isEmpty()) {
            videojuego.setPegi(pegi);
        }
    }

    public void eliminarRecurso(int id) {
        Recurso recurso = exigirRecurso(id);
        if (!recurso.isEstado()) {
            throw new IllegalStateException("No se puede eliminar un recurso prestado");
        }
        recursos.remove(recurso);
    }

    // -------------------- PRESTAMOS --------------------

    public void realizarPrestamo(int idUsuario, int idRecurso) {
        exigirUsuario(idUsuario);
        Recurso recurso = exigirRecurso(idRecurso);
        if (!recurso.isEstado()) {
            throw new IllegalStateException("El recurso ya esta prestado");
        }

        prestamos.add(new Prestamo(String.valueOf(idUsuario), String.valueOf(idRecurso),
                new Date(), "ACTIVO", null));
        recurso.setEstado(false);
    }

    public void devolverRecurso(int idRecurso) {
        Recurso recurso = exigirRecurso(idRecurso);
        Prestamo prestamo = buscarPrestamoActivoPorRecurso(idRecurso);
        if (prestamo == null) {
            throw new IllegalStateException("El recurso no tiene ningun prestamo activo");
        }
        prestamo.setEstado("DEVUELTO");
        prestamo.setFechaDevolucion(new Date());
        recurso.setEstado(true);
    }

    // -------------------- CONSULTAS --------------------

    public List<Recurso> recursosDisponibles() {
        return recursosPorEstado(true);
    }

    public List<Recurso> recursosPrestados() {
        return recursosPorEstado(false);
    }

    public List<Prestamo> prestamosDeUsuario(int idUsuario) {
        exigirUsuario(idUsuario);
        List<Prestamo> resultado = new ArrayList<Prestamo>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuario().equals(String.valueOf(idUsuario))) {
                resultado.add(prestamo);
            }
        }
        return resultado;
    }

    public List<Prestamo> prestamosActivos() {
        List<Prestamo> resultado = new ArrayList<Prestamo>();
        for (Prestamo prestamo : prestamos) {
            if ("ACTIVO".equals(prestamo.getEstado())) {
                resultado.add(prestamo);
            }
        }
        return resultado;
    }

    public List<Recurso> recursosPorTipo(String tipo) {
        List<Recurso> resultado = new ArrayList<Recurso>();
        for (Recurso recurso : recursos) {
            if (("LIBRO".equalsIgnoreCase(tipo) && recurso instanceof Libro)
                    || ("PELICULA".equalsIgnoreCase(tipo) && recurso instanceof Pelicula)
                    || ("VIDEOJUEGO".equalsIgnoreCase(tipo) && recurso instanceof Videojuego)) {
                resultado.add(recurso);
            }
        }
        return resultado;
    }

    // Dos consultas adicionales del grupo: por anio y prestamos ya devueltos.
    public List<Recurso> recursosPorAnio(Date anio) {
        List<Recurso> resultado = new ArrayList<Recurso>();
        for (Recurso recurso : recursos) {
            if (recurso.getAño().equals(anio)) {
                resultado.add(recurso);
            }
        }
        return resultado;
    }

    public List<Prestamo> prestamosDevueltos() {
        List<Prestamo> resultado = new ArrayList<Prestamo>();
        for (Prestamo prestamo : prestamos) {
            if ("DEVUELTO".equals(prestamo.getEstado())) {
                resultado.add(prestamo);
            }
        }
        return resultado;
    }

    private List<Recurso> recursosPorEstado(boolean disponible) {
        List<Recurso> resultado = new ArrayList<Recurso>();
        for (Recurso recurso : recursos) {
            if (recurso.isEstado() == disponible) {
                resultado.add(recurso);
            }
        }
        return resultado;
    }

    private Prestamo buscarPrestamoActivoPorRecurso(int idRecurso) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getRecurso().equals(String.valueOf(idRecurso))
                    && "ACTIVO".equals(prestamo.getEstado())) {
                return prestamo;
            }
        }
        return null;
    }

    private Usuario exigirUsuario(int id) {
        Usuario usuario = buscarUsuarioPorId(id);
        if (usuario == null) {
            throw new IllegalArgumentException("No existe el usuario con ID " + id);
        }
        return usuario;
    }

    private Recurso exigirRecurso(int id) {
        Recurso recurso = buscarRecursoPorId(id);
        if (recurso == null) {
            throw new IllegalArgumentException("No existe el recurso con ID " + id);
        }
        return recurso;
    }
}
