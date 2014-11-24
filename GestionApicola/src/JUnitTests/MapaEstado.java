package JUnitTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import ConsoleApp.ConsoleMain;
import Dominio.Sistema;
import Dominio.TipoError;
import Dominio.TipoRetorno;

public class MapaEstado {

	@Test
	public void testMostrarMapa() throws IOException, URISyntaxException {
		//Destruye el sistema, si existe, y lo crea de nuevo para 3 puntos:
		Sistema.getInstancia().destruirSistema();
		Sistema.getInstancia().inicializarSistema(3);
		//Añade 3 puntos (uno de cada tipo) y un apicultor para el apiario:
		Sistema.getInstancia().registrarApicultor(12223334,"Jhon Abejas","Abejorro, Las Camelias esq. El Ceibo","jhon@abejas.com","099111222");//Apicultor
		Sistema.getInstancia().registrarCiudad("Maldonado", -34.908807, -54.958212); //Ciudad
		Sistema.getInstancia().registrarApiario("Abejas felices", -34.903704, -54.973533, 12223334, 20);//Apiario
		Sistema.getInstancia().registrarCentro("Maldonado Extracciones", -34.908827, -54.998256, 220);//Centro de extracción
		//Test:
		TipoRetorno ret = new TipoRetorno();
		ret = Sistema.getInstancia().mapaEstado();
		assertEquals("se ejecuta el método", TipoError.OK, ret.getTipoError());
		assertEquals("Cadena retornada", 
				"http://maps.googleapis.com/maps/api/staticmap?center=-34.9054885,-54.9636822&zoom=13&size=640x640&maptype=roadmap&markers=color:red%7Clabel:C%7C-34.908807,-54.958212&markers=color:yellow%7Clabel:A%7C-34.903704,-54.973533&markers=color:green%7Clabel:E%7C-34.908827,-54.998256",
				ret.getValorString());
		//Para que se muestre el mapa cuando se corre la prueba:
		ConsoleApp.ConsoleMain.mostrarMapa();
	}

}
