package site.itwill.exception;

//���ܸ� ���� �����ڰ� ���� �ۼ��� Ŭ���� : Exception Ŭ������ ��ӹ޾� �ۼ�
//ȸ������ ���� �� �ߺ� ���̵� �Էµ� ��� �߻��Ǵ� ����  
public class ExistsUserinfoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ExistsUserinfoException() {
		// TODO Auto-generated constructor stub
	}
	
	public ExistsUserinfoException(String message) {
		super(message); 
	}
}
