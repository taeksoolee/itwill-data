package site.itwill.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//���Ͽ� ����� ���� ���õ���Ÿ�� �о� ����Ϳ� �����Ͽ� ����ϴ� ���α׷�
public class FileByteLoadApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[�޼���]c:\\data\\byte.txt ���Ͽ� ����� �����Դϴ�.");
		
		//FileInputStream Ŭ���� : ���� �Է½�Ʈ���� �����ϱ� ���� Ŭ����
		//FileInputStream(String fileName) : ���ϰ�θ� ���޹޾� �Է½�Ʈ���� ����� �ִ� ������
		// => ���ϰ�ο� ������ �������� ���� ��� FileNotFoundException �߻� - ����ó��
		FileInputStream in=null;
		try {
			in=new FileInputStream("c:/data/byte.txt");

			int readByte;
			
			while(true) {
				readByte=in.read();//���Ͽ� ����� ���� �о� ������ ���� - �б�
				if(readByte==-1) break;
				System.out.write(readByte);
			}
		} catch (FileNotFoundException e) {
			System.out.println("[����]�������Ͽ� �������� �ʽ��ϴ�.");
		} finally {
			//if ������ �̿��Ͽ� NullPointerException �߻� ����
			//FileInputStream.close() : ���� �Է½�Ʈ���� �����ϴ� �޼ҵ�
			if(in!=null) in.close();
		}
	}
}





