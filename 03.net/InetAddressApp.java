package site.itwill.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

//InetAddress Ŭ���� : ��Ʈ��ũ ����(IP Address, HostName)�� �����ϱ� ���� Ŭ����
public class InetAddressApp {
	public static void main(String[] args) throws UnknownHostException {
		//InetAddress.getLocalHost() : ���� ��ǻ���� ��Ʈ��ũ ������ ��ȯ�ϴ� �޼ҵ�
		// => UnknownHostException �߻� : HostName�� ��ǻ�͸� ã�� �� ���� ��� �߻��Ǵ� ���� 
		InetAddress myComputer=InetAddress.getLocalHost();
		
		//InetAddress.toString() : ��Ʈ��ũ ������ ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => ���������� ����� ��� �޼ҵ� ȣ�� ���� ����
		//System.out.println("myComputer = "+myComputer.toString());
		System.out.println("myComputer = "+myComputer);
		
		//InetAddress.getHostName() : ��Ʈ��ũ ��ǻ���̸�(HostName)�� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		System.out.println("myComputer = "+myComputer.getHostName());

		//InetAddress.getHostAddress() : IP �ּҸ� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		System.out.println("myComputer = "+myComputer.getHostAddress());
		System.out.println("============================================");
		//InetAddress.getByName(String hostName) : ��ǻ�� �̸��� ���� ��Ʈ��ũ
		//������ ��ȯ�ϴ� �޼ҵ� - �������� �̿��� ��ǻ�� �̸�(DomainHostName)
		InetAddress itwill=InetAddress.getByName("www.itwill.site");
		System.out.println("[www.itwill.site] IP Address  = "+itwill.getHostAddress());
		System.out.println("============================================");
		//InetAddress.getAllByName(String hostName) : ��ǻ�� �̸��� ���� 
		//��Ʈ��ũ �������� �迭�� ��ȯ�ϴ� �޼ҵ�
		InetAddress[] daum=InetAddress.getAllByName("www.daum.net");
				
		for(InetAddress address:daum) {
			System.out.println("[www.daum.net] IP Address  = "+address.getHostAddress());
		}
		System.out.println("============================================");
	}
}