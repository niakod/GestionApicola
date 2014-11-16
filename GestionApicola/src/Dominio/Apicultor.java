package Dominio;

/**
 * Apicultor contiene los datos de las personas encargadas de los apiarios, nodo
 * de ArbolApicultores.
 */
public class Apicultor {
	/**
	 * Cédula de identidad del apicultor.
	 */
	private int cedula;
	/**
	 * Nombre del apicultor.
	 */
	private String nombre;
	/**
	 * Direccion del apicultor.
	 */
	private String direccion;
	/**
	 * Dirección de correo electrónico del apicultor.
	 */
	private String email;
	/**
	 * Celular del apicultor.
	 */
	private String celular;
	/**
	 * Nodo Apicultor con cédula menor al actual (nodo izquierdo del árbol).
	 */
	private Apicultor menor;
	/**
	 * Nodo Apicultor con cédula mayor al actual (nodo derecho del árbol).
	 */
	private Apicultor mayor;

	/**
	 * Getter para el atributo cedula.
	 * 
	 * @return Cédula del apicultor.
	 */
	public int getCedula() {
		return cedula;
	}

	/**
	 * Establece el valor del atributo cedula..
	 * 
	 * @param cedula
	 *            Cédula del apicultor.
	 */
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	/**
	 * Obtiene el atributo nombre.
	 * 
	 * @return Nombre del apicultor.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el atributo nombre.
	 * 
	 * @param nombre
	 *            Nombre del apicultor.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el atributo direccion.
	 * 
	 * @return Dirección del apicultor.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece el valor del atributo direccion.
	 * 
	 * @param direccion
	 *            Dirección del apicultor.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Obtiene el atributo email
	 * 
	 * @return Dirección de correo electrónico del apicultor.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Establece el valor del atributo email.
	 * 
	 * @param email
	 *            Dirección de correo electrónico del apicultor.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Obtiene el valor del atributo celular.
	 * 
	 * @return Celular del apicultor.
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * Establece el valor del atributo celular.
	 * 
	 * @param celular
	 *            Número de teléfono móvil del apicultor.
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * Obtiene el nodo izquierdo del árbol con respecto al actual.
	 * 
	 * @return Nodo Apicultor izquierdo.
	 */
	public Apicultor getMenor() {
		return menor;
	}

	/**
	 * Establece el nodo izquierdo del árbol con respecto al actual.
	 * 
	 * @param menor
	 *            Nodo Apicultor izquierdo.
	 */
	public void setMenor(Apicultor menor) {
		this.menor = menor;
	}

	/**
	 * Obtiene el nodo derecho del árbol con respecto al actual.
	 * 
	 * @return Nodo Apicultor derecho.
	 */
	public Apicultor getMayor() {
		return mayor;
	}

	/**
	 * Establece el nodo derecho del árbol con respecto al actual.
	 * 
	 * @param mayor
	 *            Nodo Apicultor derecho.
	 */
	public void setMayor(Apicultor mayor) {
		this.mayor = mayor;
	}
	/**
	 * Constructor vacío.
	 */
	public Apicultor(){}
	
	public Apicultor(int vCedula, String vNombre, String vDireccion, String vEmail, String vCelular){
		this.cedula = vCedula;
		this.nombre = vNombre;
		this.direccion = vDireccion;
		this.email = vEmail;
		this.celular = vCelular;
		this.mayor = null;
		this.menor = null;
	}
}
