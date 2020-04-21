package site.itwill.io;

import java.io.File;
import java.io.IOException;

//File Ŭ���� : ���������� �����ϱ� ���� Ŭ���� - ���� ���� ��� ����
// => ����(���丮)�� ���Ϸ� �νĵǾ� ó�� ����
public class FileApp {
	public static void main(String[] args) throws IOException {
		//File(String pathName) : ���ϰ�θ� ���޹޾� File �ν��Ͻ��� �����ϴ� ������
		//���ϰ�� : ���� ��ġ�� ǥ���ϱ� ���� ǥ����� - ������ �Ǵ� �����
		//Windows �ü���� ������ġ�� ���� ����̺꿡 ���� ���� - ���� �����ڷ� \ ���(Java������ \\�� ���)
		//Linux(Mac) �ü���� ������ġ�� ���� ���� ���丮(/)�� ���� ���� - ���� �����ڷ� / ���  
		File fileOne=new File("c:\\data");
		
		//File.exists() : File �ν��Ͻ��� ����� ���ϰ�ο� ������ ���� ���
		//false ��ȯ�ϰ� ������ ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(fileOne.exists()) {
			System.out.println("c:\\data ����(���丮)�� �����մϴ�.");
		} else {
			//File.mkdir() : File �ν��Ͻ��� ����� ���ϰ�η� ���丮�� �����ϴ� �޼ҵ�
			fileOne.mkdir();
			System.out.println("c:\\data ����(���丮)�� ���� �Ͽ����ϴ�.");
		}
		System.out.println("============================================");
		//File fileTwo=new File("c:\\data\\abc.txt");
		//���� �����ڸ� \\ ������ ��� / �����ڷ� ����ϴ� ���� ���� 
		File fileTwo=new File("c:/data/abc.txt");
		
		if(fileTwo.exists()) {
			System.out.println("c:\\data\\abc.txt ������ �����մϴ�.");
		} else {
			//File.createNewFile() : File �ν��Ͻ��� ����� ���ϰ�η� ������ �����ϴ� �޼ҵ�
			// => IOException �߻� - ����ó��
			fileTwo.createNewFile();
			System.out.println("c:\\data\\abc.txt ������ ���� �Ͽ����ϴ�.");
		}
		System.out.println("============================================");
		//File fileThree=new File("c:/data/xyz.txt");
		
		//File(File parent, String child) : ���ϰ�θ� �θ�(���丮)�� 
		//�ڽ�(����)���� �����Ͽ� File �ν��Ͻ��� �����ϴ� ������
		//File fileThree=new File(fileOne,"xyz.txt");
		
		//File(String parent, String child) : ���ϰ�θ� �θ�(���丮)�� 
		//�ڽ�(����)���� �����Ͽ� File �ν��Ͻ��� �����ϴ� ������
		File fileThree=new File("c:/data","xyz.txt");
		
		if(fileThree.exists()) {
			//File.delete() : File �ν��Ͻ��� ����� ���ϰ�η� ������ �����ϴ� �޼ҵ�
			fileThree.delete();
			System.out.println("c:\\data\\xyz.txt ������ ���� �Ͽ����ϴ�.");
		} else {
			System.out.println("c:\\data\\xyz.txt ������ �������� �ʽ��ϴ�.");
		}
		System.out.println("============================================");
		//������ ǥ����� : ����̺� �Ǵ� �ֻ��� ���丮(/)�� �������� ���ϰ�� ǥ��
		//File fileFour=new File("c:/java/workspace/java-3/src");

		//����� ǥ����� : ���� �۾����丮�� �������� ���ϰ�� ǥ��
		// => ��Ŭ������ ���� �۾����丮 : ������Ʈ ���丮
		File fileFour=new File("src");
		
		if(fileFour.exists()) {
			//File.toString() : File �ν��Ͻ��� ����� ���ϰ�θ� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
			// => ���������� ����� ��� toString() �޼ҵ� ȣ�� ���� ����
			//System.out.println("���ϰ�� = "+fileFour.toString());
			System.out.println("���ϰ�� = "+fileFour);

			//File.getAbsolutePath() : File �ν��Ͻ��� ����� ���ϰ�θ� 
			//������ ǥ������� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
			System.out.println("���ϰ�� = "+fileFour.getAbsolutePath());
		} else {
			System.out.println("����(���丮)�� �������� �ʽ��ϴ�.");
		}
		System.out.println("============================================");
		File fileFive=new File("c:/");
		
		//File.isDirectory() : File �ν��Ͻ��� ����� ���ϰ���� ������ ���丮�� 
		//�ƴ� ��� false ��ȯ�ϰ� ���丮�� ��� true ��ȯ�ϴ� �޼ҵ�
		if(fileFive.isDirectory()) {
			//File.listFiles() : File �ν��Ͻ��� ����� ���ϰ���� �ڽ� 
			//���� ����� File �ν��Ͻ� �迭�� ��ȯ�ϴ� �޼ҵ�
			File[] subFile=fileFive.listFiles();
			
			System.out.println(fileFive+" ���丮�� �ڽĸ�� >>");
			for(File file:subFile) {
				//File.isFile() : File �ν��Ͻ��� ����� ���ϰ���� ������ ������ 
				//�ƴ� ��� false ��ȯ�ϰ� ������ ��� true ��ȯ�ϴ� �޼ҵ�
				if(file.isFile()) {
					System.out.println("�Ϲ����� = "+file);
				} else {
					System.out.println("���丮 = "+file);
				}
			}
		}
		System.out.println("============================================");
		
	}
}
