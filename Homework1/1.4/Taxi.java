class Taxi {
	int taxiID;
	int clientID;
	boolean isActive = true;
	boolean orderStatus;
	
	void acceptOrder(Order o) {
		isActive = false;
		clientID = o.userID;
//		get(o.startlocation);
//		get(o.targetlocation);
//		driveTo(startlocation);
//		pickUpTheUser(clientID);
//		driveTo(targetlocation);
		isActive = true;
	}
}

class User {
	int userID;
	String psw;
	
	void login(App app) {
//		putIn(userID);
//		putIn(psw);
	}
	
	Order orderTaxi(int startlocation, int targetlocation, Taxi t) {
		Order o = new Order();
		o.createOrderID();
		o.startlocation = startlocation;
		o.targetlocation = targetlocation;
		o.userID = this.userID;
		o.TaxiID = t.taxiID;
		return o;
	}
	
	public static void main(String[] args) {
		User u = new User();
		Taxi t = new Taxi();
		Order o = u.orderTaxi(1, 10, t);
		t.acceptOrder(o);
	}
}

class App {
	int active_num = 0;
	Order order;
	
	void validateUser(User u) {
//	  validateUser();
//	  validatepsw();
	}
}

class Order {
	int orderID;
	int userID;
	int TaxiID;
	int startlocation;
	int targetlocation;
	
	void createOrderID() {
		
	}
}
