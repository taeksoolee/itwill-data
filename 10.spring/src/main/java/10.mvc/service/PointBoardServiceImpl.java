package site.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.itwill10.dao.PointBoardDAO;
import site.itwill10.dao.PointUserDAO;
import site.itwill10.dto.PointBoard;
import site.itwill10.dto.PointUser;

//Service Ŭ������ �޼ҵ忡�� ���ܰ� �߻��� ��� ���� �߻� �� ����� ��� DAO 
//Ŭ���� �޼ҵ��� SQL ���(INSERT, UPDATE, DELETE)�� �ݵ�� ROLLBACK ó���ǵ��� �ۼ�
// => Spring������ Ʈ�������� �ϰ��� �ְ� ó���� �� �ֵ��� TransactionManager ���� Ŭ������ ����
@Service
public class PointBoardServiceImpl implements PointBoardService {
	@Autowired	
	private PointBoardDAO pointBoardDAO;
	
	@Autowired
	private PointUserDAO pointUserDAO;
	
	//�Խñ� ������ ���޹޾� POINTBOARD ���̺� �����ϰ� �ۼ��� ������ ��ȯ�ϴ� �޼ҵ�
	// => �Խñ� �ۼ��ڸ� �����Ͽ� POINTUSER ���̺� ����� ������� ����Ʈ�� �����ǵ��� �ۼ�
	@Transactional
	@Override
	public PointUser addPointBoard(PointBoard board) {
		/*
		if(pointUserDAO.selectPointUser(board.getWriter())==null) {
			throw new RuntimeException("�������� �ʴ� �ۼ��� �Դϴ�.");
		}
		*/
		pointBoardDAO.insertPointBoard(board);
		if(pointUserDAO.selectPointUser(board.getWriter())==null) {
			throw new RuntimeException("�������� �ʴ� �ۼ��� �Դϴ�.");
		}
		pointUserDAO.updatePointUserPlus(board.getWriter());
		return pointUserDAO.selectPointUser(board.getWriter());
	}

	//�Խñ� ��ȣ�� ���޹޾� POINTBOARD ���̺� ����� �Խñ��� �����ϰ� �ۼ��� ������ ��ȯ�ϴ� �޼ҵ�
	// => �Խñ� �ۼ��ڸ� �����Ͽ� POINTUSER ���̺� ����� ������� ����Ʈ�� ���ҵǵ��� �ۼ�
	@Transactional
	@Override
	public PointUser erasePointBoard(int num) {
		PointBoard board=pointBoardDAO.seletePointBoard(num);
		if(board==null) {
			throw new RuntimeException("�������� �ʴ� �Խñ� �Դϴ�.");
		}
		String writer=board.getWriter();
		pointBoardDAO.deletePointBoard(num);
		pointUserDAO.updatePointUserMinus(writer);
		return pointUserDAO.selectPointUser(writer);
	}

	//POINTBOARD ���̺� ����� ��� �Խñ��� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	@Override
	public List<PointBoard> getPointBoardList() {
		return pointBoardDAO.selectPointBoardList();
	}

}
