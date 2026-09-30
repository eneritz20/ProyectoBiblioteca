package vista;

import java.util.Scanner;

import controlador.Biblioteca;

public class Mostrar {

	private Scanner teclado = new Scanner(System.in);
	Biblioteca biblioteca = new Biblioteca();

	public void mostrarMenuPrincipa() {

		System.out.println(" " + "            ========================================\n"
				+ "                    BIBLIOTECA MULTIMEDIA\n"
				+ "            ========================================\n" + "            \n"
				+ "            1. Gestionar usuarios\n" + "            2. Gestionar recursos\n"
				+ "            3. Préstamos y devoluciones\n" + "            4. Consultas\n" + "            0. Salir\n"
				+ "            \n" + "            ========================================\n"
				+ "            Seleccione una opción: ");
	}

	public void mostrarUsuarios() {
		System.out.println("========================================\n" + "             USUARIOS\n"
				+ "========================================\n" + "\n" + "1. Crear usuario\n" + "2. Listar usuarios\n"
				+ "3. Buscar usuario\n" + "4. Modificar usuario\n" + "5. Eliminar usuario\n" + "0. Volver\n" + "\n");
	}

	// -------------------- USUARIOS --------------------

	public void altaUsuario() {

		System.out.println();
		System.out.println("========================================");
		System.out.println("             CREAR USUARIO");
		System.out.println("========================================");

		System.out.print("Introduzca el ID del usuario: ");
		int id = teclado.nextInt();
		teclado.nextLine();

		System.out.print("Introduzca el nombre del usuario: ");
		String nombre = teclado.nextLine();

		System.out.print("Introduzca el correo electrónico: ");
		String correo = teclado.nextLine();

		System.out.println();
		System.out.println("ID: " + id);
		System.out.println("Nombre: " + nombre);
		System.out.println("Correo: " + correo);
		System.out.println("========================================");
		biblioteca.crearUsuario(id, nombre, correo);
	}

	public void listarTodosLosUsuarios() {
		System.out.println("Listando todos los usuarios.....");
		System.out.println();
		System.out.println(biblioteca.listarUsuarios());

	}

	public void buscarUsuarios() {

		System.out.print("Introduzca el ID del usuario: ");
		int id = teclado.nextInt();
		teclado.nextLine();

		biblioteca.buscarUsuarioPorId(id);
		System.out.println();
		if (biblioteca == null) {
			System.out.println("No existe ningún usuario con el ID " + id);
		}
	}

	public void editarUsuarios() {
		System.out.println("Introduce el id del usuario a modificar");
		int idUsuarioModif = teclado.nextInt();
		System.out.println("Introduce el nuevo nombre");
		String nuevoNombreUsuario = teclado.nextLine();
		System.out.println("Introduce el nuevo correo");
		String nuevoCorreoUsuario = teclado.nextLine();
		biblioteca.modificarUsuario(idUsuarioModif, nuevoNombreUsuario, nuevoCorreoUsuario);
	}

	public void eliminarUsuarios() {
		System.out.println("Introduce el id a eliminar");
		int idEliminarUsuario = teclado.nextInt();
		biblioteca.eliminarUsuario(idEliminarUsuario);
	}

	

	// -------------------- RECURSOS --------------------

	public void mostrarRecursos() {
		System.out.println("========================================\n" + "             RECURSOS\n"
				+ "========================================\n" + "\n" + "1. Crear recurso\n" + "2. Listar recursos\n"
				+ "3. Buscar recurso\n" + "4. Modificar recurso\n" + " 5. Modificar libro " + "6.Modificar pelicula "
				+ "7. Modificar Videojuego" + "8. Eliminar recurso\n" + "0. Volver\n" + "\n"
				+ "Seleccione una opción:");
	}

	public void crearRecurso() {
		System.out.println("Introduce el id");
		int idRecurso = teclado.nextInt();
		biblioteca.crearRecurso(idRecurso);

	}

	public void listarRecursos() {
		System.out.println(biblioteca.listarRecursos());
	}

	public void buscarRecursos() {
		System.out.println("Introduce el id");
		int idBuscarRecurso = teclado.nextInt();
		biblioteca.buscarRecursoPorId(idBuscarRecurso);

	}

	public void modificarRecurso() {
		System.out.println("Introduce el id");
		int idModificarRecurso = teclado.nextInt();
		System.out.println("Introduce el titulo");
		String tituloModificarRecurso = teclado.nextLine();
		System.out.println("Introduce el año");
		Date anio = teclado.next();
		biblioteca.modificarRecurso(idModificarRecurso, tituloModificarRecurso, anio);

	}

	public void modificarLibro() {
		System.out.println("Modificando libro");
		System.out.println("Introduce el id");
		int idModificarLibro = teclado.nextInt();
		System.out.println("Introduce el autor");
		String autor = teclado.nextLine();
		System.out.println("Introduce el numero de paginas");
		Integer numPaginas = teclado.nextInt();
		biblioteca.modificarLibro(idModificarLibro, autor, numPaginas);
	}

	public void modificarPelicula() {
		System.out.println("Introduce el id");
		int idModifPelicula = teclado.nextInt();
		System.out.println("Introduce el director");
		String directorModifPelicula = teclado.nextLine();
		System.out.println("Introduce la duracion");
		Double duracionModifPelicula = teclado.nextDouble();

		biblioteca.modificarPelicula(idModifPelicula, directorModifPelicula, duracionModifPelicula);
	}

