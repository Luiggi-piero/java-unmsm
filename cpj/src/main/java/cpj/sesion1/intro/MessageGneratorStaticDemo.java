package cpj.sesion1.intro;

import java.util.Random;

public class MessageGneratorStaticDemo {

	private static String[] mensajes = { "La vida es lo que pasa mientras.... - John Lennon",
			"No esperes a que lleguen las .... - H. Jackson Brown Jr.",
			"El éxito es la suma de pequeños .... - Robert Collier",
			"La mejor manera de predecir .... - Abraham Lincoln", "No dejes que lo que no puedes ---. - John Wooden",
			"La verdadera medida de un hombre.... - M. L. King Jr.",
			"La educación es el arma más poderosa.... - Nelson Mandela",
			"La única forma de hacer un gran trabajo.... - Steve Jobs",
			"Si quieres alcanzar la grandeza, .... - Eddie Harris Jr.",
			"El mayor riesgo es no correr ningún riesgo. - Mark Zuckerberg" };

	public String getMessage() {
		Random ran = new Random();
		int index = ran.nextInt(mensajes.length);
		return mensajes[index];
	}

	public static void main(String[] args) {
		MessageGneratorStaticDemo demo = new MessageGneratorStaticDemo();
		System.out.println(demo.getMessage());
	}
}
