package Dominio;

/**
 * Un Tramo une dos Puntos y tiene un peso. <br/>
 * Nodo de ListaTramos.
 */
public class Tramo {
	/**
	 * Punto inicial del tramo.
	 */
	private Punto puntoI;
	/**
	 * Punto final del tramo.
	 */
	private Punto puntoF;
	/**
	 * Peso del tramo. Distancia entre un punto y otro.
	 */
	private int peso;
	/**
	 * Apuntador al siguiente tramo de la lista.
	 */
	private Tramo siguiente;

	/**
	 * Obtiene el punto de inicio del tramo.
	 * 
	 * @return Punto de inicio.
	 */
	public Punto getPuntoI() {
		return puntoI;
	}

	/**
	 * Establece el punto de inicio del tramo.
	 * 
	 * @param puntoI
	 *            Punto de inicio.
	 */
	public void setPuntoI(Punto puntoI) {
		this.puntoI = puntoI;
	}

	/**
	 * Obtiene el punto final del tramo.
	 * 
	 * @return Punto final.
	 */
	public Punto getPuntoF() {
		return puntoF;
	}

	/**
	 * Establece el punto final del tramo.
	 * 
	 * @param puntoF
	 *            Punto final.
	 */
	public void setPuntoF(Punto puntoF) {
		this.puntoF = puntoF;
	}

	/**
	 * Obtiene el peso del tramo.
	 * 
	 * @return Peso del tramo.
	 */
	public int getPeso() {
		return peso;
	}

	/**
	 * Establece el peso del tramo.
	 * 
	 * @param peso
	 *            Peso del tramo.
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}

	/**
	 * Obtiene el siguiente nodo de ListaTramos.
	 * 
	 * @return Siguiente tramo.
	 */
	public Tramo getSiguiente() {
		return siguiente;
	}

	/**
	 * Establece el siguiente nodo de ListaTramo.
	 * 
	 * @param siguiente
	 *            Siguiente tramo.
	 */
	public void setSiguiente(Tramo siguiente) {
		this.siguiente = siguiente;
	}

	/**
	 * Constructor vacío.
	 */
	public Tramo() {
	}

	/**
	 * Constructor que recibe todos los atributos de un tramo.
	 * 
	 * @param puntoI
	 *            Punto inicial del tramo.
	 * @param puntoF
	 *            Punto final del tramo.
	 * @param peso
	 *            Peso del tramo.
	 * @param siguiente
	 *            Siguiente tramo-nodo de ListaTramo.
	 */
	public Tramo(Punto puntoI, Punto puntoF, int peso, Tramo siguiente) {
		this.puntoI = puntoI;
		this.puntoF = puntoF;
		this.peso = peso;
		this.siguiente = siguiente;
	}
}
