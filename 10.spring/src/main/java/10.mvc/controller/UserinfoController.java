package site.itwill10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import site.itwill10.dto.Userinfo;
import site.itwill10.exception.LoginAuthFailException;
import site.itwill10.exception.UserinfoExistsException;
import site.itwill10.exception.UserinfoNotFoundException;
import site.itwill10.service.UserinfoService;

@Controller
@RequestMapping("/userinfo")
public class UserinfoController {
	@Autowired
	private UserinfoService userinfoService;

	/*
	//�������� �������� ��û�� ��쿡�� ��û �޼ҵ��� ����� ����ǵ��� ���� ����
	// => �����ڰ� �ƴ� ��� ������ ���� �߻��Ͽ� ���������� ����
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(HttpSession session) {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
			//return "userinfo/user_error";
			
			//������ ���� �߻� - ����ó�� �޼ҵ尡 �����ϴ� ���
			throw new RuntimeException();
		}
		return "userinfo/user_write";
	}
	*/
	
	//���ͼ��͸� �̿��Ͽ� �����ڰ� �ƴ� ����ڰ� ��û�� ��� ��ûó�� �޼ҵ尡 ȣ����� �ʵ��� ����
	//���ͼ���(Interceptor) : Front Controller�� ���� ��ûó�� �޼ҵ� ȣ�� �� �ʿ��� ����� �����ϴ� ��� - ���� ó�� 
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "userinfo/user_write";
	}
	
	/*
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Userinfo userinfo, Model model) {
		try {
			userinfoService.addUserinfo(userinfo);
		} catch (UserinfoExistsException e) {
			model.addAttribute("message", e.getMessage());
			return "userinfo/user_write";
		} catch (Exception e) {
			e.printStackTrace();
			return "userinfo/user_error";
		}
		return "redirect:/userinfo/login";
	}
	*/
	
	//Service Ŭ������ �޼ҵ� ����� ���ܰ� �߻��� ��� �߻��� ���ܸ� ó��
	//���� �ʰ� Front Controller���� ����
	// => Front Controller�� ����ó�� �޼ҵ�(ExceptionHandler)�� ȣ���Ͽ� ���� ó��
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Userinfo userinfo) throws UserinfoExistsException {
		userinfoService.addUserinfo(userinfo);
		return "redirect:/userinfo/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "userinfo/user_login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Userinfo userinfo
			, HttpSession session) throws LoginAuthFailException, UserinfoNotFoundException {
		//���� ���� : ���� �߻�
		userinfoService.loginAuth(userinfo);
		
		//���� ���� : ���ǿ� ��������(ȸ������) ���� - ���� 
		session.setAttribute("loginUserinfo"
			, userinfoService.getUserinfo(userinfo.getUserid()));
		
		if(session.getAttribute("destURI")!=null) {
			String destURI=(String)session.getAttribute("destURI");
			session.removeAttribute("destURI");
			return "redirect:"+destURI;
		}
		
		return "userinfo/user_login";
	}

	@RequestMapping("/logout") 
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/userinfo/login";
	}
	
	/*
	//�α��� ������ ����ڰ� �������� ��û�� ��쿡�� ��û �޼ҵ��� ����� ����ǵ��� ���� ����
	@RequestMapping("/list")
	public String list(Model model, HttpSession session
			, HttpServletRequest request) {
		//�α��� ������ ����ڰ� �ƴ� ��� ������ ���� �߻��Ͽ� ���������� ����
		//if(session.getAttribute("loginUserinfo")==null) {
		//	throw new RuntimeException();
		//}
		
		//�α��� ������ ����ڰ� �ƴ� ��� �α��� �Է������� ���û
		// => �α��� ���� �� ���� ��û �������� ����ǵ��� ���� 
		if(session.getAttribute("loginUserinfo")==null) {
			String url=request.getRequestURI().substring(request.getContextPath().length());
			String query=request.getQueryString();
			if(query==null) {
				query="";
			} else {
				query="?"+query;
			}
			
			if(request.getMethod().equals("GET")) {
				session.setAttribute("destURI", url+query);
			}
			
			return "redirect:/userinfo/login";
		}
		
		model.addAttribute("userinfoList", userinfoService.getUserinfoList());
		return "userinfo/user_list";
	}
	*/
	
	//���ͼ��͸� �̿��Ͽ� �α��� ����ڰ� �ƴ� ��� ��ûó�� �޼ҵ尡 ȣ����� �ʵ��� ����
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("userinfoList", userinfoService.getUserinfoList());
		return "userinfo/user_list";
	}
	
	//���ͼ��͸� �̿��Ͽ� �α��� ����ڰ� �ƴ� ��� ��ûó�� �޼ҵ尡 ȣ����� �ʵ��� ����
	@RequestMapping("/view")
	public String view(@RequestParam String userid, Model model) throws UserinfoNotFoundException {
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_view";
	}
	
	//���ͼ��͸� �̿��Ͽ� �α��� ����ڰ� �ƴ� ��� ��ûó�� �޼ҵ尡 ȣ����� �ʵ��� ����
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(@RequestParam String userid, Model model
			, HttpSession session) throws UserinfoNotFoundException {
		//���ͼ��� �̿��Ͽ� ó�� ����
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo.getStatus()!=9 && !loginUserinfo.getUserid().equals(userid)) {
			return "userinfo/user_error";
		}
		
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute Userinfo userinfo
			, HttpSession session) throws UserinfoNotFoundException {
		userinfoService.modifyUserinfo(userinfo);
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo.getUserid().equals(userinfo.getUserid())) {
			session.setAttribute("loginUserinfo", userinfoService.getUserinfo(userinfo.getUserid()));
		}
		return "redirect:/userinfo/view?userid="+userinfo.getUserid();
	}

	//���ͼ��͸� �̿��Ͽ� �����ڰ� �ƴ� ����ڰ� ��û�� ��� ��ûó�� �޼ҵ尡 ȣ����� �ʵ��� ����
	@RequestMapping("/remove")
	public String remove(@RequestParam String userid
			, HttpSession session) throws UserinfoNotFoundException {
		userinfoService.removeUserinfo(userid);
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo.getUserid().equals(userid)) {
			return "redirect:/userinfo/logout";
		} else {
			return "redirect:/userinfo/list";
		}
	}
	
	//@ExceptionHandler : Controller Ŭ������ ��ûó�� �޼ҵ忡�� ���ܰ� 
	//�߻��� ��� ���ܸ� ó���ϱ� ���� �޼ҵ带 ����
	// => value �Ӽ��� ���� Ŭ����(Clazz)�� �Ӽ������� ����
	//����ó�� ���� ������ ����ó�� �޼ҵ��� �Ű������� �����Ͽ� �����޾� ���
	@ExceptionHandler(UserinfoExistsException.class)
	public String exceptionHandler(UserinfoExistsException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userinfo", exception.getUserinfo());
		return "userinfo/user_write";
	}
	
	@ExceptionHandler(LoginAuthFailException.class)
	public String exceptionHandler(LoginAuthFailException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userid", exception.getUserid());
		return "userinfo/user_login";
	}
	
	/*
	//Exception�� ó���ϴ� ����ó�� �޼ҵ尡 ������ ��� ���� ����
	@ExceptionHandler(UserinfoNotFoundException.class)
	public String exceptionHandler(UserinfoNotFoundException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		return "userinfo/user_error";
	}
	*/
	
	/*
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception exception) {
		exception.printStackTrace();
		return "userinfo/user_error";
	}
	*/
}






