package modelo;

import java.util.Scanner;


import vista.Mostrar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner teclado = new Scanner(System.in);

		Mostrar mostrar = new vista.Mostrar();
		mostrar.mostrarMenu();
		int opcion = 0;
		while (opcion != 0) {
			opcion = teclado.nextInt();

			switch (opcion) {

			case 1:
				mostrar.crearUsuario();
				break;
			case 2:

			}

		}
	}
}
