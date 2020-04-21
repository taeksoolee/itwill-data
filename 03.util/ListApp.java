package site.itwill.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//List �������̽��� ��ӹ޴� �ڷᱸ�� Ŭ���� : ArrayList, Vector, LinkedList ��
// => ��������� ������ ������ ������ �ν��Ͻ� ���� ���� 
public class ListApp {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		
		//List.add(E element) : ������Ʈ(Element : �ν��Ͻ�)�� �߰��ϴ� �޼ҵ�
		list.add("ȫ�浿");
		list.add("�Ӳ���");
		list.add("����ġ");
		list.add("������");
		
		//List.toString() : List �ν��Ͻ��� ����� ��� ������Ʈ�� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => List �ν��Ͻ��� ����� ���������� ����� ��� ���� ����
		System.out.println("list = "+list.toString());
		System.out.println("============================================");
		list.add("�Ӳ���");
		System.out.println("list = "+list);
		System.out.println("============================================");
		//List.get(int index) : index ��ġ�� ������Ʈ�� ��ȯ�ϴ� �޼ҵ�
		System.out.println("list.get(2) = "+list.get(2));
		System.out.println("============================================");
		//List.add(int index, E element) : index ��ġ�� ������Ʈ�� �����ϴ� �޼ҵ�
		list.add(4, "����");
		
		//List.size() : ������Ʈ�� ������ ��ȯ�ϴ� �޼ҵ� 
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+"  ");
		}
		System.out.println();
		System.out.println("============================================");
		//List.remove(E element) : ���� ������ ������Ʈ�� �����ϴ� �޼ҵ�
		// => ���� ������ ������Ʈ�� ���� �� ������ ��� �տ� ��ġ�� ������Ʈ ����
		//list.remove("�Ӳ���");
		//List.remove(int index) : index ��ġ�� ������Ʈ�� �����ϴ� �޼ҵ�
		list.remove(5);
		
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+"  ");
		}
		System.out.println();
		System.out.println("============================================");
		//List.set(int index, E element) : index ��ġ�� ������Ʈ�� �����ϴ� �޼ҵ�
		list.set(1, "�Ӱ���");
		
		for(String name:list) {
			System.out.print(name+"  ");
		}
		System.out.println();
		System.out.println("============================================");
		System.out.println("���� �� = "+list);
		//Collections : List �ν��Ͻ��� ����� ������Ʈ�� ���� ����� �����ϴ� Ŭ����
		//Collections.sort(List list) : List �ν��Ͻ��� ������Ʈ�� �����ϴ� ����� �����ϴ� �޼ҵ�
		Collections.sort(list);
		System.out.println("���� �� = "+list);
		System.out.println("============================================");
		//List.clear() : ��� ������Ʈ�� �����ϴ� �޼ҵ�
		list.clear();
		
		//List.isEmpty() : ����� ������Ʈ�� ���� ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(list.isEmpty()) {
			System.out.println("������Ʈ�� �ϳ��� �����ϴ�.");
		}
		System.out.println("============================================");
		//Arrays.asList(T... a) : �迭�� List �ν��Ͻ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		List<Integer> numberList=Arrays.asList(10,20,30,40,50);
		System.out.println("numberList = "+numberList);
		System.out.println("============================================");
	}
}
