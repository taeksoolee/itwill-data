package site.itwill.io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

//���Ͽ� ����� ȸ�������� �о� ����ϴ� ���α׷� 
public class MemberLoadApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream in=new ObjectInputStream
				(new FileInputStream("c:/data/member.txt"));
		
		System.out.println("<<ȸ�����>>");
		while(true) {
			try {
				//readObject() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ����� EOF�� ��� EOFException �߻�
				Member member=(Member)in.readObject();
				System.out.println(member);
			} catch (EOFException e) {
				break;
			}
		}
		
		in.close();
	}
}

