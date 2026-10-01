import modelo.Recurso;
import modelo.Usuario;
import java.util.List;

public class ValidacionErrores {

    public static class BibliotecaExcepcion extends Exception {
        public BibliotecaExcepcion(String mensaje) {
            super(mensaje);
        }
    }

    // 1. ID duplicado de Usuario
    public static void comprobarUsuarioDuplicado(List<Usuario> usuarios, String id) throws BibliotecaExcepcion {
        for (Usuario u : usuarios) {
            if (id.equalsIgnoreCase(u.getId())) { // Seguro: id nunca es null
                throw new BibliotecaExcepcion("Error: El ID de usuario '" + id + "' ya existe.");
            }
        }
    }

    // 2. ID duplicado de Recurso
    public static void comprobarRecursoDuplicado(List<Recurso> recursos, String id) throws BibliotecaExcepcion {
        for (Recurso r : recursos) {
            if (id.equalsIgnoreCase(r.getId())) {
                throw new BibliotecaExcepcion("Error: Ya existe un recurso con el ID '" + id + "'.");
            }
        }
    }

    // 3. Usuario existe
    public static Usuario comprobarUsuarioExiste(List<Usuario> usuarios, String id) throws BibliotecaExcepcion {
        for (Usuario u : usuarios) {
            if (id.equalsIgnoreCase(u.getId())) {
                return u;
            }
        }
        throw new BibliotecaExcepcion("Error: El usuario con ID '" + id + "' no existe en el sistema.");
    }

    // 4. Recurso existe
    public static Recurso comprobarRecursoExiste(List<Recurso> recursos, String id) throws BibliotecaExcepcion {
        for (Recurso r : recursos) {
            if (id.equalsIgnoreCase(r.getId())) {
                return r;
            }
        }
        throw new BibliotecaExcepcion("Error: El recurso con ID '" + id + "' no existe en la biblioteca.");
    }

    // 5. Recurso disponible para prestar
    public static void comprobarRecursoDisponible(Recurso recurso) throws BibliotecaExcepcion {
        if (!recurso.isDisponible()) {
            throw new BibliotecaExcepcion("Error: Imposible prestar. El recurso '" + recurso.getTitulo() + "' ya está prestado.");
        }
    }

    // 6. Recurso prestado para devolver
    public static void comprobarRecursoPrestado(Recurso recurso) throws BibliotecaExcepcion {
        if (recurso.isDisponible()) {
            throw new BibliotecaExcepcion("Error: Imposible devolver. El recurso '" + recurso.getTitulo() + "' ya figura como disponible.");
        }
    }

    // 7. Lista usuarios vacía
    public static void comprobarListaUsuariosVacia(List<Usuario> usuarios) throws BibliotecaExcepcion {
        if (usuarios.isEmpty()) {
            throw new BibliotecaExcepcion("Aviso: No hay usuarios registrados actualmente.");
        }
    }

    // 8. Lista recursos vacía
    public static void comprobarListaRecursosVacia(List<Recurso> recursos) throws BibliotecaExcepcion {
        if (recursos.isEmpty()) {
            throw new BibliotecaExcepcion("Aviso: No hay recursos registrados en la biblioteca.");
        }
    }
}
