package cpj.sesion9.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class EqualsHashCode {
	
	@Test
	void mutacionQueAfectaHashCode() {
		Set<MutableEstudiante> set = new HashSet<>();
		MutableEstudiante e1 = new MutableEstudiante("111", "AAA", "BBB");
		MutableEstudiante e2 = new MutableEstudiante("111", "AAA", "BBB");
		set.add(e1);
		set.add(e2);
		assertEquals(1, set.size());
		assertTrue(set.contains(e1));
		assertTrue(set.contains(e2));
		e1.codigo = "222"; //Mutacion del campo que afecta hashCode
		assertFalse(set.contains(e1)); //Inubicable (hashCode diferente)
		assertFalse(set.contains(e2)); //Ubicable, pero no igual
	}
	@Test
	void mutacionQueEquals() {
		Set<MutableEstudiante> set = new HashSet<>();
		MutableEstudiante e1 = new MutableEstudiante("111", "AAA", "BBB");
		MutableEstudiante e2 = new MutableEstudiante("111", "AAA", "BBB");
		set.add(e1);
		set.add(e2);
		assertEquals(1, set.size());
		assertTrue(set.contains(e1));
		assertTrue(set.contains(e2));
		e1.nombre = "???"; //Mutacion del campo que afecta equals
		assertTrue(set.contains(e1));
		assertFalse(set.contains(e2)); //Ubicable, pero no igual
	}

}

class MutableEstudiante {
	public String codigo;
	public String apellido;
	public String nombre;
	public MutableEstudiante(String codigo, String apellido, String nombre) {
		this.codigo = codigo;
		this.apellido = apellido;
		this.nombre = nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		MutableEstudiante otro = (MutableEstudiante)obj; 
		return codigo.equals(otro.codigo) &&
				apellido.equals(otro.apellido) &&
				nombre.equals(otro.nombre);
	}
	@Override
	public int hashCode() {
		return codigo.hashCode();
	}
	
}
