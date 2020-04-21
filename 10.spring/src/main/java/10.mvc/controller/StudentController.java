package site.itwill10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Student;
import site.itwill10.service.StudentService;

//Controller Ŭ���� : Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� �޼ҵ尡 ����� Ŭ����
// => Service Ŭ������ �޼ҵ带 ȣ���Ͽ� Ŭ���̾�Ʈ�� ��û ó��
//@Controller : Controller ���� Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
@Controller
//��Ʈ�ѷ� Ŭ������ @RequestMapping ������̼��� ����Ͽ� ��� ��ûó�� �޼ҵ忡
//���������� �պκп� ���ԵǾ� ����Ǵ� url �ּҸ� ����
@RequestMapping("/student")
public class StudentController {
	//Service Ŭ���� ���� Spring Bean�� ������ ó���Ͽ� �ʵ忡 ����
	@Autowired
	private StudentService studentService;
	
	//@RequestMapping(value = "/student/add", method = RequestMethod.GET)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "student/add_student";
	}
	
	//@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Student student, Model model) {
		try {
			studentService.addStudent(student);
		} catch (Exception e) {
			model.addAttribute("message", "�̹� ������� �й��� �Է� �Ͽ����ϴ�.");
			return "student/add_student";
		}
		return "redirect:/student/display";
	}
	
	//@RequestMapping("/student/display")
	@RequestMapping("/display")
	public String display(Model model) {
		model.addAttribute("studentList", studentService.getStudentList());
		return "student/display_student";
	}
}






