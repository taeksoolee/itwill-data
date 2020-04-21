package site.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.itwill10.dao.PointBoardDAO;
import site.itwill10.dao.PointUserDAO;
import site.itwill10.dto.PointBoard;
import site.itwill10.dto.PointUser;

//Service 클래스의 메소드에서 예외가 발생된 경우 예외 발생 전 실행된 모든 DAO 
//클래스 메소드의 SQL 명령(INSERT, UPDATE, DELETE)은 반드시 ROLLBACK 처리되도록 작성
// => Spring에서는 트렌젝션을 일관성 있게 처리할 수 있도록 TransactionManager 관련 클래스를 제공
@Service
public class PointBoardServiceImpl implements PointBoardService {
	@Autowired	
	private PointBoardDAO pointBoardDAO;
	
	@Autowired
	private PointUserDAO pointUserDAO;
	
	//게시글 정보를 전달받아 POINTBOARD 테이블에 저장하고 작성자 정보를 반환하는 메소드
	// => 게시글 작성자를 전달하여 POINTUSER 테이블에 저장된 사용자의 포인트가 증가되도록 작성
	@Transactional
	@Override
	public PointUser addPointBoard(PointBoard board) {
		/*
		if(pointUserDAO.selectPointUser(board.getWriter())==null) {
			throw new RuntimeException("존재하지 않는 작성자 입니다.");
		}
		*/
		pointBoardDAO.insertPointBoard(board);
		if(pointUserDAO.selectPointUser(board.getWriter())==null) {
			throw new RuntimeException("존재하지 않는 작성자 입니다.");
		}
		pointUserDAO.updatePointUserPlus(board.getWriter());
		return pointUserDAO.selectPointUser(board.getWriter());
	}

	//게시글 번호를 전달받아 POINTBOARD 테이블에 저장된 게시글을 삭제하고 작성자 정보를 반환하는 메소드
	// => 게시글 작성자를 전달하여 POINTUSER 테이블에 저장된 사용자의 포인트가 감소되도록 작성
	@Transactional
	@Override
	public PointUser erasePointBoard(int num) {
		PointBoard board=pointBoardDAO.seletePointBoard(num);
		if(board==null) {
			throw new RuntimeException("존재하지 않는 게시글 입니다.");
		}
		String writer=board.getWriter();
		pointBoardDAO.deletePointBoard(num);
		pointUserDAO.updatePointUserMinus(writer);
		return pointUserDAO.selectPointUser(writer);
	}

	//POINTBOARD 테이블에 저장된 모든 게시글을 검색하여 반환하는 메소드
	@Override
	public List<PointBoard> getPointBoardList() {
		return pointBoardDAO.selectPointBoardList();
	}

}
