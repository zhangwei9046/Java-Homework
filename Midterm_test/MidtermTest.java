import java.util.HashSet;
import java.util.Set;

public class MidtermTest {
	public String printFizzBuss(int n) { //No.1
		if (n <= 0) return null;
		if (n % 15 == 0) {
			return "fizz buzz";
		} else if (n % 3 == 0) {
			return "fizz";
		} else if (n % 5 == 0) {
			return "buzz";
		}
		return null;
	}
	
	public int[] moveZeroes(int[] nums) { //No.2
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (nums[i] == 0) {
				for (int j = i; j < nums.length - 1; j++) {
					nums[j] = nums[j + 1];
				}
				nums[nums.length - 1] = 0;
				i--;
				length--;
			}
		}
		return nums;
	}
	
	public boolean isAnagram(String s, String t) { //No.3
		if (s == null || t == null) { // if either null, return false
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}
	
	public String sort(String s) { // define sort() method called by No.3
		char[] c = s.toCharArray();
		java.util.Arrays.sort(c);
		return new String(c);
	}
	
	public boolean containsDuplication(int[] nums) { //No.4
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}
		}
		return false;
	}
	
	public boolean twoSum(int[] nums, int target) { //No.5
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(target - nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}
		}
		return false;
	}
}
