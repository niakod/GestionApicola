
public class Punto {
	/**
	 * Nombre que identifica a un punto.
	 */
	private String nombre;
	/**
	 * Coordenada del eje X del punto.
	 */
	private double coordX;
	/**
	 * Coordenada correspondiente al eje Y del punto.
	 */
	private double coordY;
	/**
	 * Getter del atributo nombre.
	 * @return Valor del atributo nombre del punto.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Setter del atributo nombre.
	 * @param nombre Valor que se asignará al atributo nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Getter del atributo coordX.
	 * @return Valor de la coordenada para el eje X del punto.
	 */
	public double getCoordX() {
		return coordX;
	}
	/**
	 * Setter para el atributo coordX
	 * @param coordX Valor que se asignará a la coordenada del eje X del punto.
	 */
	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}
	/**
	 * Getter para el atributo coordY.
	 * @return Valor de la coordenada para el eje Y del punto.
	 */
	public double getCoordY() {
		return coordY;
	}
	/**
	 * Setter para el atributo coordY.
	 * @param coordY Valor que se asignará al eje Y del punto.
	 */
	public void setCoordY(double coordY) {
		this.coordY = coordY;
	}
	/**
	 * Constructor que recibe todos los parámetro.
	 * @param vNombre Nombre del punto.
	 * @param vCoordX Valor de la coordenada para el eje X.
	 * @param vCoordY Valor de la coordenada para el eje Y.
	 */
	public Punto(String vNombre, double vCoordX, double vCoordY) {
		this.nombre = vNombre;
		this.coordX = vCoordX;
		this.coordY = vCoordY;
	}
	/**
	 * Constructor vacío.
	 */
	public Punto(){}
}
