package site.itwill.lang;

//String : ���ڿ��� �����ϱ� ���� Ŭ���� 
// => ���ڿ� ���� �޼ҵ� ����
public class StringApp {
	public static void main(String[] args) {
		//" " ��ȣ�� �̿��Ͽ� ���ڿ��� ����� String �ν��Ͻ� ����
		String str1="ABC";
		
		//String.toString() : String �ν��Ͻ��� ����� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
		System.out.println("str1.toString() = "+str1.toString());
		//���������� ����� ��� toString() �޼ҵ� �ڵ� ȣ��
		System.out.println("str1 = "+str1);
		System.out.println("============================================");
		//" " ��ȣ�� �̿��Ͽ� �ν��Ͻ� ǥ�� �� ��� ���� ���ڿ��� �����ϰ� �ִ� 
		//�ν��Ͻ��� ������ ��� �ν��Ͻ��� �������� �ʰ� ���� �ν��Ͻ� ����
		String str2="ABC";
		
		//���������� ���� ��� ���������� ����� �ν��Ͻ��� ���Ͽ� ��� ����
		// => String �ν��Ͻ��� ����� ���ڿ��� ���ϴ� �ƴ�
		// => ���ڿ��� ���ϱ� ���� ���� ������ ��� �Ұ���
		if(str1==str2) {
			System.out.println("str1 ���������� str2 ���������� ����� �ν��Ͻ��� �����ϴ�.");
		} else {
			System.out.println("str1 ���������� str2 ���������� ����� �ν��Ͻ��� �ٸ��ϴ�.");
		}
		System.out.println("============================================");
		//new �����ڰ� �����ڸ� �̿��Ͽ� ���ο� �ν��Ͻ� ����
		String str3=new String("ABC");
		
		if(str1==str3) {
			System.out.println("str1 ���������� str3 ���������� ����� �ν��Ͻ��� �����ϴ�.");
		} else {
			System.out.println("str1 ���������� str3 ���������� ����� �ν��Ͻ��� �ٸ��ϴ�.");
		}
		System.out.println("============================================");
		//String.equals(String another) : ���޹��� ���ڿ��� ���Ͽ� �ٸ�
		//��� false ��ȯ, ���� ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(str1.equals(str3)) {
			System.out.println("�ν��Ͻ��� ����� ���ڿ��� �����ϴ�.");
		} else {
			System.out.println("�ν��Ͻ��� ����� ���ڿ��� �ٸ��ϴ�.");
		}
		System.out.println("============================================");
		String str4="abc";
		
		//equals() �޼ҵ�� �������� ��ҹ��ڸ� �����Ͽ� ��
		if(str1.equals(str4)) {
			System.out.println("�ν��Ͻ��� ����� ���ڿ��� �����ϴ�.");
		} else {
			System.out.println("�ν��Ͻ��� ����� ���ڿ��� �ٸ��ϴ�.");
		}
		System.out.println("============================================");
		//String.equalsIgnoreCase(String another) : ��ҹ��� �������� �ʰ� �� ��� ��ȯ
		if(str1.equalsIgnoreCase(str4)) {
			System.out.println("�ν��Ͻ��� ����� ���ڿ��� �����ϴ�.");
		} else {
			System.out.println("�ν��Ͻ��� ����� ���ڿ��� �ٸ��ϴ�.");
		}
		System.out.println("============================================");
		//String.compareTo(String another) : ���ڿ��� ���Ͽ� �޼ҵ� ȣ��
		//�ν��Ͻ��� ���ڿ��� ū ��� ��� ��ȯ, ���޹��� �ν��Ͻ��� ���ڿ���
		//ū ��� ���� ��ȯ, ���� ��� 0�� ��ȯ�ϴ� �޼ҵ�
		if(str1.compareTo(str4) >= 0) {
			System.out.println("str1 �ν��Ͻ��� ���ڿ��� str4 �ν��Ͻ��� ���ڿ����� ũ�ų� �����ϴ�.");
		} else {
			System.out.println("str1 �ν��Ͻ��� ���ڿ��� str4 �ν��Ͻ��� ���ڿ����� �۽��ϴ�.");
		}
		System.out.println("============================================");
		//���ڿ��� ���������� ���ڹ迭�� ó�� - ÷��(Index)�� �̿��Ͽ� ó�� ����
		String str5="ABCDEFG";
		
