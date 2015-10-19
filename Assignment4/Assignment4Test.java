 // not use wildcard import.
import static org.junit.Assert.*;

import org.junit.Test;

public class Assignment4Test {

	@Test
	public void testFindZerosGroups() {
		Assignment4 a4 = new Assignment4();
		int[] array2 = {1, 0, 0, 4, 0, 0, 0, 0, 3, 2};
		assertArrayEquals(a4.findZerosGroups(array2), new ZeroIndex[]{new ZeroIndex("00", 1), new ZeroIndex("0000", 4)});
	}

	@Test
	public void testReversesSentence() {
		Assignment4  a4= new Assignment4();
		assertEquals(a4.reversesSentence("I love the object oriented program course in NEU"), "NEU in course program oriented object the love I");
	}
	
	@Test
	public void testGenerateFibonacciNumber() {
		Assignment4 a4 = new Assignment4();
		assertEquals(a4.generateFibonacciNumber(145), "1,1,2,3,5,8,13,21,34,55,89,144");
	}
	
	@Test
	public void testCapatalizesFirstLetter() {
		Assignment4 a4 = new Assignment4();
		assertEquals(a4.capatalizesFirstLetter("we love seattle and will live here for a long time."), "We Love Seattle And Will Live Here For A Long Time.");
	}
	
	@Test
	public void testPrintWordsMoreThan3Letters() {
		Assignment4 a4 = new Assignment4();
		assertArrayEquals(a4.printWordsMoreThan3Letters("Java is a cool OOP. It doesnt have multiple inheritance"), new String[]{"Java", "cool", "doesnt", "have", "multiple", "inheritance"});
	}
}
