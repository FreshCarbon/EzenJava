package kr.co.array;

public class ArrayTest04 {
	public static void main(String[] args) {
		//�ζ� ��ȣ �����غ���
		int[] num = new int[5];
		
		for(int i=0; i<num.length; i++) {// ��ȣ ����
 			num[i] = (int)(Math.random()*45)+1;
			for(int j=0; j<i; j++) { //�ߺ��� ����
				if(num[i] == num[j]) {
					i--;
					break;
				}
			}
		}//��ȣ ���
		for(int i=0; i<num.length; i++) {
			System.out.println("�ζǹ�ȣ["+(i+1)+"]= "+num[i]);
			
		}
	}

}
