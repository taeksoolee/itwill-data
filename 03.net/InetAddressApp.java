package site.itwill.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

//InetAddress 클래스 : 네트워크 정보(IP Address, HostName)를 저장하기 위한 클래스
public class InetAddressApp {
	public static void main(String[] args) throws UnknownHostException {
		//InetAddress.getLocalHost() : 로컬 컴퓨터의 네트워크 정보를 반환하는 메소드
		// => UnknownHostException 발생 : HostName의 컴퓨터를 찾을 수 없을 경우 발생되는 예외 
		InetAddress myComputer=InetAddress.getLocalHost();
		
		//InetAddress.toString() : 네트워크 정보를 문자열로 변환하여 반환하는 메소드
		// => 참조변수를 출력할 경우 메소드 호출 생략 가능
		//System.out.println("myComputer = "+myComputer.toString());
		System.out.println("myComputer = "+myComputer);
		
		//InetAddress.getHostName() : 네트워크 컴퓨터이름(HostName)을 문자열로 변환하여 반환하는 메소드
		System.out.println("myComputer = "+myComputer.getHostName());

		//InetAddress.getHostAddress() : IP 주소를 문자열로 변환하여 반환하는 메소드
		System.out.println("myComputer = "+myComputer.getHostAddress());
		System.out.println("============================================");
		//InetAddress.getByName(String hostName) : 컴퓨터 이름에 대한 네트워크
		//정보를 반환하는 메소드 - 도메인을 이용한 컴퓨터 이름(DomainHostName)
		InetAddress itwill=InetAddress.getByName("www.itwill.site");
		System.out.println("[www.itwill.site] IP Address  = "+itwill.getHostAddress());
		System.out.println("============================================");
		//InetAddress.getAllByName(String hostName) : 컴퓨터 이름에 대한 
		//네트워크 정보들을 배열로 반환하는 메소드
		InetAddress[] daum=InetAddress.getAllByName("www.daum.net");
				
		for(InetAddress address:daum) {
			System.out.println("[www.daum.net] IP Address  = "+address.getHostAddress());
		}
		System.out.println("============================================");
	}
}