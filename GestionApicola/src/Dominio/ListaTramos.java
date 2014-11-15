package Dominio;

/**
 * Lista simplemente enlazada para almacer los tramos.
 */
public class ListaTramos {
	/**
	 * Apuntador al primer nodo de la lista.
	 */
	private Tramo primerTramo;

	/**
	 * Obtiene el primer nodo de la lista.
	 * 
	 * @return Primer tramo.
	 */
	public Tramo getPrimerTramo() {
		return primerTramo;
	}

	/**
	 * Establece el primer nodo de la lista.
	 * 
	 * @param primerTramo
	 *            Primer tramo.
	 */
	public void setPrimerTramo(Tramo primerTramo) {
		this.primerTramo = primerTramo;
	}

	/**
	 * Constructor vacío.
	 */
	public ListaTramos() {
	}

	/**
	 * Constructor que asigna un valor al atributo de la clase.
	 * 
	 * @param primerTramo
	 *            Primer nodo de la lista de tramos.
	 */
	public ListaTramos(Tramo primerTramo) {
		this.primerTramo = primerTramo;
	}

}
