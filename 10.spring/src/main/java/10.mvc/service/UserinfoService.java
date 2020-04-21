package site.itwill10.service;

import java.util.List;

import site.itwill10.dto.Userinfo;
import site.itwill10.exception.LoginAuthFailException;
import site.itwill10.exception.UserinfoExistsException;
import site.itwill10.exception.UserinfoNotFoundException;

//Service 클래스의 메소드는 기능을 구현할 경우 발생되는 예외를 외부로 전달
// => Service 클래스의 메소드를 호출하는 Controller 클래스에서 예외 처리
public interface UserinfoService {
	void addUserinfo(Userinfo userinfo) throws UserinfoExistsException;
	void modifyUserinfo(Userinfo userinfo) throws UserinfoNotFoundException;
	void removeUserinfo(String userid) throws UserinfoNotFoundException;
	Userinfo getUserinfo(String userid) throws UserinfoNotFoundException;
	List<Userinfo> getUserinfoList();
	void loginAuth(Userinfo userinfo) throws LoginAuthFailException;//인증처리 메소드
}
