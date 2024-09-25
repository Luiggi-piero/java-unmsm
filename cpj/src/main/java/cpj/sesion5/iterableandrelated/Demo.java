package cpj.sesion5.iterableandrelated;

import java.util.Iterator;
import java.util.List;

public class Demo {
	<T> void iterateGenerico(Iterable<T> ite) {
		System.out.println("********** 1. forma");
		for (T s : ite) {
			System.out.println(s);
		}
		System.out.println("********** 2. forma");
		// Or:
		ite.forEach(System.out::println);
		System.out.println("********** 3. forma");
		// Or:
		for (Iterator<T> it = ite.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
	
	void iterableWithList() {
		List<Integer> lista  = List.of(1,2,3);
		iterateGenerico(lista);
	}
	
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.iterableWithList();
	}
}
