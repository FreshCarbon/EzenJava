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

public class BookingFunction2 {
	static Scanner scan = new Scanner(System.in); //list 에서 쓰기위해 static으로 메모리에 올림
	static int revNum[] = new int[12]; //예약번호(math.random이용해 무작위 번호 생성)
	
	public static void main(String[] args) {
		int room[] = new int[12]; // 객실 개수
		int menu = 0; //호텔 예약 기능 번호
		boolean booking = true; //예약 시스템 on/off
		int select = 0, num = 0;
		
		for(int i=0; i<room.length; i++) {
			room[i] = 0;
		}
		//콘솔 실행 시 room을 0으로 초기화 -> 전부 빈 객실
		
		while(booking) { //객실 예약 실행
			
			menu = list(); //return n값을 받아 menu에 대입 -> switch 
			
			switch(menu) {
			case 1:
				do {
					checkRoom1(room);//만실, 호텔 공실 판단
					showRoom(room); //객실현황 출력
					System.out.print("예약하실 방 번호를 입력하세요 :");
					select = scan.nextInt();
					checkRoom2(room, select);//선택 객실 상태
					
				}while(checkRoom1(room)&&checkRoom2(room,select)&&rev(room, select));

				rev(room, select);// 예약 진행
				
				break;
				
			case 2: 
				do {
					checkRoom1(room);//만실, 호텔 공실 판단
					showRoom(room); //객실현황 출력
					System.out.print("예약 취소 할 객실을 입력하세요: "); 
					select = scan.nextInt();
					checkRoom2(room, select);//선택 객실 상태 					
					revCancel(room, select, num);// 예약 취소
				}while(!(checkRoom1(room)&&checkRoom2(room, select)&&revCancel(room, select,num)));
					
				
				break;
				
			case 3:
				showRoom(room); //객실현황 출력
				checkRoom1(room);
				break;
				
			case 99: //while문 false
				System.out.println("객실 예약 프로그램을 종료합니다.");
				booking = false;
				break;
				
			default: //메뉴의 값 벗어난 경우 에러 도출
				errMs();
				break;
			}
			
		}
	}
	private static boolean checkRoom2(int[] room, int select) {
		if(room[select-1] == 0) {
			System.out.println("예약 가능한 객실입니다.");
			return false;
		}
		System.out.println("예약된 객실입니다.");
		return true;
	}
	
	private static boolean checkRoom1(int[] room) {
		int n = 0;
		for(int i=0; i<room.length; i++) {
			n += room[i];
		}
		if(n == 0) {
			System.out.println("호텔이 공실입니다.");
			return true;
		}else if(n == room.length) {
			System.out.println("호텔이 만실입니다.");
			return false;
		}
		return true;
	}
	private static void showRoom(int[] room) {
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
	private static boolean revCancel(int[] room, int select, int num) {
		System.out.println("객실의 예약 번호를 입력하세요");
		num = scan.nextInt();
		if(num == revNum[select-1]) {
			System.out.println("예약번호 확인 되었습니다");
		}else {
			System.out.println("예약번호를 다시 확인해주세요");
			return true;
		}
		if(room[select-1] == 1) {
			System.out.println(select+"번 객실 예약을 취소합니다");
			room[select-1] = 0;
			System.out.println(select+"번 객실 예약이 취소되었습니다.");
			}
		return true;
		}
	private static boolean rev(int[] room, int select) {
		
		if(room[select-1] == 0) {
			System.out.println(select+"번 객실을 예약합니다.");
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
