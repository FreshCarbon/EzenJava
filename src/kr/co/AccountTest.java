package kr.co.ch5;

public class AccountTest {
	public static void main(String[] args) {
		//은행계좌 2명의 정보를 생성(acN이라는 객체 생성)
		Account ac01 = new Account();
		
//		ac01.accountNo = "123-456789-01";
//		ac01.ownerName = "홍길동";
//		ac01.balance = 50000;
//		//ac01에 대한 정보
		ac01.setAccountNo("123-456789-01");
		ac01.setOwnerName("홍길동");
		ac01.setBalance(50000);
		
		Account ac02 = new Account("254-1549-4566","임거정", 10);
		//생성자를 이용한 객체생성
		
		printAccount(ac01);
		printAccount(ac02);
		
		
		
	} //                               타입   객체
	private static void printAccount(Object obj) {
		if(obj instanceof Account) {
			Account obj2 = (Account) obj;			
			//참조변수가 참조하고있는
			//인스턴스의 실제 타입을 알아보기 위해 instanceof 연산자 사용
			
			System.out.println("예금주명: "+obj2.getOwnerName());
			System.out.println("계좌번호: "+obj2.getAccountNo());
			System.out.println("잔액: "+obj2.getBalance());
			
			System.out.println("객체줄력: \n "+obj2);
		}
	}

}
