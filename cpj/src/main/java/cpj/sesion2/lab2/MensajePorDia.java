package cpj.sesion2.lab2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
		for (String dia : nombreDia) {
			System.out.println(dia);
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
		// String curso = "";
		System.out.format("El dia seleccionado es %d, %s%n", dia, nombreDia[dia - 1]);
		
		/*
		switch (dia) {
		case 1:
			curso = "ED";
			break;
		case 2:
			curso = "PPP";
			break;
		case 3:
			curso = "CPJ";
			break;
		case 4:
			curso = "...";
			break;
		case 5:
			curso = "CJP";
			break;
		case 6:
			curso = "...";
			break;
		case 7:
			curso = "...";
			break;
		default:
			break;
		}*/
		System.out.println(mensajeDia[idCurso]);
	}
}
