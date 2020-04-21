package site.itwill.thread;

//은행계좌정보를 저장하기 위한 클래스
public class Account {
	private int balance;//잔액
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금메소드
	public void deposit(String name, int amount) {
		balance+=amount;
		System.out.println("[입금]"+name+"님이 "+amount
				+"원 입금하여 잔액이 "+balance+"원입니다.");
	}
	
	//출금메소드
	public synchronized void withDraw(String name, int amount) {
		if(balance<amount) {
			System.out.println("[에러]"+name+"님 잔액이 "+balance
					+"원 남아 "+amount+"원을 출금할 수 없습니다.");
			return;
		}
		balance-=amount;
		System.out.println("[출금]"+name+"님이 "+amount
				+"원 출금하여 잔액이 "+balance+"원입니다.");
	}
}








