package site.itwill.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;

//ObjectInputStream Ŭ���� : �Է½�Ʈ���� ���޹޾� ����Ÿ Ÿ�������� 
//�Է½�Ʈ���� �����ϱ� ���� Ŭ����
// => �Է½�Ʈ������ ���޵� ���� ��ü(�ν��Ͻ�)�� �б� ���� ��� ����
public class ObjectInputStreamApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream in=new ObjectInputStream
				(new FileInputStream("c:/data/object.txt"));
		
		//ObjectInputStream.readObject() : �Է½�Ʈ������ ��ü(�ν��Ͻ�)�� �о� ��ȯ�ϴ� �޼ҵ�
		// => Object Ÿ������ ��ü(�ν��Ͻ�)�� ��ȯ�ǹǷ� ����� ��ü ����ȯ ���
		// => ��ȯ�Ǵ� ��ü(�ν��Ͻ�)�� ���� Ŭ������ ���� ��� ClassNotFoundException �߻� - ����ó��
		String string=(String)in.readObject(); 
		Date date=(Date)in.readObject(); 
		@SuppressWarnings("unchecked")
		List<String> list=(List<String>)in.readObject();
		
		System.out.println("string = "+string);
		System.out.println("date = "+date);
		System.out.println("list = "+list);
		
		in.close();
	}
}