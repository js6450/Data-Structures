
import java.io.*;

public class MapReduce {

	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	public static void map(String s){
		String[] spending = s.split("\\s");
		for (int i = 0; i < spending.length;){
			if(isNumeric(spending[i])){
				++i;
			}
			else{
				String name = spending[i];
				StackList value = new StackList();
				if(isNumeric(spending[i+1])){
					value.push(spending[i+1]);
				}
				for(int n = 0; n < spending.length;){
					if(spending[n] == name){
						if(isNumeric(spending[n+1])){
							value.push(spending[n+1]);
						}
					}
				}
				reduce(name, value);
				
			}
		}
	}
	
	public static void reduce(String key, StackList value){
		double sum = 0;
		while(!value.isEmpty()){
			double num = new Double(value.topAndPop());
			sum = sum + num;
		}
		System.out.println(key + ": " + sum);
		
	}
	
	@SuppressWarnings("resource")
	private static String getInput(String prompt){
		BufferedReader input = null;
		System.out.print(prompt);
		System.out.flush();
		try {
			input = new BufferedReader(new FileReader(prompt));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			return input.readLine();
		}
		catch(Exception e){
			return "Error: " + e.getMessage();
		}
	}
	
	public static void main(String[] args) {
		String spendings = getInput("Enter the name of the spending file: ");
		map(spendings);
		

	}

}
