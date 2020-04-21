package site.itwill.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//�������Ͽ� ����� ���� ���ڵ�����Ÿ�� �о� Ÿ�����Ͽ� �����Ͽ� �����ϴ� ���α׷�
// => �ؽ�Ʈ ���ϸ� ���� ��� ����
public class FileCharCopyApp {
	public static void main(String[] args) throws IOException {
		//BufferedReader Ŭ���� : �Է½�Ʈ���� ���޹޾� ��뷮 �Է½�Ʈ������ �����ϴ� Ŭ����
		BufferedReader in=null;
		//BufferedWriter Ŭ���� : ��½�Ʈ���� ���޹޾� ��뷮 ��½�Ʈ������ �����ϴ� Ŭ����
		BufferedWriter out=null;
		try {
			//in=new BufferedReader(new FileReader("c:/data/setup.log"));
			in=new BufferedReader(new FileReader("c:/data/setup.exe"));

			//out=new BufferedWriter(new FileWriter("c:/data/setup_char.log"));
			out=new BufferedWriter(new FileWriter("c:/data/setup_char.exe"));
			
			int readByte;
			
			while(true) {
				readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
				out.flush();
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










