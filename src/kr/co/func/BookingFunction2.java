/* int[] room;
 * String[] revNum; // �����ȣ
 * String[] name //�����ڸ�
 * 
 * �ش���� ���� ���ɿ���:
 * boolean serchRoom(int num, int[]room);
 * �����ϱ� : ���ȣ, ��, �����ڸ�, �����ȣ
 * void checkIn(int num, int[] room, String[] revNum);
 */

package kr.co.func;

import java.util.Scanner;

public class BookingFunction2 {
	static Scanner scan = new Scanner(System.in); //list ���� �������� static���� �޸𸮿� �ø�
	static int revNum[] = new int[12]; //�����ȣ(math.random�̿��� ������ ��ȣ ����)
	
	public static void main(String[] args) {
		int room[] = new int[12]; // ���� ����
		int menu = 0; //ȣ�� ���� ��� ��ȣ
		boolean booking = true; //���� �ý��� on/off
		int select = 0, num = 0;
		
		for(int i=0; i<room.length; i++) {
			room[i] = 0;
		}
		//�ܼ� ���� �� room�� 0���� �ʱ�ȭ -> ���� �� ����
		
		while(booking) { //���� ���� ����
			
			menu = list(); //return n���� �޾� menu�� ���� -> switch 
			
			switch(menu) {
			case 1:
				do {
					checkRoom1(room);//����, ȣ�� ���� �Ǵ�
					showRoom(room); //������Ȳ ���
					System.out.print("�����Ͻ� �� ��ȣ�� �Է��ϼ��� :");
					select = scan.nextInt();
					checkRoom2(room, select);//���� ���� ����
					
				}while(checkRoom1(room)&&checkRoom2(room,select)&&rev(room, select));

				rev(room, select);// ���� ����
				
				break;
				
			case 2: 
				do {
					checkRoom1(room);//����, ȣ�� ���� �Ǵ�
					showRoom(room); //������Ȳ ���
					System.out.print("���� ��� �� ������ �Է��ϼ���: "); 
					select = scan.nextInt();
					checkRoom2(room, select);//���� ���� ���� 					
					revCancel(room, select, num);// ���� ���
				}while(!(checkRoom1(room)&&checkRoom2(room, select)&&revCancel(room, select,num)));
					
				
				break;
				
			case 3:
				showRoom(room); //������Ȳ ���
				checkRoom1(room);
				break;
				
			case 99: //while�� false
				System.out.println("���� ���� ���α׷��� �����մϴ�.");
				booking = false;
				break;
				
			default: //�޴��� �� ��� ��� ���� ����
				errMs();
				break;
			}
			
		}
	}
	private static boolean checkRoom2(int[] room, int select) {
		if(room[select-1] == 0) {
			System.out.println("���� ������ �����Դϴ�.");
			return false;
		}
		System.out.println("����� �����Դϴ�.");
		return true;
	}
	
	private static boolean checkRoom1(int[] room) {
		int n = 0;
		for(int i=0; i<room.length; i++) {
			n += room[i];
		}
		if(n == 0) {
			System.out.println("ȣ���� �����Դϴ�.");
			return true;
		}else if(n == room.length) {
			System.out.println("ȣ���� �����Դϴ�.");
			return false;
		}
		return true;
	}
	private static void showRoom(int[] room) {
		System.out.println("���� ��Ȳ�� ǥ���մϴ�.");
		for(int i=0; i<room.length; i++) {
			System.out.print((i+1)+"�� ���� ");
			if(room[i] == 0) {
				System.out.println("�ٿ��� �����մϴ�.");
			}else {
				System.out.println("�ڿ��� �Ǿ����ϴ�.");
			}
		}
		
	}
	private static boolean revCancel(int[] room, int select, int num) {
		System.out.println("������ ���� ��ȣ�� �Է��ϼ���");
		num = scan.nextInt();
		if(num == revNum[select-1]) {
			System.out.println("�����ȣ Ȯ�� �Ǿ����ϴ�");
		}else {
			System.out.println("�����ȣ�� �ٽ� Ȯ�����ּ���");
			return true;
		}
		if(room[select-1] == 1) {
			System.out.println(select+"�� ���� ������ ����մϴ�");
			room[select-1] = 0;
			System.out.println(select+"�� ���� ������ ��ҵǾ����ϴ�.");
			}
		return true;
		}
	private static boolean rev(int[] room, int select) {
		
		if(room[select-1] == 0) {
			System.out.println(select+"�� ������ �����մϴ�.");
			room[select-1] = 1;
		}
		for(int i=0; i<room.length; i++) {
			revNum[i] = (int)(Math.random()*100)+1;
			for(int j=0; j<i; j++) {
				if(revNum[i] == revNum[j]) {	
					i--;
				}
			}
		}
		System.out.println("����� ���� ��ȣ��("+revNum[select-1]+")�Դϴ�.");
		return false;
	}
	private static int list() {
		System.out.println("========================================");
		System.out.println("���� ������ �����մϴ�.");
		System.out.print("1.���� ��ȣ ���� 2.���� ��� 3.���� Ȯ�� 99.���� : ");
		int n = scan.nextInt();
		System.out.println("========================================");
		return n;
	}
	private static void errMs() {
		System.out.println("�߸��� �Է��Դϴ�.");
	}
}
