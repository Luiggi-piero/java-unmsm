package cpj.sesion5.lab;

import java.util.Scanner;

public abstract class ConsolaApp {

	private String[] opciones;

	public ConsolaApp(String[] opciones) {
		this.opciones = opciones;
	}

	protected abstract void procesarOpcion(int opcion);

	protected void mostrarMenu() {
		int n = 1;
		for (String opc : opciones) {
			System.out.format("%d.- %s%n", n++, opc);
		}
	}

	protected int leerOpcionValida() {
		int opc;
		try {
			opc = leerOpcion();
			return opc;
		} catch (Exception e) {
			return leerOpcionValida();
		}
	}

	int leerOpcion() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.print("Seleccione una opcion: ");
		int op = scan.nextInt();

		if (esOpcionValida(op))
			return op;
		else
			throw new Exception("La opcion seleccionada no es valida");

	}

	private boolean esOpcionValida(int dia) {
		return dia > 0 && dia <= opciones.length;
	}

	protected void mostrarOpciones() {
		int opcion = leerOpcionValida();
		procesarOpcion(opcion);
	}

	protected void start() {
		mostrarMenu();
		mostrarOpciones();
	}

}