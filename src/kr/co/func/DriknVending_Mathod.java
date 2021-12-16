package kr.co.func;

import java.util.Scanner;

public class DriknVending_Mathod {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		String[] name = new String[3]; //음료 이름
		int money = 0, under = 0, change = 0, select = 0; //입금액, 100원미만, 선택부, 거스름
		boolean sell = true; //자판기 구동여부
		int[] price = new int[3]; //음료 가격
		int[] stock = new int[3]; //음료 재고
		int[] dispose = {10000, 5000, 1000, 500, 100}; // 반환 화폐(큰 순서대로)
		
		while(sell) {
			select = showMenu(money, under, select);
			
			if(!(select >=1 && select<=4 || select == 99 || select == 98)) {				
				wrongMs();
				continue;
				}					
				
			switch(select) {
			case 1://금액 투입
				money = inputMoney(money, scan);
				break;
				
			case 2://음료 구매
				buying(name, price, stock, select, money);
				break;
				
			case 3://재고 파악
				showStock(stock, name);
				break;
			
			case 4://거스름
				changeOut(change, money, dispose);
				break;
			case 98://관리자 모드
				admin(name, price, stock, select);
				break;
				
			case 99://시스템 종료
				System.out.println("자판기를 종료합니다.");
				sell = false;
			}
		
		}
	}
	
	public static void buying(String name[], int price[], int stock[], int select, int money ) {
		if(name[0] == null && name[1] == null && name[2] == null) {
			System.out.println("제품이 없습니다. 관리자 메뉴에서 제품을 입력하십시오");	
			return;								
		}
		
		for(int i=0; i<name.length; i++) {
			System.out.println((i+1)+"."+name[i]+"("+price[i]+"원)");
		}
		
		System.out.println("원하는 음료의 숫자를 입력하십시오");	
		System.out.print("->");
		select = Integer.parseInt(scan.next());
		
		if(select > name.length) {
			wrongMs();
			return;
		}else if(money < price[select-1]) {
			System.out.println("잔액이 부족합니다.");
			return;
		}		
		
		if(select <= name.length) {
			System.out.println(name[select-1]+"를 선택하셨습니다.");
			if(stock[select-1]==0) {
				System.out.println(name[select-1]+"가 없습니다.");
				return;
			}
			money -= price[select-1];
			stock[select-1] -= 1;
		}					
	}
	public static void changeOut(int change, int money, int dispose[]) {
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
	}
	public static void showStock(int stock[], String name[]) {
		System.out.println("음료개수");
		for(int i=0; i<name.length; i++) {
			System.out.println(name[i]+": "+stock[i]);
		}
	}
	public static int inputMoney(int money, Scanner scan) {
		int under;
		System.out.println("입금액을 입력하시오(100원 미만 자동 반환)");
		System.out.print("->");
		money += Integer.parseInt(scan.next());
		under = money % 100;
		money -= under;
		return money;
	}
	public static void wrongMs() {
		System.out.println("잘못된 입력입니다.");
	}
	public static int showMenu(int money, int under, int select) {
		System.out.println("==========메뉴==========");
		System.out.println("원하는 메뉴 번호를 입력하시오");
		System.out.println("1.금액입력 2.음료선택 3.음료개수 4.거스름반환 98.관리자 99.종료");
		System.out.println("현재 금액: "+money+"원");
		System.out.println("100원 미만 반환 금액: "+under+"원");
		System.out.println("=======================");
		System.out.print("->");
		int n = scan.nextInt();
		return n;
		//메뉴 종료 외에 메뉴로 돌아오게 설계하기		
	}
	public static void inputNum(int select) {
		select = scan.nextInt();
	}
	public static void admin(String name[], int price[], int stock[], int select) {
		System.out.println("관리자 모드입니다.");
		System.out.print("설정할 음료의 수를 입력하십시오(최대"+name.length+"): "); //배열의 최대값
		inputNum(select);
		if(select > name.length) {
			wrongMs();
			return;
		}
		for(int i=1; i<=select; i++) { 
			System.out.println(i+"번째 음료의 이름을 입력하세요");
			name[i-1] = scan.next();
			System.out.println(i+"번째 음료의 가격을 입력하세요");
			price[i-1] = scan.nextInt();
			System.out.println(i+"번째 음료의 수량을 입력하세요");
			stock[i-1] = scan.nextInt();
			System.out.println("설정이 끝났습니다. 메뉴로 돌아갑니다.");
		}//입력된 수 만큼 반복 설정
	}

}
