/*예금 클래스 
 *  -속성 :예금주명, 계좌번호, 잔액
 *  -기능 :입금한다, 출금한다.
 * 
 *  =>필드 캡슐화 -> 필드에 접근하기 위한 getter/setter생성
 *  
 */

package kr.co.ch5;

public class Account {
	private String accountNo; // 계좌번호
	private String ownerName; // 예금주 명
	private int balance; // 잔액
	//클래스 단계에서는 속성만 선언	
	
	
	Account(){} //아무것도 없는 디폴트 생성자 작성 필요
	
	//getter/setter 설정해서 캡슐화
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	Account(String ownerName){
		this.ownerName = ownerName;
	}
	
//	Account(String accountNo){  Account(String) => 같은 타입으로 인식
//		this.accountNo = accountNo;
//	} Duplicate(중복) 에러 발생 String 값에 의한 충돌
	
	Account(String ownerName, String accountNo){
		this.ownerName = ownerName;
		this.accountNo = accountNo;
	}
	//string 값이 오면 내 객체값에 저장
	Account(String ownerName, String accountNo, int balance){
		this.ownerName = ownerName;
		this.accountNo = accountNo;
		this.balance = balance;
	}
	//다형성
	
	//예금한다
	void deposit(int ammount) {
		balance += ammount;
	}
	//출금한다
	int  withdraw(int ammount) {
		if(balance < ammount)
			return 0;
		balance -= ammount;
			return ammount;
	}

	//메소드의 수정
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}
	
	
	
	//개발 단계 전에 기능설계 꼭 필요

}
