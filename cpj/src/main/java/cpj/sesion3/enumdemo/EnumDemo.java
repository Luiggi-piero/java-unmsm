package cpj.sesion3.enumdemo;

public class EnumDemo {
	
	public static final int LUNES = 1;
	public static final int MARTES = 2;
	public static final int MIERCOLES = 3;
	public static final int JUEVES = 4;
	public static final int VIERNES = 5;
	public static final int SABADO = 6;
	public static final int DOMINGO = 7;
	
	public static String[] nombreDia = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
	
 	
	
	private static void mostrarDia(int dia) {
		System.out.printf("El día de la semana es %d, el nombre es %s %n", dia, nombreDia[dia - 1]);
	}
	
	public static void main(String[] args) {
		mostrarDia(LUNES);
	}
}
