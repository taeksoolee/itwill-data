package site.itwill09.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��Ʈ�ѷ� Ŭ���� : Ŭ���̾�Ʈ�� ��û�� ó���ϴ� �޼ҵ尡 �ۼ��� Ŭ����
// => �� Ŭ���� ��� ��Ʈ�ѷ� Ŭ������ ǥ��
public class ListController implements Controller {
	//��ûó�� �޼ҵ�
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Service Ŭ������ �޼ҵ带 ȣ���Ͽ� ����Ÿ ó�� �� ��� ��ȯ
		List<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member("aaa", "ȫ�浿", "hgd@itwill.site"));
		memberList.add(new Member("bbb", "�Ӳ���", "lim@itwill.site"));
		memberList.add(new Member("ccc", "����ġ", "cwc@itwill.site"));
		
		//ó�����(�ν��Ͻ�)�� request �ν��Ͻ��� �Ӽ����� ����
		request.setAttribute("memberList", memberList);
		
		//ó������� �����ϴ� ���������� ��ȯ
		return "member_list";
	}

}






