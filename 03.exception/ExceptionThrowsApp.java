package site.itwill.exception;

public class ExceptionThrowsApp {
	//메소드 내부 명령에 의해 발생되는 예외를 외부로 전달
	public static void displayArray() throws ArrayIndexOutOfBoundsException {
		int[] array={10,20,30,40,50};
		
		for(int i=0;i<=array.length;i++) {
			System.out.println("array["+i+"] = "+array[i]);
		}
	}
	
	//JVM으로 예외가 전달될 경우 자동 예외처리
	public static void main(String[] args) /* throws ArrayIndexOutOfBoundsException */ {
		//예외가 발생되는 메소드를 호출한 경우 예외처리 
		// => 메소드에서 발생되는 예외를 다시 전달 가능
		try {
			//ExceptionThrowsApp.displayArray();
			displayArray();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생 되었습니다.");
		}
	}
}




