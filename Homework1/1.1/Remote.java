class RemoteButton{
	
}

public class Remote {
	TV tv;
	RemoteButton[] numbers = new RemoteButton[10];
	RemoteButton increaseVolume;
	RemoteButton decreaseVolume;
	RemoteButton powerButton;
	
	void switchOn() {
		tv.turnOn();
	}
	
	void switchOff() {
		tv.turnOff();
	}
	
	void changeChannel() {
		
	}
		
	void increaseVolume() {
		int a = tv.volume;
		if (a < 0 || a > 16) { //The highest volume is 16.
			System.out.println("Error!");
		} else if (a == 16) {
			System.out.println("This is the highest volume.");
		} else {
			tv.volume++;
			
			System.out.println("Volume changed to " + a);
		}
	}
	
	void decreaseVolume(TV tv) {
		int a = tv.volume;
		if (a < 0 || a >= 16) {
			System.out.println("Error!");
		} else if (a == 0){
			System.out.println("This is the lowest volume.");
		} else {
			tv.volume--;
			System.out.println("Volume changed to " + a);
		}
	}
	
	void muteTV() {
		tv.vol = tv.volume;
		tv.volume = 0;
		System.out.println("Mute!");
	}
	
	void unmuteTV(TV tv) {
		tv.volume = tv.vol;
		System.out.println("Unmute!");
	}
}
