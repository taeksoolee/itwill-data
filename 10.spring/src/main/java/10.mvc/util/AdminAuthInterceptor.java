package site.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import site.itwill10.dto.Userinfo;

//인터셉터 클래스는 HandlerInterceptorAdapter 클래스를 상속받아 작성
// => Spring Bean으로 등록해야만 인터셉터 클래스의 메소드 호출 

//관리자 관련 권한 처리를 위한 인터셉터 클래스
// => 관리자가 아닌 사용자인 경우 에러 페이지로 이동
public class AdminAuthInterceptor extends HandlerInterceptorAdapter {
	//preHandle() : 요청처리 메소드 호출 전 실행될 명령을 작성하는 메소드
	// => false 반환 : 요청처리 메소드 미호출, true 반환 : 요청처리 메소드 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
			//request.getRequestDispatcher("userinfo/user_error").forward(request, response);
			//return false;
			
			throw new Exception();
		}
		return true;
	}
	
	//postHandle() : 요청처리 메소드 호출 후 실행될 명령을 작성하는 메소드
	// => 요청처리 메소드에서 예외가 발생될 경우 미호출
	// => 요청처리 메소드의 반환값을 조작할 경우 사용
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
	//afterCompletion() : 요청처리 메소드 호출 후 실행될 명령을 작성하는 메소드
	// => 요청처리 메소드에서 예외가 발생될 경우 호출
	// => 예외처리를 할 경우 사용
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}








