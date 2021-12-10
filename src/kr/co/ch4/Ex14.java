package kr.co.ch4;

import java.util.Scanner;

public class Ex14 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int answer = (int)(Math.random()*100)+1;
		int input = 0, count = 0;
		
		do {
			count++;
			System.out.print("1과 100사이의 값을 입력하세요: ");
			input = scan.nextInt();
			if(answer>input) {
				System.out.println("더 큰 수를 입력하세요");
			}else if(answer<input) {
				System.out.println("더 작은 수를 입력하세요");
			}else {
				System.out.println("정답입니다.");
				System.out.println("시도횟수는"+count+"번 입니다.");
				break;
			}
		}
		while(true);
	}

}
