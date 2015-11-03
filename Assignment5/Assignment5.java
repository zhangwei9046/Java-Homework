import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Assignment5 {
	public int singleNumber(int[] nums) throws Exception{ //No.1
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int count = map.get(nums[i]);
				map.put(nums[i], count + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		int count = 0;
		int singleNum = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 2) {
				throw new Exception("Illegal input");  // number appears more than twice, illegal input
			} else if (entry.getValue() == 1){
				singleNum = entry.getKey();
				count++;
			}
		}
		if (count != 1) {
			throw new Exception("Illegal input"); // More than 1 single number, illegal input
		} else {
			return singleNum;
		}
	}
	
	public int singleNumberAdvanced(int[] nums) { //XOR operation, without dealing with illegal input
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result ^= nums[i];
		}
		return result;
	}
	
	public boolean wordPattern(String pattern, String str) { //No.2
		Map<Character, String> map = new HashMap<Character, String>();
		String[] s = str.split(" ");
		char[] c = pattern.toCharArray();
		if (s.length != c.length) {
			return false;
		}
		for (int i = 0; i < s.length; i++) {
			if (map.containsKey(c[i])) {
				if (! map.get(c[i]).equals(s[i])) {
					return false;
				}
			} else if (map.containsValue(s[i])){
				return false;
			} else {	
				map.put(c[i], s[i]);
			}
		}
		return true;
	}
	
	public boolean isValid(String s) throws Exception{ //No.3
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != '(' && c != ')' && c != '{' && 
					c != '}' && c != '[' && c != ']') {
				throw new Exception("Illegal input");
			}
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} 
			if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
				return false;
			}
			if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
				return false;
			}
			if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
				return false;
			}
		}
		if (! stack.isEmpty()) {
			return false;
		}
		return true;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		Person p = new Person("Ying", "Zhang");
		System.out.println(p.toString());
		MyStack ms = new MyStack();
		ms.push(1);
		ms.push(2);
		System.out.println(ms.top());
	}
}

class MyStack {                          //No.4
	Queue<Integer> queue = new LinkedList<Integer>();
	
    //Get the size of the stack
	public int size() {
		return queue.size();
	}
	
	// Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	shiftQueue();
    	queue.poll();
    }

    // Get the top element.
    public int top() {
        shiftQueue();
        int top = queue.peek();
        queue.offer(queue.poll());
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
    
    private void shiftQueue() {
    	int i = size();
    	while (i > 1) {
    		queue.offer(queue.poll());
    		i--;
    	}
    }
}

class Person implements Comparable<Person>{ //No.5
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	String firstName;
	String lastName;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int compareTo(Person p) {
		if (this.firstName.equals(p.firstName)) {
			return this.lastName.compareTo(p.lastName);
		} else {
			return this.firstName.compareTo(p.firstName);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}

