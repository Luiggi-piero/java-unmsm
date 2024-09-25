package cpj.sesion7.generic;

public class Estudiante extends Persona implements Comparable<Estudiante> {
	private String nombre;

	public Estudiante(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int compareTo(Estudiante o) {
		return this.nombre.compareTo(o.nombre);
	}
}
