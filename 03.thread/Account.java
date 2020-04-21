package site.itwill.thread;

//������������� �����ϱ� ���� Ŭ����
public class Account {
	private int balance;//�ܾ�
	
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
	
	//�Աݸ޼ҵ�
	public void deposit(String name, int amount) {
		balance+=amount;
		System.out.println("[�Ա�]"+name+"���� "+amount
				+"�� �Ա��Ͽ� �ܾ��� "+balance+"���Դϴ�.");
	}
	
	//��ݸ޼ҵ�
	public synchronized void withDraw(String name, int amount) {
		if(balance<amount) {
			System.out.println("[����]"+name+"�� �ܾ��� "+balance
					+"�� ���� "+amount+"���� ����� �� �����ϴ�.");
			return;
		}
		balance-=amount;
		System.out.println("[���]"+name+"���� "+amount
				+"�� ����Ͽ� �ܾ��� "+balance+"���Դϴ�.");
	}
}