	public void modificarVideojuego() {

		System.out.println("Modificando videojuego");
		System.out.println("Introduce el id");
		int idModifVideojuego = teclado.nextInt();
		System.out.println("Introduce la plataforma");
		String plataformaModifVideojuego = teclado.nextLine();

		System.out.println("Introduce el pegi");
		String pegiModifVideojuego = teclado.nextLine();
		biblioteca.modificarVideojuego(idModifVideojuego, plataformaModifVideojuego, pegiModifVideojuego);
	}

	public void eliminarRecurso() {
		System.out.println("Eliminar recurso");
		System.out.println("Introduce el id");
		int idElimRecurso = teclado.nextInt();
		biblioteca.eliminarRecurso(idElimRecurso);
	}

	// -------------------- PRESTAMOS --------------------

	public void menuPrestamosDevoluciones() {
		System.out.println("========================================\n" + "             PRESTAMOS Y DEVOLUCIONES\n"
				+ "========================================\n" + "\n" + "1. Realizar prestamo\n"
				+ "2. Devolver recurso\n" + "3. Comprobar usuario\n" + "4. Comprobar recurso\n");

	}

	public void crearPrestamo() {
		System.out.println("Introduce el id del usuario");
		int idUsuarioCrearPrestamo = teclado.nextInt();
		System.out.println("Introduce el id del recurso");
		int idRecursoCrearPrestamo = teclado.nextInt();
		biblioteca.realizarPrestamo(idUsuarioCrearPrestamo, idRecursoCrearPrestamo);
	}

	public void devolverRecursoPrestamo() {
		System.out.println("Introduce el id del recurso");
		int idRecursoDevolverPrestamo = teclado.nextInt();
		biblioteca.devolverRecurso(idRecursoDevolverPrestamo);
	}

	public void comprobarUsuarioPrestamo() {
		System.out.println("Introduce el id del usuario a comprobar");
		int idUsuariComprobarprestamo = teclado.nextInt();
		biblioteca.exigirUsuario(idUsuariComprobarprestamo);
	}

	public void comprobarRecursoPrestamo() {
		System.out.println("Introduce el id del recurso");
		int idComprobarRecurso = teclado.nextInt();
		biblioteca.exigirRecurso(idComprobarRecurso);
	}

	// -------------------- CONSULTAS --------------------

	public void mostrarConsultasElegir() {
		System.out.println("========================================\n" + "          	MOSTRAR CONSULTAS\n"
				+ "========================================\n" + "\n" + "1. Listar recursos disponibles\n"
				+ "2. Listar todos los recursos prestados\n" + "3. Listar por estado los disponibles y prestados\n"
				+ "4. Buscar por titulo\n" + "5. Listar prestamos usuario\n" + "6. Listar prestamos activos\n"
				+ "7. Recursos filtrados por tipo\n" + "8. Pelicula de mayor duración\n"
				+ "9. Clasificar videojuegos por pegi\n" + "0. Cancelar\n" + "\n" + "Seleccione el tipo:");
	}

	public void listarRecursosDisponibles() {
		System.out.println(biblioteca.listarRecursos());
	}

	public void listarRecursosPrestados() {
		System.out.println(biblioteca.recursosPrestados());
	}

	public void listarDisponiblesPrestados() {
		System.out.println(biblioteca.recursosPorEstado(false));
	}

	public void buscarTituloConsulta() {
		System.out.println("Introduce el titulo");
		String tituloBuscarConsulta = teclado.nextLine();
		System.out.println(biblioteca.buscarPorTitulo(tituloBuscarConsulta));
	}

	public void listarPrestamosUsuario() {
		System.out.println("Introduce el id de usuario");
		int usuarioListarPrestamo = teclado.nextInt();
		System.out.println(biblioteca.prestamosDeUsuario(usuarioListarPrestamo));

	}

	public void listarPrestamosActivos() {
		System.out.println(biblioteca.prestamosActivos());
	}

	public void listarRecursosTipo() {

		System.out.println("Introduce el tipo");
		String tipoRecursoListar = teclado.nextLine();
		System.out.println(biblioteca.recursosPorTipo(tipoRecursoListar));
	}

	public void peliculaMayorDuracion() {
		System.out.println(biblioteca.peliculasPorDuracion(0));
	}

	public void clasificarPegi() {
		System.out.println("Introduce el pegi que quieras ver");
		String pegiClasificar = teclado.nextLine();
		System.out.println(biblioteca.videojuegosPorPegi(pegiClasificar));
	}

}



/*
 * metodo para mostrar todos los usuarios
 * 
 * Usuarios: 1 alta 1.1 buscar por id de 1 1 1.2 listar todos 1.3 editar 1.4
 * eliminar 1.5
 * 
 * Recursos: 2 alta 2.1 buscar por id 2.2 buscar por titulo 2.3 listar todos 2.4
 * editar recurso general (editar titulo y año) 2.5 editar libro 2.6 editar
 * pelicula 2.7 editar videojuego 2.8 eliminar por id 2.9
 * 
 * Prestamos: 3 alta id usuario id recurso 3.1 buscar recurso (prestado o no)
 * 3.2
 * 
 * 
 * Consultas: 4 listar todos los recursos disponibles 4.1 listar todos los
 * recursos prestado 4.2 prestamos del usuario 4.3 prestamos de todos recursos
 * prestados 4.4 filtrados por tipo 4.5 Pelicula de mayor duración 4.6
 * Clasificar por pegis 4.7
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

