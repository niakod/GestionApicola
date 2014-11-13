
public class CentroDeExtraccion extends Punto{
	/**
	 * Capacidad de extracción en litros por mes.
	 */
	private int capacidad;
	/**
	 * Obtiene la capacidad del centro de extracción.
	 * @return Capacidad en litros por mes.
	 */
	public int getCapacidad() {
		return capacidad;
	}
	/**
	 * Establece la capacidad del centro de extracción.
	 * @param capacidad Capacidad en litros por mes.
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	/**
	 * Constructor vacío.
	 */
	public CentroDeExtraccion(){}
	/**
	 * Constructor que recibe todos los atributos y llama al constructor de Punto.
	 * @param vNombre Nombre del centro de extracción.
	 * @param vCoordX Coordenada para el eje X.
	 * @param vCoordY Coordenada para el ejeY.
	 * @param vCapacidad Capacidad en litros por mes del centro de extracción.
	 */
	public CentroDeExtraccion(String vNombre, double vCoordX, double vCoordY, int vCapacidad) {
		super(vNombre, vCoordX, vCoordY);
		this.capacidad = vCapacidad;
	}
}
