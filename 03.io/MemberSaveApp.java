package site.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//ȸ�������� ���Ͽ� �����ϴ� ���α׷�
public class MemberSaveApp {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream out=new ObjectOutputStream
				(new FileOutputStream("c:/data/member.txt"));
		
		//writeObject() �޼ҵ忡���� NotSerializableException �߻� ����
		//NotSerializableException : ��ü����ȭ ������� ���� Ŭ������ 
		//�ν��Ͻ��� ��½�Ʈ������ ������ �� �߻��Ǵ� ����
		out.writeObject(new Member("aaa", "ȫ�浿", "����� ������"));
		out.writeObject(new Member("bbb", "�Ӳ���", "��õ�� ���̱�"));
		out.writeObject(new Member("ccc", "����ġ", "������ �ȴޱ�"));
		
		out.close();
		
		System.out.println("[�޼���]���Ͽ� ȸ�������� ���������� ���� �Ͽ����ϴ�.");
	}
}









