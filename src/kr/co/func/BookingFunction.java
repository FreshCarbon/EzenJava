/* int[] room;
 * String[] revNum; // 예약번호
 * String[] name //예약자명
 * 
 * 해당방의 예약 가능여부:
 * boolean serchRoom(int num, int[]room);
 * 예약하기 : 방번호, 룸, 예약자명, 예약번호
 * void checkIn(int num, int[] room, String[] revNum);
 */

package kr.co.func;

import java.util.Scanner;

public class BookingFunction {
	static Scanner scan = new Scanner(System.in); //list 에서 쓰기위해 static으로 메모리에 올림
	static int revNum[] = new int[12]; //예약번호(math.random이용해 무작위 번호 생성)
	
	public static void main(String[] args) {
		int room[] = new int[12]; // 객실 개수
		int menu = 0; //호텔 예약 기능 번호
		boolean booking = true; //예약 시스템 on/off
		int select = 0, check = 0;
		for(int i=0; i<room.length; i++) {
			room[i] = 0;
		}
		//콘솔 실행 시 room을 0으로 초기화 -> 전부 빈 객실
		
		while(booking) { //객실 예약 실행
			
			menu = list(); //return n값을 받아 menu에 대입 -> switch 
			
			switch(menu) {
			case 1:// 방번호 -> 예약가능여부 -> 예약하기
				if(full(check, room)) {
					full(check, room);
					continue;
				}//만실 여부 확인
				
				while(checkIn(room, select)) {
					checkIn(room, select);
				}
	
				break;
				
			case 2: 
				if(empty(check, room)) {
					empty(check, room);
					continue;
				}//공실 여부 확인
				
				while(checkOut(room, select)) {
					checkOut(room, select);
				}
				
				break;
				
			case 3:
				viewRoom(room); //객실 확인
				break;
				
			case 99:
				System.out.println("객실 예약 프로그램을 종료합니다.");
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
			System.out.println("예약 가능한 객실이 없습니다.");
			System.out.println("메인으로 돌아갑니다.");
			return true;
		}
		return false;			
		//전체 객실이 꽉 찼는지 확인
	}
	private static boolean empty(int check, int[] room) {
		check = 0;
		for(int i=0; i<room.length; i++) {
			check +=room[i];
		}
		if(check == 0) {
			System.out.println("취소 할 객실이 없습니다.");
			System.out.println("메인으로 돌아갑니다.");
			return true;
		}
		return false;			
		//전체 객실이  다 비었는지 확인
	}

	private static void viewRoom(int[] room) {
		System.out.println("객실 현황을 표시합니다.");
		for(int i=0; i<room.length; i++) {
			System.out.print((i+1)+"번 객실 ");
			if(room[i] == 0) {
				System.out.println("☆예약 가능합니다.");
			}else {
				System.out.println("★예약 되었습니다.");
			}
		}
		
	}

	private static boolean checkOut(int[] room, int select) {
		System.out.print("예약 취소 가능 객실은: ");
		for(int i=0; i<room.length; i++) {
			if(room[i] == 1) {
				System.out.print((i+1)+"번 ");
			}
		}
		System.out.println("객실입니다.");
		System.out.print("예약 취소 할 객실을 입력하세요: "); 
		select = scan.nextInt();
		if(room[select-1] == 1) {
			System.out.println(select+"번 객실 예약을 취소합니다");
			System.out.println("객실의 예약 번호를 입력하세요");
			int num = scan.nextInt();
			if(!(revNum[select-1] == num)) {
				errMs();
				return true;
			}else {
				room[select-1] = 0;
				System.out.println(select+"번 객실 예약이 취소되었습니다.");
			}
		}else if(room[select-1] == 0){
			System.out.println("공실입니다.");
			return true;
		}else {
			errMs();
			return true;
		}
		return false;
	}

	private static boolean checkIn(int[] room, int select) {
		
		System.out.print("예약 가능한 객실은: ");
		for(int i=0; i<room.length; i++) {
			if(room[i] == 0) {
				System.out.print((i+1)+"번 ");
			}
		}
		System.out.println("객실입니다.");
		System.out.print("예약하실 방 번호를 입력하세요 :");
		select = scan.nextInt();
		if(room[select-1] == 0) {
			System.out.println(select+"번 객실을 예약합니다.");
			room[select-1] = 1;
		}else if(room[select-1] == 1){
			System.out.println("이미 예약된 객실입니다.");
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
		System.out.println("당신의 예약 번호는("+revNum[select-1]+")입니다.");
		return false;
		
	}

	private static int list() {
		System.out.println("========================================");
		System.out.println("객실 예약을 실행합니다.");
		System.out.print("1.객실 번호 선택 2.예약 취소 3.객실 확인 99.종료 : ");
		int n = scan.nextInt();
		System.out.println("========================================");
		return n;
	}
	private static void errMs() {
		System.out.println("잘못된 입력입니다.");
	}
}
