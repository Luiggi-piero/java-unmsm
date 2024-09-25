package cpj.sesion9.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Persona {
	public String documento;
	public String apellido;
	public String nombre;
	public LocalDateTime nacimiento;
	public Persona(String documento, String apellido, String nombre, LocalDateTime nacimiento) {
		this.documento = documento;
		this.apellido = apellido;
		this.nombre = nombre;
		this.nacimiento = nacimiento;
	}
	@Override
	public boolean equals(Object obj) {
		Persona p = (Persona)obj;
		return documento.equals(p.documento) &&
				apellido.equals(p.apellido) &&
				nombre.equals(p.nombre);
	}
	
	@Override
	public String toString() {
		return String.format("%s-%s %s", documento, apellido, nombre);
	}
}

class NombreComparator implements Comparator<Persona>{
	@Override
	public int compare(Persona o1, Persona o2) {
		int result = o1.apellido.compareTo(o2.apellido);
		return result == 0 ? o1.nombre.compareTo(o2.nombre) : 0;
	}
}

class NacimientoComparator implements Comparator<Persona>{
	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.nacimiento.compareTo(o2.nacimiento);
	}
}

public class SortTest {
	List<Persona> personas;
	final Persona p1 = new Persona("123", "BBB", "BBB", LocalDateTime.of(2003, 1, 1, 0, 0, 0));
	final Persona p2 = new Persona("124", "BBB", "AAA", LocalDateTime.of(2002, 1, 1, 0, 0, 0));
	final Persona p3 = new Persona("125", "BBB", "CCC", LocalDateTime.of(2001, 1, 1, 0, 0, 0));
	
	@BeforeEach
	void init() {
		personas = Arrays.asList(p1, p2, p3);
	}
	@Test
	void test() {
		Collections.sort(personas, new NombreComparator());
		List<Persona> esperado = Arrays.asList(p2, p1, p3);
		assertEquals(esperado, personas);
		
		Collections.sort(personas, (p1, p2) -> p1.documento.compareTo(p2.documento));
		esperado = Arrays.asList(p1, p2, p3);
		assertEquals(esperado, personas);
		
		Collections.sort(personas, new NacimientoComparator());
		esperado = Arrays.asList(p3, p2, p1);
		assertEquals(esperado, personas);

	}
}
