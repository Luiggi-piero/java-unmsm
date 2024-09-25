package cpj.sesion7.generic;

import java.util.List;

public class HerenciaDemo {

	static void procesar(List<Persona> personas) {
	}
	static void procesar(Persona[] personas) {
	}
	
	public static void demoConArray() {
		Persona[] ps = {new Persona(), new Persona()};
		procesar(ps);
		
		Estudiante[] es = {new Estudiante(""), new Estudiante("")};
		procesar(es);
	}

	private static void demoConList() {
		List<Persona> ps = List.of(new Persona(), new Persona());
		procesar(ps);
		
		List<Estudiante> es = List.of(new Estudiante(""), new Estudiante(""));
		// procesar(es);  // Error de compilacion
	}

	public static void main(String[] args) {
		// Funciona
		// procesar(List.of(new Persona(), new Persona()));
		// procesar(List.of(new Estudiante(""), new Estudiante("")));

		demoConList();
	}
}
