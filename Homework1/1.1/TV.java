
public class TV {
	String name;
	int channel;
	boolean status;
	int volume;
	int vol; //Used for unmute
	
	int getChannel() {
		return this.channel;
	}
	
	int getVolume() {
		return this.volume;
	}
	
	void turnOn() {
		this.status = true;
		System.out.println("Your TV has been turned on.");
	}
	
	void turnOff() {
		this.status = false;
		System.out.println("Your TV has been turned off");
	}
	
	void telecast(int channel){
		if (channel <= 0 || channel > 100) {  //The TV has at most 100 channels.
			System.out.println("Channel Not Exist"); 
		}
		else {
			System.out.println("You are watching Channel " + channel);
		}
	}
	
}
