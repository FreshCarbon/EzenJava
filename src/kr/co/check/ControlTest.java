/*
 * ������ �帧 �ľ��ϱ�
 * ------------menu
 * 1. 1~10������ ��
 * 2. 3��
 * 3. �� ���� ū �� ���ϱ�
 * 4. ����
 * ----------------------
 * select number
 * ----------------------
 * 1,2,3 ���ý� ���� �� �ٽ� �޴�����
 * 4 = ���� Done!
 */

package kr.co.check;

import java.util.Scanner;

public class ControlTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = 0, sum = 0, select = 0, num1 = 0, num2 = 0;
		
		loop: while(true) {
			System.out.println("----------Menu----------");
			System.out.println("1. 1~10������ ��");
			System.out.println("2. 3��"); 
			System.out.println("3.�� ���� ū �� ���ϱ�"); 
			System.out.println("4. ����"); 
			System.out.println("------------------------");
			System.out.print("Select: ");
			select = scan.nextInt(); {
				if(select == 4) {
					System.out.println("Done!");
					break loop;
				}else if(!(select>=1 && select<=3)) {
					System.out.println("1~4 ������ ���� �Է��Ͻÿ�");
					continue;
				}
			}
			switch(select) {
			case 1: for(int i=1; i<=10; i++) {
				sum = sum + i;
			}
			System.out.println("�� ����"+sum+"�Դϴ�.");
			break;
			case 2: for(int j=1; j<=9; j++) {
				a = j * 3;
				System.out.println("3 * "+j+" ="+a);
			}
			break;
			case 3:
				System.out.println("ù ��° ���� �Է��մϴ�: ");
				num1 = scan.nextInt();
				System.out.println("�� ��° ���� �Է��մϴ�: ");
				num2 = scan.nextInt();
				if(num1>num2) {
					System.out.println("ū ����"+num1+"�Դϴ�");
					break;
				}else if(num1==num2) {
					System.out.println("���� �� �Դϴ�.");
				}else {
					System.out.println("ū ����"+num2+"�Դϴ�");
					break;
				}
			}
		}
		
		scan.close();

		
		
		

	}

}
