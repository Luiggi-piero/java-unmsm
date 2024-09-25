package cpj.sesion1.intro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FactorialTest {

	@Test
	void testFactorialConNumeroPequenyos() {
		assertEquals(1, Factorial.factorial(0));
		assertEquals(1, Factorial.factorial(1));
		assertEquals(2, Factorial.factorial(2));
		assertEquals(6, Factorial.factorial(3));
		assertEquals(24, Factorial.factorial(4));
		assertEquals(120, Factorial.factorial(5));
	};
	
	@Test
	void testFactorialConNumerosGrandes() {
		// soporta hasta 12
		assertEquals(3628800L, Factorial.factorial(10));
		assertEquals(479001600L, Factorial.factorial(12));
	}
	
	@Test
	void testFactorialConNumerosQueExcedenAlLimite() {
		assertThrows(RuntimeException.class, () -> Factorial.factorial(13));
	}
	
	@Test
	void testFactorialConNumerosQueExcedenAlLimiteMinimo() {
		assertThrows(RuntimeException.class, () -> Factorial.factorial(-1));
	}
	
}
