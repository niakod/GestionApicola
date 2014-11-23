package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Sistema;
import Dominio.TipoError;
import Dominio.TipoRetorno;

public class RegistrarApiario {

	@Test
	public void test() {
		//Destruye el sistema, si existe, e inicializa un nuevo sistema para 3 puntos:
		Sistema.getInstancia().destruirSistema();
		Sistema.getInstancia().inicializarSistema(3);
		//Registro de un apiculto para los apiarios:
		Sistema.getInstancia().registrarApicultor(12223334,"Jhon Abejas","Abejorro, Las Camelias esq. El Ceibo","jhon@abejas.com","099111222");
		//Registro de una ciudad (también es punto, ocupa un lugar de los puntos del sistema):
		Sistema.getInstancia().registrarCiudad("Maldonado", -34.908807, -54.958212);
		//Casos de prueba:
		TipoRetorno ret = new TipoRetorno();
		ret = Sistema.getInstancia().registrarApiario("Abejas felices", -34.903704, -54.973533, 12223334, 20);
		assertEquals("Primer apiario ingresador de forma correcta",TipoError.OK, ret.getTipoError());
		ret = Sistema.getInstancia().registrarApiario("Melosos Anónimos", -33.900571, -54.962933, 12223334, 45);
		assertEquals("Segundo apiario registrado", TipoError.OK, ret.getTipoError());
		ret = Sistema.getInstancia().registrarApiario("Un apiario", -34.908807, -54.958212, 12223334, 27);
		assertEquals("Registro de apiario en coordenadas de una ciudad (otro punto ya registrado en el sistema",
				TipoError.ERROR_2, ret.getTipoError());
		ret = Sistema.getInstancia().registrarApiario("Otro apiario", -34.908807, -54.958222, 10009999, 80);
		assertEquals("Registro de un apiario cuando la cédula del apicultor no existe en el sistema",
				TipoError.ERROR_4, ret.getTipoError());
		ret = Sistema.getInstancia().registrarApiario("Abejas felices", -34.903724, -54.973553, 12223334, 20);
		assertEquals("Registro de un apiario cuyo nombre ya ha sido registrado", TipoError.ERROR_3, ret.getTipoError());
		ret = Sistema.getInstancia().registrarApiario("Maldonado", -34.800571, -54.862933, 12223334, 45);
		assertEquals("Registro de un apiario cuando el nombre ya pertenece a un punto del sistema", TipoError.ERROR_3,
				ret.getTipoError());
		ret = Sistema.getInstancia().registrarApiario("Miel para todos", -34.902118, -54.944951, 12223334, 60);
		assertEquals("Registro de un apiario cuando ya no se pueden añadir nuevos puntos al sistema",
				TipoError.ERROR_1, ret.getTipoError());
	}

}
