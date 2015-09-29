
public class Driver {
	boolean isInjured;
	void driveOnRoad(Car c) {
		c.runOnRoad();
	}
	void call911(Driver d){
//		if((isInjured == true) || (d.isInjured == true)) askForAmbulance();
//		callPolice();
	}
	
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.driver = new Driver();
		Car c2 = new Car();
		c2.driver = new Driver();
		c1.driver.driveOnRoad(c1);
		c2.driver.driveOnRoad(c2);
		c1.collideWith(c2);
		c1.driver.call911(c2.driver);
		if (c1.driver.isInjured == true) {
			Ambulance a1 = new Ambulance();
			a1.takeaway(c1.driver);
		}
		if (c2.driver.isInjured == true) {
			Ambulance a2 = new Ambulance();
			a2.takeaway(c2.driver);
		}
		Cop cop = new Cop();
		cop.indentifyResposibility();
		TowingCompany tc = new TowingCompany();
		cop.inform(tc);
		tc.sendTowTruck(c1);
		tc.sendTowTruck(c2);
		tc.payfor(c1.driver);
		tc.payfor(c2.driver);
	}
}

class Car {
	Driver driver;
	void runOnRoad(){}
	void collideWith(Car c) {}
}
class Cop {
	void indentifyResposibility() {}
	void inform(TowingCompany tc) {}
}

class InsuranceProvider {
	void informInsurance(Driver d) {}
}
class Road {
	
}
class Ambulance {
	void takeaway(Driver d) {}
}
class TowingCompany{
	TowTruck towtruck;
	
	void sendTowTruck(Car c){
		TowTruck tt = new TowTruck();
		tt.takeaway(c);
	}
	void payfor(Driver d){}
}
class TowTruck {
	void takeaway(Car c){}
}

