package cpj.sesion9.collections;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cpj.sesion9.entitys.Estudiante;



class CollectionTest {
	Collection<Estudiante> col1;
	Collection<Estudiante> col2;
	Collection<Estudiante> col3;
	final Estudiante e1 = new Estudiante("12345678", "Juan Ungenio", 8, null);
	final Estudiante e2 = new Estudiante("22345678", "Carlos Dosantos", 9, null);
	final Estudiante e3 = new Estudiante("32345678", "Luis Trelles", 10, null);
	final Estudiante e4 = new Estudiante("42345678", "Julio Cuadros", 11, null);
	final Estudiante e5 = new Estudiante("52345678", "Miguel Cinquiño", 12, null);

	
	@BeforeEach
	public void init() {
		
		col1 = new ArrayList<>();
		col1.add(e1);
		col1.add(e2);
		col1.add(e3);
				
		col2 = new ArrayList<>();
		col2.add(e1);
		col2.add(e2);

		col3 = new ArrayList<>();
		col3.add(e3);
		col3.add(e4);
		col3.add(e5);
		
	}

	@Test
	void testContainsAll() {
		assertTrue(col1.containsAll(col2));
		assertFalse(col1.containsAll(col3));
	}

	@Test
	void testRetainsAllIsIntersection1() {
		col1.retainAll(col2);
		assertEquals(2, col1.size());
		assertArrayEquals(col2.toArray(), col1.toArray());
		
		col3.retainAll(col2);
		assertEquals(0, col3.size());
	}

	@Test
	void testRetainsAllIsIntersection2() {
		col1.retainAll(col3);
		assertEquals(1, col1.size());
		assertEquals(e3, col1.toArray()[0]);
	}

	@Test
	void testRemoveAll() {
		col1.removeAll(col2);
		assertEquals(1, col1.size());
		
		col3.removeAll(col2);
		assertEquals(3, col3.size());
	}

	@Test
	void testAddAll_ImplementacionDependent() {
		col1.addAll(col2);
		assertEquals(5, col1.size());
		
		col3.addAll(col2);
		assertEquals(5, col3.size());
		
		
	}

}
