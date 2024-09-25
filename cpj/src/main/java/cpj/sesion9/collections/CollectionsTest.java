package cpj.sesion9.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class CollectionsTest {

	@Test
	void test() {
		List<String> list = Arrays.asList(
				"123", "223", "323", "423");
		Collections.shuffle(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
	}

}
