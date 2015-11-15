
public class PrintNumChar {
	//True: print number,False: print char
	static boolean flag;
	
	public static void main(String[] args) {
		PrintNumThread pnt = new PrintNumThread();
		PrintCharThread pct = new PrintCharThread();
		flag = true;
		pnt.start();
		pct.start();
		
	}
	
	//Print number method
	public void printNum() {
		for (int i = 1; i <= 52; i+=2) {
			synchronized (PrintNumChar.class) {
				//Not numbers' turn, wait
				if (flag == false) {
					try {
						PrintNumChar.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} 
				
				//print numbers
				System.out.print(i+""+(i+1));
				flag = false;
				PrintNumChar.class.notify();
			}	
		}
	}
	
	public void printChar() {
		for (char c = 'A'; c <= 'Z'; c++) {
			synchronized (PrintNumChar.class) {
				//Not char's turn, wait
				if (flag == true) {
					try {
						PrintNumChar.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//Print char
				System.out.print(c);
				flag = true;
				PrintNumChar.class.notify();
			}
		}
	}
}

//Thread for printing numbers
class PrintNumThread extends Thread {
	@Override
	public void run() {
		PrintNumChar p = new PrintNumChar();
		
		p.printNum();
	}
}

//Thread for printing chars
class PrintCharThread extends Thread {
	@Override
	public synchronized void run() {
		PrintNumChar p = new PrintNumChar();
		p.printChar();
	}
}