package cpj.sesion4.object;

public class EqualDemo {
	public static void main(String[] args) {
		personaEquals();
	}

	private static void personaEquals() {
		Persona persona1 = new Persona("torres", "luis", "123");
		Persona persona2 = new Persona("torres", "luis", "123");
		System.out.println(persona1.equals(persona2));
	}
	
	private static void stringEquals() {
		String s1 = "Java";
		
	}
}
