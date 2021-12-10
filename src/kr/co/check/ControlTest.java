/*
 * 제어의 흐름 파악하기
 * ------------menu
 * 1. 1~10까지의 합
 * 2. 3단
 * 3. 두 수의 큰 값 구하기
 * 4. 종료
 * ----------------------
 * select number
 * ----------------------
 * 1,2,3 선택시 실행 후 다시 메뉴보기
 * 4 = 종료 Done!
 */

package kr.co.check;

import java.util.Scanner;

public class ControlTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = 0, sum = 0, select = 0, num1 = 0, num2 = 0;
		
		loop: while(true) {
			System.out.println("----------Menu----------");
			System.out.println("1. 1~10까지의 합");
			System.out.println("2. 3단"); 
			System.out.println("3.두 수의 큰 값 구하기"); 
			System.out.println("4. 종료"); 
			System.out.println("------------------------");
			System.out.print("Select: ");
			select = scan.nextInt(); {
				if(select == 4) {
					System.out.println("Done!");
					break loop;
				}else if(!(select>=1 && select<=3)) {
					System.out.println("1~4 사이의 수를 입력하시오");
					continue;
				}
			}
			switch(select) {
			case 1: for(int i=1; i<=10; i++) {
				sum = sum + i;
			}
			System.out.println("총 합은"+sum+"입니다.");
			break;
			case 2: for(int j=1; j<=9; j++) {
				a = j * 3;
				System.out.println("3 * "+j+" ="+a);
			}
			break;
			case 3:
				System.out.println("첫 번째 수를 입력합니다: ");
				num1 = scan.nextInt();
				System.out.println("두 번째 수를 입력합니다: ");
				num2 = scan.nextInt();
				if(num1>num2) {
					System.out.println("큰 수는"+num1+"입니다");
					break;
				}else if(num1==num2) {
					System.out.println("같은 수 입니다.");
				}else {
					System.out.println("큰 수는"+num2+"입니다");
					break;
				}
			}
		}
		
		scan.close();

		
		
		

	}

}
