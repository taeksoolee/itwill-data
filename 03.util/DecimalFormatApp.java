package site.itwill.util;

import java.text.DecimalFormat;

//DecimalFormat : ���ڸ� ǥ���ϱ� ���� ���������� �����ϱ� ���� Ŭ����  
public class DecimalFormatApp {
	public static void main(String[] args) {
		//���Ϲ��� : #(����)  0(����)  .  , ��
		DecimalFormat df=new DecimalFormat("###,###,##0");
		
		int number=100000000;
		
		System.out.println("number = "+number+"��");
		
		//DecimalFormat.format(Object number) : ���޹��� ��(����)�� DecimalFormat
		//�ν��Ͻ��� ����� ���������� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		System.out.println("number = "+df.format(number)+"��");
		
		//DecimalFormat.getInstance() : �⺻ ���������� ����� DecimalFormat 
		//�ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		System.out.println("number = "
				+DecimalFormat.getInstance().format(number)+"��");
	
		//DecimalFormat.getCurrencyInstance() : ȭ�� ���� ���������� �����
		//DecimalFormat �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		System.out.println("number = "
				+DecimalFormat.getCurrencyInstance().format(number));
	}
}
