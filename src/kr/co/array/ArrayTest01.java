package kr.co.array;

public class ArrayTest01 {

	public static void main(String[] args) {
		int[] arr;
		//배열 선언하기
		arr = new int[10];
		//각 index에 데이터값 입력
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = arr[0] + arr[1];
		
		System.out.println("arr[0]="+arr[0]);
		System.out.println("arr[1]="+arr[1]);
		System.out.println("arr[2]="+arr[2]);
		
		//배열의 주소
		System.out.println("배열 num의 주소 : "+ arr);
		
		//배열의 길이 
		System.out.println("배열 num의 길이: " + arr.length);//length()<-x
		
		

	}

}
