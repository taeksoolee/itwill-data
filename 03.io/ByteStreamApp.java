package site.itwill.io;

import java.io.IOException;

//Ű���� �Է°��� ���õ���Ÿ(1Byte)�� �Է¹޾� ����Ϳ� �����ϴ� ���α׷�
// => EOF(End Of File : �Է����� - [Ctrl]+[Z])�� �Է��ϸ� ���α׷� ����
public class ByteStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[�޼���]Ű���带 ���� ���� �Է��� �ּ���.[����:Ctrl+Z]");
		
		//Ű���� �Է°��� ��ȯ�޾� �����ϱ� ���� ����
		int readByte;
		
		while(true) {
			//System.in : Java ���α׷� �ۼ��� �⺻������ �����Ǵ� Ű���� �Է½�Ʈ��
			// => InputStream Ŭ������ ������ �ν��Ͻ�
			//InputStream.read() : �Է½�Ʈ������ ���õ���Ÿ�� �о� ��ȯ�ϴ� �޼ҵ�
			// => �Է½�Ʈ���� ���� �������� ���� ��� ������ �Ͻ� ����
			// => Ű���带 ���� ��Ʈ���� �Է°��� ������ ���͸� ���� ������ �����
			//��� ����� Ŭ������ �޼ҵ忡���� IOException �߻� - ����ó��
			// => IOException : �Է½�Ʈ�� �Ǵ� ��½�Ʈ���� ������ �ִ� ��� �߻��Ǵ� ���� 
			readByte=System.in.read();
			
			//�Է����� ���� ����(Ctrl+Z : EOF >> -1)�� ����� ��� �ݺ��� ����
			if(readByte==-1) break;
			
			//System.out : Java ���α׷� �ۼ��� �⺻������ �����Ǵ� ����� ��½�Ʈ��
			// => PrintStream Ŭ������ ������ �ν��Ͻ�
			// => PrintStream Ŭ���� : OutputStream Ŭ������ ��ӹ��� �ڽ�Ŭ����
			//OutputStream.write(int b) : ���õ���Ÿ�� ��½�Ʈ������ �����ϴ� �޼ҵ�
			System.out.write(readByte);
		}
		
		System.out.println("[�޼���]���α׷��� �����մϴ�.");
	}
}









