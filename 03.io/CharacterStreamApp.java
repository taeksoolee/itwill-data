package site.itwill.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//Ű���� �Է°��� ���ڵ�����Ÿ(2Byte)�� �Է¹޾� ����Ϳ� �����ϴ� ���α׷�
// => ���ڵ�����Ÿ : ���õ���Ÿ�� ���ڵ���Ÿ�� ������Ų ��
// => EOF(End Of File : �Է����� - [Ctrl]+[Z])�� �Է��ϸ� ���α׷� ����
public class CharacterStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[�޼���]Ű���带 ���� ���� �Է��� �ּ���.[����:Ctrl+Z]");
		
		//InputStreamReader(InputStream in) : InputStream �ν��Ͻ��� ���޹޾�
		//InputStreamReader �ν��Ͻ��� �����ϱ� ���� ������
		// => ���õ���Ÿ ��� ���ڵ�����Ÿ�� �Է� ���� �� �ִ� ��Ʈ������ Ȯ�� 
		InputStreamReader in=new InputStreamReader(System.in);
		
		//OutputStreamWriter(OutputStream out) : OutputStream �ν��Ͻ��� ���޹޾�
		//OutputStreamWriter �ν��Ͻ��� �����ϱ� ���� ������
		// => ���õ���Ÿ ��� ���ڵ�����Ÿ�� ����� �� �ִ� ��Ʈ������ Ȯ�� 
		//OutputStreamWriter out=new OutputStreamWriter(System.out);
		//PrintWriter Ŭ���� : OutputStreamWriter Ŭ������ ��ӹ��� �ڽ�Ŭ����
		PrintWriter out=new PrintWriter(System.out);
	
		int readByte;
		
		while(true) {
			//�Է½�Ʈ������ �Է°��� ���ڵ�����Ÿ�� �о� ��ȯ�޾� ����
			readByte=in.read();
			
			if(readByte==-1) break;
			
			//���ڵ�����Ÿ�� ��ȯ�Ͽ� ��½�Ʈ������ ����
			// => Writer ���� ���Ŭ������ ���� ��¹��ۿ� ��Ƽ� �ѹ��� ��½�Ʈ���� ����  
			out.write(readByte);
			//Writer.flush() : ��¹��ۿ� �����ϴ� ���ڵ�����Ÿ�� ��½�Ʈ������ �����ϴ� �޼ҵ�
			out.flush();			
		}
		
		System.out.println("[�޼���]���α׷��� �����մϴ�.");
	}
}