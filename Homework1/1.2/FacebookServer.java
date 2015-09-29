
public class FacebookServer {
	User[] activeUsers;
	FacebookRegistry registry;
	
	boolean validateUser(User user) {
		String un = user.user_name;
		String pwd = user.pwd;
		boolean b = registry.isUserValid(un, pwd);
		return b;
	}
}

class FacebookRegistry {
	public boolean isUserValid(String un, String pwd) {
		return false;
	}
}
