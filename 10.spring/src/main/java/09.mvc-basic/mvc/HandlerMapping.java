package site.itwill09.mvc;

import java.util.HashMap;
import java.util.Map;

//Ŭ���̾�Ʈ ��û������ ó�� �ν��Ͻ��� �����ϱ� ���� �ݷ��� �ʵ尡 ����� Ŭ����
public class HandlerMapping {
	//Map - Key : ��û����(String), Value : ó�� �ν��Ͻ�(Controller)
	private Map<String, Controller> mapping;
	
	public HandlerMapping() {
		mapping=new HashMap<String, Controller>();
		//Map �ʵ��� �ʱ�ȭ �۾� �޼ҵ� ȣ��
		initConfig();
	}
	
	private void initConfig() {
		mapping.put("/list.itwill", new ListController());
		mapping.put("/view.itwill", new ViewController());
	}
	
	//Ŭ���̾�Ʈ ��û������ ���޹޾� ó�� �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
	public Controller getController(String command) {
		return mapping.get(command);
	}
}








