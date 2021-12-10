package kr.co.ch4;

public class Ex04 {
	public static void main(String[] args) {
        int sum = 0, num = 0;
		
		while(sum<100) {
			num++;
			if(num%2==0) {
				sum = sum - num;
			}else if(num%2!=0) {
				sum = sum + num;
			}
			System.out.println(sum);
			
			//199
		}

	}
}
