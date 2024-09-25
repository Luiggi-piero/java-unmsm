package cpj.sesion6.cast;

public class Cat extends Animal implements Comparable<Cat> {
	String tipo = "Cat";
	
	public Cat() {
		
	}

	@Override
	void hacerSonido() {
		System.out.println("soy un gato...miau");
	}

	public String getTipo(){
		System.out.println("getTipo de Cat");
		return tipo;
	}
	
	public static void main(String[] args) {
		new Cat();
	}

	@Override
	public int compareTo(Cat o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
