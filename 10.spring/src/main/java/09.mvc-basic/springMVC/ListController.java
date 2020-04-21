package site.itwill09.springMVC;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//Command Controller 클래스는 Spring Framework에서 제공하는 Controller 
//인터페이스를 상속받아 작성
public class ListController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Service 클래스의 메소드를 호출하여 데이타 처리 후 결과 반환
		List<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member("aaa", "홍길동", "hgd@itwill.site"));
		memberList.add(new Member("bbb", "임꺽정", "lim@itwill.site"));
		memberList.add(new Member("ccc", "전우치", "cwc@itwill.site"));
		
		//ModelAndView : 요청 처리결과와 응답페이지 정보를 저장하는 클래스
		ModelAndView mav=new ModelAndView();
		
		//ModelAndView.addObject(String attributeName , Object attributeValue) :
		//요청 처리결과를 추가하는 메소드
		// => request.setAttribute() 메소드와 유사한 기능을 제공
		mav.addObject("memberList", memberList);
		
		//ModelAndView.setViewName(String viewName) : 응답페이지 정보를 변경하는 메소드
		mav.setViewName("member_list");
		
		return mav;
	}

}
