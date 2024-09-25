package cpj.sesion3.formatter;

import java.time.LocalDateTime;

import cpj.sesion1.intro.CalculadorBinario;

public class FormatterDermo {
	public static void main(String[] args) {
			System.out.format("%+010.4f*%<f%n", Math.PI);
			System.out.format("%d - %1$o - %1$x %n", 15);
			System.out.printf("Una cadena es %s, un caracter es %c, un boolean es %b%n", "cadena", 'c', true);
			LocalDateTime ahora = LocalDateTime.now();
			System.out.printf("Ahora es %TH:%1$TM:%1$TS  - %1$TY/%1$TB  %n", ahora);
			System.out.printf("%s%n", new CalculadorBinario());
	}
}
