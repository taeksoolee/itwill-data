package site.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//요청처리 클래스(Model - Command Controller)가 반드시 상속받아야 되는 인터페이스
// => 인터페이스를 상속받은 모든 자식클래스가 같은 구조로 작성되도록 규칙 제공
// => 모든 자식클래스의 인스턴스를 인터페이스 참조변수에 저장하여 메소드 호출 - 다형성
public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
