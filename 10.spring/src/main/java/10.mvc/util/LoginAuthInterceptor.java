package site.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//�α��� ���� ���� ó���� ���� ���ͼ��� Ŭ����
// => �α��� ����ڰ� �ƴ� �α��� �Է� �������� �̵�
// => �α��� ���� �� ���� ��û �������� ����ǵ��� ���� 
public class LoginAuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		
		if(session.getAttribute("loginUserinfo")==null) {
			String url=request.getRequestURI().substring(request.getContextPath().length());
			String query=request.getQueryString();
			if(query==null) {
				query="";
			} else {
				query="?"+query;
			}
			
			if(request.getMethod().equals("GET")) {
				session.setAttribute("destURI", url+query);
			}
			
			response.sendRedirect(request.getContextPath()+"/userinfo/login");
			return false;
		}
		return true;
	}
}






