package kr.co.array;

public class ArrayTest01 {

	public static void main(String[] args) {
		int[] arr;
		//�迭 �����ϱ�
		arr = new int[10];
		//�� index�� �����Ͱ� �Է�
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = arr[0] + arr[1];
		
		System.out.println("arr[0]="+arr[0]);
		System.out.println("arr[1]="+arr[1]);
		System.out.println("arr[2]="+arr[2]);
		
		//�迭�� �ּ�
		System.out.println("�迭 num�� �ּ� : "+ arr);
		
		//�迭�� ���� 
		System.out.println("�迭 num�� ����: " + arr.length);//length()<-x
		
		

	}

}
