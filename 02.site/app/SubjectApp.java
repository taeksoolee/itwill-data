package site.app;

import site.itwill.subject.JavaSubject;
//�ٸ� ��Ű���� Ŭ������ ���� ǥ���ϱ� ���� import Ű���带 �̿��Ͽ� ����
// => Ŭ������ �Է� �� [Ctrl]+[Space]�� ������ �ڵ� import ����
//[Ctrl]+[Shift]+[O] : import �߰� �Ǵ� ���� ����Ű 
import site.uniwill.subject.NetworkSubject;
//��Ű���� �ٸ� ������ �̸��� Ŭ������ import ���� �Ұ���
//import site.uniwill.subject.JavaSubject;

public class SubjectApp {
	public static void main(String[] args) {
		//�ٸ� ��Ű���� Ŭ������ ����ϰ��� �� ��� ��Ű������ �����ϴ� 
		//Ŭ���������� ǥ���ؾ߸� ���� ����
		site.itwill.subject.OracleSubject subject1=new site.itwill.subject.OracleSubject();
		subject1.display();
		
		//import ����� Ŭ������ ��Ű������ �����ϰ� Ŭ���������θ� ǥ���ص� ���� ����
		NetworkSubject subject2=new NetworkSubject();
		subject2.display();
		
		//���� �̸��� Ŭ������ �ٸ� ��Ű���� ����� ��� import ���� ����
		JavaSubject subject3=new JavaSubject();
		subject3.display();
		
		//import ������ �Ұ����� ��� ��Ű������ ������ Ŭ���������� ǥ��
		site.uniwill.subject.JavaSubject subject4=new site.uniwill.subject.JavaSubject();
		subject4.display();
	}
}