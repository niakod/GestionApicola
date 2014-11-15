package Dominio;
/**
 * Estructura para el árbol de Apicultores.
 */
public class ArbolApicultores {
	/**
	 * Apuntador hacia el primer Apicultor del árbol.
	 */
	private Apicultor primerNodo;
	/**
	 * Obtiene el primer nodo del árbol.
	 * @return Primer apicultor del árbol.
	 */
	public Apicultor getPrimerNodo() {
		return primerNodo;
	}
	/**
	 * Establece el primer nodo del árbol.
	 * @param primerNodo Primer apicultor del árbol.
	 */
	public void setPrimerNodo(Apicultor primerNodo) {
		this.primerNodo = primerNodo;
	}
	/**
	 * Constructor vacío.
	 */
	public ArbolApicultores() {
	}
	/**
	 * Constructor que recibe el atributo para el nodo raíz del árbol.
	 * @param primerNodo Primer apicultor del árbol.
	 */
	public ArbolApicultores(Apicultor primerNodo) {
		this.primerNodo = primerNodo;
	}
}
