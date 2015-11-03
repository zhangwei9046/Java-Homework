import static org.junit.Assert.*;

import org.junit.Test;

public class Assignment5Test {

	@Test
	public void testSingleNumber() throws Exception{ //No.1
		Assignment5 a5 = new Assignment5();
		assertEquals(4, a5.singleNumber(new int[]{3,4,3}));
		assertEquals(5, a5.singleNumber(new int[]{1,2,3,4,5,4,3,2,1}));
		
		assertEquals(4, a5.singleNumberAdvanced(new int[]{3,4,3}));       //test for singleNumberAdvanced
		assertEquals(5, a5.singleNumberAdvanced(new int[]{1,2,3,4,5,4,3,2,1}));
		assertEquals(0, a5.singleNumberAdvanced(new int[]{1,2,1,2}));
	}

	@Test
	public void testWordPattern() { //No.2
		Assignment5 a5 = new Assignment5();
		assertFalse(a5.wordPattern("abb", "dog cat cat cat"));
		assertTrue(a5.wordPattern("abba", "dog cat cat dog"));
		assertFalse(a5.wordPattern("abba", "dog cat cat fish"));
		assertFalse(a5.wordPattern("aaaa", "dog cat cat dog"));
		assertFalse(a5.wordPattern("abba", "dog dog dog dog"));
	}

	@Test
	public void testIsValid() throws Exception { //No.3
		Assignment5 a5 = new Assignment5();
		assertTrue(a5.isValid("()"));
		assertFalse(a5.isValid(")"));
		assertTrue(a5.isValid("(){}[]"));
		assertTrue(a5.isValid("[({})]"));
		assertFalse(a5.isValid("[{(})]"));
		assertFalse(a5.isValid("((){}"));
	}
	
	@Test
	public void testMyStack() { //No.4
		MyStack ms = new MyStack();
		assertTrue(ms.empty());
		ms.push(1);
		ms.push(2);
		assertEquals(2, ms.size());
		assertEquals(2, ms.top());
		assertFalse(ms.empty());
		ms.pop();
		assertEquals(1, ms.size());
		ms.pop();
		assertTrue(ms.empty());
	}
	
	@Test
	public void testPerson() { //No.5
		Person ying = new Person("Ying", "Zhang");
		Person zoey = new Person("Zoey", "Yeoz");
		assertEquals("Ying", ying.getFirstName());
		assertEquals("Zhang", ying.getLastName());
		assertEquals(-1, ying.compareTo(zoey));
		assertFalse(ying.equals(zoey));
		
		ying.setFirstName("Zoey");
		ying.setLastName("Yeoz");
		assertEquals("Zoey", ying.getFirstName());
		assertEquals("Yeoz", ying.getLastName());
		assertEquals(0, ying.compareTo(zoey));
		assertTrue(ying.equals(zoey));
	}
	
	@Test
	public void testMyHashMap() { //No.6
		MyHashMap map = new MyHashMap(); //initiate
		assertTrue(map.isEmpty());
		assertEquals(0, map.size());
		
		map.put(1, "Hello");  //put
		map.put(2, "World");
		assertFalse(map.isEmpty());
		assertEquals(2, map.size());
		assertTrue(map.containsKey(1));
		assertFalse(map.containsKey(4));
		assertFalse(map.containsValue("Ying"));
		assertTrue(map.containsValue("World"));
		assertSame("Hello", map.get(1));
		
		assertSame("Hello", map.remove(1));  //remove
		assertSame(null, map.get(1));
		assertEquals(1, map.size());
		assertFalse(map.containsKey(1));
		assertFalse(map.containsValue("Hello"));
		
		map.clear();
		assertTrue(map.isEmpty());
		assertFalse(map.containsKey(2));
		assertFalse(map.containsValue("World"));
		
		for (int i = 0; i < 33; i++) {
			map.put(i, "Ying");
		}
		assertEquals(33, map.size()); //test for rehash, since the default capacity for array is 31
	}
}
