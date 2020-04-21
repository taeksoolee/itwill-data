package site.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;

//Ű���� �Է°��� ���õ���Ÿ�� �о� ���Ͽ� �����Ͽ� �����ϴ� ���α׷�
public class FileByteSaveApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[�޼���]Ű���带 ���� ���� �Է��� �ּ���.[����:Ctrl+Z]");

		//FileOutputStream Ŭ���� : ���� ��½�Ʈ���� �����ϱ� ���� Ŭ����
		// => FileOutputStream(String fileName) : ���ϰ�θ� ���޹޾� ��½�Ʈ���� ����� �ִ� ������
		// => ���ϰ�ο� ������ �������� ���� ��� FileNotFoundException �߻� - ����ó��
		// => FileNotFoundException Ŭ������ IOException Ŭ������ �ڽ�Ŭ����
		// => ������ �������� ���� ��� ������ �ڵ����� ����� ��Ʈ�� ����
		// => ������ ���� �� ��� ���� ���뿡 ��� ���ο� �������� ���Ͽ� ���� - ������(OverWrite) �߻�
		//FileOutputStream out=new FileOutputStream("c:/data/byte.txt");
		
		//FileOutputStream(String name, boolean append) : �Ű������� true ����
		//������ ��� ���� ���� �ڿ� ���ο� ������ �߰��Ͽ� ���Ͽ� ���� - �̾��
		FileOutputStream out=new FileOutputStream("c:/data/byte.txt",true);
		
		int readByte;
		
		while(true) {
			readByte=System.in.read();
			if(readByte==-1) break;
			out.write(readByte);//���� ��½�Ʈ���� �� ���� - ����
		}
		
		//���Ͽ��� �Է½�Ʈ���� ��½�Ʈ���� �ϳ����� ���� ����
		// => ���Ͽ� ������ ��Ʈ���� �ݵ�� ����
		//FileOutputStream.close() : ���� ��½�Ʈ�� �����ϴ� �޼ҵ�
		out.close();
		
		System.out.println("[�޼���]c:\\data\\byte.txt ���Ͽ� Ű���� �Է°��� ���� �Ǿ����ϴ�.");
	}
}







