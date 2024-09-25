package cpj.sesion4.object;

import java.util.Objects;

public class Persona {
	private String apellido;
	private String nombre;
	private String dni;

	public Persona(String apellido, String nombre, String dni) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, dni, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(dni, other.dni)
				&& Objects.equals(nombre, other.nombre);
	}		
}
