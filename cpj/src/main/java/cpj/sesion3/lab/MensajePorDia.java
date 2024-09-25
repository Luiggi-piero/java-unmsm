package cpj.sesion3.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class MensajePorDia {
	private String[] nombreDia = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };
	private String[] mensajeDia = { "ED", "PPP", "CPJ", "...", "CJP", "...", "..." };

	public static void main(String[] args) throws Exception {
		MensajePorDia m = new MensajePorDia();
		m.mostrarMenu();
		int dia = m.leerDia();
		m.mostrarMensaje(dia);
	}

	void mostrarMenu() {
		/*for (String dia : nombreDia) {
			System.out.println(dia);
		}*/
		for(DayOfWeek dow: DayOfWeek.values()) {
			System.out.println(dow.getDisplayName(TextStyle.FULL, Locale.of("es", "ES")));
		}
	}

	int leerDiaValido() {
		int dia;
		try {
			dia = leerDia();
			return dia;
		} catch (Exception e) {
			return leerDiaValido();
		}
	}

	int leerDia() throws Exception {
		// Forma 1
		// String diaOpt = System.console().readLine("Seleccione un dia: ");
		
		// Forma 2
		//System.out.print("Seleccione un dia: ");
		//String diaOpt = new BufferedReader(new InputStreamReader(System.in)).readLine();
		
		
		/**
		 * laboratorio 3 - 2.2
		 */
		// Forma 3
		Scanner scan = new Scanner(System.in);
		System.out.print("Seleccione un dia: ");
		int dia = scan.nextInt();
		
		//int dia = Integer.parseInt(diaOpt);
		if (diaValido(dia))
			return dia;
		else 
			return leerDia();
			// throw new Exception("El dia seleccionado no es valido");

	}

	private boolean diaValido(int dia) {
		return dia > 0 && dia <= nombreDia.length;
	}

	void mostrarMensaje(int dia) {
		int idCurso = dia - 1;
		
		/**
		 * laboratorio 3 - 2.1
		 */
		System.out.format("El dia seleccionado es %d, %s%n", dia, DayOfWeek.of(dia).getDisplayName(TextStyle.FULL, Locale.of("es", "ES")));
		System.out.println(mensajeDia[idCurso]);
	}
}