		//String.length() : ���� ������ ��ȯ�ϴ� �޼ҵ�
		System.out.println("���ڿ��� ���� ���� = "+str5.length());
		System.out.println("============================================");
		//String.charAt(int index) : index ��ġ�� ���ڸ� ��ȯ�ϴ� �޼ҵ�
		System.out.println("�ι�° ��ġ�� ���� = "+str5.charAt(1));
		System.out.println("============================================");
		//String.indexOf(char ch) �Ǵ� String.indexOf(String str) : ���ڿ�����
		//���� �Ǵ� ���ڿ��� �˻��Ͽ� ����÷��(Begin Index)�� ��ȯ�ϴ� �޼ҵ�
		System.out.println("A ������ ����÷�� = "+str5.indexOf('A'));
		System.out.println("EF ���ڿ��� ����÷�� = "+str5.indexOf("EF"));
		//�˻� ����(���ڿ�)�� ���� ��� -1 ��ȯ
		System.out.println("X ���ڿ��� ����÷�� = "+str5.indexOf("X"));
		System.out.println("============================================");
		String str6="Java";
		//String.concat(String str) : ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		//str6=str6.concat(" Programming");
		
		//concat() �޼ҵ� ��� + �Ǵ� += �����ڸ� �̿��Ͽ� ���� ó��
		//str6=str6+" Programming";
		str6+=" Programming";
		System.out.println("str6 = "+str6);
		System.out.println("============================================");
		//String.toUpperCase() : ���ڿ��� �����ڸ� ��� �빮�ڷ� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		System.out.println("�빮�� ��ȯ = "+str6.toUpperCase());
		//String.toLowerCase() : ���ڿ��� �����ڸ� ��� �ҹ��ڷ� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		System.out.println("�ҹ��� ��ȯ = "+str6.toLowerCase());
		System.out.println("============================================");
		String str7="    ȫ�浿         ";
		System.out.println("�Էµ� �̸��� ["+str7+"]�Դϴ�.");
		
		//String.trim() : ���ڿ��� �հ� �ڿ� �����ϴ� ��� ������ �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		System.out.println("�Էµ� �̸��� ["+str7.trim()+"]�Դϴ�.");
		System.out.println("============================================");
		String str8="     ��   ��     ��      ";
		System.out.println("�Էµ� �̸��� ["+str8+"]�Դϴ�.");

		//String.replace(String regEx, String replacement) : ���ڿ�����
		//�˻� ���ڿ�(����ǥ����)�� ã�� ġȯ ���ڿ��� ���� �� ��ȯ�ϴ� �޼ҵ�
		System.out.println("�Էµ� �̸��� ["+str8.replace(" ","")+"]�Դϴ�.");
		System.out.println("�Էµ� �̸��� ["+str8.replace(" ","").replace("��", "��")+"]�Դϴ�.");
		System.out.println("============================================");
		String str9="010-1234-5678";
		
		System.out.println("��ȭ��ȣ = "+str9);
		
		//String.split(String regEx) : ���ڿ��� ���޹��� ���� ���ڿ�
		//(����ǥ����)�� �и��Ͽ� ���ڿ� �迭�� ��ȯ�ϴ� �޼ҵ�
		// => ����ǥ������ ��Ÿ���ڴ� \\ �ڿ� Escape ���� �������� ǥ��
		String[] array=str9.split("-");
		System.out.println("�պκ� ��ȭ��ȣ = "+array[0]);
		System.out.println("�߰��κ� ��ȭ��ȣ = "+array[1]);
		System.out.println("�޺κ� ��ȭ��ȣ = "+array[2]);
		System.out.println("============================================");
		//String.substring(int beginIndex, int endIndex) : ���ڿ�����
		//����÷��(÷����ġ ���� ����)���� ����÷��(÷����ġ ���� ������)
		//������ ���ڿ��� �и��Ͽ� ��ȯ�ϴ� �޼ҵ�
		System.out.println("�պκ� ��ȭ��ȣ = "+str9.substring(0, 3));
		System.out.println("�߰��κ� ��ȭ��ȣ = "+str9.substring(4, 8));
		//System.out.println("�޺κ� ��ȭ��ȣ = "+str9.substring(9, 13));
		//����÷�ڸ� ������ ��� �ڵ����� ���ڿ� ���������� �и��Ͽ� ��ȯ
		System.out.println("�޺κ� ��ȭ��ȣ = "+str9.substring(9));
		System.out.println("============================================");
	}
}