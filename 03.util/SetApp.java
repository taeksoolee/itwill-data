package site.itwill.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//�ڷᱸ�� : ���� ���� ������ ȿ�������� �����ϴ� ��� 

//Set �������̽��� ��ӹ޴� �ڷᱸ�� Ŭ���� : HashSet, LinkedHashSet, TreeSet ��
// => ���� ������ ������ ������ ������ �ν��Ͻ� ���� �Ұ� 
public class SetApp {
	public static void main(String[] args) {
		//���׸� Ÿ�Կ� Ŭ������ �������� ������ �⺻���� Object Ÿ������ ����
		//HashSet<String> set=new HashSet<String>();
		Set<String> set=new HashSet<String>();
		
		//Set.add(E element) : ������Ʈ(Element : �ν��Ͻ�)�� �߰��ϴ� �޼ҵ�
		set.add("ȫ�浿");
		//���׸� Ÿ���� ���޵� Ŭ������ �ν��Ͻ��� �ƴ� ��� ���� �߻�
		//set.add(100);
		set.add("�Ӳ���");
		set.add("����ġ");
		set.add("������");
		
		//Set.toString() : Set �ν��Ͻ��� ����� ��� ������Ʈ�� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => Set �ν��Ͻ��� ����� ���������� ����� ��� ���� ����
		System.out.println("set = "+set.toString());
		System.out.println("============================================");
		set.add("ȫ�浿");
		System.out.println("set = "+set);
		System.out.println("============================================");
		//Set.remove(E element) : ���� ������ ������Ʈ�� �����ϴ� �޼ҵ�
		set.remove("�Ӳ���");

		//Set.size() : ����� ������Ʈ�� ������ ��ȯ�ϴ� �޼ҵ�
		System.out.println("set.size() = "+set.size());
		System.out.println("============================================");
		//Set.iterator() : Set �ν��Ͻ��� �ݺ�ó�� �ϱ� ���� Iterator �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//Iterator �ν��Ͻ� : �ݺ������� - ������Ʈ�� �ݺ�ó�� �ϱ� ���� �ν��Ͻ� 
		Iterator<String> iterator=set.iterator();
		
		//Iterator.hasNext() : ��� ������ ������Ʈ�� ������ ��� true�� ��ȯ�ϴ� �޼ҵ�
		while(iterator.hasNext()) {
			//Iterator.next() : ������Ʈ�� ��ȯ�Ͽ� ���� ������Ʈ ��ġ�� �̵��ϴ� �޼ҵ�
			System.out.print(iterator.next()+"  ");
		}
		System.out.println();
		System.out.println("============================================");
		//������ for ������ ���ο� Iterator �ν��Ͻ��� ����Ͽ� �ݺ� ó��
		for(String name:set) {
			System.out.print(name+"  ");
		}
		System.out.println();
		System.out.println("============================================");
	}
}










