package site.itwill10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.itwill10.dao.PointUserDAO;
import site.itwill10.dto.PointUser;

@Service
public class PointUserServiceImpl implements PointUserService {
	@Autowired
	private PointUserDAO pointUserDAO;
	
	//사용자 정보를 전달받아 POINTUSER 테이블에 저장하고 저장된 사용자 
	//정보를 검색하여 반환하는 메소드
	@Override
	public PointUser addPointUser(PointUser user) {
		//전달된 사용자의 아이디 중복 유무 검사 - 중복된 경우 인위적 예외 발생
		if(pointUserDAO.selectPointUser(user.getId())!=null) {
			throw new RuntimeException("이미 사용중인 아이디 입니다.");
		}
		//예외가 발생될 경우 하단에 존재하는 명령 미실행
		pointUserDAO.insertPointUser(user);
		return pointUserDAO.selectPointUser(user.getId());
	}

}





