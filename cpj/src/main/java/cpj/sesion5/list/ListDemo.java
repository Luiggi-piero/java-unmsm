package cpj.sesion5.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListDemo {
	
	private static void demo() {

		List<String> mensajes = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			mensajes.add("mensaje 1." + i);
		}
		mensajes.addAll(5, Arrays.asList("mensaje 2.1", "mensaje 2.2", "mensaje 2.3"));

		String mensajeRemovido = mensajes.remove(0);
		mensajes.add(0, "mensaje 100");
		System.out.println("Antes del sort: "+ mensajes);
		Collections.sort(mensajes);
		mensajes.forEach(System.out::println);
		List<String> unoPuntoAlgo = mensajes.stream()
				.filter(s -> s.matches("mensaje 1\\..")).collect(Collectors.toList());
		System.out.println(unoPuntoAlgo);
	}

	public static void main(String[] args) {
		demo();
	}
}
