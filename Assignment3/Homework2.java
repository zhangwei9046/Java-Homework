import java.util.Scanner;
public class Homework2 {
    
    public int[] displayEvenNumbers(int a){
        int even[] = new int[a/2];
        for (int i = 0; i < a/2; i++) {
            even[i] = i * 2 + 2;
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
        int count = 1;
        while (a/10 != 0) {
            a = a/10;
            count++;
        }
        return count;
    }
    
    int numberOfaInString(String s) {
        return numberOfCharacterInString(s, 'a');
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
    
    public static void main(String[] args) {
        Homework2 h2 = new Homework2();
        h2.testDisplayEvenNumbers();
        h2.testIsPrime();
        h2.testNumberOfDigits();
        h2.testNumberOfaInString();
        h2.testNumberOfCharacterInString();
        h2.testMaxAndMin();
    }
    
    public void testDisplayEvenNumbers() {
        System.out.print("Input: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.print("Output: ");
        int[] even = displayEvenNumbers(a);
        String s = "";
        for (int i = 0; i < even.length; i++) {
            s += even[i] + ", ";
        }
        s = s.substring(0, s.length()-2);
        System.out.println(s);
    }
    
    public void testIsPrime() {
        System.out.print("Input: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.print("Output: ");
        boolean b = isPrime(a);
        if (b) {
            System.out.println( a + " is Prime");
        } else {
            System.out.println(a + " is not Prime");
        }
    }
    
    public void testNumberOfDigits() {
        System.out.print("Input: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.print("Output: ");
        int count = numberOfDigits(a);
        if (count == 1) {
            System.out.println(a + " has " + count + " digit");
        } else {
            System.out.println(a + " has " + count + " digits");
        }
    }
    
    public void testNumberOfaInString() {
        System.out.print("Input: ");
        Scanner scanner1 = new Scanner(System.in);
        
        String s2 = scanner1.next();
        int count2 = numberOfaInString(s2);
        if (count2 == 0) {
            System.out.print(s2 + " has no 'a'");
        } else {
            System.out.print(s2 + " has " + count2 + " 'a'");
        }
        
    }
    
    public void testNumberOfCharacterInString() {
        System.out.print("Input: ");
        Scanner scanner2 = new Scanner(System.in);
        String s1 = scanner2.next();
        String s2 = scanner2.next();
        System.out.print("Output: ");
        s1 = s1.substring(0, s1.length()-1);
        char a1 = s2.charAt(1);
        int count3 = numberOfCharacterInString(s1, a1);
        if (count3 == 0) {
            System.out.print(s1 + " has no '" + a1 + "'");
        } else {
            System.out.print(s1 + " has " + count3 + " '" + a1 + "'");
        }	
    }
    
    public void testMaxAndMin() {
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
        System.out.println(findMax(numbers));
        System.out.println("Max is " + findMax(numbers) + " and Min is " + findMin(numbers));
        
    }
}
