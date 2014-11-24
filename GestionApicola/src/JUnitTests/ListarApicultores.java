package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Sistema;
import Dominio.TipoError;
import Dominio.TipoRetorno;

public class ListarApicultores {

	@Test
	public void test() {
		//Se destruye (si existe) el sistema y se crea para 8 puntos:
				Sistema.getInstancia().destruirSistema();
				Sistema.getInstancia().inicializarSistema(8);
				//Apicultores
				Sistema.getInstancia().registrarApicultor(12223334,"Jhon Abejas","Abejorro, Las Camelias esq. El Ceibo","jhon@abejas.com","099111222");
				Sistema.getInstancia().registrarApicultor(10001119, "Little Apikultor", "Las flores esq. Las acacias", "little@apicultores.net", "094111222");
				Sistema.getInstancia().registrarApicultor(19992229, "Big Apikultor", "Madre selva esq. Avisapas", "big@apicultores.net", "091888999");
				Sistema.getInstancia().registrarApicultor(11112222, "Señor Apikultor", "Jasmín esq. Orquídeas", "señor@apicultores.net", "093123123");
				Sistema.getInstancia().registrarApicultor(10001000, "Señora Apikultora", "Jasmín esq. Orquídeas", "señora@apicultores.net", "093123456");
				Sistema.getInstancia().registrarApicultor(21112111, "Melina Miel", "Dr.Edye y Rincón", "melimiel@apicultores.net", "098998998");
				Sistema.getInstancia().registrarApicultor(29001234, "Luis Panales", "Su casa", "panales@gmail.com", "096999888");
				//Test
				TipoRetorno ret = new TipoRetorno();
				String textoEsperado = "10001000;Señora Apikultora;093123456|10001119;Little Apikultor;094111222|11112222;Señor Apikultor;093123123|12223334;Jhon Abejas;099111222|19992229;Big Apikultor;091888999|21112111;Melina Miel;098998998|29001234;Luis Panales;096999888|";
				ret = Sistema.getInstancia().listadoApicultores();
				assertEquals("Listado de Apicultores registrados, ordenado por cedula de manera ascendente", TipoError.OK, ret.getTipoError());
				assertEquals("String conteniendo los Apicultores registrados", textoEsperado, ret.getValorString());
				
	}

}