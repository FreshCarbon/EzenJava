package kr.co.array;

import java.util.Scanner;

public class DriknVending {
	public static void main(String[] args) {
		
		String[] name = new String[3]; // ���� �̸�
		int[] price = new int[3]; //���� ����
		int[] stock = new int[3]; //���
		int money = 0; //�Աݾ�
		int under = 0; //100�� �̸� �ݾ� ����
		int change = 0;//�Ž���
		int[] dispose = {10000, 5000, 1000, 500, 100};
		int select = 0; //���Ǳ� ����
		boolean sell = true; //���Ǳ� ��������
		Scanner scan = new Scanner(System.in);
		
		while(sell) {
			System.out.println("==========�޴�==========");
			System.out.println("���ϴ� �޴� ��ȣ�� �Է��Ͻÿ�");
			System.out.println("1.�ݾ��Է� 2.���ἱ�� 3.���ᰳ�� 4.�Ž�����ȯ 98.������ 99.����");
			System.out.println("���� �ݾ�: "+money+"��");
			System.out.println("100�� �̸� ��ȯ �ݾ�: "+under+"��");
			System.out.println("=======================");
			System.out.print("->");
			select = Integer.parseInt(scan.next()); 
			//�޴� ���� �ܿ� �޴��� ���ƿ��� �����ϱ�
			
			if(!(select>=1 && select<=4 || select == 99 || select == 98)) {
				System.out.println("�߸��� �����Դϴ�.");
				continue;
			}
			switch(select) {
			case 1:
				System.out.println("�Աݾ��� �Է��Ͻÿ�(100�� �̸� �ڵ� ��ȯ)");
				System.out.print("->");
				money += Integer.parseInt(scan.next());
				under = money % 100;
				money -= under;
				break;
				
			case 2:
				if(name[0] == null && name[1] == null && name[2] == null) {
					System.out.println("��ǰ�� �����ϴ�. ������ �޴����� ��ǰ�� �Է��Ͻʽÿ�");	
					break;								
				}
				
				for(int i=0; i<name.length; i++) {
					System.out.println((i+1)+"."+name[i]+"("+price[i]+"��)");
				}
				
				System.out.println("���ϴ� ������ ���ڸ� �Է��Ͻʽÿ�");	
				System.out.print("->");
				select = Integer.parseInt(scan.next());
				
				if(select > name.length) {
					System.out.println("�߸��� �Է��Դϴ�.");
					break;
				}else if(money < price[select-1]) {
					System.out.println("�ܾ��� �����մϴ�.");
					break;
				}		
				
				if(select <= name.length) {
					System.out.println(name[select-1]+"�� �����ϼ̽��ϴ�.");
					if(stock[select-1]==0) {
						System.out.println(name[select-1]+"�� �����ϴ�.");
						break;
					}
					money -= price[select-1];
					stock[select-1] -= 1;
				}
				break;
				
			case 3:
				System.out.println("���ᰳ��");
				for(int i=0; i<name.length; i++) {
					System.out.println(name[i]+": "+stock[i]);
				}
				break;
			
			case 4:
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
				break;
			case 98:
				System.out.println("������ ����Դϴ�.");
				System.out.print("������ ������ ���� �Է��Ͻʽÿ�(�ִ�"+name.length+"): "); //�迭�� �ִ밪
				select = scan.nextInt();
				if(select > name.length) {
					System.out.println("�߸��� �Է��Դϴ�.");
					break;
				}
				for(int i=1; i<=select; i++) { 
					System.out.println(i+"��° ������ �̸��� �Է��ϼ���");
					name[i-1] = scan.next();
					System.out.println(i+"��° ������ ������ �Է��ϼ���");
					price[i-1] = scan.nextInt();
					System.out.println(i+"��° ������ ������ �Է��ϼ���");
					stock[i-1] = scan.nextInt();
				}//�Էµ� �� ��ŭ �ݺ� ����
				System.out.println("������ �������ϴ�. �޴��� ���ư��ϴ�.");
				break;
				
			case 99:
				System.out.println("���Ǳ⸦ �����մϴ�.");
				sell = false;
			}
				
		}
		scan.close();
	}

}
