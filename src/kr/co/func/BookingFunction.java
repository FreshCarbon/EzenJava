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

public class BookingFunction {
	static Scanner scan = new Scanner(System.in); //list ���� �������� static���� �޸𸮿� �ø�
	static int revNum[] = new int[12]; //�����ȣ(math.random�̿��� ������ ��ȣ ����)
	
	public static void main(String[] args) {
		int room[] = new int[12]; // ���� ����
		int menu = 0; //ȣ�� ���� ��� ��ȣ
		boolean booking = true; //���� �ý��� on/off
		int select = 0, check = 0;
		for(int i=0; i<room.length; i++) {
			room[i] = 0;
		}
		//�ܼ� ���� �� room�� 0���� �ʱ�ȭ -> ���� �� ����
		
		while(booking) { //���� ���� ����
			
			menu = list(); //return n���� �޾� menu�� ���� -> switch 
			
			switch(menu) {
			case 1:// ���ȣ -> ���డ�ɿ��� -> �����ϱ�
				if(full(check, room)) {
					full(check, room);
					continue;
				}//���� ���� Ȯ��
				
				while(checkIn(room, select)) {
					checkIn(room, select);
				}
	
				break;
				
			case 2: 
				if(empty(check, room)) {
					empty(check, room);
					continue;
				}//���� ���� Ȯ��
				
				while(checkOut(room, select)) {
					checkOut(room, select);
				}
				
				break;
				
			case 3:
				viewRoom(room); //���� Ȯ��
				break;
				
			case 99:
				System.out.println("���� ���� ���α׷��� �����մϴ�.");
				booking = false;
				break;
				
			default:
				errMs();
				break;
			}
			
		}
	
	}
	private static boolean full(int check, int[] room) {
		check = 0;
		for(int i=0; i<room.length; i++) {
			check +=room[i];
		}
		if(check == room.length) {
			System.out.println("���� ������ ������ �����ϴ�.");
			System.out.println("�������� ���ư��ϴ�.");
			return true;
		}
		return false;			
		//��ü ������ �� á���� Ȯ��
	}
	private static boolean empty(int check, int[] room) {
		check = 0;
		for(int i=0; i<room.length; i++) {
			check +=room[i];
		}
		if(check == 0) {
			System.out.println("��� �� ������ �����ϴ�.");
			System.out.println("�������� ���ư��ϴ�.");
			return true;
		}
		return false;			
		//��ü ������  �� ������� Ȯ��
	}

	private static void viewRoom(int[] room) {
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

	private static boolean checkOut(int[] room, int select) {
		System.out.print("���� ��� ���� ������: ");
		for(int i=0; i<room.length; i++) {
			if(room[i] == 1) {
				System.out.print((i+1)+"�� ");
			}
		}
		System.out.println("�����Դϴ�.");
		System.out.print("���� ��� �� ������ �Է��ϼ���: "); 
		select = scan.nextInt();
		if(room[select-1] == 1) {
			System.out.println(select+"�� ���� ������ ����մϴ�");
			System.out.println("������ ���� ��ȣ�� �Է��ϼ���");
			int num = scan.nextInt();
			if(!(revNum[select-1] == num)) {
				errMs();
				return true;
			}else {
				room[select-1] = 0;
				System.out.println(select+"�� ���� ������ ��ҵǾ����ϴ�.");
			}
		}else if(room[select-1] == 0){
			System.out.println("�����Դϴ�.");
			return true;
		}else {
			errMs();
			return true;
		}
		return false;
	}

	private static boolean checkIn(int[] room, int select) {
		
		System.out.print("���� ������ ������: ");
		for(int i=0; i<room.length; i++) {
			if(room[i] == 0) {
				System.out.print((i+1)+"�� ");
			}
		}
		System.out.println("�����Դϴ�.");
		System.out.print("�����Ͻ� �� ��ȣ�� �Է��ϼ��� :");
		select = scan.nextInt();
		if(room[select-1] == 0) {
			System.out.println(select+"�� ������ �����մϴ�.");
			room[select-1] = 1;
		}else if(room[select-1] == 1){
			System.out.println("�̹� ����� �����Դϴ�.");
			return true;
		}else {
			errMs();
			return true;
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
