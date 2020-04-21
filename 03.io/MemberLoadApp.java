package site.itwill.io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

//파일에 저장된 회원정보를 읽어 출력하는 프로그램 
public class MemberLoadApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream in=new ObjectInputStream
				(new FileInputStream("c:/data/member.txt"));
		
		System.out.println("<<회원목록>>");
		while(true) {
			try {
				//readObject() 메소드를 호출하여 반환된 결과가 EOF인 경우 EOFException 발생
				Member member=(Member)in.readObject();
				System.out.println(member);
			} catch (EOFException e) {
				break;
			}
		}
		
		in.close();
	}
}

