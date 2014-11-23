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
	private static int intOptMenu = 0; // Opción para el menú de la aplicación.

	/**
	 * Metodo principal de la aplicacion.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("          __");
		System.out.println("         // \\                            _ _  __");
		System.out
				.println("         \\\\_/ //                        ( | )/_/");
		System.out.println("'-.._.. -(||)(')   GESTIÓN APICOLA   __( >O< )");
		System.out.println("         ´´´                         \\_\\( | )");
		System.out.println("                                         ¯ ¯");
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
				case 3:
					registrarApicultor(scan);
					break;
				case 4:
					registrarCiudad(scan);
					break;
				case 5:
					registrarApiario(scan);
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
		System.out.println("3 - Registrar Apicultor.");
		System.out.println("4 - Registrar Ciudad.");
		System.out.println("5 - Registrar Apiario");
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
	 * 
	 * @throws IOException
	 */
	private static void destruirSistema() throws IOException {
		TipoRetorno ret = Sistema.getInstancia().destruirSistema();
		System.out.println(ret.getTipoError().toString());
		if (ret.getTipoError() == TipoError.ERROR_1) {
			System.out
					.println("No se ha inicializado el sistema, por lo que no puede destruirse.");
		}
		System.in.read();
	}

	/**
	 * Registra un nuevo apicultor en el sistema.
	 * 
	 * @param s
	 *            Scanner para leer los datos ingresados por el usuario en la
	 *            consola.
	 * @throws IOException
	 */
	private static void registrarApicultor(Scanner s) throws IOException {
		int cedula;
		String nombre;
		String direccion;
		String email;
		String celular;
		try {
			// Ingreso de datos por parte del usuario:
			System.out.println("Ingrese la cédula (sin puntos ni guión):");
			cedula = s.nextInt();
			System.out.println("Ingrese el nombre:");
			nombre = s.nextLine();
			System.out.println("Ingrese la dirección:");
			direccion = s.nextLine();
			System.out.println("Ingrese la dirección de correo electrónico:");
			email = s.nextLine();
			System.out.println("Ingrese el celular:");
			celular = s.nextLine();
			// Agregar nuevo apicultor al sistema:
			TipoRetorno ret = Sistema.getInstancia().registrarApicultor(cedula,
					nombre, direccion, email, celular);
			// Resultado la funcionalidad:
			System.out.println(ret.getTipoError().toString());
			if (ret.getTipoError() == TipoError.ERROR_1) {
				System.out.println("Ya existe un apicultor con la cédula "
						+ cedula + " registrado en el sistema.");
			}
			System.in.read();
		} catch (InputMismatchException ime) {
			System.out.println("Debe ingresar la cédula sin puntos ni guión.");
		}
	}
	/**
	 * Registra una nueva ciudad en el sistema
	 * @param s Scanner para leer los datos ingresados por el usuario en la consola.
	 * @throws IOException 
	 */
	private static void registrarCiudad(Scanner s) throws IOException {
		try {
			System.out.println("Ingrese el nombre de la ciudad:");
			String nombre = s.nextLine();
			System.out.println("Ingrese la coordenada para el eje x:");
			double x = s.nextDouble();
			System.out.println("Ingrese la coordenada para el eje y;");
			double y = s.nextDouble();
			TipoRetorno ret = Sistema.getInstancia().registrarCiudad(nombre, x, y);
			System.out.println(ret.getTipoError().toString());
			if(ret.getTipoError() == TipoError.ERROR_1){
				System.out.println("No se pueden registrar más puntos en el sistema.");
			}
			else if(ret.getTipoError() == TipoError.ERROR_2){
				System.out.println("Ya existe un punto en el sistema en las coordenadas" +y+","+x+".");
			}
			else if(ret.getTipoError() == TipoError.ERROR_3){
				System.out.println("Ya existe un punto en el sistema con el nombre"+nombre+".");
			}
			System.in.read();
		} catch (InputMismatchException ime) {
			System.out.println("Las coordenadas deben estar en un formato númerico.");
		}
	}
	/**
	 * Registra un nuevo apiario en el sistema.
	 * @param s Scanner para leer datos ingresados por el usuario.
	 * @throws IOException
	 */
	private static void registrarApiario(Scanner s) throws IOException{
		TipoRetorno ret = new TipoRetorno();
		ret.setTipoError(TipoError.NO_IMPLEMENTADA); //Por defecto
		try {
			System.out.println("Ingrese el nombre del Apiario");
			String nombre = s.nextLine();
			System.out.println("Ingrese la coordenada para el eje x:");
			double x = s.nextDouble();
			System.out.println("Ingrese la coordenada para el eje y;");
			double y = s.nextDouble();
			System.out.println("Ingrese la cédula del apicultor:");
			int cedula = s.nextInt();
			System.out.println("Ingrese la capacidad en litros por mes:");
			int capacidad = s.nextInt();
			ret = Sistema.getInstancia().registrarApiario(nombre, x, y, cedula, capacidad);
			if(ret.getTipoError() == TipoError.ERROR_1){
				System.out.println("No se pueden registrar más puntos en el sistema.");
			}
			else if(ret.getTipoError() == TipoError.ERROR_2){
				System.out.println("Ya existe un punto en el sistema en las coordenadas" +y+","+x+".");
			}
			else if(ret.getTipoError() == TipoError.ERROR_3){
				System.out.println("Ya existe un punto en el sistema con el nombre"+nombre+".");
			}
			else if(ret.getTipoError() == TipoError.ERROR_4){
				System.out.println("La cédula ingresada no coincide con ningún apicultor registrado en el sistema.");
			}
			System.in.read();
		}
		catch(InputMismatchException ime){
			System.out.println("Las coordenadas, la cédula del apicultor y la capacidad deben estar en un formato númerico.");
		}
	}
}
