package cpj.sesion6.cast;

abstract class Animal {
	String tipo = "Animal";

	public Animal() {
		 System.out.println("El tipo es: " + tipo);
		//System.out.println("El tipo es: " + getTipo());
	}

	@Override
	public String toString() {
		return "Soy un animal";
	}

	abstract void hacerSonido();

	public String getTipo() {
		System.out.println("get tipo de Animal");
		return tipo;
	}
}
