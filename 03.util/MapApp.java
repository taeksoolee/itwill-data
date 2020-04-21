package site.itwill.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//Map �������̽��� ��ӹ޴� �ڷᱸ�� Ŭ���� : HashMap, Hashtable ��
// => Ű(Key)�� ��(Value)�� �ϳ��� ��(Entry)���� ��� ����
// => Ű�� �̿��Ͽ� ���� ������ �˻��ϱ� ���� ���
public class MapApp {
	public static void main(String[] args) {
		Map<String, String> map=new HashMap<String, String>();
		
		//Map.put(K key, V value) : ��Ʈ��(Ű�� ��)�� �߰��ϴ� �޼ҵ�
		// => Ű�� Set �������̽� ���·� ����Ǹ� ���� Collection �������̽� ���·� ����
		// => Ű�� �̿��Ͽ� ���� ����ǹǷ� ������� ���ǹ� 
		map.put("1000","ȫ�浿");
		map.put("2000","�Ӳ���");
		map.put("3000","����ġ");
		map.put("4000","������");
		map.put("5000","����");
		
		//Map.toString() : Map �ν��Ͻ��� ����� ��� ��Ʈ���� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => ���������� ����� ��� ���� ����
		System.out.println("map = "+map.toString());
		System.out.println("==============================================");
		//Map.put(K key, V value) �޼ҵ�� Ű�� �ߺ��� ��� Ű�� ���� �� ����
		map.put("2000","�Ӱ���");
		System.out.println("map = "+map);
		System.out.println("==============================================");
		//Map.remove(K key) : Ű�� ���� ��Ʈ���� �����ϴ� �޼ҵ�
		map.remove("4000");
		System.out.println("map = "+map);
		System.out.println("==============================================");
		//Map.get(K key) : Ű�� ���� ���� ��ȯ�ϴ� �޼ҵ�
		String name=map.get("1000");
		System.out.println("name = "+name);
		System.out.println("==============================================");
		//Map.values() : ��� �ʰ�(Collection �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ� 
		Iterator<String> iteratorValue=map.values().iterator();
		
		while(iteratorValue.hasNext()) {
			System.out.print(iteratorValue.next()+"  ");
		}
		System.out.println();
		System.out.println("==============================================");
		//Map.keySet() : ��� ��Ű(Set �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ� 
		Iterator<String> iteratorKey=map.keySet().iterator();
		
		while(iteratorKey.hasNext()) {
			String key=iteratorKey.next();
			System.out.println("�й� = "+key+", �̸� = "+map.get(key));
		}
		System.out.println("==============================================");
		for(String value:map.values()) {
			System.out.print(value+"  ");
		}
		System.out.println();
		System.out.println("==============================================");
		for(String key:map.keySet()) {
			System.out.println("�й� = "+key+", �̸� = "+map.get(key));
		}
		System.out.println("==============================================");
	}
}