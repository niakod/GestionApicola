package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;
import Dominio.Sistema;
import Dominio.TipoError;
import Dominio.TipoRetorno;

public class RegistrarApicultor {

	@Test
	public void testRegistrarApicultor() {
		Sistema.getInstancia().inicializarSistema(20); //Del test DestruirSistema, el sistema no ha sido inicializado.
		TipoRetorno ret = new TipoRetorno();
		ret = Sistema.getInstancia().registrarApicultor(12223334,"Jhon Abejas","Abejorro, Las Camelias esq. El Ceibo","jhon@abejas.com","099111222");
		assertEquals("Primer registro de apicultor", TipoError.OK, ret.getTipoError());
		ret = Sistema.getInstancia().registrarApicultor(12223334, "nombre", "direccion", "email", "celular");
		assertEquals("No se puede registrar un apicultor con una cedula ya registrada en el sistema",
				TipoError.ERROR_1, ret.getTipoError());
		ret = Sistema.getInstancia().registrarApicultor(10001119, "Little Apikultor", "Las flores esq. Las acacias", "little@apicultores.net", "094111222");
		assertEquals("Registro de un apicultor con cédula menor al primero", TipoError.OK, ret.getTipoError());
		ret = Sistema.getInstancia().registrarApicultor(19992229, "Big Apikultor", "Madre selva esq. Avisapas", "big@apicultores.net", "091888999");
		assertEquals("Registro de un apicultor con cédula mayor al primero", TipoError.OK, ret.getTipoError());
		ret = Sistema.getInstancia().registrarApicultor(11112222, "Señor Apikultor", "Jasmín esq. Orquídeas", "señor@apicultores.net", "093123123");
		assertEquals("Registro de un apicultor para raiz.menor.mayor", TipoError.OK, ret.getTipoError());
		ret = Sistema.getInstancia().registrarApicultor(10001000, "Señora Apikultora", "Jasmín esq. Orquídeas", "señora@apicultores.net", "093123456");
		assertEquals("Registro de un apicultor para raiz.menor.menor", TipoError.OK, ret.getTipoError());
		ret = Sistema.getInstancia().registrarApicultor(21112111, "Melina Miel", "Dr.Edye y Rincón", "melimiel@apicultores.net", "098998998");
		assertEquals("Registro de un apicultor para raiz.mayor.mayor", TipoError.OK, ret.getTipoError());
		ret = Sistema.getInstancia().registrarApicultor(29001234, "Luis Panales", "Su casa", "panales@gmail.com", "096999888");
		assertEquals("Registro de un apicultor para raiz.mayor.mayor.menor", TipoError.OK, ret.getTipoError());
	}

}
