package site.itwill.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//Map 인터페이스를 상속받는 자료구조 클래스 : HashMap, Hashtable 등
// => 키(Key)와 값(Value)를 하나의 쌍(Entry)으로 묶어서 관리
// => 키를 이용하여 값을 빠르게 검색하기 위해 사용
public class MapApp {
	public static void main(String[] args) {
		Map<String, String> map=new HashMap<String, String>();
		
		//Map.put(K key, V value) : 엔트리(키와 값)을 추가하는 메소드
		// => 키는 Set 인터페이스 형태로 저장되며 값은 Collection 인터페이스 형태로 저장
		// => 키를 이용하여 값이 저장되므로 저장순서 무의미 
		map.put("1000","홍길동");
		map.put("2000","임꺽정");
		map.put("3000","전우치");
		map.put("4000","일지매");
		map.put("5000","장길산");
		
		//Map.toString() : Map 인스턴스에 저장된 모든 엔트리를 문자열로 변환하여 반환하는 메소드
		// => 참조변수를 출력할 경우 생략 가능
		System.out.println("map = "+map.toString());
		System.out.println("==============================================");
		//Map.put(K key, V value) 메소드는 키가 중복될 경우 키에 대한 값 변경
		map.put("2000","임걱정");
		System.out.println("map = "+map);
		System.out.println("==============================================");
		//Map.remove(K key) : 키에 대한 엔트리를 제거하는 메소드
		map.remove("4000");
		System.out.println("map = "+map);
		System.out.println("==============================================");
		//Map.get(K key) : 키에 대한 값을 반환하는 메소드
		String name=map.get("1000");
		System.out.println("name = "+name);
		System.out.println("==============================================");
		//Map.values() : 모든 맵값(Collection 인스턴스)을 반환하는 메소드 
		Iterator<String> iteratorValue=map.values().iterator();
		
		while(iteratorValue.hasNext()) {
			System.out.print(iteratorValue.next()+"  ");
		}
		System.out.println();
		System.out.println("==============================================");
		//Map.keySet() : 모든 맵키(Set 인스턴스)을 반환하는 메소드 
		Iterator<String> iteratorKey=map.keySet().iterator();
		
		while(iteratorKey.hasNext()) {
			String key=iteratorKey.next();
			System.out.println("학번 = "+key+", 이름 = "+map.get(key));
		}
		System.out.println("==============================================");
		for(String value:map.values()) {
			System.out.print(value+"  ");
		}
		System.out.println();
		System.out.println("==============================================");
		for(String key:map.keySet()) {
			System.out.println("학번 = "+key+", 이름 = "+map.get(key));
		}
		System.out.println("==============================================");
	}
}