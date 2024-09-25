package cpj.sesion2.lab2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicLibDemo {
	private String[] opciones = { "Circulo", "Rectangulo", "Cadena(String)", "Fechas", "Lista(Nuevo elemento)",
			"Lista(Mostrar contenido)", "Salir" };
	private static List<String> lista = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		
		BasicLibDemo m = new BasicLibDemo();
		m.mostrarMenu();
		
		//int opcion = m.leerOpcionValida();
		//m.procesarOpcion(opcion);
		mostrarOpciones(m);
		
	}

	void mostrarMenu() {
		int n = 1;
		for (String opc : opciones) {
			System.out.format("%d.- %s%n", n++, opc);
		}
	}

	int leerOpcionValida() {
		int opc;
		try {
			opc = leerOpcion();
			return opc;
		} catch (Exception e) {
			return leerOpcionValida();
		}
	}

	int leerOpcion() throws Exception {
		// String opc = System.console().readLine("Seleccione una opcion: ");
		//System.out.print("Seleccione una opcion: ");
		//String opc = new BufferedReader(new InputStreamReader(System.in)).readLine();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Seleccione una opcion: ");
		int op = scan.nextInt();
		//int op = Integer.parseInt(opc);
		
		if (esOpcionValida(op))
			return op;
		else
			throw new Exception("La opcion seleccionada no es valida");

	}

	private boolean esOpcionValida(int dia) {
		return dia > 0 && dia <= opciones.length;
	}

	void procesarOpcion(int opcion) {
		//List<String> lista = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		switch (opcion) {
		case 1:
			//String radioStr = System.console().readLine("Ingrese el radio: ");
			
			procesarCirculo(scan);
			mostrarOpciones(new BasicLibDemo());
			break;
		case 2:
			procesarRectangulo(scan);
			mostrarOpciones(new BasicLibDemo());
			break;
		case 3:
			//String cad1 = System.console().readLine("Ingrese un string: ");
			//String cad2 = System.console().readLine("Ingrese otro string: ");
			//String cad3 = System.console().readLine("Escoja un caracter especial(*#.-/): ");
			
			procesarCadena(scan);
			mostrarOpciones(new BasicLibDemo());
			break;
		case 4:
			System.out.println("???(Por desarrollar.)");
			mostrarOpciones(new BasicLibDemo());
			break;

		case 5:
			//String cad = System.console().readLine("Ingrese elemento: ");
			agregarElementoLista(lista, scan);
			mostrarOpciones(new BasicLibDemo());
			break;
		case 6:
			mostrarContenidoLista(lista);
			mostrarOpciones(new BasicLibDemo());
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
		
		//System.out.print("Escoja un caracter especial(*#.-/): ");
		//String cad3 = scan.next();
		String cad3 = procesarTercerCaracter(scan);
		
		int pos = cad1.toLowerCase().indexOf(cad2.toLowerCase());
		if (pos >= 0) {
			System.out.format("La cadena '%s' es parte de '%s', y se encuentra en la posicion %d%n", cad2, cad1,
					pos);
			System.out.format("Con la subcadena('%s') eliminada seria '%s'%n",cad2, cad1.toLowerCase().replace(cad2.toLowerCase(), ""));
			System.out.format("Con la subcadena('%s') remplazada por '%s' seria '%s'%n", cad2, cad3, cad1.toLowerCase().replace(cad2.toLowerCase(), cad3));
		} else {
			System.out.format("La cadena '%s' NO es parte de '%s'", cad2, cad1);
		}
	}

	private void procesarRectangulo(Scanner scan) {
		System.out.print("Ingrese la base del rectángulo: ");
		int base = scan.nextInt();
		System.out.print("Ingrese la altura del rectángulo: ");
		int altura = scan.nextInt();
		System.out.println("Área: "+ base * altura);
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
	
	/**
	 * Problema 2.1
	 * el método mostrarMensaje es reemplazado por  procesarOpcion
	 */
	
	private static boolean esCaracterValido(String c) throws Exception{
		if(c.equals("*") || c.equals("#") || c.equals(".") || c.equals("-") || c.equals("/")) {
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
	
	private static void mostrarOpciones(BasicLibDemo m) {
		int opcion = m.leerOpcionValida();
		m.procesarOpcion(opcion);
	}
	
}
