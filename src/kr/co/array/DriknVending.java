package kr.co.array;

import java.util.Scanner;

public class DriknVending {
	public static void main(String[] args) {
		
		String[] name = new String[3]; // 음료 이름
		int[] price = new int[3]; //음료 가격
		int[] stock = new int[3]; //재고
		int money = 0; //입금액
		int under = 0; //100원 미만 금액 저장
		int change = 0;//거스름
		int[] dispose = {10000, 5000, 1000, 500, 100};
		int select = 0; //자판기 선택
		boolean sell = true; //자판기 구동여부
		Scanner scan = new Scanner(System.in);
		
		while(sell) {
			System.out.println("==========메뉴==========");
			System.out.println("원하는 메뉴 번호를 입력하시오");
			System.out.println("1.금액입력 2.음료선택 3.음료개수 4.거스름반환 98.관리자 99.종료");
			System.out.println("현재 금액: "+money+"원");
			System.out.println("100원 미만 반환 금액: "+under+"원");
			System.out.println("=======================");
			System.out.print("->");
			select = Integer.parseInt(scan.next()); 
			//메뉴 종료 외에 메뉴로 돌아오게 설계하기
			
			if(!(select>=1 && select<=4 || select == 99 || select == 98)) {
				System.out.println("잘못된 선택입니다.");
				continue;
			}
			switch(select) {
			case 1:
				System.out.println("입금액을 입력하시오(100원 미만 자동 반환)");
				System.out.print("->");
				money += Integer.parseInt(scan.next());
				under = money % 100;
				money -= under;
				break;
				
			case 2:
				if(name[0] == null && name[1] == null && name[2] == null) {
					System.out.println("제품이 없습니다. 관리자 메뉴에서 제품을 입력하십시오");	
					break;								
				}
				
				for(int i=0; i<name.length; i++) {
					System.out.println((i+1)+"."+name[i]+"("+price[i]+"원)");
				}
				
				System.out.println("원하는 음료의 숫자를 입력하십시오");	
				System.out.print("->");
				select = Integer.parseInt(scan.next());
				
				if(select > name.length) {
					System.out.println("잘못된 입력입니다.");
					break;
				}else if(money < price[select-1]) {
					System.out.println("잔액이 부족합니다.");
					break;
				}		
				
				if(select <= name.length) {
					System.out.println(name[select-1]+"를 선택하셨습니다.");
					if(stock[select-1]==0) {
						System.out.println(name[select-1]+"가 없습니다.");
						break;
					}
					money -= price[select-1];
					stock[select-1] -= 1;
				}
				break;
				
			case 3:
				System.out.println("음료개수");
				for(int i=0; i<name.length; i++) {
					System.out.println(name[i]+": "+stock[i]);
				}
				break;
			
			case 4:
				System.out.println("거스름돈이 반환됩니다.");
				change += money;
				money = 0;
				System.out.println(change+"원이");
				for(int oturi : dispose) {
					System.out.print(oturi+"원이"+(change / oturi)+"개/장 ");
					if(change > oturi) {
						change -= oturi;
					}
				}
				System.out.println("반환됩니다.");
				change = 0;
				break;
			case 98:
				System.out.println("관리자 모드입니다.");
				System.out.print("설정할 음료의 수를 입력하십시오(최대"+name.length+"): "); //배열의 최대값
				select = scan.nextInt();
				if(select > name.length) {
					System.out.println("잘못된 입력입니다.");
					break;
				}
				for(int i=1; i<=select; i++) { 
					System.out.println(i+"번째 음료의 이름을 입력하세요");
					name[i-1] = scan.next();
					System.out.println(i+"번째 음료의 가격을 입력하세요");
					price[i-1] = scan.nextInt();
					System.out.println(i+"번째 음료의 수량을 입력하세요");
					stock[i-1] = scan.nextInt();
				}//입력된 수 만큼 반복 설정
				System.out.println("설정이 끝났습니다. 메뉴로 돌아갑니다.");
				break;
				
			case 99:
				System.out.println("자판기를 종료합니다.");
				sell = false;
			}
				
		}
		scan.close();
	}

}
