package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Sistema;
import Dominio.TipoError;
import Dominio.TipoRetorno;

public class RegistrarCentro {

	@Test
	public void test() {
		//Se elimina (si existía) y se vuelve a crear un sistema con capacidad de 3 puntos.
		Sistema.getInstancia().destruirSistema();
		Sistema.getInstancia().inicializarSistema(3);
		TipoRetorno ret = Sistema.getInstancia().registrarCentro("Maldonado Extracciones", -34.908827, -54.958256, 220);
		assertEquals("Insertar primer centro", TipoError.OK, ret.getTipoError());
		ret = Sistema.getInstancia().registrarCentro("Punta Ballena Extracciones", -34.888877, -55.040423, 350);
		assertEquals("Insertar sengundo centro", TipoError.OK, ret.getTipoError());
		ret = Sistema.getInstancia().registrarCentro("Otra vez", -34.908827, -54.958256, 120);
		assertEquals("Ingresar una ciudad con las coordenadas de una ciudad ya registrada en el sistema",
				TipoError.ERROR_2, ret.getTipoError());
		ret = Sistema.getInstancia().registrarCentro("Maldonado Extracciones", -32.908807, -52.958212, 530);
		assertEquals("Ingresar un centro cuando ya existe un punto con el mismo nombre",
				TipoError.ERROR_3, ret.getTipoError());
		ret = Sistema.getInstancia().registrarCentro("Punta del Este Extracciones", -34.964245, -54.951100, 358);
		assertEquals("Ingresar un tercer centro", TipoError.OK, ret.getTipoError());
		ret = Sistema.getInstancia().registrarCentro("San Carlos Extracciones", -34.796557, -54.926876, 180);
		assertEquals("Ingresar un centro cuando ya se han registrado todos los puntos posibles",
				TipoError.ERROR_1, ret.getTipoError());
	}

}
