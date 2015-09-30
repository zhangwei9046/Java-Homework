public class Person {
	int age;
	String gender;
	void watchChannel(Remote r) {
		if (!tv.status) {
			tv.turnOn();
		}
		r.changeChannel();
	}
}
