package site.itwill.lang;

public class StringBufferApp {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();
		
		//StringBuffer.append(Object o) : 전달값을 문자열에 추가하는 메소드
		// => String 인스턴스의 문자열을 += 연산자와 같이 사용한 효과와 동일
		sb.append("ABCD").append("EFG"); 
		
		//StringBuffer.toString() : StringBuffer 인스턴스에 저장된 문자열을
		//이용하여 String 인스턴스를 생성하여 반환하는 메소드
		String str=sb.toString();
		
		System.out.println("str = "+str);
		System.out.println("============================================");
		//StringBuffer 인스턴스가 저장된 참조변수를 출력할 경우 toString() 메소드 자동 호출
		System.out.println("sb = "+sb);
		System.out.println("============================================");
		//StringBuffer.insert(int offset, Object o) : 문자열의 원하는 위치에 값을 삽입하는 메소드
		sb.insert(4, "X");
		System.out.println("sb = "+sb);
		System.out.println("============================================");
		//StringBuffer.deleteCharAt(int index) : 문자열에서 원하는 위치의 문자를 제거하는 메소드
		sb.deleteCharAt(2);
		System.out.println("sb = "+sb);
		System.out.println("============================================");
		//StringBuffer.delete(int start, int end) : 문자열에서 원하는 범위의 문자들을 제거하는 메소드
		sb.delete(4, 6);
		System.out.println("sb = "+sb);
		System.out.println("============================================");
		//StringBuffer.reverse() : 문자열을 반대로 나열하여 재배치하는 메소드
		sb.reverse();
		System.out.println("sb = "+sb);
		System.out.println("============================================");
	}
}










