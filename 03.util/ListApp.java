package site.itwill.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//List 인터페이스를 상속받는 자료구조 클래스 : ArrayList, Vector, LinkedList 등
// => 저장순서가 있으며 동일한 정보의 인스턴스 저장 가능 
public class ListApp {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		
		//List.add(E element) : 엘리먼트(Element : 인스턴스)를 추가하는 메소드
		list.add("홍길동");
		list.add("임꺽정");
		list.add("전우치");
		list.add("일지매");
		
		//List.toString() : List 인스턴스에 저장된 모든 엘리먼트를 문자열로 변환하여 반환하는 메소드
		// => List 인스턴스가 저장된 참조변수를 출력할 경우 생략 가능
		System.out.println("list = "+list.toString());
		System.out.println("============================================");
		list.add("임꺽정");
		System.out.println("list = "+list);
		System.out.println("============================================");
		//List.get(int index) : index 위치의 엘리먼트를 반환하는 메소드
		System.out.println("list.get(2) = "+list.get(2));
		System.out.println("============================================");
		//List.add(int index, E element) : index 위치에 엘리먼트를 삽입하는 메소드
		list.add(4, "장길산");
		
		//List.size() : 엘리먼트의 갯수를 반환하는 메소드 
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+"  ");
		}
		System.out.println();
		System.out.println("============================================");
		//List.remove(E element) : 같은 정보의 엘리먼트를 제거하는 메소드
		// => 같은 정보의 엘리먼트가 여러 개 존재할 경우 앞에 위치한 엘리먼트 제거
		//list.remove("임꺽정");
		//List.remove(int index) : index 위치의 엘리먼트를 제거하는 메소드
		list.remove(5);
		
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+"  ");
		}
		System.out.println();
		System.out.println("============================================");
		//List.set(int index, E element) : index 위치의 엘리먼트를 변경하는 메소드
		list.set(1, "임걱정");
		
		for(String name:list) {
			System.out.print(name+"  ");
		}
		System.out.println();
		System.out.println("============================================");
		System.out.println("정렬 전 = "+list);
		//Collections : List 인스턴스에 저장된 엘리먼트를 위한 기능을 제공하는 클래스
		//Collections.sort(List list) : List 인스턴스의 엘리먼트를 정렬하는 기능을 제공하는 메소드
		Collections.sort(list);
		System.out.println("정렬 후 = "+list);
		System.out.println("============================================");
		//List.clear() : 모든 엘리먼트를 제거하는 메소드
		list.clear();
		
		//List.isEmpty() : 저장된 엘리먼트가 없는 경우 true를 반환하는 메소드
		if(list.isEmpty()) {
			System.out.println("엘리먼트가 하나도 없습니다.");
		}
		System.out.println("============================================");
		//Arrays.asList(T... a) : 배열을 List 인스턴스로 변환하여 반환하는 메소드
		List<Integer> numberList=Arrays.asList(10,20,30,40,50);
		System.out.println("numberList = "+numberList);
		System.out.println("============================================");
	}
}
