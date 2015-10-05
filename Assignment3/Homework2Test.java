import static org.junit.Assert.*;

import org.junit.Test;

public class Homework2Test {

	@Test
	public void testDisplayEvenNumbers() {
		Homework2 h2 = new Homework2();
		assertArrayEquals(h2.displayEvenNumbers(5), new int[]{2, 4});
		assertArrayEquals(h2.displayEvenNumbers(21), new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20});
	}

	@Test
	public void testIsPrime() {
		Homework2 h2 = new Homework2();
		assertTrue(h2.isPrime(7));
		assertFalse(h2.isPrime(9));
	}

	@Test
	public void testNumberOfDigits() {
		Homework2 h2 = new Homework2();
		assertEquals(h2.numberOfDigits(54321), 5);
		assertEquals(h2.numberOfDigits(0), 1);
	}

	@Test
	public void testNumberOfaInString() {
		Homework2 h2 = new Homework2();
		assertEquals(h2.numberOfaInString("dafaeeka"), 3);
		assertEquals(h2.numberOfaInString("dargrgssgr"), 1);
	}

	@Test
	public void testNumberOfCharacterInString() {
		Homework2 h2 = new Homework2();
		assertEquals(h2.numberOfCharacterInString("dafaeeka", 'e'), 2);
		assertEquals(h2.numberOfCharacterInString("dargrgssgr", 'g'), 3);
	}

	@Test
	public void testFindMax() {
		Homework2 h2 = new Homework2();
		assertEquals(h2.findMax(new int[]{3, 6, 21, 9}), 21);
		assertEquals(h2.findMax(new int[]{3, 14, 2, 9, 45}), 45);
	}

	@Test
	public void testFindMin() {
		Homework2 h2 = new Homework2();
		assertEquals(h2.findMin(new int[]{3, 6, 21, 9}), 3);
		assertEquals(h2.findMin(new int[]{3, 14, 2, 9, 45}), 2);
	}

}
