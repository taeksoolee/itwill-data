package site.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��Ʈ�ѷ�(Controller) : Ŭ���̾�Ʈ�� ��� ��û�� �޾� URL �ּҸ� �м��Ͽ� 
//��û�� ���� �� Ŭ����(Model)�� �޼ҵ带 ȣ���Ͽ� ��û ó�� �� JSP ����
//(View)�� ����ǵ��� �帧�� �����ϱ� ���� ���� Ŭ����
//=> web.xml ���Ͽ��� Ŭ������ �������� ����ϰ� ���� ������ ��Ȱ�� ����� �� �ֵ��� URL �������� ���� ó��
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Ŭ���̾�Ʈ ��û�� ó���ϱ� ���� WAS ���α׷��� �ڵ� ȣ���ϴ� �޼ҵ�
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.Ŭ���̾�Ʈ�� ��û URL �ּ� �м� - �䱸���� �ľ�
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		
		//2.��û�� ���� ��Ʈ�ѷ� Ŭ������ ó�� �޼ҵ� ȣ���ϰ� ���������� ������ ��ȯ�޾� ���� 
		// => ��û ó�� Ŭ���� : Model >> Controller
		/*
		Controller controller=null;
		if(command.equals("/list.itwill")) {
			controller=new ListController();
		} else if(command.equals("/view.itwill")) {
			controller=new ViewController();
		}
		*/

		//��û������ �����Ͽ� ó�� �ν��Ͻ��� ��ȯ�޾� ó��
		HandlerMapping handlerMapping=new HandlerMapping();
		Controller controller=handlerMapping.getController(command);
		
		//ó���޼ҵ带 ȣ���ϰ� ���������� ������ ��ȯ�޾� ����
		String view=controller.handleRequest(request, response);
		
		//3.������������ ������ �̵��Ͽ� Ŭ���̾�Ʈ���� ������ ����
		// => ��ȯ���� ������������ ������ ���������� ��ȯ�Ͽ� ������ �̵�
		ViewResolver viewResolver=new ViewResolver();
		String viewPage=viewResolver.getViewPage(view);		
		
		request.getRequestDispatcher(viewPage).forward(request, response);
	}
}








