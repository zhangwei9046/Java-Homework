import static org.junit.Assert.*;

import org.junit.Test;

public class MidtermTestTest {

	@Test
	public void testPrintFizzBuss() {
		MidtermTest mt = new MidtermTest();
		assertNull(mt.printFizzBuss(0));
		assertNull(mt.printFizzBuss(101));
		assertSame(mt.printFizzBuss(3), "fizz");
		assertSame(mt.printFizzBuss(81), "fizz");
		assertSame(mt.printFizzBuss(5), "buzz");
		assertSame(mt.printFizzBuss(125), "buzz");
		assertSame(mt.printFizzBuss(15), "fizz buzz");
		assertSame(mt.printFizzBuss(225), "fizz buzz");
	}

	@Test
	public void testMoveZeroes() {
		MidtermTest mt = new MidtermTest();
		assertArrayEquals(mt.moveZeroes(new int[]{0,1,0,3,12}),
				new int[]{1,3,12,0,0});
		assertArrayEquals(mt.moveZeroes(new int[]{1,2,0,0,3}),
				new int[]{1,2,3,0,0});
		assertArrayEquals(mt.moveZeroes(new int[]{4,6,0,0,3,0}),
				new int[]{4,6,3,0,0,0});
		assertArrayEquals(mt.moveZeroes(new int[]{0,10,8,0,0,9,0}),
				new int[]{10,8,9,0,0,0,0});
		
	}

	@Test
	public void testIsAnagram() {
		MidtermTest mt = new MidtermTest();
		assertFalse(mt.isAnagram(null, null));
		assertFalse(mt.isAnagram(null, "abc"));
		assertTrue(mt.isAnagram("", ""));
		assertFalse(mt.isAnagram("spar", "spark"));
		assertTrue(mt.isAnagram("anagram", "nagaram"));
		assertFalse(mt.isAnagram("rat", "car"));
	}

	@Test
	public void testContainsDuplication() {
		MidtermTest mt = new MidtermTest();
		assertFalse(mt.containsDuplication(new int[]{3,21,5,8,16}));
		assertTrue(mt.containsDuplication(new int[]{3,21,5,8,16,8}));
		assertTrue(mt.containsDuplication(new int[]{7,2,3,4,7}));
		assertFalse(mt.containsDuplication(new int[]{0,8,4,9}));
		assertFalse(mt.containsDuplication(new int[]{}));
	}

	@Test
	public void testTwoSum() {
		MidtermTest mt = new MidtermTest();
		assertTrue(mt.twoSum(new int[]{3,3}, 6));
		assertTrue(mt.twoSum(new int[]{1,4,7,11,13}, 11));
		assertFalse(mt.twoSum(new int[]{3,0,8,5}, 6));
		assertFalse(mt.twoSum(new int[]{0,0,9,10}, 16));
		assertFalse(mt.twoSum(new int[]{}, 0));
	}
}
