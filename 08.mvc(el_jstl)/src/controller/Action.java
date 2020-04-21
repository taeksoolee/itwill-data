package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 모델클래스가 반드시 상속받아야 되는 인터페이스
// => 모델클래스의 처리메소드 작성에 대한 규칙 제공
//처리메소드는 HttpServletRequest 인스턴스와 HttpServletResponse 인스턴스를
//이용하여 요청에 대한 처리작업을 실행하고 뷰 관련 정보 반환
public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
