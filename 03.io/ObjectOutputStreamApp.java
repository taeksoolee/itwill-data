package site.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Date;

//ObjectOutputStream Ŭ���� : ��½�Ʈ���� ���޹޾� ����Ÿ Ÿ�������� 
//��½�Ʈ���� �����ϱ� ���� Ŭ���� 
// => ��ü(�ν��Ͻ�)�� ��½�Ʈ������ �����ϱ� ���� ��� ���� 
public class ObjectOutputStreamApp {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream out=new ObjectOutputStream
				(new FileOutputStream("c:/data/object.txt"));
		
		//ObjectOutputStream.writeObject(Object o) : ��ü(�ν��Ͻ�)�� ��½�Ʈ���� �����ϴ� �޼ҵ�
		//out.writeObject(new String("ȫ�浿"));
		out.writeObject("ȫ�浿");
		out.writeObject(new Date());
		out.writeObject(Arrays.asList("�Ӳ���","����ġ","������","����"));
		
		out.close();
		
		System.out.println("c:\\data\\object.txt ���Ͽ� ��ü���� ���� �Ͽ����ϴ�.");
	}
}










