package realization;

public class PrinterApp {
	public static void main(String[] args) {
		//�⺻ �޼ҵ带 ȣ���ϱ� ���ؼ��� ���������� �������̽��� ����
		Printable printerOne=new PrinterSingle();
		printerOne.print();
		//�������̵� �������� ���� ��� �������̽��� �⺻ �޼ҵ� ȣ��
		printerOne.scan();
		System.out.println("============================================");
		Printable printerTwo=new PrinterMultiple();
		printerTwo.print();
		//�������̵� ����� ��� �ڽ�Ŭ������ �������̵� �޼ҵ� ȣ��
		printerTwo.scan();
		System.out.println("============================================");
	}
}
