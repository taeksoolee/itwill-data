package basic;

//��ǻ�Ϳ��� ������ �����޾� ����ϴ� ���α׷��� �ۼ��ϼ���.
// => ���� : �ұ�Ģ������ �߻��Ǵ� ����
public class MathRandomApp {
	public static void main(String[] args) {
		//Math Ŭ���� : ���� ���� ����� �޼ҵ尡 ����� Ŭ����
		
		//Math.random() : 0.0 ���� ũ�ų� ���� 1.0���� ���� �Ǽ������� ��ȯ�ϴ� �޼ҵ�
		for(int i=1;i<=5;i++) {
			System.out.println(i+"��° �Ǽ����� = "+Math.random());
		}
		System.out.println("============================================");
		//0~99 ������ ���������� �����޾� ���
		for(int i=1;i<=5;i++) {
			System.out.println(i+"��° ��������(0~99) = "+(int)(Math.random()*100));
		}
		System.out.println("============================================");
		//1~45 ������ ���������� �����޾� ���
		for(int i=1;i<=5;i++) {
			System.out.println(i+"��° ��������(1~45) = "+((int)(Math.random()*100)%45+1));
		}
		System.out.println("============================================");
	}
}










