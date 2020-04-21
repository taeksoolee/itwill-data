package site.itwill.exception;

//예외(Exception) : 프로그램의 명령 실행에 의해 발생되는 오류
// => 예외가 발생되는 명령에 대한 처리 필요 - 예외처리
// => 심각한 예외인 경우 프로그램 실행 전 예외처리를 하지 않을 경우 에러로 표시
// => 심각하지 않은 예외인 경우 JVM에 의해 자동 예외 처리 - 비권장
public class ExceptionHandleApp {
	public static void main(String[] args) {
		int[] array={10,20,30,40,50};
		
		//try 영역에 작성된 명령에서 예외가 발생되는지를 감시
		// => 예외가 발생될 경우 예외 처리 클래스로 인스턴스를 생성
		// => 예외 발생 명령 아래에 존재하는 명령 미실행 - 스레드(프로그램 흐름) 이동
		try {
			//배열 요소의 첨자가 범위를 벗어날 경우 ArrayIndexOutOfBoundsException 예외 발생
			for(int i=0;i<=array.length;i++) {
				System.out.println("array["+i+"] = "+array[i]);
			}
		
			//위 명령에서 예외가 발생될 경우 명령 미실행 
			System.out.println("[결과]프로그램을 정상적으로 실행 하였습니다.");
		} catch (ArrayIndexOutOfBoundsException e) {
			//예외가 발생될 경우 catch 영역의 명령 실행
			// => try 영역에서 발생된 해당 예외 인스턴스를 전달받아 저장하여 예외 처리
			//예외처리 : 프로그램 사용자에게 메세지를 제공하거나 개발자에게 에러로그 제공
			System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생 되었습니다.");
			
			//Throwable.getMessage() : 예외 인스턴스의 메세지를 반환하는 메소드
			//Throwable : 에러(Error)와 예외(Exception)의 부모클래스
			//System.out.println("[로그]에러 메세지 = "+e.getMessage());
			
			//Throwable.printStackTrace() : 예외가 발생된 흐름을 역으로 추적하여 출력하는 메소드 
			//e.printStackTrace();
		} finally {
			//finally 영역에는 예외와 상관없이 무조건 실행될 명령을 작성 - 사용 인스턴스 제거
			System.out.println("# 무조건 실행될 명령 #");
		}
	}
}
