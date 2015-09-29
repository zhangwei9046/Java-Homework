public class Person {
	int age;
	String gender;
	
	String getType() {
		if (age < 0) {
			return "Error";
		} else if (age >= 0 && age < 1) {
			return "infant";
		} else if (age >=1 && age < 3) {
			return "Toddler";
		} else if (age >= 3 && age < 5) {
			return "Pre Schooler";
		} else if (age >= 6 && age <6) {
			if (gender == null) {
				return "Error";
			} else if (gender.toLowerCase().equals("female")){
				return "KG Girl";
			} else if (gender.toLowerCase().equals("male")) {
				return "KG Boy";
			} else {
				return "Error";
			}
		}
		return "Cannot identify";
	}
	// Answer for Question 12
}
