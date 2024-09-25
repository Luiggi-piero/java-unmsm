package cpj.sesion1.intro;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class CalculadorBinarioTest {

	/**
	 * @Test void testDemoUsandoConstructorConArg() { assertEquals(6.00,
	 *       CalculadorBinario.demoUsandoConstructorConArg(new Scanner(System.in)));
	 *       }
	 */

	@Test
	void testDemoUsadoContructorNoArg() {
		assertEquals(10.0, CalculadorBinario.demoUsadoContructorNoArg(new Scanner(System.in)));
	}

}
