import java.io.*;

public class Calculator {
	private static String getInput(String prompt){
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(prompt);
		System.out.flush();
		try{
			return input.readLine();
		}
		catch(Exception e){
			return "Error: " + e.getMessage();
		}
	}
	public static void main(String[] args){
		String calc = getInput("Enter the desired calculation: ");
		Convert.convert(calc);
		//System.out.println(PostCalc.evaluate(output));
	}
}	
