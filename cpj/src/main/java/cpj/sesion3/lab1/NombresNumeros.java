package cpj.sesion3.lab1;

import java.util.ArrayList;

public class NombresNumeros {
	public static void main(String[] args) {
		processArray(args);
	}

	private static void processArray(String[] arr) {
		String indicesDeNumeros = "";
		String indicesDeNombres = "";
		
		for (int i = 0; i < arr.length; i++) {
			if (isNumeric(arr[i])) {
				indicesDeNumeros += "-" + i;
			} else {
				indicesDeNombres += "-" + i;
			}
		}

		String[] numerosArreglo = generarArreglo(arr, indicesDeNumeros);
		String[] nombresArreglo = generarArreglo(arr, indicesDeNombres);
		
		mostrarArreglo(nombresArreglo);
		mostrarArreglo(numerosArreglo);
		System.out.println(sumarArreglo(numerosArreglo));
	}
	
	private static int sumarArreglo(String[] arreglo) {
		int total = 0;
		for (int i = 0; i < arreglo.length; i++) {
			total += Integer.parseInt(arreglo[i]);
		}
		return total;
	}

	private static String[] generarArreglo(String[] arr, String indicesCadena) {
		indicesCadena = indicesCadena.substring(1);
		String[] arregloIndices = indicesCadena.split("-");
		String[] arregloElementos = new String[arregloIndices.length];
		for (int i = 0; i < arregloIndices.length; i++) {
			arregloElementos[i] = arr[Integer.parseInt(arregloIndices[i])];
		}
		return arregloElementos;
	}
	
	private static void mostrarArreglo(String[] arreglo) {
		String resultado = "";
		for (int i = 0; i < arreglo.length; i++) {
			if(arreglo.length - 1 == i) {
				resultado += arreglo[i];
			}else {
				resultado += arreglo[i] + ", ";
			}
			
		}
		System.out.println(resultado);
	}

	// Comprueba si es un numero
	private static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}









/**
 * Operadores
 * =   <  ++  - == +=
 * 
 * Controles de flujo
 * if   else   for  return
 * 
 * Variables primitivas
 * int
 * 
 * Varibles de tipo referencia
 * String
 * 
 */