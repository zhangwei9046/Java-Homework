class People {
  String name;
  Phone phone;
  
  void talkWith(People friend) {
  }
  
  void endTheCall(People friend) {
	  this.phone.cutOff(friend.phone);
  }
  
  void call(People friend) {
	  Phone p = new Phone();
	  if (p.connects(friend.phone)) {
		  talkWith(friend);
		  if (! friend.phone.status.equals("unavailable")) {
			  p.cutOff(friend.phone);
		  } else {
			  endTheCall(friend);
		  }
	  }
  }
  
  public static void main(String[] args) {
	  People People = new People();
	  People friend = new People();
	  friend.phone = new Phone();
	  friend.phone.number = "2062948210";
	  People.call(friend);
  }
}

class Phone { 
	String number;
	String status;
	
	boolean connects(Phone p) {
	if (p.status.equals("available")) return true;
		else if (p.status.equals("busy") || p.status.equals("unavailable")) {
			return false;
		}
		else return false;
	}
	
	void cutOff(Phone p) {
		
	}
}