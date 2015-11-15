
public class PrintCharacterThread extends Thread {
	//Define a "PrintingStick" Character
	private static Character sc;  
	private Character c;
	
	//get the "PrintingStick"
	public static Character getSc() {
		return sc;
	}
	
	//Constructor
	public PrintCharacterThread(Character c) {
		this.c = c;
	}
	
	//Print method
	public void printCharacter() {
		System.out.print(c);
	}
	
	//Find the next "PrintingStick"
	public void nextSc() {
		if (sc == 'E') {
			sc = 'A';
		} else {
			sc++;
		}
	}
	
	@Override
	public void run() {
		//I did not set the terminal for printing, 
		//so it will keep printing after start.
		while (true) {
			synchronized (getSc()) {
				if (c == getSc()) {
					printCharacter();
					nextSc();
				}
			}	
		}
	}
	
	public static void main (String[] args) {
		PrintCharacterThread[] pct = new PrintCharacterThread[5];
		for (int i = 0; i < 5; i++) {
			pct[i] = new PrintCharacterThread((char) (65+i));
		}
		sc = 'A';
		for (int i = 0; i < 5; i++) {
			pct[i].start();
		}
	}
}
