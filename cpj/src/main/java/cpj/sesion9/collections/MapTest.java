package cpj.sesion9.collections;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MapTest {
	
	@Test
	void collectionView() {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("1", 10);
		m.put("2", 20);
		m.put("3", 30);

		Set<String> s = m.keySet();
		Set<String> expected = new HashSet<>(Arrays.asList("1", "2", "3"));
		assertEquals(expected, s);
		
		Collection<Integer> vals = m.values();
		//Collection<Integer> expectedVals = Arrays.asList(10, 20, 30);
		//assertEquals(expectedVals, vals);
		assertEquals(3, vals.size());
		assertTrue(vals.contains(10));
		assertTrue(vals.contains(20));
		assertTrue(vals.contains(30));
		
		Set<Entry<String, Integer>> es = m.entrySet();
		assertEquals(3, es.size());
		
		for (Entry<String, Integer> entry : es) {
			System.out.format("(%s,%d)", 
					entry.getKey(), entry.getValue());
		}
	}


}
