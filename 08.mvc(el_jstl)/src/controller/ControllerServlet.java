package site.itwill.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��Ʈ�ѷ�(Controller) : Ŭ���̾�Ʈ�� ��� ��û�� �޾� �ʿ��� ����� ��(Model)��
//����ϰ� �����ϰ� �������� ��(View)�� ����Ͽ� ���޵ǵ��� �����ϴ� ����

//1.Ŭ���̾�Ʈ�� ��� ��û�� ���� �� �ִ� ���� �������� ��� ����
//@WebServlet("URL") : ������ ����Ǳ� ���� URL �ּҸ� �����ϴ� ������̼�
// => URL �ּҿ� ���ϱ�ȣ(* �Ǵ� ?)�� �̿��Ͽ� ����
// => ex)@WebServlet("*.do") : Ŭ���̾�Ʈ�� ~.do ������ URL �ּҷ� ��û�� ��� ���� ����
//web.xml ���Ͽ� ������ ������ �� �ֵ��� ����
// => ���� Ŭ������ �ҽ����� ���� ���� �پ��� ȯ�漳�� ����
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//��û����(Key)�� �� �ν��Ͻ�(Value)�� �����ϱ� ���� �ݷ��� �ʵ�
	private Map<String, Action> actionMap;
	
	/*
	//Ŭ������ �ν��Ͻ��� �����ϱ� ���� ������ - �ʱ�ȭ �۾�
	public ControllerServlet() {
		actionMap=new HashMap<String, Action>();
	}
	*/
	
	//Ŭ���̾�Ʈ ��û�� ���� ���� Ŭ������ �ν��Ͻ��� ������ �� ���� 
	//���� �ѹ��� �ڵ� ȣ��Ǵ� �޼ҵ� - �ʱ�ȭ �۾�
	// => �Ű������� �ڵ� ����� ServletConfig �ν��Ͻ��� �̿��Ͽ� �ܺ������� ���� �����޾� �ʱ�ȭ �۾� 
	@Override
	public void init(ServletConfig config) throws ServletException {
		//System.out.println("ControllerServlet Ŭ������ init() �޼ҵ� ȣ��");
		//�ݷ��� �ʵ忡 �ν��Ͻ��� �����Ͽ� ����
		actionMap=new HashMap<String, Action>();
		
		/*
		//�ݷ��� �ʵ�(�ν��Ͻ�)�� ��û����(Key)�� �� �ν��Ͻ�(Value)�� �߰�
		// => �� �ν��Ͻ��� �̸� �����Ͽ� ������ �� �ʿ��� ��� ���� : ����ӵ� ����
		actionMap.put("/loginform.do", new LoginFormModel());
		actionMap.put("/login.do", new LoginModel());
		actionMap.put("/logout.do", new LogoutModel());
		actionMap.put("/writeform.do", new WriteFormModel());
		actionMap.put("/write.do", new WriteModel());
		actionMap.put("/list.do", new ListModel());
		actionMap.put("/view.do", new ViewModel());
		actionMap.put("/modifyform.do", new ModifyFormModel());
		actionMap.put("/modify.do", new ModifyModel());
		actionMap.put("/remove.do", new RemoveModel());
		actionMap.put("/error.do", new ErrorModel());
		*/
		
		//Properties ���Ͽ� ��û������ �� Ŭ������ �����ϰ� ������ ������
		//�о� �ݷ��� �ʵ忡 �߰� - ���������� ȿ���� ����
		//Properties ����(~.properties) : ���α׷� ���࿡ �ʿ��� ������ �����ϱ� ���� �ؽ�Ʈ ����
		
		//Properties ������ �ý��� ��θ� ��ȯ�޾� ����
		//ServletConfig.getServletContext() : ServletContext �ν��Ͻ�
		//(���ؽ�Ʈ ���� ����)�� ��ȯ�ϴ� �޼ҵ�
		//ServletContext.getRealPath(String path) : ���ؽ�Ʈ�� �����ϴ� �ڿ��� �ý��� ��θ� ��ȯ�ϴ� �޼ҵ�
		//String configFilePath=config.getServletContext().getRealPath("/WEB-INF/model.properties");
		
		//ServletConfig.getInitParameter(String name) : web.xml ������
		//������ �������� init-param ������Ʈ�� �������� ��ȯ�ϴ� �޼ҵ� 
		String configFile=config.getInitParameter("configFile");
		String configFilePath=config.getServletContext().getRealPath(configFile);
		
		//Properties �ν��Ͻ� ���� : Properties ������ ������ �����ϱ� ���� �ν��Ͻ�
		Properties properties=new Properties();
		
		try {
			//Properties ������ �б� ���� ���� �Է½�Ʈ�� ����
			FileInputStream in=new FileInputStream(configFilePath);
			
			//Properties ������ �о� Properties �ν��Ͻ��� ����
			//Properties.load(InputStream in) : ���� �Է½�Ʈ���� ���� 
			//Properties ������ ������ �о� Properties �ν��Ͻ��� �����ϴ� �޼ҵ� 
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Properties �ν��Ͻ��� ����� ������ �̿��Ͽ� �ݷ��� �ʵ忡 ��Ʈ�� �߰�
		//Properties.keySet() : Properties �ν��Ͻ��� ��� Ű���� ��ȯ�ϴ� �޼ҵ� 
		for(Object key:properties.keySet()) {
			//��û����(Key)�� ��ȯ�޾� ����
			String actionCommand=(String)key;
			
			//��Ŭ����(Value)�� ��ȯ�޾� ����
			//Properties.get(String key) : Properties �ν��Ͻ��� ����� 
			//���� Ű�� �̿��Ͽ� ��ȯ�ϴ� �޼ҵ�
			String actionClass=(String)properties.get(key);
			
			//Ŭ������ �̿��Ͽ� �ν��Ͻ� �����Ͽ� ���� - ���÷��� ��� �̿�
			//Class.forName(String className) : Ŭ�������� ���޹޾� �ش� 
			//Ŭ������ �޸𸮿� �����ϴ� �޼ҵ�
			//Class.newInstance() : �޸𸮿� ����� Ŭ������ �⺻ �����ڸ� 
			//�̿��Ͽ� �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
			try {
				Action actionObject=(Action)Class.forName(actionClass).newInstance();
				
				//�ݷ��� �ʵ忡 ��û������ �� �ν��Ͻ��� �ϳ��� ��Ʈ���� �߰�
				actionMap.put(actionCommand, actionObject);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Ŭ���̾�Ʈ�� GET �Ǵ� POST ����� ��û�� �����ϱ� ���� ȣ��Ǵ� �޼ҵ�
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("ControllerServlet Ŭ������ service() �޼ҵ� ȣ��");
		
		//2.Ŭ���̾�Ʈ�� ��û �м� : URL �ּ� �̿� - http://localhost:8000/mvc/XXX.do
		//HttpServletRequest.getRequestURI() : ��û URL �ּ��� URI ���� ��ȯ�ϴ� �޼ҵ� - /mvc/XXX.do
		String requestURI=request.getRequestURI();
		//request.getContextPath() : ��û URL �ּ��� ���ؽ�Ʈ ��θ� ��ȯ�ϴ� �޼ҵ� - /mvc
		String contextPath=request.getContextPath();
		//Ŭ���̾�Ʈ�� ��û������ ��ȯ�޾� ����
		String command=requestURI.substring(contextPath.length());
		//System.out.println("command = "+command);
		
		//3.��û������ ���� ��(Model) Ŭ������ �ν��Ͻ��� �����Ͽ� ó�� �޼ҵ� ȣ��
		// => ��(Model) Ŭ������ ó�� �޼ҵ带 �̿��Ͽ� Ŭ���̾�Ʈ ��û�� ���� ��� ����
		/*
		/loginform.do  : �α��� �Է�������(ȯ���޼��� ���������) >> LoginFormModel - "user_login.jsp" ������ �̵�
		/login.do      : �α��� ó�������� >> LoginModel - "login.do" �����̷�Ʈ �̵�
		/logout.do     : �α׾ƿ� ó�������� >> LogoutModel - "loginform.do" �����̷�Ʈ �̵�
		/writeform.do  : ȸ������ ���� �Է������� >> WriteFormModel - "user_write.jsp" ������ �̵�
		/write.do      : ȸ������ ���� ó�������� >> WriteModel - "loginform.do" �����̷�Ʈ �̵�
		/list.do       : ȸ����� ��������� >> ListModel - "user_list.jsp" ������ �̵�
		/view.do       : ȸ������ ��������� >> ViewModel - "user_view.jsp" ������ �̵�
		/modifyform.do : ȸ������ ���� �Է������� >> ModifyFormModel - "user_modify.jsp" ������ �̵�
		/modify.do     : ȸ������ ���� ó�������� >> ModifyModel - "view.do" �����̷�Ʈ �̵�
		/remove.do     : ȸ������ ���� ó�������� >> RemoveModel - "list.do" �����̷�Ʈ �̵�
		/error.do      : �����޼��� ��������� >> ErrorModel - "user_error.jsp" ������ �̵�
		*/
		
		/*
		//�������̽��� �̿��Ͽ� �������� ����
		// => ������������ �������̽��� ��ӹ��� �ڽ�Ŭ������ �ν��Ͻ� ����
		Action action=null;
		
		//��Ŭ������ �ν��Ͻ��� �����Ͽ� ����
		if(command.equals("/loginform.do")) {
			action=new LoginFormModel();
		} else if(command.equals("/login.do")) {
			action=new LoginModel();
		} else if(command.equals("/logout.do")) {
			action=new LogoutModel();
		} else if(command.equals("/writeform.do")) {
			action=new WriteFormModel();
		} else if(command.equals("/write.do")) {
			action=new WriteModel();
		} else if(command.equals("/list.do")) {
			action=new ListModel();
		} else if(command.equals("/view.do")) {
			action=new ViewModel();
		} else if(command.equals("/modifyform.do")) {
			action=new ModifyFormModel();
		} else if(command.equals("/modify.do")) {
			action=new ModifyModel();
		} else if(command.equals("/remove.do")) {
			action=new RemoveModel();
		} else if(command.equals("/error.do")) {
			action=new ErrorModel();
		} else {
			action=new ErrorModel();
		}
		*/

		//��û����(Key)�� �̿��Ͽ� �ݷ��� �ʵ忡 ����� �� �ν��Ͻ�
		//(value)�� ��ȯ�޾� �θ� ���������� ����
		Action action=actionMap.get(command);
		//��û������ ���� �� �ν��Ͻ��� �������� ���� ���
		if(action==null) {
			action=actionMap.get("/error.do");
		}
		
		//�θ� ���������� ����� �ڽ� �ν��Ͻ��� ���� �ٸ� �޼ҵ� ȣ��
		//��Ŭ������ ó���޼ҵ带 ȣ���Ͽ� ��û ���� �� �� ���� ������ ��ȯ�޾� ����
		ActionForward actionForward=action.execute(request, response);
		
		//4.��ȯ���� �� ���� ������ �̿��Ͽ� Ŭ���̾�Ʈ���� �����ϵ��� ����
		if(actionForward.isForward()) {//forward �ʵ尪�� true�� ���
			//JSP ������ ����ǵ��� ������ ó��
			request.getRequestDispatcher(actionForward.getPath()).forward(request, response);
		} else {//forward �ʵ尪�� false�� ���
			//Ŭ���̾�Ʈ�� �ٸ� �ڿ��� ��û�ϵ��� �����̷�Ʈ ó��
			response.sendRedirect(actionForward.getPath());
		}
	}
}
