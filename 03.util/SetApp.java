package site.itwill.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//자료구조 : 여러 개의 값들을 효율적으로 관리하는 방법 

//Set 인터페이스를 상속받는 자료구조 클래스 : HashSet, LinkedHashSet, TreeSet 등
// => 저장 순서가 없으면 동일한 정보의 인스턴스 저장 불가 
public class SetApp {
	public static void main(String[] args) {
		//제네릭 타입에 클래스를 전달하지 않으면 기본으로 Object 타입으로 설정
		//HashSet<String> set=new HashSet<String>();
		Set<String> set=new HashSet<String>();
		
		//Set.add(E element) : 엘리먼트(Element : 인스턴스)를 추가하는 메소드
		set.add("홍길동");
		//제네릭 타입의 전달된 클래스의 인스턴스가 아닌 경우 에러 발생
		//set.add(100);
		set.add("임꺽정");
		set.add("전우치");
		set.add("일지매");
		
		//Set.toString() : Set 인스턴스에 저장된 모든 엘리먼트를 문자열로 변환하여 반환하는 메소드
		// => Set 인스턴스가 저장된 참조변수를 출력할 경우 생략 가능
		System.out.println("set = "+set.toString());
		System.out.println("============================================");
		set.add("홍길동");
		System.out.println("set = "+set);
		System.out.println("============================================");
		//Set.remove(E element) : 같은 정보의 엘리먼트를 제거하는 메소드
		set.remove("임꺽정");

		//Set.size() : 저장된 엘리먼트의 갯수를 반환하는 메소드
		System.out.println("set.size() = "+set.size());
		System.out.println("============================================");
		//Set.iterator() : Set 인스턴스를 반복처리 하기 위한 Iterator 인스턴스를 반환하는 메소드
		//Iterator 인스턴스 : 반복지시자 - 엘리먼트를 반복처리 하기 위한 인스턴스 
		Iterator<String> iterator=set.iterator();
		
		//Iterator.hasNext() : 사용 가능한 엘리먼트가 존재할 경우 true을 반환하는 메소드
		while(iterator.hasNext()) {
			//Iterator.next() : 엘리먼트를 반환하여 다음 엘리먼트 위치로 이동하는 메소드
			System.out.print(iterator.next()+"  ");
		}
		System.out.println();
		System.out.println("============================================");
		//변형된 for 구문은 내부에 Iterator 인스턴스를 사용하여 반복 처리
		for(String name:set) {
			System.out.print(name+"  ");
		}
		System.out.println();
		System.out.println("============================================");
	}
}










