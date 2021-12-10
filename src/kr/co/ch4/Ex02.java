package kr.co.ch4;

public class Ex02 {
	public static void main(String[] args) {
		int sum = 0;
		
		for(int i=1; i<=20; i++) {
			if(i%2==0) {
				continue;
			}else if(i%3==0) {
				continue;
			}
			sum = i + sum;
		}
		System.out.println(sum);
	}//73

}
