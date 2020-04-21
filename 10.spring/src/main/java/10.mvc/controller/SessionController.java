package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import site.itwill10.dto.Hewon;

@Controller
//@SessionAttributes : ��Ʈ�ѷ��� ��ûó�� �޼ҵ忡�� �����ϴ� ���� ���
//��ûó�� �޼ҵ��� ������������ ����� �� �ֵ��� �����ϴ� ������̼�
// => ���������� ���� ������ �� Request Scope�� �ƴ� Session Scope ���
// => Session Scope�� ��������� ��Ʈ�ѷ��� �ڿ��� ��� ����
// => ���� ó���� �ٸ� ��ûó�� �޼ҵ忡�� �ʿ��� ������ �����ϰų� �˻��ϴ� �۾� ����
//value �Ӽ� : Session Scope�� �����Ǳ� ���� �Ӽ����� �Ӽ������� ����
@SessionAttributes(value = "hewon")
public class SessionController {
	//���̵� ���޹޾� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ� - Service Ŭ������ �޼ҵ�
	private Hewon getHewon(String id) {
		Hewon hewon=new Hewon();
		hewon.setId(id);
		hewon.setPasswd("123456");
		hewon.setName("ȫ�浿");
		hewon.setEmail("abc@itwill.site");
		hewon.setGender("����");
		return hewon;
	}
	
	//���̵� ���޹޾� �ش� ���̵��� ȸ�������� ���������� �����ϴ� ��ûó�� �޼ҵ�
	// => ��ȯ���� ȸ�������� ���������� �Ϲ��±� ���
	@RequestMapping("/hewon_view")
	public String hewonView(Model model) {
		//ȸ�������� �˻��Ͽ� ��ȯ�޾� ���� - Service Ŭ������ �޼ҵ� ȣ��
		Hewon hewon=getHewon("abc123");
	
		//Model ��ü�� �̿��Ͽ� ������������ ���� ���� - Request Scope
		//model.addAttribute("hewon", hewon);
		
		//Model.addAttribute(Object attributeValue) : ���������� �����Ǵ� 
		//�Ӽ����� ������ ��� �����Ǵ� ���� �ڷ����� �Ӽ������� �ڵ� ����
		// => �⺻��(Wrapper) �Ǵ� ���ڿ�(String)�� �ڷ������� ����
		//@SessionAttributes ������̼ǿ� ���� Session Scope�� ����
		model.addAttribute(hewon);
		
		return "session/hewon_view";
	}
	
	/*
	//���̵� ���޹޾� �ش� ���̵��� ȸ�������� ���������� �����ϴ� ��ûó�� �޼ҵ�
	// => ��ȯ���� ȸ�������� ���������� �Է��±׿� ���
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String hewonUpdate(@RequestParam String id, Model model) {
		Hewon hewon=getHewon(id);
		model.addAttribute(hewon);
		return "session/hewon_update";
	}
	*/
	
	//Session Scope�� ���� ȸ�������� �����ǹǷ� ���̵� �̿��� ȸ������
	//�˻� ��� ���ʿ�
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String hewonUpdate() {
		return "session/hewon_update";
	}
	
	//������ ȸ�������� ���޹޾� ȸ�������� �����ϴ� ��ûó�� �޼ҵ�
	//Session Scope�� �����Ǵ� ȸ�������� Command ��ü�� �ڵ� ���� ��
	//�Է°��� �����޾� Command ��ü�� �ʵ忡 ����
	//SessionStatus : @SessionAttributes ������̼ǿ� ���� �����Ǵ� ����
	//���������� �����ϴ� �ν��Ͻ�
	@RequestMapping(value = "/hewon_update", method = RequestMethod.POST)
	public String hewonUpdate(@ModelAttribute Hewon hewon
			, SessionStatus status) {
		//�Է°��� ���޵��� �ʾƵ� Session Scope�� ������ ȸ������ ���
		//System.out.println("���̵� = "+hewon.getId());
		
		//SessionStatus.setComplete() : @SessionAttributes ������̼ǿ� 
		//���� �����Ǵ� ���� �����ϴ� �޼ҵ�
		status.setComplete();
		
		return "session/hewon_view";
	}
}








