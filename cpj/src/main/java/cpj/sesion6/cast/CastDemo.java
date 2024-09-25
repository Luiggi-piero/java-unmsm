package cpj.sesion6.cast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CastDemo {
	
	public void demo() {
		// Upcastingg - no es necesario el casteo - de ArrayList a List
		List<String> lista = new ArrayList<>();
		System.out.println(lista);
		// Para ver los fallos revisar el diagrama de relaciones entre LinkedList, List, ArrayList , etc
		
		// Downcasting -  si es necesario el casteo explicito - de List  a ArrayList
		ArrayList<String> lista2 = (ArrayList<String>) lista;
		System.out.println(lista2);
		
		// Falla en tiempo de compilacion
		//LinkedList<String> lin = new LinkedList<>();
		//ArrayList<String> arr = (ArrayList<String>) lin;
		
		// Falla en tiempo de ejecucion
		//Collection<String> col= new TreeSet<>();    
		//HashSet<String> ha = (HashSet<String>) col;
		
		
		// Falla en tiempo de compilacion
		//List<String> list = new ArrayList<>();
		//TreeSet<String> set = (TreeSet<String>) list;
	}
	
	public static void main(String[] args) {
		new CastDemo().demo();
	}
}
