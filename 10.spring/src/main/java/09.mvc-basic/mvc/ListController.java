package site.itwill09.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//컨트롤러 클래스 : 클라이언트의 요청을 처리하는 메소드가 작성된 클래스
// => 모델 클래스 대신 컨트롤러 클래스로 표현
public class ListController implements Controller {
	//요청처리 메소드
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Service 클래스의 메소드를 호출하여 데이타 처리 후 결과 반환
		List<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member("aaa", "홍길동", "hgd@itwill.site"));
		memberList.add(new Member("bbb", "임꺽정", "lim@itwill.site"));
		memberList.add(new Member("ccc", "전우치", "cwc@itwill.site"));
		
		//처리결과(인스턴스)를 request 인스턴스에 속성으로 저장
		request.setAttribute("memberList", memberList);
		
		//처리결과를 응답하는 페이지정보 반환
		return "member_list";
	}

}






