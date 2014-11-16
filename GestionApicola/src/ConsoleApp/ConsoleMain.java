package ConsoleApp;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Dominio.Sistema;
import Dominio.TipoError;
import Dominio.TipoRetorno;

/**
 * Interfaz de usuario, consola.
 */
public class ConsoleMain {
	private static int intOptMenu = 0;

	/**
	 * Metodo principal de la aplicacion.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		try {
			do {
				showMenu(); // Muestra el menú de opciones.
				intOptMenu = scan.nextInt();
				switch (intOptMenu) {
				case 1:
					inicializarSistema(scan);
					break;
				case 2:
					destruirSistema();
					break;
				}
			} while (intOptMenu != 0);
		} catch (InputMismatchException ime) {
			System.out.println("Debe ingresar un número entero.");
		}
	}

	/**
	 * Muestra en consola el menú de opciones de la aplicación.
	 */
	private static void showMenu() {
		System.out.println("Ingrese la opción deseada:");
		System.out.println("1 - Inicializar el sistema.");
		System.out.println("2 - Destruir sistema.");
		System.out.println("0 - Salir de la aplicación.");
	}

	/**
	 * Inicializa el sistema.
	 * 
	 * @param s
	 *            Scanner para leer datos ingresados por el usuario desde la
	 *            consola.
	 * @throws IOException
	 */
	private static void inicializarSistema(Scanner s) throws IOException {
		System.out
				.println("Ingrese la cantidad máxima de puntos que soportará el sistema:");
		try {
			int cp = s.nextInt();
			TipoRetorno ret = Sistema.getInstancia().inicializarSistema(cp);
			System.out.println(ret.getTipoError().toString());
			if (ret.getTipoError() == TipoError.ERROR_1) {
				System.out
						.println("La cantidad máxima de puntos debe ser mayor a cero.");
			} else if (ret.getTipoError() == TipoError.ERROR_2) {
				System.out.println("Debe destruír el sistema actual primero.");
			}
		} catch (InputMismatchException ime) {
			System.out.println("Debe ingresar un número entero");
		}
		System.in.read();
	}
	/**
	 * Destruye el sistema.
	 * @throws IOException
	 */
	private static void destruirSistema() throws IOException{
		TipoRetorno ret = Sistema.getInstancia().destruirSistema();
		System.out.println(ret.getTipoError().toString());
		if(ret.getTipoError() == TipoError.ERROR_1){
			System.out.println("No se ha inicializado el sistema, por lo que no puede destruirse.");
		}
		System.in.read();
	}
}
