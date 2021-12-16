package kr.co.func;

import java.util.Scanner;

public class DriknVending_Mathod {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		String[] name = new String[3]; //���� �̸�
		int money = 0, under = 0, change = 0, select = 0; //�Աݾ�, 100���̸�, ���ú�, �Ž���
		boolean sell = true; //���Ǳ� ��������
		int[] price = new int[3]; //���� ����
		int[] stock = new int[3]; //���� ���
		int[] dispose = {10000, 5000, 1000, 500, 100}; // ��ȯ ȭ��(ū �������)
		
		while(sell) {
			select = showMenu(money, under, select);
			
			if(!(select >=1 && select<=4 || select == 99 || select == 98)) {				
				wrongMs();
				continue;
				}					
				
			switch(select) {
			case 1://�ݾ� ����
				money = inputMoney(money, scan);
				break;
				
			case 2://���� ����
				buying(name, price, stock, select, money);
				break;
				
			case 3://��� �ľ�
				showStock(stock, name);
				break;
			
			case 4://�Ž���
				changeOut(change, money, dispose);
				break;
			case 98://������ ���
				admin(name, price, stock, select);
				break;
				
			case 99://�ý��� ����
				System.out.println("���Ǳ⸦ �����մϴ�.");
				sell = false;
			}
		
		}
	}
	
	public static void buying(String name[], int price[], int stock[], int select, int money ) {
		if(name[0] == null && name[1] == null && name[2] == null) {
			System.out.println("��ǰ�� �����ϴ�. ������ �޴����� ��ǰ�� �Է��Ͻʽÿ�");	
			return;								
		}
		
		for(int i=0; i<name.length; i++) {
			System.out.println((i+1)+"."+name[i]+"("+price[i]+"��)");
		}
		
		System.out.println("���ϴ� ������ ���ڸ� �Է��Ͻʽÿ�");	
		System.out.print("->");
		select = Integer.parseInt(scan.next());
		
		if(select > name.length) {
			wrongMs();
			return;
		}else if(money < price[select-1]) {
			System.out.println("�ܾ��� �����մϴ�.");
			return;
		}		
		
		if(select <= name.length) {
			System.out.println(name[select-1]+"�� �����ϼ̽��ϴ�.");
			if(stock[select-1]==0) {
				System.out.println(name[select-1]+"�� �����ϴ�.");
				return;
			}
			money -= price[select-1];
			stock[select-1] -= 1;
		}					
	}
	public static void changeOut(int change, int money, int dispose[]) {
		System.out.println("�Ž������� ��ȯ�˴ϴ�.");
		change += money;
		money = 0;
		System.out.println(change+"����");
		for(int oturi : dispose) {
			System.out.print(oturi+"����"+(change / oturi)+"��/�� ");
			if(change > oturi) {
				change -= oturi;
			}
		}
		System.out.println("��ȯ�˴ϴ�.");
		change = 0;
	}
	public static void showStock(int stock[], String name[]) {
		System.out.println("���ᰳ��");
		for(int i=0; i<name.length; i++) {
			System.out.println(name[i]+": "+stock[i]);
		}
	}
	public static int inputMoney(int money, Scanner scan) {
		int under;
		System.out.println("�Աݾ��� �Է��Ͻÿ�(100�� �̸� �ڵ� ��ȯ)");
		System.out.print("->");
		money += Integer.parseInt(scan.next());
		under = money % 100;
		money -= under;
		return money;
	}
	public static void wrongMs() {
		System.out.println("�߸��� �Է��Դϴ�.");
	}
	public static int showMenu(int money, int under, int select) {
		System.out.println("==========�޴�==========");
		System.out.println("���ϴ� �޴� ��ȣ�� �Է��Ͻÿ�");
		System.out.println("1.�ݾ��Է� 2.���ἱ�� 3.���ᰳ�� 4.�Ž�����ȯ 98.������ 99.����");
		System.out.println("���� �ݾ�: "+money+"��");
		System.out.println("100�� �̸� ��ȯ �ݾ�: "+under+"��");
		System.out.println("=======================");
		System.out.print("->");
		int n = scan.nextInt();
		return n;
		//�޴� ���� �ܿ� �޴��� ���ƿ��� �����ϱ�		
	}
	public static void inputNum(int select) {
		select = scan.nextInt();
	}
	public static void admin(String name[], int price[], int stock[], int select) {
		System.out.println("������ ����Դϴ�.");
		System.out.print("������ ������ ���� �Է��Ͻʽÿ�(�ִ�"+name.length+"): "); //�迭�� �ִ밪
		inputNum(select);
		if(select > name.length) {
			wrongMs();
			return;
		}
		for(int i=1; i<=select; i++) { 
			System.out.println(i+"��° ������ �̸��� �Է��ϼ���");
			name[i-1] = scan.next();
			System.out.println(i+"��° ������ ������ �Է��ϼ���");
			price[i-1] = scan.nextInt();
			System.out.println(i+"��° ������ ������ �Է��ϼ���");
			stock[i-1] = scan.nextInt();
			System.out.println("������ �������ϴ�. �޴��� ���ư��ϴ�.");
		}//�Էµ� �� ��ŭ �ݺ� ����
	}

}
