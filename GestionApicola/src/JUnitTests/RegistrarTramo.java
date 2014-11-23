package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Sistema;
import Dominio.TipoError;
import Dominio.TipoRetorno;

public class RegistrarTramo {

	@Test
	public void test() {
		//Se destruye (si existe) el sistema y se crea para 3 puntos:
		Sistema.getInstancia().destruirSistema();
		Sistema.getInstancia().inicializarSistema(3);
		//Se registran tres puntos en el sistema y un apicultor para el apiario:
		Sistema.getInstancia().registrarApicultor(12223334,"Jhon Abejas","Abejorro, Las Camelias esq. El Ceibo","jhon@abejas.com","099111222");//Apicultor
		Sistema.getInstancia().registrarCiudad("Maldonado", -34.908807, -54.958212); //Ciudad
		Sistema.getInstancia().registrarApiario("Abejas felices", -34.903704, -54.973533, 12223334, 20);//Apiario
		Sistema.getInstancia().registrarCentro("Maldonado Extracciones", -34.908827, -54.958256, 220);//Centro de extracción
		//Test:
		TipoRetorno ret = new TipoRetorno();
		ret = Sistema.getInstancia().registrarTramo(-34.903704, -54.973533, -34.908807, -54.958212, 1);
		assertEquals("Registro de un tramo", TipoError.OK, ret.getTipoError());
		ret = Sistema.getInstancia().registrarTramo(-34.903704, -54.973533, -34.908807, -54.958212, 1);
		assertEquals("Registro de un tramo ya registrado", TipoError.ERROR_3, ret.getTipoError());
		ret = Sistema.getInstancia().registrarTramo(-34.908807, -54.958212,-34.903704, -54.973533, 1);
		assertEquals("Registro de un tramo ya registrado con los puntos invertidos", TipoError.ERROR_3, ret.getTipoError());
		ret = Sistema.getInstancia().registrarTramo(-33.903704, -53.973533, -33.908807, -34.958212, 1);
		assertEquals("Registro de un tramo cuyos dos puntos no existen", TipoError.ERROR_2, ret.getTipoError());
		ret = Sistema.getInstancia().registrarTramo(-14.903704, -14.973533, -34.908807, -54.958212, 1);
		assertEquals("Registro de un tramo cuyo punto inicial no existe", TipoError.ERROR_2, ret.getTipoError());
		ret = Sistema.getInstancia().registrarTramo(-34.903704, -54.973533, -14.908807, -14.958212, 1);
		assertEquals("Registro de un tramo cuyo punto final no existe", TipoError.ERROR_2, ret.getTipoError());
		ret = Sistema.getInstancia().registrarTramo(-34.903704, -54.973533, -34.908827, -54.958256, 0);
		assertEquals("Registro de un tramo cuyo peso es cero", TipoError.ERROR_1, ret.getTipoError());
		ret = Sistema.getInstancia().registrarTramo(-34.903704, -54.973533, -34.908827, -54.958256, -1);
		assertEquals("Registro de un tramo cuyo peso es menor que cero", TipoError.ERROR_1, ret.getTipoError());
	}

}
