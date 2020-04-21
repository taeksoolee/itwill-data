package site.itwill09.springMVC;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//Command Controller Ŭ������ Spring Framework���� �����ϴ� Controller 
//�������̽��� ��ӹ޾� �ۼ�
public class ListController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Service Ŭ������ �޼ҵ带 ȣ���Ͽ� ����Ÿ ó�� �� ��� ��ȯ
		List<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member("aaa", "ȫ�浿", "hgd@itwill.site"));
		memberList.add(new Member("bbb", "�Ӳ���", "lim@itwill.site"));
		memberList.add(new Member("ccc", "����ġ", "cwc@itwill.site"));
		
		//ModelAndView : ��û ó������� ���������� ������ �����ϴ� Ŭ����
		ModelAndView mav=new ModelAndView();
		
		//ModelAndView.addObject(String attributeName , Object attributeValue) :
		//��û ó������� �߰��ϴ� �޼ҵ�
		// => request.setAttribute() �޼ҵ�� ������ ����� ����
		mav.addObject("memberList", memberList);
		
		//ModelAndView.setViewName(String viewName) : ���������� ������ �����ϴ� �޼ҵ�
		mav.setViewName("member_list");
		
		return mav;
	}

}
