package site.itwill.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

//Ű����� �̸��� �¾ �⵵�� �Է¹޾� �̸��� ���̸� ����ϴ� ���α׷�
public class ConsoleIOAPP {
	public static void main(String[] args) throws IOException {
		//��Ʈ���� �ٴܰ� ������ �̿��� ��Ʈ�� Ȯ��
		// => System.in : Ű����� ���õ���Ÿ�� �Է¹ޱ� ���� �����Ǵ� �Է½�Ʈ��
		// => new InputStreamReader(InputStream in) : InputStream ��Ʈ���� ���޹޾�
		//    ���ڵ�����Ÿ�� �Է¹��� �� �ִ� InputStreamReader ��Ʈ������ Ȯ��
		// => new BufferedReader(InputStreamReader in) : InputStreamReader ��Ʈ���� ���޹޾�
		//    ��뷮 ����Ÿ�� �Է¹��� �� �ִ� BufferedReader ��Ʈ������ Ȯ��
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//PrintStream Ŭ������ print() �Ǵ� println() �޼ҵ带 �̿��� ���
		//��� ������ ���� �����ص� ���ڿ��� ��ȯ�Ͽ� ����
		System.out.print("�̸� �Է� >> ");
		//BufferedReader.readLine() : �Է½�Ʈ���� �����ϴ� ��� ���ڵ�
		//����Ÿ(����)�� ���ڿ��� �о� ��ȯ�ϴ� �޼ҵ�
		String name=in.readLine();	
		
		System.out.print("�¾ �⵵ �Է� >> ");
		//�Է°��� ���ڿ��� ��ȯ�޾� �������� ��ȯ�Ͽ� ����
		int year=Integer.parseInt(in.readLine());
		
		int age=Calendar.getInstance().get(Calendar.YEAR)-year+1;
		
		System.out.println("[���]"+name+"���� ���̴� "+age+"���Դϴ�.");
	}
}
