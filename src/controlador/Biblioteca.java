package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Libro;
import modelo.Pelicula;
import modelo.Prestamo;
import modelo.Recurso;
import modelo.Usuario;
import modelo.Videojuego;

//GENTE, REMINDER: ESTA CLASE SON SOLO LOS METODOS Q HACE TO LA BIBLIO, NO ES MAIN, NO ES EJECUTABLE

public class Biblioteca {

	private final List<Usuario> usuarios = new ArrayList<Usuario>();
	private final List<Recurso> recursos = new ArrayList<Recurso>();
	private final List<Prestamo> prestamos = new ArrayList<Prestamo>();

	// -------------------- USUARIOS --------------------

//alta
	public void crearUsuario(int id, String nombre, String correo) {
		if (buscarUsuarioPorId(id) != null) {
			throw new IllegalArgumentException("Ya existe un usuario con ID " + id); // no permitir identificadores
																						// duplicados
		}

		Usuario usuario = new Usuario(id, nombre, correo);
		usuarios.add(usuario);
	}

	// buscar
	public Usuario buscarUsuarioPorId(int id) {
		for (Usuario usuario : usuarios) {
			if (usuario.getId() == id) {
				return usuario;
			}
		}
		return null;
	}

	// listar all
	public List<Usuario> listarUsuarios() {
		return usuarios; // retorna array q esta arriba del to
	}

	// editar
	public void modificarUsuario(int id, String nombre, String correo) {
		Usuario usuario = exigirUsuario(id);

		if (nombre != null && !nombre.trim().isEmpty()) {
			usuario.setNombre(nombre);
		}

		if (correo != null && !correo.trim().isEmpty()) {
			usuario.setCorreo(correo);
		}
	}

	// eliminar
	public void eliminarUsuario(int id) {
		Usuario usuario = exigirUsuario(id);

		for (Prestamo prestamo : prestamos) {
			if (prestamo.getUsuario().equals(String.valueOf(id)) && prestamo.getEstado().equals("ACTIVO")) {
				throw new IllegalStateException("No se puede eliminar: el usuario tiene prestamos activos");
			}
		}
		usuarios.remove(usuario);
	}

	// -------------------- RECURSOS --------------------

	// alta
	public void crearRecurso(Recurso recurso) {
		if (recurso == null) {
			throw new IllegalArgumentException("El recurso no puede ser nulo");
		}
		if (buscarRecursoPorId(recurso.getId()) != null) {
			throw new IllegalArgumentException("Ya existe un recurso con ID: " + recurso.getId());
		}
		recursos.add(recurso);
	}

	// buscar x id
	public Recurso buscarRecursoPorId(int id) {
		for (Recurso recurso : recursos) {
			if (recurso.getId() == id) {
				return recurso;
			}
		}
		return null;
	}

	// listar all
	public List<Recurso> listarRecursos() {
		return recursos;
	}

	// editar recurso general
	public void modificarRecurso(int id, String titulo, Date anio) {
		Recurso recurso = exigirRecurso(id);

		if (titulo != null && !titulo.trim().isEmpty()) {
			recurso.setTitulo(titulo);
		}
		if (anio != null) {
			recurso.setAño(anio);
		}
	}

	// editar libro
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

	// editar peli
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

	// editar vj
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

	// eliminar
	public void eliminarRecurso(int id) {
		Recurso recurso = exigirRecurso(id);

		if (!recurso.isEstado()) {
			throw new IllegalStateException("No se puede eliminar un recurso prestado");
		}
		recursos.remove(recurso);
	}

	// -------------------- PRESTAMOS --------------------

	// alta
	public void realizarPrestamo(int idUsuario, int idRecurso) {
		exigirUsuario(idUsuario);
		Recurso recurso = exigirRecurso(idRecurso);

		if (!recurso.isEstado()) {
			throw new IllegalStateException("El recurso ya esta prestado"); // No permitir prestar un recurso que ya
																			// este prestado
		}

		Prestamo prestamo = new Prestamo(String.valueOf(idUsuario), String.valueOf(idRecurso), new Date(), "ACTIVO",
				null);

		prestamos.add(prestamo);
		recurso.setEstado(false); // Al prestar un recurso debe quedar como no disponible.
	}

