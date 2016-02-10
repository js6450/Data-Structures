public class Factorial {
	public static int factorial(int number){
		int factorial = 1;
		for(int i = number; i != 0; i--){
			factorial *= i;
		}
		return factorial;
	}
	public static void main(String[] args) {
		System.out.println(Factorial.factorial(5));
	}
}
