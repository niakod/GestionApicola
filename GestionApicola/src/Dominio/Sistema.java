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
	 * @param vCantPuntos
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

	/**
	 * Registra al apicultor de cédula "cedula" en el sistema.
	 * 
	 * @param cedula
	 *            Cédula del nuevo apicultor.
	 * @param nombre
	 *            Nombre del nuevo apicultor.
	 * @param direccion
	 *            Dirección del nuevo apicultor.
	 * @param email
	 *            Dirección de correo electrónico del nuevo apicultor.
	 * @param celular
	 *            Número de teléfono móvil del nuevo apicultor.
	 * @return Resultado del método.
	 */
	public TipoRetorno registrarApicultor(int cedula, String nombre,
			String direccion, String email, String celular) {
		TipoRetorno ret = new TipoRetorno();
		ret.setTipoError(TipoError.NO_IMPLEMENTADA); // Retorno por defecto.
		Apicultor a = new Apicultor(cedula, nombre, direccion, email, celular);
		boolean booAux = treApicultores.addApicultor(a);
		if (booAux == false) {
			ret.setTipoError(TipoError.ERROR_1);
		} else {
			ret.setTipoError(TipoError.OK);
		}
		return ret;
	}

	/**
	 * Registra la ciudad de nombre nombre y coordenadas coordX, coordY en el
	 * sistema.
	 * 
	 * @param nombre
	 *            Nombre de la ciudad.
	 * @param coordX
	 *            Coordenada en el eje x para la localización de la ciudad.
	 * @param coordY
	 *            Coordenada en el eje y para la localización de la ciudad.
	 * @return Resultado del método.
	 */
	public TipoRetorno registrarCiudad(String nombre, double coordX,
			double coordY) {
		TipoRetorno ret = new TipoRetorno();
		ret.setTipoError(TipoError.NO_IMPLEMENTADA); // Retorno por defecto.
		Ciudad c = new Ciudad(nombre, coordX, coordY);
		if (!existePunto(c)) {
			boolean aux = false;
			int i = 0;
			while (aux == false && i < cantPuntos) {
				if (arrPuntos[i] == null) {
					arrPuntos[i] = c;
					aux = true;
					ret.setTipoError(TipoError.OK);
				} else if (arrPuntos[i].getCoordX() == c.getCoordX()
						&& arrPuntos[i].getCoordY() == c.getCoordY()) {
					ret.setTipoError(TipoError.ERROR_2);
					aux = true;
				}
				i++;
			}
			if (aux == false) {
				ret.setTipoError(TipoError.ERROR_1);
			}
		} else {
			ret.setTipoError(TipoError.ERROR_3);
		}
		return ret;
	}

	/**
	 * Chequea si existe un punto de nombre p.nombre en el sistema.
	 * 
	 * @param p
	 *            Nuevo punto.
	 * @return false si no existe, true si existe.
	 */
	public boolean existePunto(Punto p) {
		boolean aux = false;
		int i = 0;
		while (i < this.cantPuntos && aux == false) {
			if (arrPuntos[i] != null) {
				if (arrPuntos[i].getNombre().equals(p.getNombre())) {
					aux = true;
				}
			}
			i++;
		}
		return aux;
	}	

	/**
	 * 
	 * @param coordX 
	 * 		Coordenada en el eje x para la localización de la ciudad.
	 * @param coordY
	 * 		Coordenada en el eje y para la localización de la ciudad.
	 * @return Resultado del método.
	 */
	public TipoRetorno listadoDeApiariosEnCiudad(Double coordX, Double coordY) {
		TipoRetorno ret = new TipoRetorno();
		ret.setTipoError(TipoError.NO_IMPLEMENTADA); // Retorno por defecto.
		
		//Se crea una instancia de punto con las coordenadas recibidas como parametro.
		Punto p = new Punto();
		p.setCoordX(coordX);
		p.setCoordY(coordY);
		//Se crea una lista auxiliar de tramos, en la que se guardan los que tengan un peso menor a 20.
		ListaTramos lstAux = new ListaTramos();
		Tramo t = lstTramos.getPrimerTramo();
		if (t != null && t.getPeso() <= 20) {
			lstAux.agregarTramo(t);
		}
		while(t.getSiguiente() != null){
			t = t.getSiguiente();
			if(t.getPeso() <= 20){
				lstAux.agregarTramo(t);
			}
		}
		String strApiarios = "";
		strApiarios = listarApiarios(lstAux, strApiarios, 0, p);
		
		ret.setTipoError(TipoError.OK);
		ret.setValorString(strApiarios);
		
		return ret;
		
	}
	
	/**
	 * Devuelve una lista de coordenadas X e Y de apiarios que sean alcanzables recorriendo no mas de 20 Kil�metros desde el
	 * punto que define la ciudad.
	 * 
	 * @param lst 
	 * 			Una copia de lstTramos.
	 * @param lista 
	 * 			Variable String que acumula las coordenadas de los apiarios encontrados.
	 * @param distanciaParcial 
	 * 			Siempre vale 0 si se parte del punto que define la ciudad; en caso que se este evaluando un tramo que 
	 * enlazado al anterior pueda llevar a un apiario, el valor de este par�metro sera el del peso del tramo anterior.
	 *
	 * @param punto
	 * 		punto de origen del tramo que se evalua.
	 * @return Resultado del m�todo.
	 */
	private String listarApiarios(ListaTramos lst, String lista, int distanciaParcial,
			Punto punto) {
		Tramo t = lst.getPrimerTramo();
		if (t.getPeso() + distanciaParcial <= 20) {
			if (t.getPuntoI().getCoordX() == punto.getCoordX()
					&& t.getPuntoI().getCoordY() == punto.getCoordY()) {
				if (t.getPuntoF().getClass().getName()
						.equals("Dominio.Apiario")) {
					lista += t.getPuntoF().getCoordX() + ";"
							+ t.getPuntoF().getCoordY() + "|";
				}
				if (t.getSiguiente() != null) {
					Tramo tAux = t.getSiguiente();
					lst.eliminarTramo(t);
					lista = listarApiarios(lst, lista,
							tAux.getPeso(), tAux.getPuntoF());
				}
			} else if (t.getPuntoF().getCoordX() == punto.getCoordX()
					&& t.getPuntoF().getCoordY() == punto.getCoordY()) {
				if (t.getPuntoI().getClass().getName()
						.equals("Dominio.Apiario")) {
					lista += t.getPuntoI().getCoordX() + ";"
							+ t.getPuntoI().getCoordY() + "|";

				}
				if (t.getSiguiente() != null) {
					Tramo tAux = t.getSiguiente();
					lst.eliminarTramo(t);
					lista = listarApiarios(lst, lista,
							tAux.getPeso(), tAux.getPuntoI());
				}

			}
		}
		if(t.getSiguiente() != null){
			lst.cambiarOrden();
			lista = listarApiarios(lst, lista, distanciaParcial, punto);
		}
		return lista;
	}
	
	/**
	 * Devuelve un listado con todos los centros de extraccion.
	 * 
	 * @return Resultado del método.
	 */
	public TipoRetorno listadoDeCentros(){
		TipoRetorno ret = new TipoRetorno();
		ret.setTipoError(TipoError.NO_IMPLEMENTADA); // Retorno por defecto.
		String strLista = "";
		
		for(int i = 0; i < cantPuntos; i++){
			if(arrPuntos[i].getClass().getName().equals("Dominio.CentroDeExtraccion")){
				CentroDeExtraccion ce = (CentroDeExtraccion) arrPuntos[i];
				strLista += ce.getCoordX() + ";" + ce.getCoordY() + ";" + ce.getCapacidad() + "|";
			}
		}
		
		ret.setTipoError(TipoError.OK);
		ret.setValorString(strLista);
		
		return ret;
	}
	
	/**
	 * Devuelve un listado de los apicultores ordenados por c�dula de forma ascendente.
	 * 
	 * @return Resultado del m�todo.
	 */
	public TipoRetorno listadoApicultores(){
		TipoRetorno ret = new TipoRetorno();
		String strApicultores = getApicultoresInOrden(this.treApicultores.getPrimerNodo());
		ret.setTipoError(TipoError.OK);
		ret.setValorString(strApicultores);
		
		return ret;
	}
	
	/**
	 * Recorre un arbol de Apicultores y devuelve un String con los datos de los mismos, ordenado
	 * de forma ascendente por su c�dula.
	 * 
	 * @param a Instancia de Apicultor.
	 * 
	 * @return Resultado del m�todo.
	 * 
	 */
	private String getApicultoresInOrden(Apicultor a){
		String ret = "";
		if(a != null){
		ret += getApicultoresInOrden(a.getMenor());
		ret += a.getCedula() + ";" + a.getNombre() + ";" + a.getCelular() + "|";
		ret += getApicultoresInOrden(a.getMayor());
		}
		return ret;
	}
	/**
	 * Registra un apiario de nombre nombre en el sistema, el cual está a cargo del apicultor de cédula
	 * cedula_apicultor y tiene una capacidad de producción de capacidad litros de miel por mes.
	 * @param nombre Nombre del apiario.
	 * @param coordX Coordinada del eje X.
	 * @param coordY Coordinada del eje Y.
	 * @param cedula_apicultor Cédula de identidad del apicultor a cargo del apiario.
	 * @param capacidad Capacidad del producción (en litros de miel por mes).
	 * @return Resultado del método.
	 */
	public TipoRetorno registrarApiario(String nombre, double coordX, double coordY, int cedula_apicultor,
			int capacidad){
		TipoRetorno ret = new TipoRetorno();
		ret.setTipoError(TipoError.NO_IMPLEMENTADA); //Retorno por defecto.
		Apicultor a = new Apicultor();
		a.setCedula(cedula_apicultor);
		a = treApicultores.existeApicultor(a, treApicultores.getPrimerNodo());
		if (a != null){
			Apiario api = new Apiario(nombre, coordX, coordY, capacidad, a);
			if (!existePunto(api)) {
				boolean aux = false;
				int i = 0;
				while (aux == false && i < cantPuntos) {
					if (arrPuntos[i] == null) {
						arrPuntos[i] = api;
						aux = true;
						ret.setTipoError(TipoError.OK);
					} else if (arrPuntos[i].getCoordX() == api.getCoordX() && arrPuntos[i].getCoordY() == api.getCoordY()) {
						ret.setTipoError(TipoError.ERROR_2);
						aux = true;
					}
					i++;
				}
				if (aux == false) {
					ret.setTipoError(TipoError.ERROR_1);
				}
			}
			else{
				ret.setTipoError(TipoError.ERROR_3);
			}
		}
		else{
			ret.setTipoError(TipoError.ERROR_4); //No existe apicultor.
		}
		return ret;
	}
	/**
	 * Registra un centro de extracción de nombre "nombre" en el sistema, con una capacidad de extracción
	 * de "capacidad" litros de miel por mes.
	 * @param nombre Nombre del centro de extracción.
	 * @param coordX Coordenada de ubicación del centro en el eje X.
	 * @param coordY Coordenada de localización del centro en el eje Y.
	 * @param capacidad Capacidad en litros de miel por mes que puede ser extraíada en este centro.
	 * @return Resultado del método.
	 */
	public TipoRetorno registrarCentro(String nombre, double coordX, double coordY, int capacidad){
		TipoRetorno ret = new TipoRetorno();
		ret.setTipoError(TipoError.NO_IMPLEMENTADA); //Retorno por defecto.
		CentroDeExtraccion c = new CentroDeExtraccion(nombre, coordX, coordY, capacidad);
		if (!existePunto(c)) {
			boolean aux = false;
			int i = 0;
			while (aux == false && i < cantPuntos) {
				if (arrPuntos[i] == null) {
					arrPuntos[i] = c;
					aux = true;
					ret.setTipoError(TipoError.OK);
				} else if (arrPuntos[i].getCoordX() == c.getCoordX() && arrPuntos[i].getCoordY() == c.getCoordY()) {
					ret.setTipoError(TipoError.ERROR_2);
					aux = true;
				}
				i++;
			}
			if (aux == false) {
				ret.setTipoError(TipoError.ERROR_1);
			}
		}
		else{
			ret.setTipoError(TipoError.ERROR_3);
		}
		return ret;
	}
	
	/**
	 * Registra un tramo en el sistema desde la coordenada inicio (coordXi,coordYi) hasta la coordenanda
	 * destino (coordXf,coordYf) de peso "peso".
	 * @param coordXi Coordenada para el eje X inicial.
	 * @param coordYi Coordenada para el eje Y inicial.
	 * @param coordXf Coordenada para el eje X final.
	 * @param coordYf Coordenada para el eje Y final.
	 * @param peso Kilómetros del tramo.
	 * @return Resultado del método.
	 */
	public TipoRetorno registrarTramo(double coordXi, double coordYi, double coordXf, double coordYf, int peso){
		TipoRetorno ret = new TipoRetorno();
		ret.setTipoError(TipoError.NO_IMPLEMENTADA); //Por defecto.
		Punto pInicio = getPuntoByCoords(coordXi, coordYi);
		Punto pFinal = getPuntoByCoords(coordXf, coordYf);
		if(peso > 0){
			if (pInicio != null && pFinal != null){
				Tramo t = new Tramo(pInicio, pFinal, peso, null);
				if(!lstTramos.existeTramo(t)){
					lstTramos.agregarTramo(t);
					ret.setTipoError(TipoError.OK);
				}
				else{
					ret.setTipoError(TipoError.ERROR_3);//Ya existe el tramo.
				}
			} else {
				ret.setTipoError(TipoError.ERROR_2); //No existe uno o ambos puntos.
			}
		}
		else{
			ret.setTipoError(TipoError.ERROR_1);
		}
		return ret;
	}
	/**
	 * Obtiene un Punto dadas sus coordenadas.
	 * @param coordX Coordenada del punto para el eje X.
	 * @param coordY Coordenada del punto para el eje Y.
	 * @return Punto ubicado en las coordenadas dadas, null si el punto no existe.
	 */
	public Punto getPuntoByCoords(double coordX, double coordY){
		Punto p = null;
		int i = 0;
			while (p == null && i < cantPuntos){
				if(arrPuntos[i].getCoordX() == coordX && arrPuntos[i].getCoordY() == coordY){
					p = arrPuntos[i];
				}
				i++;
			}
		return p;
	}
	/**
	 * Genera la cadena para un mapa de Google Maps que muestre todos los puntos registrados en el sistema (apiarios,
	 * ciudades y centros de extracción.
	 * Para diferenciarlos, mostrará las ciudades en rojo, los centros de extracción en verde y los centros de
	 * extracción en amarillo.
	 * @return Resultado del metodo.
	 */
	public TipoRetorno mapaEstado(){
		TipoRetorno ret = new TipoRetorno();
		ret.setTipoError(TipoError.NO_IMPLEMENTADA); //Retorno por defecto
		int i = 0;
		String aux = "";
		if(arrPuntos[0] != null){
			aux = "http://maps.googleapis.com/maps/api/staticmap?center=-34.9054885,-54.9636822&zoom=13&size=640x640&maptype=roadmap";
			while (i < cantPuntos && arrPuntos[i] != null){
				if(arrPuntos[i].getClass().equals(Ciudad.class)){
					aux += "&markers=color:red%7Clabel:C%7C"+arrPuntos[i].getCoordX()+","+arrPuntos[i].getCoordY();
				}
				else if(arrPuntos[i].getClass().equals(CentroDeExtraccion.class)){
					aux += "&markers=color:green%7Clabel:E%7C"+arrPuntos[i].getCoordX()+","+arrPuntos[i].getCoordY();
				}
				else if(arrPuntos[i].getClass().equals(Apiario.class)){
					aux += "&markers=color:yellow%7Clabel:A%7C"+arrPuntos[i].getCoordX()+","+arrPuntos[i].getCoordY();
				}
				i++;
			}
		}
		ret.setTipoError(TipoError.OK);
		ret.setValorString(aux);
		return ret;
	}
}
