package site.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jHelloWorldApp {
	//Logger : 로그 프로그램을 기록을 전달하기 위한 인스턴스
	//LoggerFactory.getLogger(Class<?> clazz) : 메모리에 저장된 클래스(Clazz)을
	//이용하여 기록을 전달하기 위한 Logger 인스턴스를 생성하여 반환하는 메소드
	private static final Logger logger 
		= LoggerFactory.getLogger(Log4jHelloWorldApp.class);
	
	public static void main(String[] args) {
		//Logger.info(String message) : 로그이벤트를 발생하여 메세지를 전달하는 메소드
		logger.info("시작");
		Log4jHelloWorld hw=new Log4jHelloWorld();
		String message=hw.hello("홍길동");
		System.out.println("message = "+message);
		logger.info("종료");
	}
}
