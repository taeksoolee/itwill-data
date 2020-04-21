package site.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Ű����� ��������� �Է¹޾� ���ñ��� ��ƿ� ��¥(��)�� ����Ͽ� ����ϴ� ���α׷�
//ex) ������� �Է�[ex.2000-01-01] >> 2019-11-07
//    [���]�¾�� 1�� �������ϴ�.
// => ���Ŀ� ���� ���� ��������� �Էµ� ��� �޼��� ��� �� ���α׷� ����
public class DayCalculateApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");		
		
		//���������� �ʱⰪ���� null �Ǵ� �ν��Ͻ� ����
		Date birthday=null;
		System.out.print("������� �Է�[ex.2000-01-01] >> ");
		try {
			birthday=sdf.parse(scanner.nextLine());
		} catch (ParseException e) {
			System.out.println("[����]���Ŀ� ���� �ʴ� ��������� �Է� �Ͽ����ϴ�.");
			System.exit(0);
		} finally {
			scanner.close();
		}
		
		//��ƿ� �ϼ�(���� - ����)�� ����Ͽ� ���
		//long day=(new Date().getTime()-birthday.getTime())/(1000*60*60*24);
		long day=(System.currentTimeMillis()-birthday.getTime())/(1000*60*60*24);
				
		System.out.println("[���]�¾�� "+day+"�� �������ϴ�.");		
	}
}