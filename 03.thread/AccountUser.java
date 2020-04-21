package site.itwill.thread;

//������� ����������� �����ϱ� ���� Ŭ����
public class AccountUser extends Thread {
	private Account account;//�������� - ����
	private String userName;//������̸�
	
	public AccountUser() {
		// TODO Auto-generated constructor stub
	}

	public AccountUser(Account account, String userName) {
		super();
		this.account = account;
		this.userName = userName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//������¿��� ����ڰ� �Ա� ó�� �ݺ� ����
	@Override
	public void run() {
		for(int i=1;i<=3;i++) {
			synchronized (account) {
				account.deposit(userName, 5000);
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}




