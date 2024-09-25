package cpj.sesion9.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class ConversionsTest {

	@Test
	void toSetOrList() {
		Collection<String> c = new ArrayList<>();
		c.add("123");
		c.add("223");
		c.add("323");
		c.add("223");
		assertEquals(4, c.size());
		
		Set<String> set1 = new HashSet<>(c);
		assertEquals(3, set1.size());

		Set<String> set2 = c.stream().collect(Collectors.toSet());
		assertEquals(3, set2.size());
		
		Set<String> set3 = c.stream().collect(Collectors.toCollection(TreeSet::new));
		assertEquals(3, set3.size());
		
	}

	@Test
	void toQue() {
		Collection<String> c = new ArrayList<>();
		c.add("123");
		c.add("223");
		c.add("323");
		c.add("223");
		assertEquals(4, c.size());
		
		Queue<String> q1 = new PriorityQueue<>(c);
		assertEquals(4, q1.size());
		
		Deque<String> q2 = new LinkedList<>(c);
		assertEquals("223", q2.pollLast());
		assertEquals(3, q2.size());
	}

	@Test
	void toMap() {
		Collection<String> c = new ArrayList<>();
		c.add("123");
		c.add("223");
		c.add("323");
		//c.add("223");
		
		Map<String, Integer> map = c.stream().collect(Collectors.toMap(
				(e) -> e,
				(e) -> 2
				));
				
		assertEquals(3, map.size());
		assertEquals(2, (int)map.get("123"));
	}

	@Test
	void toArray() {
		Collection<String> c = new ArrayList<>();
		c.add("123");
		c.add("223");
		c.add("323");
		c.add("223");
		assertEquals(4, c.size());
		
		Object[] as = c.toArray();
		assertEquals(4, as.length);
	}

	@Test
	void arrayToList() {
		List<String> lst = Arrays.asList("123", "223", "323");
		assertEquals(3, lst.size());
	}

	@Test
	void arrayToOtro() {
		Set<String> set = Arrays.asList("uno", "dos", "dos")
				.stream().collect(Collectors.toSet());
		assertEquals(2, set.size());
	}

	@Test
	void arrayAndListunModified() {
		List<String> lst = Arrays.asList("123", "223", "323");
		assertThrows(UnsupportedOperationException.class, 
				() -> {
					lst.add("423");			
				}
		);
	}
	
	

}
