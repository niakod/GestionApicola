package Dominio;
/**
 * Hereda de punto.
 * No contiene más atributos que los heredados.
 * Se almacena en un array de puntos.
 */
public class Ciudad extends Punto{
	/**
	 * Constructor vacío.
	 */
	public Ciudad(){}
	/**
	 * Constructor que recibe todos los atributos y llama al constructor de Punto.
	 * @param vNombre Nombre de la ciudad.
	 * @param vCoordX Coordenada para el eje X.
	 * @param vCoordY Coordenada para el ejeY.
	 */
	public Ciudad(String vNombre, double vCoordX, double vCoordY) {
		super(vNombre, vCoordX, vCoordY);
	}
}
