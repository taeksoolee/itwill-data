package site.itwill06.oop;

//�������̽��� �߻�޼ҵ带 �������̵� �����Ͽ� �ٽɰ����ڵ� �ۼ�
//�ٽɰ��ɸ�� : �ٽɰ����ڵ�θ� �ۼ��� �޼ҵ尡 ����� Ŭ����
public class AopOne implements AopInterface {
	@Override
	public void display1() {
		//Ⱦ�ܰ����ڵ� : �α�,����,Ʈ������,����ó�� ���� �����ϱ� ���� ��� 
		//System.out.println("### �޼ҵ��� ��� ���� �� ��ϵ� ���� ###");
		//�ٽɰ����ڵ� : �޼ҵ�� ����� �����ϱ� ���� �ݵ�� �ʿ��� ���
		System.out.println("*** AopOne Ŭ������ display1() �޼ҵ��� ��� ���� ***");
	}

	@Override
	public void display2() {
		//System.out.println("### �޼ҵ��� ��� ���� �� ��ϵ� ���� ###");
		System.out.println("*** AopOne Ŭ������ display2() �޼ҵ��� ��� ���� ***");
	}

	@Override
	public void display3() {
		//System.out.println("### �޼ҵ��� ��� ���� �� ��ϵ� ���� ###");
		System.out.println("*** AopOne Ŭ������ display3() �޼ҵ��� ��� ���� ***");
	}

}
