package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Sistema;
import Dominio.TipoError;
import Dominio.TipoRetorno;

public class ListarCentrosExtraccion {

	@Test
	public void testListarCentrosExtraccion() {
		//Se destruye (si existe) el sistema y se crea para 8 puntos:
		Sistema.getInstancia().destruirSistema();
		Sistema.getInstancia().inicializarSistema(8);
		Sistema.getInstancia().registrarCiudad("Ciudad_1", -45.90, -53.88); //Ciudad
		Sistema.getInstancia().registrarCiudad("Ciudad_2", -23.999, -88.2654); //Ciudad
		Sistema.getInstancia().registrarCentro("Ciudad_1 Extracciones", -34.25, -54.97, 362);//Centro de extracción
		Sistema.getInstancia().registrarCentro("Ciudad_2 Extracciones", -25.63, -36.99, 636);//Centro de extracción
		Sistema.getInstancia().registrarCentro("Ciudad_3 Extracciones", -17.897, -36.54, 870);//Centro de extracción
		Sistema.getInstancia().registrarCentro("Ciudad_4 Extracciones", -52.47, -99.36, 360);//Centro de extracción
		Sistema.getInstancia().registrarCentro("Ciudad_5 Extracciones", -99.87452, -57.6698, 500);//Centro de extracción
		Sistema.getInstancia().registrarCentro("Ciudad_6 Extracciones", -34.908827, -54.958256, 220);//Centro de extracción
		//test
		TipoRetorno ret = new TipoRetorno();
		String textoEsperado = "-34.25;-54.97;362|-25.63;-36.99;636|-17.897;-36.54;870|-52.47;-99.36;360|-99.87452;-57.6698;500|-34.908827;-54.958256;220|";
		ret = Sistema.getInstancia().listadoDeCentros();
		assertEquals("Listado de Centros de extraccion registrados en el sistema", TipoError.OK, ret.getTipoError());
		assertEquals("String conteniendo los Centros de extraccion", textoEsperado, ret.getValorString());
	}

}