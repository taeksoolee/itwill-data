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
	//관리지가 페이지를 요청한 경우에만 요청 메소드의 명령이 실행되도록 권한 설정
	// => 관리자가 아닌 경우 인위적 예외 발생하여 에레페이지 응답
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(HttpSession session) {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
			//return "userinfo/user_error";
			
			//인위적 예외 발생 - 예외처리 메소드가 존재하는 경우
			throw new RuntimeException();
		}
		return "userinfo/user_write";
	}
	*/
	
	//인터셉터를 이용하여 관리자가 아닌 사용자가 요청한 경우 요청처리 메소드가 호출되지 않도록 설정
	//인터셉터(Interceptor) : Front Controller에 의해 요청처리 메소드 호출 전 필요한 명령을 실행하는 기능 - 권한 처리 
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
	
	//Service 클래스의 메소드 실행시 예외가 발생될 경우 발생된 예외를 처리
	//하지 않고 Front Controller에게 전달
	// => Front Controller는 예외처리 메소드(ExceptionHandler)를 호출하여 예외 처리
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
		//인증 실패 : 예외 발생
		userinfoService.loginAuth(userinfo);
		
		//인증 성공 : 세션에 인증정보(회원정보) 저장 - 권한 
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
	//로그인 상태의 사용자가 페이지를 요청한 경우에만 요청 메소드의 명령이 실행되도록 권한 설정
	@RequestMapping("/list")
	public String list(Model model, HttpSession session
			, HttpServletRequest request) {
		//로그인 상태의 사용자가 아닌 경우 인위적 예외 발생하여 에레페이지 응답
		//if(session.getAttribute("loginUserinfo")==null) {
		//	throw new RuntimeException();
		//}
		
		//로그인 상태의 사용자가 아닌 경우 로그인 입력페이지 재요청
		// => 로그인 성공 후 기존 요청 페이지로 응답되도록 설정 
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
	
	//인터셉터를 이용하여 로그인 사용자가 아닌 경우 요청처리 메소드가 호출되지 않도록 설정
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("userinfoList", userinfoService.getUserinfoList());
		return "userinfo/user_list";
	}
	
	//인터셉터를 이용하여 로그인 사용자가 아닌 경우 요청처리 메소드가 호출되지 않도록 설정
	@RequestMapping("/view")
	public String view(@RequestParam String userid, Model model) throws UserinfoNotFoundException {
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_view";
	}
	
	//인터셉터를 이용하여 로그인 사용자가 아닌 경우 요청처리 메소드가 호출되지 않도록 설정
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(@RequestParam String userid, Model model
			, HttpSession session) throws UserinfoNotFoundException {
		//인터셉터 이용하여 처리 가능
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

	//인터셉터를 이용하여 관리자가 아닌 사용자가 요청한 경우 요청처리 메소드가 호출되지 않도록 설정
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
	
	//@ExceptionHandler : Controller 클래스의 요청처리 메소드에서 예외가 
	//발생된 경우 예외를 처리하기 위한 메소드를 설정
	// => value 속성에 예외 클래스(Clazz)를 속성값으로 설정
	//예외처리 관련 정보를 예외처리 메소드의 매개변수를 선언하여 제공받아 사용
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
	//Exception를 처리하는 예외처리 메소드가 존재할 경우 생략 가능
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






