package example;

public class VariableExample {
	public static void main(String[] args) {
		//������ ���̰� 7�̰� ������ ���̰� 10�� �簢���� ������ ���
		//�簢���� ���̸� ����Ͽ� ���
		int garo=7,sero=10;
		int nulbe=garo*sero;
		System.out.println("�簢���� ���� = "+nulbe);
		System.out.println("===================================");
		
		//���̰� 9�̰� �غ��� ���̰� 7�� �ﰢ���� ������ ��� �ﰢ���� ���̸� ����Ͽ� ���
		int ����=9,����=7;
		double ����=����*����/2.;
		System.out.println("�ﰢ���� ���� = "+����);
		System.out.println("===================================");
		
		//10���� ��ü ������ �հ谡 759Kg�� ��� ��� �����Ը� ����Ͽ� ���
		int count=10,totWeight=759;
		double avgWeight=(double)totWeight/count;
		System.out.println("��� ������ = "+avgWeight+"Kg");
		System.out.println("===================================");
		
		//�̸��� "ȫ�浿"�� �л��� �������� 89��, �������� 93��, �������� 95���� �޾��� ���
		//������ ����� ����Ͽ� �̸�, ����, ��� ���
		//��, ����� �Ҽ��� �� �ڸ������� ����ϰ� �������� ���� ó�� �ǵ��� �ۼ�
		String name="ȫ�浿";
		int kor=89,eng=93,mat=95;
		int tot=kor+eng+mat;
		double avg=tot/3.;
		System.out.println("�̸� = "+name+", ���� = "+tot
				+", ��� = "+(int)(avg*10)/10.);
	}
}




