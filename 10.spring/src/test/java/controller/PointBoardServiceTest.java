package site.itwill.controller;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import site.itwill10.dto.PointBoard;
import site.itwill10.dto.PointUser;
import site.itwill10.service.PointBoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
//@FixMethodOrder : 테스트 메소드의 호출 순서를 설정하는 어노테이션
// => MethodSorters Enum 자료형의 상수필드를 이용하여 호출순서 설정
// => MethodSorters.DEFAULT : 테스트 메소드의 HashCode(메모리 주소)를 이용하여 호출 순서 설정 - 실행순서 예측 불가능
// => MethodSorters.JVM : JVM이 테스트 메소드를 불러온 순서대로 호출 순서 설정 - 실행순서  예측 불가능
// => MethodSorters.NAME_ASCENDING : 테스트 메소드의 이름을 오름차순 정렬하여 호출 순서 설정 - 실행순서  예측 가능
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PointBoardServiceTest {
	private static final Logger logger=LoggerFactory.getLogger(PointBoardServiceTest.class);
	
	/*
	@Autowired
	private PointUserService pointUserService;
	
	@Test
	public void testAddPointUser() {
		PointUser user=new PointUser();
		user.setId("xyz");
		user.setName("임꺽정");
		
		PointUser addUser=pointUserService.addPointUser(user);
		
		logger.info("아이디 = "+addUser.getId()
			+", 이름 = "+addUser.getName()+", 포인트 = "+addUser.getPoint());
	}
	*/
	
	@Autowired
	private PointBoardService pointBoardService;
	
	@Test
	public void testAddPointBoard() {
		PointBoard board=new PointBoard();
		board.setWriter("xxx");
		board.setSubject("게시글 테스트");
		
		PointUser user=pointBoardService.addPointBoard(board);
		logger.info("아이디 = "+user.getId()+", 이름 = "+user.getName()+", 포인트 = "+user.getPoint());
	}
	
	/*
	@Test
	public void testErasePointBoard() {
		PointUser user=pointBoardService.erasePointBoard(2);
		logger.info("아이디 = "+user.getId()+", 이름 = "+user.getName()+", 포인트 = "+user.getPoint());
	}
	*/
	
	@Test
	public void testGetPointBoardList() {
		List<PointBoard> boardList=pointBoardService.getPointBoardList();
		for(PointBoard board:boardList) {
			logger.info("글번호 = "+board.getNum()+", 작성자 = "
					+board.getWriter()+", 제목 = "+board.getSubject());
		}
	}
}









