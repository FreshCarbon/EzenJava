package kr.co.array;

import java.util.Scanner;

public class ArrayTest03 {
	public static void main(String[] args) {
		//Ŭ������ ��ü�� = new ������();
		Scanner scan = new Scanner(System.in);
		
		//Ű����� 10���� ������ �Է¹ޱ� 
		int[] score = new int[10];
		int sum = 0;
		float average = 0.0f; 	
		
		for(int i=0; i<score.length; i++) {
			System.out.print((i+1)+"��° ������ �Է��Ͻÿ�:");
			score[i] = scan.nextInt();
		}

		//�л��� �� �� �� ��� ���ϱ�
		for(int j=0; j<score.length; j++) {
			score[j] = scan.nextInt();
			sum += score[j];
		}
		average = (float)sum / score.length;		
		
		
		//�л��� ���� �� ������
		System.out.println("����: "+sum);
		System.out.println("��հ�: "+average);
		
		
		
		
		
		
		//Ű����� 10���� �л��̸��� �Է¹ޱ�
		
		String[] name = new String[10];
		
		for(int j=0; j<name.length; j++) {
			name[j] = scan.next();
			
		}
		
	}

}
