package site.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.itwill10.dto.PointBoard;
import site.itwill10.mapper.PointBoardMapper;

@Repository
public class PointBoardDAOImpl implements PointBoardDAO {
	@Autowired
	private SqlSession sqlSession;		
	
	@Override
	public int insertPointBoard(PointBoard board) {
		return sqlSession.getMapper(PointBoardMapper.class).insertPointBoard(board);
	}

	@Override
	public int deletePointBoard(int num) {
		return sqlSession.getMapper(PointBoardMapper.class).deletePointBoard(num);
	}

	@Override
	public PointBoard seletePointBoard(int num) {
		return sqlSession.getMapper(PointBoardMapper.class).selectPointBoard(num);
	}

	@Override
	public List<PointBoard> selectPointBoardList() {
		return sqlSession.getMapper(PointBoardMapper.class).selectPointBoardList();
	}

}
