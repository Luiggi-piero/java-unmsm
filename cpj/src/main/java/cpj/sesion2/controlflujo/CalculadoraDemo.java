package cpj.sesion2.controlflujo;

import cpj.sesion1.intro.CalculadorBinario;

public class CalculadoraDemo {

	public static void main(String[] args) {
		
		int num1 = 0;
		int num2 = 0;
		String operador = null;
		
		for (int i = 0; i < args.length; i++) {
			switch (i) {
			case 0:
				num1 = Integer.parseInt(args[i]);
				break;
			case 1:
				num2 = Integer.parseInt(args[i]);
				break;
			case 2:
				operador = args[i];
				break;
			default:
				break;
			}
		}
		
		CalculadorBinario calc = new CalculadorBinario(num1, num2, operador);
		System.out.printf("%d %s %d = %.2f%n", num1, operador, num2, calc.getResultado());
	}

}
