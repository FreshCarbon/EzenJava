package kr.co.ch5;

public class AccountTest {
	public static void main(String[] args) {
		//������� 2���� ������ ����(acN�̶�� ��ü ����)
		Account ac01 = new Account();
		
//		ac01.accountNo = "123-456789-01";
//		ac01.ownerName = "ȫ�浿";
//		ac01.balance = 50000;
//		//ac01�� ���� ����
		ac01.setAccountNo("123-456789-01");
		ac01.setOwnerName("ȫ�浿");
		ac01.setBalance(50000);
		
		Account ac02 = new Account("254-1549-4566","�Ӱ���", 10);
		//�����ڸ� �̿��� ��ü����
		
		printAccount(ac01);
		printAccount(ac02);
		
		
		
	} //                               Ÿ��   ��ü
	private static void printAccount(Object obj) {
		if(obj instanceof Account) {
			Account obj2 = (Account) obj;			
			//���������� �����ϰ��ִ�
			//�ν��Ͻ��� ���� Ÿ���� �˾ƺ��� ���� instanceof ������ ���
			
			System.out.println("�����ָ�: "+obj2.getOwnerName());
			System.out.println("���¹�ȣ: "+obj2.getAccountNo());
			System.out.println("�ܾ�: "+obj2.getBalance());
			
			System.out.println("��ü�ٷ�: \n "+obj2);
		}
	}

}
