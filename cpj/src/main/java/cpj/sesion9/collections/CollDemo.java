package cpj.sesion9.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import cpj.sesion9.entitys.Estudiante;


public class CollDemo {
	Collection<Estudiante> c;
	CollDemo(){
		c = new ArrayList<>();
		c.add(new Estudiante("12345678", "Juan Perez", 15, null));
		c.add(new Estudiante("22345678", "Carlos Diaz", 8, null));
	}

	public void listWithAgregateOpe(){
		c.stream()
		.forEach(e -> System.out.println(e));
	}

	public void listWithForEach(){
		for (Estudiante e : c) {
			System.out.println(e);
		}
	}

	public void listWithIterator(){
		Iterator<Estudiante> iter = c.iterator();
		while (iter.hasNext()) {
			Estudiante e =  iter.next();
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		CollDemo demo = new CollDemo();
		demo.listWithIterator();
	}
}
