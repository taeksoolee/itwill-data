package site.itwill.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//DataInputStream Ŭ���� : �Է½�Ʈ���� ���޹޾� ����Ÿ Ÿ�������� 
//�Է½�Ʈ���� �����ϱ� ���� Ŭ����
// => �Է½�Ʈ������ ���޵� ���� ���ϴ� ������ ������ �б� ���� ��� ����
public class DataInputStreamApp {
	public static void main(String[] args) throws IOException {
		DataInputStream in=new DataInputStream
				(new FileInputStream("c:/data/data.txt"));

		//���� ���Ͽ� ����� ������� �ݵ�� �о� ��ȯ�޾� ���
		//DataInputStream.readInt() : �Է½�Ʈ���� ���� ���������� �о� ��ȯ�ϴ� �޼ҵ�
		int value1=in.readInt();
		
		//DataInputStream.readBoolean() : �Է½�Ʈ���� ���� �������� �о� ��ȯ�ϴ� �޼ҵ�
		boolean value2=in.readBoolean();
		
		//DataInputStream.readUTF() : �Է½�Ʈ���� ���� ���ڿ��� �о� ��ȯ�ϴ� �޼ҵ�
		String value3=in.readUTF();
		
		System.out.println("������ = "+value1);
		System.out.println("���� = "+value2);
		System.out.println("���ڿ� = "+value3);
		
		in.close();
	}
}











