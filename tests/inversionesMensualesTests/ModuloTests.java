package inversionesMensualesTests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import inversionesMensuales.Modulo;

public class ModuloTests {

	@Test
	public void calcularInversionTest() {
		assertArrayEquals(new Double[] { 1268.2418, 1608.4372, 2039.8873, 2587.0704 },
				Modulo.calcularInversion(1000, 0.24, 4));
		assertArrayEquals(new Double[] { 2000.0000, 4000.0001, 8000.0002, 16000.0005, 32000.0012 },
				Modulo.calcularInversion(1000, 0.71355714, 5));
	}

	@Test
	public void calcularMontoTest() {
		assertEquals(120, Modulo.superarMonto(1000, 0.07, 2000));
		assertEquals(48, Modulo.superarMonto(1000, 0.24, 2587));
	}

	@Test (expected = Error.class) 
	public void MontoMenorQueInversionTest() {
		Modulo.superarMonto(1000, 0.07, 890);
	}

	@Test (expected = Error.class) 
	public void MontoDeInteresInvalidoTest() {
		Modulo.calcularInversion(1000, -4.00, 5);
	}
	
	@Test (expected = Error.class) 
	public void MontoDeAniosInvalidoTest() {
		Modulo.calcularInversion(1000, 4.00, -5);
	}
	
	@Test (expected = Error.class) 
	public void MontoDeInversionInvalidoTest() {
		Modulo.calcularInversion(0, 4.00, -5);
	}
}
