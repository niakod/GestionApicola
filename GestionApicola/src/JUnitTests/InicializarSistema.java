package JUnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import Dominio.Sistema;
import Dominio.TipoRetorno;
import Dominio.TipoError;

public class InicializarSistema {

	@Test
	public void testInicializarSistema() {
		TipoRetorno tr = Sistema.getInstancia().inicializarSistema(0);
		assertEquals("No se puede inicializar el sistema con 0 puntos",
				TipoError.ERROR_1, tr.getTipoError());
		tr = Sistema.getInstancia().inicializarSistema(-3);
		assertEquals(
				"No se puede inicializar el sistema con una cantidad de puntos menor a cero",
				TipoError.ERROR_1, tr.getTipoError());
		tr = Sistema.getInstancia().inicializarSistema(2);
		assertEquals(
				"El sistema se inicializa correctamente con un número mayor a 0",
				TipoError.OK, tr.getTipoError());
		tr = Sistema.getInstancia().inicializarSistema(10);
		assertEquals("No se puede inicializar el sistema sin destruírlo antes",
				TipoError.ERROR_2, tr.getTipoError());
	}
}
