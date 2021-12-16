//입력받은 두 수의 합을 구하시오.
//1. 두 수의 합을 구하는 기능 -> int sum(n1, n2);

package kr.co.func;

public class FunctionTest01 {
	private static int sum(int n1, int n2) {
		int sum = 0;
		sum = n1 + n2;
		return sum; //return 은 메인에서 사용하겠다는 뜻
	}
	
	
	public static void main(String[] args) {
		int n1 = 10, n2 = 20; //선언
		int result = 0;
		
		result = sum(n1, n2);//함수 4번타입, int sum을 호출하여 =을 통해 return 받음
		System.out.println("두 수읜 합은: "+ result);
				
	}

}
