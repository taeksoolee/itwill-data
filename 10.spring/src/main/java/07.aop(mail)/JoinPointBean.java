package site.itwill07.aop;

//�ٽɰ��ɸ��
public class JoinPointBean {
	public void add() {
		System.out.println("*** JoinPointBean Ŭ������ add() �޼ҵ� ȣ�� ***");
	}
	
	public void modify(int num, String name) {
		System.out.println("*** JoinPointBean Ŭ������ modify() �޼ҵ� ȣ�� ***");
	}
	
	public void remove(int num) {
		System.out.println("*** JoinPointBean Ŭ������ remove() �޼ҵ� ȣ�� ***");
	}
	
	public String getName() {
		System.out.println("*** JoinPointBean Ŭ������ getName() �޼ҵ� ȣ�� ***");
		return "ȫ�浿";
	}
	
	public void calc(int num1,int num2) {
		System.out.println("*** JoinPointBean Ŭ������ calc() �޼ҵ� ȣ�� ***");
		System.out.println("�� = "+(num1/num2));
	}
}
