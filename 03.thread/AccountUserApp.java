package site.itwill.thread;

//���� ������ ������ : ������ ������ ������ ���� ���� ���� �ν��Ͻ��� �޼ҵ带
//ȣ���� ��� �޼ҵ� ����� ó���� ���� ������ �ұ�Ģ�Ͽ� �߸��� ��� �߻� 
//�ذ��)���� �޼ҵ带 ��û�� �����尡 �޼ҵ� ����� ���� ������ �ٸ� 
//�����带 ������(Lock)�� ���� - ������ ����ȭ
// => �����尡 ��û�ϴ� �ν��Ͻ��� �޼ҵ带 synchronized Ű����� ����ȭ �޼ҵ� ����
// => �����尡 �ν��Ͻ��� �޼ҵ带 ����ȭ(synchronized) �������� ȣ��
public class AccountUserApp {
	public static void main(String[] args) {
		Account account=new Account(10000);//�ܾ� : 10000��
		
		//������ �ν��Ͻ��� �����带 �����Ͽ� run() �޼ҵ��� ��� ����
		// => ������ �ϳ��� 1�ʸ��� �Ա� ó���� 3�� �ݺ� 
		new AccountUser(account, "ȫ�浿").start();
		new AccountUser(account, "�Ӳ���").start();
		new AccountUser(account, "����ġ").start();
	}
}
