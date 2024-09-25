package cpj.sesion7.generic;


public class GenericDemo {
	public static <T> boolean contiene(T[] anArray, T elem) {
		for (T e : anArray)
			if (e.equals(elem))
				return true;
		return false;
	}

	private static void demoContiene() {
		Integer[] enteros = { 1, 2, 4, 10 };
		System.out.println(contiene(enteros, 10));
		System.out.println(contiene(enteros, 5));
	}

	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
		int count = 0;
		for (T e : anArray)
			if (e.compareTo(elem) > 0)
				++count;
		return count;
	}

	private static void demoCountGreaterThan() {
		Integer[] enteros = { 1, 2, 4, 10, 13 };
		System.out.println(countGreaterThan(enteros, 6));

		String[] cadenas = { "Spring", "Flask", "Angular", "React" };
		System.out.println(countGreaterThan(cadenas, "Flask"));

		Cat[] cs = { new Cat("pepe"), new Cat("jose"), new Cat("niebla") };
		System.out.println(countGreaterThan(cs, new Cat("niebla")));
	}

	public static void main(String[] args) {
		// demoContiene();
		demoCountGreaterThan();
	}
}
