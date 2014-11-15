package Dominio;
/**
 * Clase que se utiliza para devolver los resultados de los métodos. <br/>
 * Tendrá un tipo de error y opcionalmente, si existen, un valor entero y un valor de tipo String.
 */
public class TipoRetorno {
	/**
	 * Atributo utilizado para devolver un valor del enum TipoError según el estado de la funcionalidad solicitada.
	 * Si se pudo realizar de forma correcta, será OK, si hubo algún error será ERROR_[número del error]
	 * y si la funcionalidad aún no ha sido implementada será NO_IMPLEMENTADA.
	 */
	private TipoError tipoError;
	/**
	 * Atributo que se utiliza para devolver un valor entero, en caso de ser necesario.
	 */
	private int valorEntero;
	/**
	 * Atributo que se utiliza para devolver una cadena de texto, en caso de ser necesario.
	 */
	private String valorString;
	/**
	 * Getter para el tipo de error.
	 * @return OK en caso de éxito, ERROR_[número del error] en caso de error, NO_IMPLEMENTADA en caso de
	 * que la funcionalidad solicitada aún no esté disponible.
	 */
	public TipoError getTipoError() {
		return tipoError;
	}
	/**
	 * Setter para el atributo tipoError.
	 * @param tipoError Recibe el valor que devolverá según el resultado de una funcionalidad:
	 * OK en caso de éxito, ERROR_[número del error] en caso de error, NO_IMPLEMENTADA en caso de
	 * que la funcionalidad solicitada aún no esté disponible.
	 */
	public void setTipoError(TipoError tipoError) {
		this.tipoError = tipoError;
	}
	/**
	 * Getter para el atributo valorEntero
	 * @return Obtiene el valor entero que devolvió la funcionalidad solicitada.
	 */
	public int getValorEntero() {
		return valorEntero;
	}
	/**
	 * Setter para el atributo valorEntero
	 * @param valorEntero Establece el valor entero que devuelve el método solicitado.
	 */
	public void setValorEntero(int valorEntero) {
		this.valorEntero = valorEntero;
	}
	/**
	 * Getter para el atributo valorString
	 * @return Cadena de texto que devolvió la funcionalidad solicitada.
	 */
	public String getValorString() {
		return valorString;
	}
	/**
	 * Setter para el atributo valorString
	 * @param valorString Establece la cadena de texto que devuelve el método solicitado.
	 */
	public void setValorString(String valorString) {
		this.valorString = valorString;
	}
	/**
	 * Constructor vacío.
	 */
	public TipoRetorno(){}
}
