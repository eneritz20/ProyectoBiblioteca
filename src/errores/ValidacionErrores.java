
import modelo.Recurso;
import modelo.Usuario;
import java.util.List;

public class ValidacionErrores{


public static class BibliotecaExcepcion extends Exception {
public BibliotecaExcepcion(String mensaje) {
super(mensaje);
}
}

//   ID duplicado de Usuario
public static void comprobarUsuarioDuplicado(List<Usuario> usuarios, String id) throws BibliotecaExcepcion {
for (Usuario u : usuarios) {
if (u.getId().equalsIgnoreCase(id)) {
throw new BibliotecaExcepcion("Error: El ID de usuario '" + id + "' ya existe.");
}
}
}

//  ID duplicado de Recurso
public static void comprobarRecursoDuplicado(List<Recurso> recursos, String id) throws BibliotecaExcepcion {
for (Recurso r : recursos) {
if (r.getId().equalsIgnoreCase(id)) {
throw new BibliotecaExcepcion("Error: Ya existe un recurso con el ID '" + id + "'.");
}
}
}

// 3.  el Usuario existe 
public static Usuario comprobarUsuarioExiste(List<Usuario> usuarios, String id) throws BibliotecaExcepcion {
for (Usuario u : usuarios) {
if (u.getId().equalsIgnoreCase(id)) {
return u;
}
}
throw new BibliotecaExcepcion("Error: El usuario con ID '" + id + "' no existe en el sistema.");
}

//  el Recurso existe
public static Recurso comprobarRecursoExiste(List<Recurso> recursos, String id) throws BibliotecaExcepcion {
for (Recurso r : recursos) {
if (r.getId().equalsIgnoreCase(id)) {
return r;
}
}
throw new BibliotecaExcepcion("Error: El recurso con ID '" + id + "' no existe en la biblioteca.");
}

//el recurso esté disponible para prestar
public static void comprobarRecursoDisponible(Recurso recurso) throws BibliotecaExcepcion {
if (!recurso.isDisponible()) {
throw new BibliotecaExcepcion("Error: Imposible prestar. El recurso '" + recurso.getTitulo() + "' ya está prestado.");
}
}

//  el recurso esté prestado para poder devolverlo
public static void comprobarRecursoPrestado(Recurso recurso) throws BibliotecaExcepcion {
if (recurso.isDisponible()) {
throw new BibliotecaExcepcion("Error: Imposible devolver. El recurso '" + recurso.getTitulo() + "' ya figura como disponible.");
}
}

//  las listas no estén vacías al listar
public static void comprobarListaUsuariosVacia(List<Usuario> usuarios) throws BibliotecaExcepcion {
if (usuarios.isEmpty()) {
throw new BibliotecaExcepcion("Aviso: No hay usuarios registrados actualmente.");
}
}

public static void comprobarListaRecursosVacia(List<Recurso> recursos) throws BibliotecaExcepcion {
if (recursos.isEmpty()) {
throw new BibliotecaExcepcion("Aviso: No hay recursos registrados en la biblioteca.");
}
}
}

