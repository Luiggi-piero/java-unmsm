package cpj.sesion5.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicLibDemo extends ConsolaApp {

	private static String[] opciones = { "Circulo", "Rectangulo", "Cadena(String)", "Fechas", "Lista(Nuevo elemento)",
			"Lista(Mostrar contenido)", "Salir" };

	private static List<String> lista = new ArrayList<>();

	public BasicLibDemo() {
		super(opciones);
	}

	public static void main(String[] args) throws Exception {
		ConsolaApp demo = new BasicLibDemo();
		demo.start();
	}

	@Override
	protected void procesarOpcion(int opcion) {
		Scanner scan = new Scanner(System.in);
		switch (opcion) {
		case 1:
			procesarCirculo(scan);
			mostrarOpciones();
			break;
		case 2:
			procesarRectangulo(scan);
			mostrarOpciones();
			break;
		case 3:
			procesarCadena(scan);
			mostrarOpciones();
			break;
		case 4:
			// fechas
			System.out.println("???(Por desarrollar.)");
			mostrarOpciones();
			break;

		case 5:
			agregarElementoLista(lista, scan);
			mostrarOpciones();
			break;
		case 6:
			mostrarContenidoLista(lista);
			mostrarOpciones();
			break;
		case 7:
			terminarPrograma();
			break;
		default:
			System.exit(0);
			break;
		}
		scan.close();
	}

	private void agregarElementoLista(List<String> lista, Scanner scan) {
		System.out.print("Ingrese elemento: ");
		String cad = scan.next();
		lista.add(cad);
	}

	private void mostrarContenidoLista(List<String> lista) {
		System.out.println("Contenido de la lista es:");
		for (String elem : lista) {
			System.out.println(elem);
		}
	}

	private void terminarPrograma() {
		System.out.println("Programa terminado");
		System.exit(0);
	}

	private void procesarCadena(Scanner scan) {
		System.out.print("Ingrese un string: ");
		String cad1 = scan.next();
		System.out.print("Ingrese otro string: ");
		String cad2 = scan.next();

		String cad3 = procesarTercerCaracter(scan);

		int pos = cad1.toLowerCase().indexOf(cad2.toLowerCase());
		if (pos >= 0) {
			System.out.format("La cadena '%s' es parte de '%s', y se encuentra en la posicion %d%n", cad2, cad1, pos);
			System.out.format("Con la subcadena('%s') eliminada seria '%s'%n", cad2,
					cad1.toLowerCase().replace(cad2.toLowerCase(), ""));
			System.out.format("Con la subcadena('%s') remplazada por '%s' seria '%s'%n", cad2, cad3,
					cad1.toLowerCase().replace(cad2.toLowerCase(), cad3));
		} else {
			System.out.format("La cadena '%s' NO es parte de '%s'", cad2, cad1);
		}
	}

	private void procesarRectangulo(Scanner scan) {
		System.out.print("Ingrese la base del rectángulo: ");
		int base = scan.nextInt();
		System.out.print("Ingrese la altura del rectángulo: ");
		int altura = scan.nextInt();
		System.out.println("Área: " + base * altura);
	}

	private void procesarCirculo(Scanner scan) {
		System.out.print("Ingrese el radio: ");
		String radioStr = scan.next();

		double radio = Double.parseDouble(radioStr);
		System.out.format("El area del circulo con radio %f es %f%n", radio, getAreaCirculo(radio));
	}

	private double getAreaCirculo(double radio) {
		return Math.PI * Math.pow(radio, 2);
	}

	private static boolean esCaracterValido(String c) throws Exception {
		if (c.equals("*") || c.equals("#") || c.equals(".") || c.equals("-") || c.equals("/")) {
			return true;
		} else {
			throw new Exception("El caracter no es valido");
		}
	}

	private static String procesarTercerCaracter(Scanner scan) {
		System.out.print("Escoja un caracter especial(*#.-/): ");
		String cad3 = scan.next();

		try {
			esCaracterValido(cad3);
			return cad3;
		} catch (Exception e) {
			return procesarTercerCaracter(scan);
		}

	}

}
