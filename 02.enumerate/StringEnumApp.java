package enumerate;

public class StringEnumApp {
	public static void main(String[] args) {
		System.out.println("삽입 = "+StringEnum.INSERT);
		System.out.println("변경 = "+StringEnum.UPDATE);
		System.out.println("삭제 = "+StringEnum.DELETE);
		System.out.println("검색 = "+StringEnum.SELECT);
		System.out.println("============================================");
		System.out.println("삽입 = "+StringEnum.INSERT.getValue());
		System.out.println("변경 = "+StringEnum.UPDATE.getValue());
		System.out.println("삭제 = "+StringEnum.DELETE.getValue());
		System.out.println("검색 = "+StringEnum.SELECT.getValue());
		System.out.println("============================================");
		//EnumType.values() : 상수필드를 배열로 변환하여 반환하는 메소드
		for(StringEnum temp:StringEnum.values()) {
			//EnumValue.ordinal() : 상수필드를 구분하기 위한 고유값을 반환하는 메소드
			System.out.println(temp+" = "+temp.ordinal());
		}
		System.out.println("============================================");
	}
}






