package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Sistema;
import Dominio.TipoError;
import Dominio.TipoRetorno;

public class DestruirSistema {

	@Test
	public void testDestruirSistema() {
		/*
		 * Si se corren todos los test juntos, se debe destruír el sistema, ya que se deja inicializado
		 * por el test InicializarSistema.
		 * De lo contrario, no afecta al test.
		 */
		Sistema.getInstancia().destruirSistema();
		//Test:
		TipoRetorno tr = Sistema.getInstancia().destruirSistema();
		assertEquals("No puede destruirse un sistema si no se ha inicializado",TipoError.ERROR_1, tr.getTipoError());
		Sistema.getInstancia().inicializarSistema(5); //Se inicializa el sistema para el siguiente test.
		tr = Sistema.getInstancia().destruirSistema();
		assertEquals("Sistema destruído luego de creado", TipoError.OK, tr.getTipoError());
	}

}
