package site.itwill09.mvc;

//���������� �����ϴ� ����� Ŭ����
public class ViewResolver {
	//���ڿ��� ���޹޾� ������ ��������(JSP ����)�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ� 
	// => "/WEB-INF" ���丮�� JSP ������ �ۼ��Ͽ� Ŭ���̾�Ʈ�� ��û �ź�
	public String getViewPage(String view) {
		return "/WEB-INF/mvc/"+view+".jsp";
	}
}
