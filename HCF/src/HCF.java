public class HCF {
	public static int Hcf(int[] num){
		for(int i = 0; i < (num.length - 1);i++){
			int num1 = num[i];
			int num2 = num[i + 1];
			int hcf = 1;
			while(num2 != 0){
				hcf = num1 % num2;
				num1 = num2;
				num2 = hcf;
			}
		}
		return num[num.length - 1];
		int i = num.length;
	}
			
			
			
	
	public static void main(String[] args) {
		int[] num = {48,18,3};
		System.out.println(HCF.Hcf(num));
	}

}
