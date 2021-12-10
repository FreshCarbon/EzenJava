package kr.co.ch4;

public class Ex09 {
	public static void main(String[] args) {
		String str = "12345";
		int sum = 0;
		
		for(int i=0; i<str.length(); i++) {
			
			sum = sum + str.charAt(i) - '0';
			
			}
		System.out.println("sum="+sum);
		System.out.println('1'+'2'+'3'+'4'+'5');
	}

}
