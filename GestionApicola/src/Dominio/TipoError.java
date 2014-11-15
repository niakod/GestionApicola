package Dominio;

/**
 * Establece los valores posibles para cuando un método es ejecutado
 * correctamente: OK, <br/>
 * para cuando el método responde con un error: ERROR_1,ERROR_2,ERROR_3,ERROR_4, <br/>
 * y para cuando la funcionalidad del método aún no ha sido implementado:
 * NO_IMPLEMENTADA.
 */
public enum TipoError {
	OK, ERROR_1, ERROR_2, ERROR_3, ERROR_4, NO_IMPLEMENTADA
}
