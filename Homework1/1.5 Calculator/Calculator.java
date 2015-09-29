
public class Calculator {
	int add(int i1, int i2) {
		return i1 + i2;
	}
	
	int subtract(int i1, int i2) {
		return i1 - i2;
	}
	
	int multiply(int i1, int i2) {
		return i1 * i2;
	}
	
	int divide(int i1, int i2) {
		if (i2 == 0) {
			return 88888;
		}
		else return i1/i2;
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		System.out.println(c.divide(3, 0));
	}
}
