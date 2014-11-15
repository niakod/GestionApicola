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
	private int cantPuntos = 0;
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
	private Sistema() {
	}

	/**
	 * Obtiene la instancia del sistema o crea una nueva si la actual es nula.
	 * 
	 * @return Instancia del sistema.
	 */
	public static Sistema getInstancia() {
		if (instancia == null) {
			instancia = new Sistema();
		}
		return instancia;
	}

	/**
	 * Inicializa las estructuras necesarias para representar el sistema
	 * especificado, capaz de albergar como máximo la cantidad de puntos que
	 * recibe como parámetros en el mapa. Los puntos del mapa serán las
	 * ciudades, puntos de extracción, o apiarios.
	 * 
	 * @param cantPuntos
	 *            Cantidad máxima de puntos soportados por el sistema a crear.
	 * @return Resultado del método.
	 */
	public TipoRetorno inicializarSistema(int vCantPuntos) {
		TipoRetorno tr = new TipoRetorno();
		// Retorno por defecto:
		tr.setTipoError(TipoError.NO_IMPLEMENTADA);
		if (getInstancia().cantPuntos != 0) {
			// Si el sistema ya existe debe ser destruído primero.
			tr.setTipoError(TipoError.ERROR_2);
		} else if (vCantPuntos <= 0) {
			// El número de puntos máximo debe ser mayor a cero.
			tr.setTipoError(TipoError.ERROR_1);
		} else {
			getInstancia().cantPuntos = vCantPuntos; // Asigna la cantidad de
														// puntos.
			// Inicializa el array de puntos con la cantidad máxima de puntos
			// que soportará el sistema:
			getInstancia().arrPuntos = new Punto[vCantPuntos];
			// Inicializa la lista de tramos, con el primer elemento en null:
			getInstancia().lstTramos = new ListaTramos(null);
			// Inicializa el árbol de apicultores, con la raíz en null:
			getInstancia().treApicultores = new ArbolApicultores(null);
			tr.setTipoError(TipoError.OK); // El sistema se inicializa de forma
											// correcta.
		}
		return tr;
	}

	/**
	 * Destruye el sistema de todos sus elementos y estructuras.
	 * 
	 * @return Resultado del método.
	 */
	public TipoRetorno destruirSistema() {
		TipoRetorno tr = new TipoRetorno();
		// Retorno por defecto:
		tr.setTipoError(TipoError.NO_IMPLEMENTADA);
		if (getInstancia().cantPuntos == 0) {
			// No se ha inicializado el sistema.
			tr.setTipoError(TipoError.ERROR_1);
		} else {
			// Setea cantPuntos a 0:
			getInstancia().cantPuntos = 0;
			// Setea los punteros para el array de puntos, lista de tramos y
			// árbol de apicultores a null.
			getInstancia().arrPuntos = null;
			getInstancia().lstTramos = null;
			getInstancia().treApicultores = null;
			// El sistema se destruyo de forma correcta:
			tr.setTipoError(TipoError.OK);
		}
		return tr;
	}
}
