package kr.co.array;

import java.util.Scanner;

public class ArrayTest03 {
	public static void main(String[] args) {
		//클래스명 객체명 = new 생성자();
		Scanner scan = new Scanner(System.in);
		
		//키보드로 10명의 성적을 입력받기 
		int[] score = new int[10];
		int sum = 0;
		float average = 0.0f; 	
		
		for(int i=0; i<score.length; i++) {
			System.out.print((i+1)+"번째 성적을 입력하시오:");
			score[i] = scan.nextInt();
		}

		//학생의 총 합 및 평균 구하기
		for(int j=0; j<score.length; j++) {
			score[j] = scan.nextInt();
			sum += score[j];
		}
		average = (float)sum / score.length;		
		
		
		//학생의 총합 및 평균출력
		System.out.println("총합: "+sum);
		System.out.println("평균값: "+average);
		
		
		
		
		
		
		//키보드로 10명의 학생이름을 입력받기
		
		String[] name = new String[10];
		
		for(int j=0; j<name.length; j++) {
			name[j] = scan.next();
			
		}
		
	}

}
