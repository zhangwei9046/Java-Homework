
public class Student {
	float gpa;
	
	String getGrade(float gpa) {
		if (gpa >= 3.75) {
			return "A+";
		} else if (gpa >= 3.5 && gpa < 3.75) {
			return "A-";
		} else if (gpa >= 3.25 && gpa < 3.5) {
			return "B+";
		} else if (gpa >=3 && gpa < 3.25) {
			return "B-";
		} else if (gpa >= 0 && gpa < 3) {
			return "C";
		} else {
			return "Error";
		}
	}
	
	
}
