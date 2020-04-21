package enumerate;

//클래스(인터페이스)에서 상수필드를 선언할 경우 단점 - 나열형(EnumType) 이용
// => 의미있는 문자열로 표현할 수 없으며 값을 대표적으로 표현하기 부적절
// => 상수필드가 선언된 클래스(인터페이스) 무의미
public class InterfaceApp {
	public static void main(String[] args) {
		//상수필드 출력 => 필드값 출력
		System.out.println("삽입 = "+InterfaceOne.INSERT);
		System.out.println("변경 = "+InterfaceOne.UPDATE);
		System.out.println("삭제 = "+InterfaceOne.DELETE);
		System.out.println("검색 = "+InterfaceOne.SELECT);
		System.out.println("============================================");
		System.out.println("삽입 = "+InterfaceTwo.ADD);
		System.out.println("변경 = "+InterfaceTwo.MODIFY);
		System.out.println("삭제 = "+InterfaceTwo.ERASE);
		System.out.println("검색 = "+InterfaceTwo.SEARCH);
		System.out.println("============================================");
		//상수필드와 동일한 자료형의 변수에 필드값 저장 가능
		//int choice=InterfaceOne.INSERT;
		int choice=InterfaceTwo.ADD;
		
		System.out.println("선택 = "+choice);
		System.out.println("============================================");
		switch (choice) {
		//case 구문에 값 대신 상수필드 사용 가능
		case InterfaceOne.INSERT:
			System.out.println("# 학생정보를 저장합니다.");
			break;
		case InterfaceOne.UPDATE:
			System.out.println("# 학생정보를 변경합니다.");
			break;
		case InterfaceOne.DELETE:
			System.out.println("# 학생정보를 삭제합니다.");
			break;
		case InterfaceOne.SELECT:
			System.out.println("# 학생정보를 검색합니다.");
			break;
		}
		System.out.println("============================================");
	}
}
