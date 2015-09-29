
public class Math {
	static String evenOrOdd(int i) {
		if (i%2 == 0) {
			return "Even";
		} else {
			return "Odd";
		}
	}
	
	static boolean isMultipleOf3(int i) {
		if (i%3 == 0) return true;
		else return false;
	}
	
	String posOrNeg(int i) {
		if (i == 0) {
			return "Not Positive Not Negative";
		} else if (i < 0) {
			return "Negative";
		} else if (i > 0){
			return "Positive";
		} else return "Error";
	}
	
	int maximum(int i, int j) {
		if (i > j) return i;
		else return j;
	}
	
	int minimum(int i, int j) {
		if(i > j) return j;
		else return i;
	}
	
}
