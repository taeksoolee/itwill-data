package site.itwill.student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

//����ǥ����(Regular Expression) : ��Ÿ���ڵ��� �̿��Ͽ� ������ ��Ģ�� ���ڿ� ǥ���ϴ� ���
/*
^���ڿ� : ���ڿ��� ���۵��� �ǹ�
���ڿ�$ : ���ڿ��� ������� �ǹ�
. : ������ �ϳ��� ���ڸ� �ǹ�(\ ���ڴ� ǥ�� �Ұ���)
[����1����2����3] : ������ ���ڵ� �� �ϳ��� �ǹ�
[^����1����2����3] : ������ ���ڵ��� �ƴ� ���� �ϳ��� �ǹ�
[����1-����2] : ����1���� ����2������ ���ڵ� �� �ϳ��� �ǹ�
(���ڿ�1|���ڿ�2) : ������ ���ڿ��� �� �ϳ��� �ǹ�
���ڿ�+ : ���ڿ��� 1�� �̻� �ݺ����� �ǹ�
���ڿ�* : ���ڿ��� 0�� �̻� �ݺ����� �ǹ�
���ڿ�? : ���ڿ��� 0�� �Ǵ� 1���� �������� �ǹ�
���ڿ�{����} : ���ڿ��� ���ڸ�ŭ�� �ݺ����� �ǹ�
���ڿ�{����1,����2} : ���ڿ��� ����1���� ����2������ �ݺ����� �ǹ�

\s : ������ �����ϴ� ���ڿ��� �ǹ�
\S : ������ �������� �ʴ� ���ڿ��� �ǹ�
\w : ������, ����, _�� ���ڷθ� ǥ���Ǵ� ���ڿ��� �ǹ�
\W : ������, ����, _�� ���ڸ� ������ ���ڷ� ǥ���Ǵ� ���ڿ��� �ǹ�
\d : ���� ������ ���ڷθ� ǥ���Ǵ� ���ڿ��� �ǹ�
\D : ���� ������ ���ڸ� ������ ���ڷ� ǥ���Ǵ� ���ڿ��� �ǹ�
\��Ÿ���� : ��Ÿ���ڸ� ���ڷ� ǥ��

(?!)���ڿ� : ���ڿ����� ��ҹ��ڸ� �������� ������ �ǹ�
(?=���ڿ�) : ���ڿ��� �����ϰ� ������ �ǹ�
(?!���ڿ�) : ���ڿ��� �����ϰ� ���� ������ �ǹ�
*/

//Ű����� �Է¹��� ���� ���� ���� ���α׷�
public class ValidationApp {
	public static void main(String[] args) throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		/*
		System.out.print("���̵� �Է� >> ");
		String id=in.readLine();
		
		//�⺻ ��ȿ�� �˻� >> �Է°� ���� ������ ���� �˻�
		if(id==null || id.equals("")) {
			System.out.println("[����]���̵� �ݵ�� �Է��� �ּ���.");
			System.exit(0);
		}
		
		//�Է±�Ģ�� ���� ��ȿ�� �˻� >> ���̵�� �����ڷ� ���۵Ǹ� ������
		//,����,Ư������(_)�� �������� 6~20 ������ ���ڷ� �Էµǵ��� ���� 
		// => ����ǥ������ �̿��� �Է°��� ��ȿ�� �˻�

		//Pattern.matches(String reg, CharSequence input) : ����ǥ������
		//���ڿ��� �Է°��� ���Ͽ� boolean ����� ��ȯ�ϴ� �޼ҵ�
		// => false : ����ġ, true : ��ġ
		
		//if(!Pattern.matches("^[a-zA-Z][a-zA-Z0-9_]{5,19}$", id)) {
		//	System.out.println("[����]�Էµ� ���̵� ���Ŀ� ���� �ʽ��ϴ�.");
		//	System.exit(0);
		//}
		
		
		//Pattern Ŭ���� : ����ǥ������ �����ϱ� ���� Ŭ����
		//Pattern.compile(String reg) : ���ڿ��� ���޹޾� ����ǥ�������� 
		//��ȯ�Ͽ� Pattern �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�  
		//Pattern idPattern=Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{5,19}$");
		Pattern idPattern=Pattern.compile("^[a-zA-Z]\\w{5,19}$");
		
		//Matcher Ŭ���� : ����ǥ���İ� ���ڿ��� �� ó�� ����� �����ϱ� ���� Ŭ����
		//Pattern.matcher(CharSequence input) : Pattern �ν��Ͻ��� �����
		//����ǥ���İ� ���� �Է°��� ���޹޾� �� ó���ϱ� ����  
		//Matcher �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		Matcher idMatcher=idPattern.matcher(id);
		
		//Matcher.matches() : ����ǥ���İ� �Է°��� ���Ͽ� boolean ����� ��ȯ�ϴ� �޼ҵ�
		// => false : ����ġ, true : ��ġ
		if(!idMatcher.matches()) {
			System.out.println("[����]�Էµ� ���̵� ���Ŀ� ���� �ʽ��ϴ�.");
			System.exit(0);
		}

		System.out.println("[�޼���]�������� ���� �Է� �Ͽ����ϴ�.");
		*/
		
		/*
		System.out.print("��й�ȣ �Է� >> ");
		String password=in.readLine();
		
		if(password==null || password.equals("")) {
			System.out.println("[����]��й�ȣ�� �ݵ�� �Է��� �ּ���.");
			System.exit(0);
		}
		
		//��й�ȣ�� ������,����,Ư�����ڸ� �ݵ�� 1�� �̻� �����Ͽ� 
		//8~30 ������ ���ڷ� �Էµǵ��� ����
		String passwordReg="^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{8,30}";
		if(!Pattern.matches(passwordReg, password)) {
			System.out.println("[����]�Էµ� ��й�ȣ�� ���Ŀ� ���� �ʽ��ϴ�.");
			System.exit(0);
		}
		
		System.out.println("[�޼���]�������� ���� �Է� �Ͽ����ϴ�.");
     	*/
		
		System.out.print("�̸��� �Է� >> ");
		String email=in.readLine();
		
		if(email==null || email.equals("")) {
			System.out.println("[����]�̸����� �ݵ�� �Է��� �ּ���.");
			System.exit(0);
		}
		
		//�̸����� [������̸�@������] ������ ���ڷ� �Էµǵ��� ����
		String emailReg="^([a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9-]+)+)*$";
		if(!Pattern.matches(emailReg, email)) {
			System.out.println("[����]�Էµ� �̸����� ���Ŀ� ���� �ʽ��ϴ�.");
			System.exit(0);
		}
		
		System.out.println("[�޼���]�������� ���� �Է� �Ͽ����ϴ�.");

	}
}






