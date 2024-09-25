package cpj.sesion3.enumdemo;

public class EnumDemo2 {
	
	private static void mostrarDia(DiaDeLaSemana dia) {
		System.out.printf("El día de la semana es %d, el nombre es %s %n", dia.ordinal() + 1, dia.name());
	}
	
	private static void mostrarTodosLosDias() {
		for(DiaDeLaSemana dia: DiaDeLaSemana.values()) {
			System.out.printf("El día de la semana es %d, el nombre es %s %n", dia.ordinal() + 1, dia.name());
		}
	}
	
	public static void main(String[] args) {
		mostrarDia(DiaDeLaSemana.domingo);
		mostrarDia(DiaDeLaSemana.miercoles);
		mostrarTodosLosDias();
	}
}
