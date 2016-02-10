import java.io.*;
import java.util.*;

class Categorize {
	private static void categorize(String prompt){
		CatTree ct = new CatTree();
		BufferedReader input = null;
		System.out.print(prompt);
		System.out.flush();
		try {
			input = new BufferedReader(new FileReader(prompt));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String line = input.readLine();
			for (int i = 0; i < line.length()+ 1; i++){
				String[] element = line.split("\\s");
				Dictionary<String,String> d = new Hashtable<String,String>();
				d.put("name", element[0]);
				d.put("product", element[1]);
				d.put("location", element[2]);
				ListNode n = new ListNode(d);
				ct.insert(n);
			}
		}
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		categorize("Enter the name of the spending file: ");

	}
}

