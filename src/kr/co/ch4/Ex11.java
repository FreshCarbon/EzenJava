package kr.co.ch4;

public class Ex11 {
	public static void main(String[] args) {
		
		int num1 = 1, num2 = 1, num3 = 0;
		System.out.print(num1+","+num2);
		
		for(int i=0; i<8; i++) {
			num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
			System.out.print(","+num3);
		}//���� num1,2�� �� �ڸ� �� �����Ƿ� 10������ ���Ϸ��� 8�� �� �ݺ����ָ� �ȴ�
		
		
		
		
		
		
		
		
	}

}
