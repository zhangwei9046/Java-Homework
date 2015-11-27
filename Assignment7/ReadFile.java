/*1. Open a local file, read the file line by line. 
 *Each line should be imported as a string and stored in ArrayList. 
 *Then print out the ArrayList reversely. 
 *You can create your own file to test. 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	public ArrayList<String> readFileIntoArrayList(File file) {
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> strings = new ArrayList<String>();
		while(true) {
			try {
				String string = br.readLine();
				if(string == null) {
					break;
				}
				strings.add(string);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return strings;
	}
	
	public void printReversely(ArrayList<String> strings) {
		for (int i = strings.size() - 1; i >= 0; i--) {
			System.out.println(strings.get(i));
		}
	}
	
	public static void main(String[] args) {
		ReadFile r = new ReadFile();
		File file = new File("/Users/ying/hello.txt");
		r.printReversely(r.readFileIntoArrayList(file));
	}
}
