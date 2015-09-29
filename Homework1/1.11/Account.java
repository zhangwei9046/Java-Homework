
public class Account {
	String number;
	float balance;
	
	void deposit(double d) {
		if (d >= 100 && d <= 1000) {
			this.balance += 1 + d;
		} else if (d > 1000){
			this.balance += 2 + d;
		} else {
			this.balance += d;
		}
		System.out.println("Your balance is: " + balance);
	}
	
	void withdraw(double d) {
		if (d <= 0) {
			System.out.println("Error!");
		} else if (d > balance) {
			System.out.println("Insufficient balance!");
		} else {
			this.balance -= d;
			System.out.println("Your balance is: " + balance);
		}
	}
	
	public static void main(String[] args) {
		Account a = new Account();
		a.deposit(508.9);
		a.deposit(4);
		a.withdraw(400.000024);
	}
}
