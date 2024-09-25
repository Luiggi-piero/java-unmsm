package cpj.sesion5.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MensajePorDia extends ConsolaApp {

	private static String[] opciones = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };
	private static String[] mensajeDia = { "ED", "PPP", "CPJ", "...", "CJP", "...", "..." };

	public MensajePorDia() {
		super(opciones);
	}

	public static void main(String[] args) throws Exception {
		MensajePorDia demo = new MensajePorDia();
		demo.start();
	}

	@Override
	protected void procesarOpcion(int dia) {
		int idCurso = dia - 1;
		System.out.format("El dia seleccionado es %d, %s%n", dia, opciones[dia - 1]);
		System.out.println(mensajeDia[idCurso]);
	}
}
