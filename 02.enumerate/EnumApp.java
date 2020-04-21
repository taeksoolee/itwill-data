package enumerate;

public class EnumApp {
	public static void main(String[] args) {
		//상수필드 출력 - 필드명 출력
		// => 필드값 대신 의미 있는 문자열로 표현
		System.out.println("삽입 = "+EnumOne.INSERT);
		System.out.println("변경 = "+EnumOne.UPDATE);
		System.out.println("삭제 = "+EnumOne.DELETE);
		System.out.println("검색 = "+EnumOne.SELECT);
		System.out.println("============================================");
		System.out.println("삽입 = "+EnumTwo.ADD);
		System.out.println("변경 = "+EnumTwo.MODIFY);
		System.out.println("삭제 = "+EnumTwo.ERASE);
		System.out.println("검색 = "+EnumTwo.SEARCH);
		System.out.println("============================================");
		//상수필드값을 같은 자료형의 변수에 저장 불가능
		// => 상수필드가 선언된 Enum 자료형으로 생성된 참조변수에 상수필드값 저장 가능
		// => 상수필드를 대표값으로 표현 가능
		//int choice=EnumOne.INSERT;
		
		EnumOne choice=EnumOne.INSERT;
		//다른 Enum 자료형에 선언된 상수필드값 저장 불가능
		//EnumOne choice=EnumTwo.ADD;
		System.out.println("============================================");
		//switch 구문의 변수와 동일한 Enum 자료형의 상수필드만 case 구문에서 표현 가능
		// => 상수필드가 선언된 Enum 자료형에 의미 부여
		switch (choice) {
		//case 구문에 상수필드를 선언할 경우 Enum 자료형 생략
		case INSERT:
			System.out.println("# 학생정보를 저장합니다.");
			break;
		case UPDATE:
			System.out.println("# 학생정보를 변경합니다.");
			break;
		case DELETE:
			System.out.println("# 학생정보를 삭제합니다.");
			break;
		case SELECT:
			System.out.println("# 학생정보를 검색합니다.");
			break;
		}
		System.out.println("============================================");
	}
}







