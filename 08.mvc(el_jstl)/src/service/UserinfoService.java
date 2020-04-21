package site.itwill.service;

import java.sql.SQLException;
import java.util.List;

import site.itwill.dao.UserinfoModelTwoDAO;
import site.itwill.dto.UserinfoDTO;
import site.itwill.exception.ExistsUserinfoException;
import site.itwill.exception.PasswordMissMatchException;
import site.itwill.exception.UserinfoNotFoundException;

//Service 클래스 : DAO 클래스의 메소드를 호출하여 모델 클래스의 요청 처리
//메소드에서 원하는 기능을 제공하기 위한 클래스 - 컴퍼넌트 클래스(모듈)
// => 어플리케이션이 원하는 기능을 제공하기 위한 메소드 작성
public class UserinfoService {
	private static UserinfoService _service;
	
	private UserinfoService() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_service=new UserinfoService();		
	}
	
	public static UserinfoService getService() {
		return _service;
	}
	
	//회원정보를 전달받아 USERINFO 테이블에 저장하는 메소드
	// => 전달된 회원정보 중 아이디가 중복될 경우 인위적 예외 발생
	public void addUserinfo(UserinfoDTO userinfo) throws SQLException, ExistsUserinfoException {
		//전달된 회원의 아이디에 대한 회원정보가 존재할 경우
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userinfo.getUserid())!=null) {
			//인위적 예외 발생
			throw new ExistsUserinfoException("이미 사용중인 아이디를 입력 하였습니다.");
		}
		//예외가 발생된 경우 하단에 존재하는 명령 미실행
		UserinfoModelTwoDAO.getDAO().insertUserinfo(userinfo);
	}
	
	//회원정보를 전달받아 USERINFO 테이블에 저장된 회원정보를 변경하는 메소드
	// => 전달된 회원정보 중 아이디의 회원정보가 없는 경우 인위적 예외 발생
	public void modifyUserinfo(UserinfoDTO userinfo) throws SQLException, UserinfoNotFoundException {
		getUserinfo(userinfo.getUserid());
		UserinfoModelTwoDAO.getDAO().updateUserinfo(userinfo);
	}
	
	//아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 삭제하는 메소드
	// => 전달된 아이디의 회원정보가 없는 경우 인위적 예외 발생
	public void removeUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		getUserinfo(userid);
		UserinfoModelTwoDAO.getDAO().deleteUserinfo(userid);
	}
	
	//아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 검색하여 반환하는 메소드
	// => 전달된 아이디의 회원정보가 없는 경우 인위적 예외 발생
	public UserinfoDTO getUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		UserinfoDTO userinfo=UserinfoModelTwoDAO.getDAO().selectUserinfo(userid);
		if(userinfo==null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 존재하지 않습니다.");
		}
		return userinfo;
	}
	
	//USERINFO 테이블에 저장된 모든 회원정보를 검색하여 반환하는 메소드
	public List<UserinfoDTO> getUserinfoList() throws SQLException {
		return UserinfoModelTwoDAO.getDAO().selectAllUserinfo();
	}
	
	//인증정보를 전달받아 인증처리하는 메소드 
	// => 인증 실패시 인위적 예외 발생
	public void login(String userid, String password) throws SQLException, UserinfoNotFoundException, PasswordMissMatchException  {
		//아이디에 대한 인증 처리 => 아이디에 대한 회원정보가 없는 경우 인위적 예외 발생
		UserinfoDTO userinfo=getUserinfo(userid);
		
		//비밀번호에 대한 인증 처리 => 비밀번호가 맞지 않는 경우 인위적 예외 발생
		if(!password.equals(userinfo.getPassword())) {
			throw new PasswordMissMatchException("입력한 아이디가 잘못 되었거나 비밀번호가 맞지 않습니다.");
		}
	}
}









