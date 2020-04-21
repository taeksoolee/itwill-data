package site.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��ûó�� Ŭ����(Model - Command Controller)�� �ݵ�� ��ӹ޾ƾ� �Ǵ� �������̽�
// => �������̽��� ��ӹ��� ��� �ڽ�Ŭ������ ���� ������ �ۼ��ǵ��� ��Ģ ����
// => ��� �ڽ�Ŭ������ �ν��Ͻ��� �������̽� ���������� �����Ͽ� �޼ҵ� ȣ�� - ������
public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
