package cpj.sesion7.generic;

public class Cat extends Animal implements Comparable<Cat> {
	private String nombre;

	Cat(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	void hacerSonido() {
		System.out.println("soy un gato...miau");
	}

	@Override
	public int compareTo(Cat o) {
		return this.nombre.compareTo(o.nombre);
	}
}
