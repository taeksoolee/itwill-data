package oop;

public class MemberApp {
	public static void main(String[] args) {
		//�⺻ �����ڸ� �̿��Ͽ� �ν��Ͻ� ����
		// => �ν��Ͻ��� �ʵ忡�� �⺻���� �ڵ� ����
		Member member1=new Member();
		
		/*
		System.out.println("���̵� = "+member1.getId());
		System.out.println("�̸� = "+member1.getName());
		System.out.println("�̸��� = "+member1.getEmail());
		*/
		member1.display();
		System.out.println("============================================");
		//Setter �޼ҵ带 ȣ���Ͽ� �ʵ尪 ����
		member1.setId("aaa");
		member1.setName("ȫ�浿");
		member1.setEmail("aaa@google.com");
		
		member1.display();
		System.out.println("============================================");
		//�ν��Ͻ� ������ �������� �Ű������� �ʵ忡 ����� ���� �����Ͽ� �ʱ�ȭ ����
		Member member2=new Member("bbb");
		member2.display();
		System.out.println("============================================");
		Member member3=new Member("ccc", "�Ӳ���");
		member3.display();
		System.out.println("============================================");
		Member member4=new Member("ddd", "����ġ", "ddd@daum.net");
		member4.display();
		System.out.println("============================================");
	}
}