	// busca recurso y si no tiene lanza mnsj, si no loo vuelve true "devuelto"
	public void devolverRecurso(int idRecurso) {
		Recurso recurso = exigirRecurso(idRecurso);

		for (Prestamo prestamo : prestamos) {
			if (prestamo.getRecurso().equals(String.valueOf(idRecurso)) && prestamo.getEstado().equals("ACTIVO")) {

				prestamo.setEstado("DEVUELTO");
				prestamo.setFechaDevolucion(new Date());
				recurso.setEstado(true);
				return;
			}
		}

		throw new IllegalStateException("El recurso no tiene un prestamo activo");
	}

	// Comprobar que el usuario existe
	private Usuario exigirUsuario(int id) {
		Usuario usuario = buscarUsuarioPorId(id);
		if (usuario == null) {
			throw new IllegalArgumentException("No existe el usuario con ID " + id);
		}
		return usuario;
	}

	// Comprobar que el recurso existe
	private Recurso exigirRecurso(int id) {
		Recurso recurso = buscarRecursoPorId(id);
		if (recurso == null) {
			throw new IllegalArgumentException("No existe el recurso con ID " + id);
		}
		return recurso;
	}

	// -------------------- CONSULTAS --------------------

	// listar all dispo
	public List<Recurso> recursosDisponibles() {
		return recursosPorEstado(true);
	}

	// listar all prestados
	public List<Recurso> recursosPrestados() {
		return recursosPorEstado(false);
	}

	// este metodo lo uso para mostrar el listado d todos los dispos y prestados
	private List<Recurso> recursosPorEstado(boolean disponible) {
		List<Recurso> resultado = new ArrayList<Recurso>();

		for (Recurso recurso : recursos) {
			if (recurso.isEstado() == disponible) {
				resultado.add(recurso);
			}
		}
		return resultado;
	}

	// buscar x titulo
	public List<Recurso> buscarPorTitulo(String texto) {
		List<Recurso> resultado = new ArrayList<Recurso>();

		for (Recurso recurso : recursos) {
			if (recurso.getTitulo().toLowerCase().contains(texto.toLowerCase())) {
				resultado.add(recurso);
			}
		}

		return resultado;
	}

	// listar all prrestamos usu
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

	// listar all prestamos activos
	public List<Prestamo> prestamosActivos() {
		List<Prestamo> resultado = new ArrayList<Prestamo>();

		for (Prestamo prestamo : prestamos) {
			if (prestamo.getEstado().equals("ACTIVO")) {
				resultado.add(prestamo);
			}
		}
		return resultado;
	}

	// Recursos filtrados por tipo
	public List<Recurso> recursosPorTipo(String tipo) {
		List<Recurso> resultado = new ArrayList<Recurso>();

		for (Recurso recurso : recursos) {
			if (tipo.equalsIgnoreCase("LIBRO") && recurso instanceof Libro) {
				resultado.add(recurso);
			}

			if (tipo.equalsIgnoreCase("PELICULA") && recurso instanceof Pelicula) {
				resultado.add(recurso);
			}

			if (tipo.equalsIgnoreCase("VIDEOJUEGO") && recurso instanceof Videojuego) {
				resultado.add(recurso);
			}
		}
		return resultado;
	}

	// 2 consultas adicionales decididas por el grupo:

	// pelis x mayor duracion
	public List<Pelicula> peliculasPorDuracion(double duracion) {
		List<Pelicula> resultado = new ArrayList<Pelicula>();

		for (Recurso recurso : recursos) {
			if (recurso instanceof Pelicula) {
				Pelicula pelicula = (Pelicula) recurso;

				if (pelicula.getDuracion() > duracion) {
					resultado.add(pelicula);
				}
			}
		}

		return resultado;
	}

	// clasificar x pegi
	public List<Videojuego> videojuegosPorPegi(String pegi) {
		List<Videojuego> resultado = new ArrayList<Videojuego>();

		for (Recurso recurso : recursos) {
			if (recurso instanceof Videojuego) {
				Videojuego videojuego = (Videojuego) recurso;

				if (videojuego.getPegi().equalsIgnoreCase(pegi)) {
					resultado.add(videojuego);
				}
			}
		}

		return resultado;
	}

}