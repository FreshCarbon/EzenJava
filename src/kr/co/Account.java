/*���� Ŭ���� 
 *  -�Ӽ� :�����ָ�, ���¹�ȣ, �ܾ�
 *  -��� :�Ա��Ѵ�, ����Ѵ�.
 * 
 *  =>�ʵ� ĸ��ȭ -> �ʵ忡 �����ϱ� ���� getter/setter����
 *  
 */

package kr.co.ch5;

public class Account {
	private String accountNo; // ���¹�ȣ
	private String ownerName; // ������ ��
	private int balance; // �ܾ�
	//Ŭ���� �ܰ迡���� �Ӽ��� ����	
	
	
	Account(){} //�ƹ��͵� ���� ����Ʈ ������ �ۼ� �ʿ�
	
	//getter/setter �����ؼ� ĸ��ȭ
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
	
//	Account(String accountNo){  Account(String) => ���� Ÿ������ �ν�
//		this.accountNo = accountNo;
//	} Duplicate(�ߺ�) ���� �߻� String ���� ���� �浹
	
	Account(String ownerName, String accountNo){
		this.ownerName = ownerName;
		this.accountNo = accountNo;
	}
	//string ���� ���� �� ��ü���� ����
	Account(String ownerName, String accountNo, int balance){
		this.ownerName = ownerName;
		this.accountNo = accountNo;
		this.balance = balance;
	}
	//������
	
	//�����Ѵ�
	void deposit(int ammount) {
		balance += ammount;
	}
	//����Ѵ�
	int  withdraw(int ammount) {
		if(balance < ammount)
			return 0;
		balance -= ammount;
			return ammount;
	}

	//�޼ҵ��� ����
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}
	
	
	
	//���� �ܰ� ���� ��ɼ��� �� �ʿ�

}
