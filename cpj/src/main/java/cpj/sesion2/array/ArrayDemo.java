package cpj.sesion2.array;

public class ArrayDemo {

	public static void mostrarArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "-");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] impares = new int[] { 1, 3, 5, 7 };
		int[] pares = new int[] { 2, 4, 6 };

		mostrarArray(pares);
		mostrarArray(impares);
		mostrarArray(new int[] { 11, 12 });
	}
}
