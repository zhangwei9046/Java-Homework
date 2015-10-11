import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Assignment4 {
	public ZeroIndex[] findZerosGroups(int[] array) {
		ArrayList<ZeroIndex> al = new ArrayList<ZeroIndex>();
		int count = 0;
		String s = "";
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				count++;
				s += "0";
			} else if (count > 1){
				al.add(new ZeroIndex(s, i-count));
				count = 0;
				s = "";
			}
		}
		if (count > 1) {
			al.add(new ZeroIndex(s, array.length - count));
		}
		return al.toArray(new ZeroIndex[0]);
	}
	
	public void testFindZerosGroups(int[] array) {
		ZeroIndex[] zi = findZerosGroups(array);
		for (int i = 0; i < zi.length; i++) {
			System.out.println(zi[i].getZeroPattern() + " occurs @ index " + zi[i].getIndex());
		}
	}
	
 	public String reversesSentence(String s) {
		s = " " + s;
		String str = "";
		int start = 0;
		for (int i = 1;i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				str = s.substring(start, i) + str;
				start = i;
			}
		}
		str = s.substring(start + 1, s.length()) + str;
		return str;
	}
	
	public void printNumberPyramid(int row) {
		int count = 1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print(" " + count);
				count++;
			}
			System.out.println();
		}
	}
	
	public String generateFibonacciNumber(int limit) {
		int i = 1, j = 1;
		String s = 1 + "," + 1 + ",";
		while(true) {
			i = i + j;
			if (i > limit){
				break;
			} else {
				s = s + i + ",";
			}
			j = j + i;
			if (j > limit){
				break;
			} else {
				s = s + j + ",";
			}
		}
		s = s.substring(0, s.length()-1);
		return s;
	}
	
	public String capatalizesFirstLetter(String s) {
		char[] c = s.toCharArray();
		c[0] = Character.toUpperCase(c[0]);
		for (int i = 1; i < c.length; i++) {
			if (c[i] == ' ') {
				c[i+1] = Character.toUpperCase(c[i+1]);
			}
		}
		return new String(c);
	}
	
	public String[] printWordsMoreThan3Letters(String s) {
		ArrayList<String> al = new ArrayList<String>();
		int count = 0;
		int start = 0;
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 65 && s.charAt(i) <= 122) {
				count++;
			} 
			else if (count > 3){
				al.add(s.substring(start, i));
				count = 0;
				start = i + 1;
			} else {
				count = 0;
				start = i + 1;
			}
		}
		if (s.charAt(s.length()-1) >= 65 && s.charAt(s.length()-1) <= 122) {
			al.add(s.substring(start, s.length()));
		}
		return al.toArray(new String[0]);
	}
	
	public void guessNumber() {
		Random randomGenerator = new Random();
		int i = randomGenerator.nextInt(100) + 1;
		System.out.println("Please guess a number between 1 and 100 - You have 5 chances to guess");
		int k;
		for (k = 0; k < 5; k++) {
			Scanner scanner = new Scanner(System.in);
			int guess_num = scanner.nextInt();
			if (k == 4) {
				if (guess_num == i) {
					System.out.println("Congratulations! You've guessed it right and you guessed it in " + 5 +" chances..");
				} else {
					System.out.println("Haha! The number I've guessed is: " + i + ". Game Over!");
				}
			} else {
			    if (guess_num > i) {
				    System.out.println(guess_num + " is greater than what I've guessed - You have " + (4 - k) + " chances to guess");
			    }
			    else if (guess_num < i) {
				    System.out.println(guess_num + " is less than what I've guessed - You have " + (4 - k) + " chances to guess");
			    } else {
				    System.out.println("Congratulations! You've guessed it right and you guessed it in " + (k + 1) +" chances..");
				    break;
			    }
		    }
	    }
	}
	
	public void cowsAndBulls() {
		Random randomGenerator = new Random();
		int num = randomGenerator.nextInt(9000) + 1000;
		int[] digit = new int[4];
		digit[0] = num/1000;
		digit[1] = (num - digit[0] * 1000) / 100;
		digit[2] = (num - digit[0]* 1000 - digit[1] * 100) / 10;
		digit[3] = num - digit[0] * 1000 - digit[1] * 100 - digit[2] * 10;
		System.out.println("Please enter a 4 digit number");
		
		while (true) {
			System.out.print("Input: ");
			Scanner scanner = new Scanner(System.in);
			String s = scanner.next();
			if (s.length() == 4) {
				int cow = 0;
				int bull = 0;
				int[] guess = new int[4];
				for (int i = 0; i < 4; i++) {
					guess[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
				}
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (i == j && guess[i] == digit[j]) {
							cow++;
						} else if (guess[i] == digit[j]) {
							bull++;
						}
					}
				}
				System.out.print("Output: " + cow + " Cow " + bull +" Bull");
				System.out.println();
				if (cow == 0 && bull == 4) {
					break;
				}
				cow = 0;
				bull = 0;
			} else {
				System.out.println("Please enter a 4 digit number:");
				continue;
			}
			
		}
	}
	public static void main(String[] args) {
		Assignment4 a = new Assignment4();
		a.guessNumber();
//		a.cowsAndBulls();
		
	}
	
	
}

class ZeroIndex {
	private String zeroPattern;
	private int index;
	
	public ZeroIndex(String zeroPattern, int index) {
		super();
		this.zeroPattern = zeroPattern;
		this.index = index;
	}
	
	public String getZeroPattern() {
		return zeroPattern;
	}
	public void setZeroPattern(String zeroPattern) {
		this.zeroPattern = zeroPattern;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + ((zeroPattern == null) ? 0 : zeroPattern.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZeroIndex other = (ZeroIndex) obj;
		if (index != other.index)
			return false;
		if (zeroPattern == null) {
			if (other.zeroPattern != null)
				return false;
		} else if (!zeroPattern.equals(other.zeroPattern))
			return false;
		return true;
	}
}