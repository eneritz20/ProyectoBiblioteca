package vista;

import java.util.Scanner;

public class Mostrar {

    private Scanner teclado = new Scanner(System.in);
	
	public void mostrarMenu() {
		
		System.out.println(" "
				+ "            ========================================\n"
				+ "                    BIBLIOTECA MULTIMEDIA\n"
				+ "            ========================================\n"
				+ "            \n"
				+ "            1. Gestionar usuarios\n"
				+ "            2. Gestionar recursos\n"
				+ "            3. Préstamos y devoluciones\n"
				+ "            4. Consultas\n"
				+ "            0. Salir\n"
				+ "            \n"
				+ "            ========================================\n"
				+ "            Seleccione una opción: ");
	}
	
	public void crearUsuario() {
		
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
	        System.out.println("========================================");
	        System.out.println("        USUARIO INTRODUCIDO");
	        System.out.println("========================================");
	        System.out.println("ID: " + id);
	        System.out.println("Nombre: " + nombre);
	        System.out.println("Correo: " + correo);
	        System.out.println("========================================");
	    }
	
	
	
	public void mostrarUsuarios() {
		System.out.println("========================================\n"
				+ "             USUARIOS\n"
				+ "========================================\n"
				+ "\n"
				+ "1. Crear usuario\n"
				+ "2. Listar usuarios\n"
				+ "3. Buscar usuario\n"
				+ "4. Modificar usuario\n"
				+ "5. Eliminar usuario\n"
				+ "0. Volver\n"
				+ "\n");
	}
	public void mostrarRecursos() {
		System.out.println("========================================\n"
				+ "             RECURSOS\n"
				+ "========================================\n"
				+ "\n"
				+ "1. Crear recurso\n"
				+ "2. Listar recursos\n"
				+ "3. Buscar recurso\n"
				+ "4. Modificar recurso\n"
				+ "5. Eliminar recurso\n"
				+ "6. Consultar disponibilidad\n"
				+ "0. Volver\n"
				+ "\n"
				+ "Seleccione una opción:");
	}
	public void mostrarTipoRecurso() {
		System.out.println("========================================\n"
				+ "          CREAR RECURSO\n"
				+ "========================================\n"
				+ "\n"
				+ "1. Libro\n"
				+ "2. Película\n"
				+ "3. Videojuego\n"
				+ "0. Cancelar\n"
				+ "\n"
				+ "Seleccione el tipo:");
		
	}
	public void mostrarTipoLibro() {
		System.out.println("Título:\n"
				+ "Año:\n"
				+ "Autor:\n"
				+ "Número de páginas:");
	}
	public void mostrarTipoPelicula() {
		System.out.println("Título:\n"
				+ "Año:\n"
				+ "Director:\n"
				+ "Duración en minutos:");
	}
	public void mostrarTipoVideojuego() {
		System.out.println("Título:\n"
				+ "Año:\n"
				+ "Plataforma:\n"
				+ "PEGI:");
	}
	
	public void mostrarPrestamos() {
		System.out.println("========================================\n"
				+ "        PRÉSTAMOS Y DEVOLUCIONES\n"
				+ "========================================\n"
				+ "\n"
				+ "1. Realizar préstamo\n"
				+ "2. Realizar devolución\n"
				+ "3. Ver préstamos activos\n"
				+ "4. Ver préstamos de un usuario\n"
				+ "0. Volver\n"
				+ "\n"
				+ "Seleccione una opción:");
	}
	
	public void mostrarConsultas() {
		System.out.println("========================================\n"
				+ "             CONSULTAS\n"
				+ "========================================\n"
				+ "\n"
				+ "1. Recursos disponibles\n"
				+ "2. Recursos prestados\n"
				+ "3. Buscar por título\n"
				+ "4. Préstamos de un usuario\n"
				+ "5. Préstamos activos\n"
				+ "6. Recursos por tipo\n"
				+ "7. Recursos más recientes\n"
				+ "8. Usuarios con préstamos activos\n"
				+ "0. Volver\n"
				+ "\n"
				+ "Seleccione una opción:");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
