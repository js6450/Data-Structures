
public class PositiveExponential {
	public static int calEx(int a, int b, int sum){
		if(b == 0){
			return sum;
		}
		else{
			return calEx(a, (b - 1), (sum * a));
		}
	}
	public static int posEx(int base, int exp){
		if(exp == 0){
			return 1;
		}
		return calEx(base, exp, 1);
		}
	public static void main(String[] args) {
		System.out.println(PositiveExponential.posEx(2, 2));
	}

}
