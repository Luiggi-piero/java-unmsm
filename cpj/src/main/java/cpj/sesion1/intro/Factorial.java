package cpj.sesion1.intro;

// ************* NOTAS *************
// borrar toda una linea: ctrl + d
// autocompleta las importaciones: ctrl + shift + o
// formatear: ctrl + shift + f
// buscar archivos: ctrl + shift + r
  		
public class Factorial {

	public static long factorial(int n) {
		
		if(n < 0 || n >= 13) {
			throw new RuntimeException("Se excede al límite máximo");
		}
		
		int result = 1; // 2
		for (int i = 1; i <= n; i++) { // 3
			result *= i;
		}
		return result;
	}

}
