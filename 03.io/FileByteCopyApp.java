package site.itwill.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//�������Ͽ� ����� ���� ���õ���Ÿ�� �о� Ÿ�����Ͽ� �����Ͽ� �����ϴ� ���α׷�
// => ��� ���Ͽ� ���� ��� ����
public class FileByteCopyApp {
	public static void main(String[] args) throws IOException {
		//BufferedInputStream Ŭ���� : �Է½�Ʈ���� ���޹޾� ��뷮 �Է½�Ʈ������ �����ϴ� Ŭ����
		BufferedInputStream in=null;
		//BufferedOutputStream Ŭ���� : ��½�Ʈ���� ���޹޾� ��뷮 ��½�Ʈ������ �����ϴ� Ŭ����
		BufferedOutputStream out=null;
		try {
			//in=new BufferedInputStream(new FileInputStream("c:/data/setup.log"));
			in=new BufferedInputStream(new FileInputStream("c:/data/setup.exe"));
			
			//out=new BufferedOutputStream(new FileOutputStream("c:/data/setup_byte.log"));
			out=new BufferedOutputStream(new FileOutputStream("c:/data/setup_byte.exe"));
			
			int readByte;
			
			while(true) {
				readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
			}
			
			System.out.println("[�޼���]������ ���������� ���� �Ͽ����ϴ�.");
		} catch (FileNotFoundException e) {
			System.out.println("[����]���������� �������� �ʽ��ϴ�.");
		} finally {
			if(in!=null) in.close();
			if(out!=null) out.close();
		}
	}
}
