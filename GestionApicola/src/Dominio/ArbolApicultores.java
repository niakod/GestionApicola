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
	 * 
	 * @return Primer apicultor del árbol.
	 */
	public Apicultor getPrimerNodo() {
		return primerNodo;
	}

	/**
	 * Establece el primer nodo del árbol.
	 * 
	 * @param primerNodo
	 *            Primer apicultor del árbol.
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
	 * 
	 * @param primerNodo
	 *            Primer apicultor del árbol.
	 */
	public ArbolApicultores(Apicultor primerNodo) {
		this.primerNodo = primerNodo;
	}
	
	public boolean addApicultor(Apicultor nodoApicultor){
		boolean aux = false;
		if(this.primerNodo == null){
			this.primerNodo = nodoApicultor;
			aux = true;
		}
		else if(!existeApicultor(nodoApicultor,this.primerNodo)){
			//TODO: Recorrer el arbol, según el valor de la cédula hasta encontrar un apuntador a null.
		}
		return aux;
	}
	/**
	 * Recorre el arbol de apicultores usando recursividad.
	 * Compara la cédula del apicultor buscado con la del nodo actual.
	 * @param oApicultor Apicultor buscado.
	 * @param oRaiz Nodo actual.
	 * @return true si existe el apicultor buscado, false si no existe.
	 */
	public boolean existeApicultor(Apicultor oApicultor, Apicultor oRaiz){
		boolean aux = false;
		//Caso base: encuentra un apicultor con la misma cédula.
		if (oRaiz.getCedula() == oApicultor.getCedula()){
			aux = true;
		}
		//Si el nodo derecho es nulo:
		else if(oRaiz.getMayor() == null){
			//Si el nodo izquierdo es distinto de nulo:
			if(oRaiz.getMenor() != null){
				//Paso recursivo con el nodo de la izquierda unicamente:
				existeApicultor(oApicultor,oRaiz.getMenor());
			}
		}
		//Si el nodo izquierdo es nulo:
		else if(oRaiz.getMenor() == null){
			//Si el nodo derecho es distinto de nulo:
			if(oRaiz.getMayor() != null){
				//Paso recursivo con el nodo de la derecha unicamente:
				existeApicultor(oApicultor,oRaiz.getMayor());
			}
		}
		else{
			//Si ninguno de los dos nodos son nulos, paso recursivo con ambos:
			existeApicultor(oApicultor,oRaiz.getMenor());
			existeApicultor(oApicultor,oRaiz.getMayor());
		}
		return aux;
	}
}
