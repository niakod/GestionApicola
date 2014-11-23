package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Sistema;
import Dominio.TipoError;
import Dominio.TipoRetorno;

public class AgregarCiudad {

	@Test
	public void testAgregarCiudad() {
		//El sistema esta creado para 20 puntos desde RegistrarApicultor.
		//Lo destruimos y creamos uno que soporte solo tres para esta prueba:
		Sistema.getInstancia().destruirSistema();
		Sistema.getInstancia().inicializarSistema(3);
		TipoRetorno ret = Sistema.getInstancia().registrarCiudad("Maldonado", -34.908807, -54.958212);
		assertEquals("Insertar primer ciudad", TipoError.OK, ret.getTipoError());
		ret = Sistema.getInstancia().registrarCiudad("Punta Ballena", -34.888869, -55.040497);
		assertEquals("Insertar sengunda ciudad", TipoError.OK, ret.getTipoError());
		ret = Sistema.getInstancia().registrarCiudad("Otra vez Punta Ballena", -34.888869, -55.040497);
		assertEquals("Ingresar una ciudad con las coordenadas de una ciudad ya registrada en el sistema",
				TipoError.ERROR_2, ret.getTipoError());
		ret = Sistema.getInstancia().registrarCiudad("Maldonado", -32.908807, -52.958212);
		assertEquals("Ingresar una ciudad cuando ya existe un punto con el mismo nombre",
				TipoError.ERROR_3, ret.getTipoError());
		ret = Sistema.getInstancia().registrarCiudad("Punta del Este", -34.964345, -54.951200);
		assertEquals("Ingresar una tercer ciudad", TipoError.OK, ret.getTipoError());
		ret = Sistema.getInstancia().registrarCiudad("San Carlos", -34.796507, -54.926836);
		assertEquals("Ingresar una ciudad cuando ya se han registrado todos los puntos posibles",
				TipoError.ERROR_1, ret.getTipoError());
	}

}
