package inheritance;

public class MemberEventApp {
	public static void main(String[] args) {
		//�ڽ�Ŭ������ �����ڸ� �̿��Ͽ� �ν��Ͻ��� ������ ��� �θ�Ŭ������
		//�����ڰ� ���� ȣ��Ǿ� �θ� �ν��Ͻ� ���� �� �ڽ� �ν��Ͻ� ���� 
		MemberEvent member1=new MemberEvent();
		
		member1.setId("aaa");
		member1.setName("ȫ�浿");
		member1.setEmail("aaa@google.com");
		
		member1.display();
		System.out.println("============================================");
		MemberEvent member2=new MemberEvent("bbb", "�Ӳ���", "bbb@daum.net");
		member2.display();
		System.out.println("============================================");
	}
}





