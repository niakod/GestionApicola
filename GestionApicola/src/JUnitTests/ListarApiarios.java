package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Sistema;
import Dominio.TipoError;
import Dominio.TipoRetorno;

public class ListarApiarios {

	@Test
	public void test() {
		//Se destruye (si existe) el sistema y se crea para 8 puntos:
				Sistema.getInstancia().destruirSistema();
				Sistema.getInstancia().inicializarSistema(8);
				//Se registran tres puntos en el sistema y un apicultor para el apiario:
				Sistema.getInstancia().registrarApicultor(12223334,"Jhon Abejas","Abejorro, Las Camelias esq. El Ceibo","jhon@abejas.com","099111222");//Apicultor
				Sistema.getInstancia().registrarCiudad("Ciudad_1", -45.90, -53.88); //Ciudad
				Sistema.getInstancia().registrarCiudad("Ciudad_2", -23.999, -88.2654); //Ciudad
				Sistema.getInstancia().registrarApiario("Apiario_1", -34.25, -54.97, 12223334, 20);//Apiario
				Sistema.getInstancia().registrarApiario("Apiario_2", -25.63, -36.99, 12223334, 35);//Apiario
				Sistema.getInstancia().registrarApiario("Apiario_3", -17.897, -36.54, 12223334, 96);//Apiario
				Sistema.getInstancia().registrarApiario("Apiario_4", -52.47, -99.36, 12223334, 36);//Apiario
				Sistema.getInstancia().registrarApiario("Apiario_5", -99.87452, -57.6698, 12223334, 78);//Apiario
				Sistema.getInstancia().registrarCentro("Ciudad_1 Extracciones", -34.908827, -54.958256, 220);//Centro de extracción
				//Tramos
				Sistema.getInstancia().registrarTramo(-45.90, -53.88, -34.25, -54.97, 3);
				Sistema.getInstancia().registrarTramo(-34.25, -54.97, -23.999, -88.2654, 3);
				Sistema.getInstancia().registrarTramo(-45.90, -53.88, -34.908827, -54.958256, 3);
				Sistema.getInstancia().registrarTramo(-34.908827, -54.958256, -17.897, -36.54, 5);
				Sistema.getInstancia().registrarTramo(-17.897, -36.54, -99.87452, -57.6698, 5);
				Sistema.getInstancia().registrarTramo(-45.90, -53.88, -25.63, -36.99, 10);
				Sistema.getInstancia().registrarTramo(-25.63, -36.99, -52.47, -99.36, 12);
				//Test:
				TipoRetorno ret = new TipoRetorno();
				String textoEsperado = "-34.25;-54.97|-25.63;-36.99|-17.897;-36.54|-99.87452;-57.6698|";
				ret = Sistema.getInstancia().listadoDeApiariosEnCiudad(-45.90, -53.88);
				assertEquals("Listado de Apiarios alcanzables en 20 km de recorrido desde Ciudad_1", TipoError.OK, ret.getTipoError());
				assertEquals("String conteniendo los Apiarios", textoEsperado, ret.getValorString());
	}

}
