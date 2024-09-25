package cpj.sesion5.prueba;

public class Persona {
	private int edad;
	private String nombre;
	
	public Persona(int edad, String nombre) {
		this.edad = edad;
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void hablar() {
		System.out.println("Soy una persona");
	}
}
