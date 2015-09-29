import java.util.*;
public class Homework2 {
	public static void main(String[] args) {
		Homework2 h2 = new Homework2();
		h2.method1();
		h2.method2();
		h2.method3();
		h2.method4();
		h2.method5();
		h2.method6();
		h2.method7();
	}
	@SuppressWarnings("resource")
	void method1(){
		System.out.print("Input: ");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		System.out.print("Output: ");
		for (int i = 1; i <= a-2; i++) {
			if (i%2 == 0) System.out.print(i + ", ");
		}
		for (int i = a-1; i <= a; i++){
			if(i%2 == 0) System.out.print(i);
		}
	}
	
	void method2() {
		System.out.print("Input: ");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		System.out.print("Output: ");
		if (a < 2) {
			System.out.print(a + " is not Prime");
		} else {
			int i = 2;
			while (i * i <= a) {
			if (a%i == 0) {
				System.out.print(a + " is not Prime");
			    break;
			    } else i++;
			}
			if (i * i > a) System.out.print(a + " is Prime");
		}
	}
	
	void method3() {
		System.out.print("Input: ");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		System.out.print("Output: ");
		int i = a;
		int count = 0;
		while (i%10 != 0) {
			i = i/10;
			count++;
		}
		if (count == 1) {
			System.out.println(a + " has " + count + " digit");
		} else {
			System.out.println(a + " has " + count + " digits");
		}
		
	}
	
	void method4() {
		System.out.print("Input: ");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		System.out.print("Output: ");
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				count++;
			}
		}
		if (count == 0) {
			System.out.print(s + " has no 'a'");
		}
		System.out.print(s + " has " + count + " 'a'");
	}
	
	void method5() {
		System.out.print("Input: ");
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.next();
		String s2 = scanner.next();
		System.out.print("Output: ");
		s1 = s1.substring(0, s1.length()-1);
		
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s2.charAt(1) == s1.charAt(i)) {
				count++;
			}
		}
		if (count == 0) {
			System.out.print(s1 + " has no '" + s2.charAt(1) + "'");
		} else {
			System.out.print(s1 + " has " + count + " '" + s2.charAt(1) + "'");
		}
	}
	
	void method6() {
		System.out.print("Input: ");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		System.out.print("Output: ");
		String[] ss = s.split(", ");
		int length = ss.length;
		ss[0] = ss[0].substring(1);
		ss[length - 1] = ss[length - 1].substring(0, ss[length - 1].length() - 1);
		
		int max = Integer.parseInt(ss[0]);
		for (int i = 1; i < ss.length; i++) {
			int val = Integer.parseInt(ss[i]);
			if (val > max) {
				max = val;
			}
		}
			System.out.println(max);
	}
	
	void method7() {
		System.out.print("Input: ");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		System.out.print("Output: ");
		String[] ss = s.split(", ");
		int length = ss.length;
		ss[0] = ss[0].substring(1);
		ss[length - 1] = ss[length - 1].substring(0, ss[length - 1].length() - 1);
		
		int max = Integer.parseInt(ss[0]);
		int min = max;
		for (int i = 1; i < ss.length; i++) {
			int a = Integer.parseInt(ss[i]);
			if (a > max) {
				max = a;
			}
			if (a < min) {
				min = a;
			}
		}
			System.out.println("Max is " + max + " and Min is " + min);
	}
}
