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
//@FixMethodOrder : �׽�Ʈ �޼ҵ��� ȣ�� ������ �����ϴ� ������̼�
// => MethodSorters Enum �ڷ����� ����ʵ带 �̿��Ͽ� ȣ����� ����
// => MethodSorters.DEFAULT : �׽�Ʈ �޼ҵ��� HashCode(�޸� �ּ�)�� �̿��Ͽ� ȣ�� ���� ���� - ������� ���� �Ұ���
// => MethodSorters.JVM : JVM�� �׽�Ʈ �޼ҵ带 �ҷ��� ������� ȣ�� ���� ���� - �������  ���� �Ұ���
// => MethodSorters.NAME_ASCENDING : �׽�Ʈ �޼ҵ��� �̸��� �������� �����Ͽ� ȣ�� ���� ���� - �������  ���� ����
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
		user.setName("�Ӳ���");
		
		PointUser addUser=pointUserService.addPointUser(user);
		
		logger.info("���̵� = "+addUser.getId()
			+", �̸� = "+addUser.getName()+", ����Ʈ = "+addUser.getPoint());
	}
	*/
	
	@Autowired
	private PointBoardService pointBoardService;
	
	@Test
	public void testAddPointBoard() {
		PointBoard board=new PointBoard();
		board.setWriter("xxx");
		board.setSubject("�Խñ� �׽�Ʈ");
		
		PointUser user=pointBoardService.addPointBoard(board);
		logger.info("���̵� = "+user.getId()+", �̸� = "+user.getName()+", ����Ʈ = "+user.getPoint());
	}
	
	/*
	@Test
	public void testErasePointBoard() {
		PointUser user=pointBoardService.erasePointBoard(2);
		logger.info("���̵� = "+user.getId()+", �̸� = "+user.getName()+", ����Ʈ = "+user.getPoint());
	}
	*/
	
	@Test
	public void testGetPointBoardList() {
		List<PointBoard> boardList=pointBoardService.getPointBoardList();
		for(PointBoard board:boardList) {
			logger.info("�۹�ȣ = "+board.getNum()+", �ۼ��� = "
					+board.getWriter()+", ���� = "+board.getSubject());
		}
	}
}









