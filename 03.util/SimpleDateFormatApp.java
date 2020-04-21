package site.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//SimpleDateFormat : Date �ν��Ͻ��� ����ϱ� ���� ����� �����ϴ� Ŭ����
public class SimpleDateFormatApp {
	public static void main(String[] args) {
		Date now=new Date();
		
		//SimpleDateFormat(String pattern) : ��¥�� �ð������� ���� 
		//��������(���Ϲ��ڿ� ���ڿ�)�� �����ϴ� �ν��Ͻ��� �����ϴ� ������
		// => ���Ϲ��� : y(��) M(��) d(��) H(��) m(��) s(��) E(����) �� 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy�� MM�� dd�� E����");
	
		//SimpleDateFormat.format(Date date) : Date �ν��Ͻ��� ����� ��¥�� �ð������� 
		//SimpleDateFormat �ν��Ͻ��� ����� ���������� ��ȯ�Ͽ� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
		String printDate=sdf.format(now);
		
		System.out.println("���� = "+printDate);
		
		//SimpleDateFormat.applyPattern(String pattern) : SimpleDateFormat
		//�ν��Ͻ��� ����� ���������� �����ϴ� �޼ҵ�
		sdf.applyPattern("yyyy-mm-dd HH:mm:ss");
		
		String want="2000-01-01 00:00:00";
		try {
			//SimpleDateFormat.parse(String str) : SimpleDateFormat �ν��Ͻ���
			//����� ���������� ������ ���ڿ��� ���޹޾� Date �ν��Ͻ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
			// => ���������� ���ڿ��� ���� ���� ��� ParseException �߻� 
			Date wantDate = sdf.parse(want);
			System.out.println("wantDate = "+wantDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}





