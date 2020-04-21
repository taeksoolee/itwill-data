package site.itwill.lang;

public class StringBufferApp {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();
		
		//StringBuffer.append(Object o) : ���ް��� ���ڿ��� �߰��ϴ� �޼ҵ�
		// => String �ν��Ͻ��� ���ڿ��� += �����ڿ� ���� ����� ȿ���� ����
		sb.append("ABCD").append("EFG"); 
		
		//StringBuffer.toString() : StringBuffer �ν��Ͻ��� ����� ���ڿ���
		//�̿��Ͽ� String �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		String str=sb.toString();
		
		System.out.println("str = "+str);
		System.out.println("============================================");
		//StringBuffer �ν��Ͻ��� ����� ���������� ����� ��� toString() �޼ҵ� �ڵ� ȣ��
		System.out.println("sb = "+sb);
		System.out.println("============================================");
		//StringBuffer.insert(int offset, Object o) : ���ڿ��� ���ϴ� ��ġ�� ���� �����ϴ� �޼ҵ�
		sb.insert(4, "X");
		System.out.println("sb = "+sb);
		System.out.println("============================================");
		//StringBuffer.deleteCharAt(int index) : ���ڿ����� ���ϴ� ��ġ�� ���ڸ� �����ϴ� �޼ҵ�
		sb.deleteCharAt(2);
		System.out.println("sb = "+sb);
		System.out.println("============================================");
		//StringBuffer.delete(int start, int end) : ���ڿ����� ���ϴ� ������ ���ڵ��� �����ϴ� �޼ҵ�
		sb.delete(4, 6);
		System.out.println("sb = "+sb);
		System.out.println("============================================");
		//StringBuffer.reverse() : ���ڿ��� �ݴ�� �����Ͽ� ���ġ�ϴ� �޼ҵ�
		sb.reverse();
		System.out.println("sb = "+sb);
		System.out.println("============================================");
	}
}










