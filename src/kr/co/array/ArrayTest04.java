package kr.co.array;

public class ArrayTest04 {
	public static void main(String[] args) {
		//로또 번호 생성해보기
		int[] num = new int[5];
		
		for(int i=0; i<num.length; i++) {// 번호 생성
 			num[i] = (int)(Math.random()*45)+1;
			for(int j=0; j<i; j++) { //중복값 제거
				if(num[i] == num[j]) {
					i--;
					break;
				}
			}
		}//번호 출력
		for(int i=0; i<num.length; i++) {
			System.out.println("로또번호["+(i+1)+"]= "+num[i]);
			
		}
	}

}
