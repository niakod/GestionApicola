package Dominio;

/**
 * Un apiario hereda de punto, tiene una capacidad y un Agricultor. Se almacenan
 * en un array de puntos.
 */
public class Apiario extends Punto {
	/**
	 * Capacidad del apiario en litros por mes.
	 */
	private int capacidad;
	/**
	 * Apicultor encargado del apiario.
	 */
	private Apicultor apicultor;

	/**
	 * Obtiene la capacidad del apiario.
	 * 
	 * @return Capacidad en litros por mes.
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * Establece la capacidad del apiario.
	 * 
	 * @param capacidad
	 *            Capacidad en litros por mes,
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * Obtiene al apicultor encargado del apiario.
	 * 
	 * @return Apicultor a cargo del apiario.
	 */
	public Apicultor getApicultor() {
		return apicultor;
	}

	/**
	 * Establece el apicultor a cargo del apiario.
	 * 
	 * @param apicultor
	 *            Apicultor encargado del apiario.
	 */
	public void setApicultor(Apicultor apicultor) {
		this.apicultor = apicultor;
	}

	/**
	 * Constructor vacío.
	 */
	public Apiario() {
	}

	/**
	 * Constructor que recibe todos los atributos.
	 * 
	 * @param vNombre
	 *            Nombre del apiario.
	 * @param vCoordX
	 *            Coordenada del eje X.
	 * @param vCoordY
	 *            Coordenada del eje Y.
	 * @param vCapacidad
	 *            Capacidad en litros por mes.
	 * @param vApicultor
	 *            Apicultor a cargo del apiario.
	 */
	public Apiario(String vNombre, double vCoordX, double vCoordY,
			int vCapacidad, Apicultor vApicultor) {
		super(vNombre, vCoordX, vCoordY);
		this.capacidad = vCapacidad;
		this.apicultor = vApicultor;
	}

}
