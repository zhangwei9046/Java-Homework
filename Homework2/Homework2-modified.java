import java.util.*;
public class Homework2 {
	public static void main(String[] args) {
		Homework2 h2 = new Homework2();
		/*
//		test1:
		System.out.print("Input: ");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		System.out.print("Output: ");
		int[] even = h2.displayEvenNumbers(a);
		String s = "";
		for (int i = 0; i < even.length; i++) {
			s += even[i] + ", ";
		}
		s = s.substring(0, s.length()-2);
		System.out.println(s);
//		test2:
		boolean b = h2.isPrime(a);
		if (b) {
			System.out.println( a + " is Prime");
		} else {
			System.out.println(a + " is not Prime");
		}
//		test3:
		int count = h2.numberOfDigits(a);
		if (count == 1) {
			System.out.println(a + " has " + count + " digit");
		} else {
			System.out.println(a + " has " + count + " digits");
		}

//		test4:
		System.out.print("Input: ");
		Scanner scanner1 = new Scanner(System.in);
		
		String s2 = scanner1.next();
		int count2 = h2.numberOfaInString(s2);
		if (count2 == 0) {
			System.out.print(s2 + " has no 'a'");
		} else {
			System.out.print(s2 + " has " + count2 + " 'a'");	
		}
		
//		test5:
		System.out.print("Input: ");
		Scanner scanner2 = new Scanner(System.in);
		String s1 = scanner2.next();
		String s2 = scanner2.next();
		System.out.print("Output: ");
		s1 = s1.substring(0, s1.length()-1);
		char a1 = s2.charAt(1);
		int count3 = h2.numberOfCharacterInString(s1, a1);
		if (count3 == 0) {
			System.out.print(s1 + " has no '" + a1 + "'");
		} else {
			System.out.print(s1 + " has " + count3 + " '" + a1 + "'");
		}
		*/
//		test6:
		System.out.print("Input: ");
		Scanner scanner3 = new Scanner(System.in);
		String s = scanner3.nextLine();
		s = s.substring(1, s.length()-1);
		System.out.print("Output: ");
		String[] ss = s.split(", ");
		int length = ss.length;
		int[] numbers = new int[length];
		for (int i = 0; i < length; i ++) {
			numbers[i] = Integer.parseInt(ss[i]);
		}
		System.out.println(h2.findMax(numbers));
		System.out.println("Max is " + h2.findMax(numbers) + " and Min is " + h2.findMin(numbers));
	}

	public int[] displayEvenNumbers(int a){
		int index = 0;
		int even[] = new int[a/2];
		for (int i = 1; i <= a; i++) {
			if (i%2 == 0) {
				even[index] = i;
				index++;
			}
		}
		return even;
	}
	
	boolean isPrime(int a) {
		if (a < 2) {
			return false;
		} else {
			int i = 2;
			while (i * i <= a) {
			if (a%i == 0) {
				return false;
			} else {
			    	i++;
			    }
			}
		}
		return true;
	}
	
	int numberOfDigits(int a) {
		int i = a;
		int count = 0;
		while (i%10 != 0) {
			i = i/10;
			count++;
		}
		return count;
	}
	
	int numberOfaInString(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				count++;
			}
		}
		return count;
	}
	
	int numberOfCharacterInString(String s, char a) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == a) {
				count++;
			}
		}
		return count;
		
	}
	
	public int findMax(int numbers[]) {
		int val = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > val) {
				val = numbers[i];
			}
		}
		return val;
	}
	
	public int findMin(int numbers[]) {
		int val = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < val) {
				val = numbers[i];
			}
		}
		return val;
	}
}
