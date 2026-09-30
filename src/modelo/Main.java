package modelo;

import java.util.Scanner;

import vista.Mostrar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);

		Mostrar mostrar = new Mostrar();
		mostrar.mostrarMenuPrincipa();
		int opcion = 7;
		int opcionUsuarios = 0;
		int opcionRecursos = 0;
		int opcionPrestamosDevoluciones = 0;
		int opcionElegirConsultas = 0;
		while (opcion != 0) {
			opcion = teclado.nextInt();

			switch (opcion) {

			case 1:
				mostrar.mostrarUsuarios();
				opcionUsuarios = teclado.nextInt();
				switch (opcionUsuarios) {
				case 1:
					mostrar.altaUsuario();
					break;
				case 2:
					mostrar.listarTodosLosUsuarios();
					break;
				case 3:
					mostrar.buscarUsuarios();
					break;
				case 4:
					mostrar.editarUsuarios();
					break;
				case 5:
					mostrar.eliminarUsuarios();
					break;
				}
				break;

			case 2:
				mostrar.mostrarRecursos();
				opcionRecursos = teclado.nextInt();
				switch (opcionRecursos) {
				case 1:
					mostrar.crearRecurso();
					break;
				case 2:
					mostrar.listarRecursos();
					break;
				case 3:
					mostrar.buscarRecursos();
					break;
				case 4:
					mostrar.modificarRecurso();
					break;
				case 5:
					mostrar.modificarLibro();
					break;
				case 6:
					mostrar.modificarPelicula();
					break;
				case 7:
					mostrar.modificarVideojuego();
					break;
				case 8:
					mostrar.eliminarRecurso();
					break;
					
				}
				break;
			case 3:
				mostrar.menuPrestamosDevoluciones();
				opcionPrestamosDevoluciones = teclado.nextInt();
				switch (opcionPrestamosDevoluciones) {
				case 1:
					mostrar.crearPrestamo();
					break;
				case 2:
					mostrar.devolverRecursoPrestamo();
					break;
				case 3:
					mostrar.comprobarUsuarioPrestamo();
					break;
				case 4:
					mostrar.comprobarRecursoPrestamo();
					break;
				}
				break;
			case 4:
				mostrar.mostrarConsultasElegir();
				opcionElegirConsultas = teclado.nextInt();
				switch (opcionElegirConsultas) {
				case 1:
					mostrar.listarRecursosDisponibles();
					break;
				case 2:
					mostrar.listarRecursosPrestados();
					break;
				case 3:
					mostrar.listarDisponiblesPrestados();
					break;
				case 4:
					mostrar.buscarTituloConsulta();
					break;
				case 5:
					mostrar.listarPrestamosUsuario();
					break;
				case 6:
					mostrar.listarPrestamosActivos();
					break;
				case 7:
					mostrar.listarRecursosTipo();
					break;
				case 8:
					mostrar.peliculaMayorDuracion();
					break;

				}
				break;
			}

		}

	}
}
