package kr.co.ch4;

import java.util.Scanner;

public class Ex14 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int answer = (int)(Math.random()*100)+1;
		int input = 0, count = 0;
		
		do {
			count++;
			System.out.print("1�� 100������ ���� �Է��ϼ���: ");
			input = scan.nextInt();
			if(answer>input) {
				System.out.println("�� ū ���� �Է��ϼ���");
			}else if(answer<input) {
				System.out.println("�� ���� ���� �Է��ϼ���");
			}else {
				System.out.println("�����Դϴ�.");
				System.out.println("�õ�Ƚ����"+count+"�� �Դϴ�.");
				break;
			}
		}
		while(true);
	}

}
