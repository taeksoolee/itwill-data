package realization;

public class WolfHumanApp {
	public static void main(String[] args) {
		WolfHuman wh=new WolfHuman();
		
		wh.speak();
		wh.walk();
		wh.smile();
		wh.change();
		wh.cryLoudly();
		wh.fastWalk();
		System.out.println("===========================================");
		//�θ� ���������� �ڽ� �ν��Ͻ� ���� - �θ� �ν��Ͻ� �޼ҵ� ����
		// => ��ü ����ȯ�� �̿��ϸ� �ڽ� �ν��Ͻ� �޼ҵ� ���� ����
		Human human=new WolfHuman();
		
		human.speak();
		human.walk();
		human.smile();
		System.out.println("===========================================");
		//����� ��ü ����ȯ�� �̿��Ͽ� �ڽ� �ν��Ͻ� �޼ҵ� ȣ��
		((WolfHuman)human).change();
		System.out.println("===========================================");
		//�������̽��� �̿��Ͽ� �������� ���� ���� => �ڽ� �ν��Ͻ� ����
		//�ڽ�Ŭ������ ���� Ŭ������ �������̽����� ���� ����� ��ü ����ȯ ����
		Wolf wolf=(Wolf)human;

		//������ ��ü ����ȯ�� ���� �ڽ� �ν��Ͻ��� �޼ҵ� ȣ��
		wolf.cryLoudly();
		wolf.fastWalk();
		System.out.println("===========================================");
	}
}









