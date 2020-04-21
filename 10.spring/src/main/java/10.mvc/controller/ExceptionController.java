package site.itwill10.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice : ����ó�� �޼ҵ常 ����� Ŭ������ ����ϴ� ������̼�
// => ��� Controller Ŭ������ ��ûó�� �޼ҵ忡�� �߻��� ����ó�� ����
@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception exception) {
		exception.printStackTrace();
		return "userinfo/user_error";
	}
}
