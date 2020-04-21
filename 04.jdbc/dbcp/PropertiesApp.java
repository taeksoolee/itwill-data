package site.itwill.dbcp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Properties ����(.properties) : ���α׷� ���࿡ �ʿ��� ���� �����ϱ� ���� �ؽ�Ʈ ����
// => ���α׷��� �������� �ʰ� Properties ������ �����Ͽ� ���α׷� ���� ��� ���� ����
// => ���������� ȿ���� ����
// => Properties ���Ͽ� ���� �����Ǵ� ���� ���ڿ�(String)�� ����

//user.properties ������ �о� ���尪�� ����ϴ� ���α׷�
public class PropertiesApp {
	public static void main(String[] args) throws IOException {
		//1.Properties ������ �б� ���� �Է½�Ʈ�� ����
		
		//FileInputStream Ŭ������ �̿��Ͽ� �Է½�Ʈ�� ����
		// => FileInputStream Ŭ������ �̿��� ��� ���� ��ο� ���� ���� �߻�
		//InputStream in=new FileInputStream("bin/site/itwill/dbcp/user.properties");
		
		//���÷��� ����� �̿��Ͽ� �Է½�Ʈ�� ����
		// => Ŭ����.class - Ŭ������ �޸𸮿� ����(Clazz : Class �ν��Ͻ�)�Ͽ� ����ϱ� ���� ���
		//Class.getClassLoader() : ClassLoader �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//ClassLoader.getResourceAsStream(String resource) : ���ҽ� ������
		//�б� ���� �Է½�Ʈ���� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		InputStream in=PropertiesApp.class.getClassLoader()
				.getResourceAsStream("site/itwill/dbcp/user.properties");
		
		//2.Properties �ν��Ͻ� ���� - Properties Ŭ������ Map �������̽��� ��ӹ޴� �ݷ��� Ŭ����
		Properties properties=new Properties();
		
		//3.Properties ������ ������ �о� Properties �ν��Ͻ��� ����
		//Properties.load(InputStream in) : Properties ������ �о� Properties �ν��Ͻ��� �����ϴ� �޼ҵ� 
		properties.load(in);
		
		//4.Properties �ν��Ͻ����� Ű(Key:String)�� �̿��Ͽ� ��(Value:String)�� ��ȯ�޾� ����
		//Properties.get(String key) : Ű�� ���� ���� ��ȯ�ϴ� �޼ҵ�
		// => ���� Object Ÿ������ ��ȯ�ϹǷ� ��ü ����ȯ�Ͽ� ����
		String id=(String)properties.get("id");
		String password=(String)properties.get("password");
		String name=(String)properties.get("name");
		
		System.out.println("user.properties ���Ͽ� ����� ���� >>");
		System.out.println("���̵� = "+id);
		System.out.println("��й�ȣ = "+password);
		System.out.println("�̸� = "+name);
	}
}










