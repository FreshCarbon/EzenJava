package kr.co.array;

import java.util.Scanner;

public class ArrayTest02 {
	public static void main(String[] args) {
		//����� 10���� ������ ����غ���
		int[] num = {23,24,65,84,654,16,98,32,89,10};
		
		System.out.println("num[0]"+num[0]);
		System.out.println("num[1]"+num[1]);
		System.out.println("num[2]"+num[2]);
		System.out.println("num[3]"+num[3]);
		System.out.println("num[4]"+num[4]);
		System.out.println("num[5]"+num[5]);
		System.out.println("num[6]"+num[6]);
		System.out.println("num[7]"+num[7]);
		System.out.println("num[8]"+num[8]);
		System.out.println("num[9]"+num[9]);
		System.out.println("===================");
		
		//for�� ����غ���
		for(int i=0; i<num.length; i++) {
			System.out.println("num["+i+"]"+num[i]);			
		}
		
		
		
		
	}

}
