package site.itwill.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//Ű���� �Է°��� ���ڵ�����Ÿ�� �о� ���Ͽ� �����Ͽ� �����ϴ� ���α׷�
public class FileCharSaveApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[�޼���]Ű���带 ���� ���� �Է��� �ּ���.[����:Ctrl+Z]");

		//Ű���� �Է½�Ʈ���� Ȯ��� �Է½�Ʈ������ ����
		InputStreamReader in=new InputStreamReader(System.in);
		
		//FileWriter Ŭ���� : ���Ͽ� ��½�Ʈ���� �����ϴ� Ŭ����
		// => FileWriter(String fileName) : ���ϰ�θ� ���޹޾� ��½�Ʈ���� ����� �ִ� ������
		// => ���ϰ�ο� ������ �������� ���� ��� IOException �߻� - ����ó��
		// => ������ �������� ���� ��� ������ �ڵ����� ����� ��Ʈ�� ����
		// => ������ ���� �� ��� ���� ���뿡 ��� ���ο� �������� ���Ͽ� ���� - ������(OverWrite) �߻�		
		//FileWriter out=new FileWriter("c:/data/char.txt");
		
		//FileWriter(String name, boolean append) : �Ű������� true ����
		//������ ��� ���� ���� �ڿ� ���ο� ������ �߰��Ͽ� ���Ͽ� ���� - �̾��
		FileWriter out=new FileWriter("c:/data/char.txt",true);
		
		int readByte;
		
		while(true) {
			readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);
			out.flush();
		}
		
		//FileWriter.close() : ���� ��½�Ʈ���� �����ϴ� �޼ҵ�
		out.close();
		
		System.out.println("[�޼���]c:\\data\\char.txt ���Ͽ� Ű���� �Է°��� ���� �Ǿ����ϴ�.");
	}
}
