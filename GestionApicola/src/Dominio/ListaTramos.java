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
	
	/**
	 * Devuelve el ultimo tramo de la lista.
	 * Si no existiera ninguno, devuelve null.
	 * 
	 * @return Ultimo tramo.
	 */
	 public Tramo getUltimo(){
	        Tramo t;
	        if (this.getPrimerTramo() == null){
	            t = null;
	        }
	        else{
	            t = this.getPrimerTramo();
	            while (t.getSiguiente() != null){
	                t = t.getSiguiente();
	            }
	        }
	        return t;
	    }
	 
	 /**
	  * Elimina un tramo de la lista
	  * 
	  * @param t Tramo a eliminar
	  */
	 public void eliminarTramo(Tramo t){
	        boolean aux = false;
	        Tramo item = this.getPrimerTramo();
	        if(item.equals(t)){
	            item = item.getSiguiente();
	        }
	        while(aux == false && item.getSiguiente() != null){
	            if(item.getSiguiente().equals(t)){
	                item.setSiguiente(item.getSiguiente().getSiguiente());
	            }
	        }
	    }
	 
	 /**
	  * Agrega un tramo a la lista.
	  * 
	  * @param t Tramo a agregar.
	  */
	 public void agregarTramo(Tramo t){
		 Tramo aux = getUltimo();
		 if(aux == null){
			 this.setPrimerTramo(t);
		 }else{
			 aux.setSiguiente(t);
		 }
	 }
	 
	 /**
	  * Cambia el orden de la lista: El primer item pasa al �ltimo lugar, y el segundo pasa al primero.
	  * 
	  */
	 public void cambiarOrden(){
		 if(this.getPrimerTramo() != null && this.getPrimerTramo().getSiguiente() != null){
			 Tramo t = this.getPrimerTramo();
			 this.setPrimerTramo(t.getSiguiente());
			 this.agregarTramo(t);
		 }
	 }
	 public boolean existeTramo(Tramo oTramo){
		 boolean aux = false;
		 Tramo t = this.primerTramo;
		 if(this.primerTramo != null){
			 while (aux == false && t != null){
				 if(t.getPuntoI().equals(oTramo.getPuntoI()) && t.getPuntoF().equals(oTramo.getPuntoF())){
					 aux = true;
				 }
				 else if(t.getPuntoI().equals(oTramo.getPuntoF()) && t.getPuntoF().equals(oTramo.getPuntoI())){
					 aux = true;
				 }
				 t = t.getSiguiente();
			 }
		 }
		 return aux;
	 }
}
