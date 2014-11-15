package Dominio;
/**
 * Fachada del sistema. Utiliza Singleton.
 */
public class Sistema {
	/**
	 * Instancia única del sistema.
	 */
	private static Sistema instancia = null;
	/**
	 * Cantidad máxima de puntos que soportará el sistema.
	 */
	private int cantPuntos;
	/**
	 * Array de puntos del sistema.
	 */
	private Punto[] arrPuntos;
	/**
	 * Lista de tramos del sistema.
	 */
	private ListaTramos lstTramos;
	/**
	 * Arbol de apicultores del sistema.
	 */
	private ArbolApicultores treApicultores;
	/**
	 * Constructor de Sistema, no recibe parámetros.
	 */
	private Sistema(){
		
	}
	/**
	 * Obtiene la instancia del sistema o crea una nueva si la actual es nula.
	 * @return Instancia del sistema.
	 */
	public static Sistema getInstancia(){
		if (instancia == null){
			instancia = new Sistema();
		}
		return instancia;
	}
}
