package site.itwill.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//DataOutputStream Ŭ���� : ��½�Ʈ���� ���޹޾� ����Ÿ Ÿ�������� 
//��½�Ʈ���� �����ϱ� ���� Ŭ����
// => ���ϴ� ������ ���� ��½�Ʈ������ �����ϱ� ���� ��� ���� 
public class DataOutputStreamApp {
	public static void main(String[] args) throws IOException {
		DataOutputStream out=new DataOutputStream
				(new FileOutputStream("c:/data/data.txt"));
		
		//DataOutputStream.writeInt(int value) : �������� ��½�Ʈ������ �����ϴ� �޼ҵ�
		out.writeInt(100);
		
		//DataOutputStream.writeBoolean(boolean value) : ������ ��½�Ʈ������ �����ϴ� �޼ҵ�
		out.writeBoolean(true);
		
		//DataOutputStream.writeUTF(String value) : ���ڿ��� ��½�Ʈ������ �����ϴ� �޼ҵ�
		out.writeUTF("ȫ�浿");
		
		out.close();
		
		System.out.println("c:\\data\\data.txt ���Ͽ� �پ��� ������ ������ ���� �Ͽ����ϴ�.");
	}
}






