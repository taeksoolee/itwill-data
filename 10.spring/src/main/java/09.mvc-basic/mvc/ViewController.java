package site.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member member=new Member("aaa", "ȫ�浿", "hong@itwill.site");
		request.setAttribute("member", member);
		return "member_view";
	}
}






