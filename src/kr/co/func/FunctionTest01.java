//�Է¹��� �� ���� ���� ���Ͻÿ�.
//1. �� ���� ���� ���ϴ� ��� -> int sum(n1, n2);

package kr.co.func;

public class FunctionTest01 {
	private static int sum(int n1, int n2) {
		int sum = 0;
		sum = n1 + n2;
		return sum; //return �� ���ο��� ����ϰڴٴ� ��
	}
	
	
	public static void main(String[] args) {
		int n1 = 10, n2 = 20; //����
		int result = 0;
		
		result = sum(n1, n2);//�Լ� 4��Ÿ��, int sum�� ȣ���Ͽ� =�� ���� return ����
		System.out.println("�� ���� ����: "+ result);
				
	}

}
