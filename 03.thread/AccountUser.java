package site.itwill.thread;

//은행계좌 사용자정보를 저장하기 위한 클래스
public class AccountUser extends Thread {
	private Account account;//계좌정보 - 포함
	private String userName;//사용자이름
	
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
	
	//은행계좌에서 사용자가 입금 처리 반복 실행
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




