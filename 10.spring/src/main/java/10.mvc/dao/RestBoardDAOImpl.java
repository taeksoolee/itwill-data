package site.itwill10.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.itwill10.dto.RestBoard;
import site.itwill10.mapper.RestBoardMapper;

@Repository
public class RestBoardDAOImpl implements RestBoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertRestBoard(RestBoard board) {
		return sqlSession.getMapper(RestBoardMapper.class).insertRestBoard(board);
	}

	@Override
	public int updateRestBoard(RestBoard board) {
		return sqlSession.getMapper(RestBoardMapper.class).updateRestBoard(board);
	}

	@Override
	public int deleteRestBoard(int num) {
		return sqlSession.getMapper(RestBoardMapper.class).deleteRestBoard(num);
	}

	@Override
	public RestBoard selectRestBoard(int num) {
		return sqlSession.getMapper(RestBoardMapper.class).selectRestBoard(num);
	}
	
	@Override
	public int selectRestBoardCount() {
		return sqlSession.getMapper(RestBoardMapper.class).selectRestBoardCount();
	}

	@Override
	public List<RestBoard> selectRestBoardList(Map<String, Object> map) {
		return sqlSession.getMapper(RestBoardMapper.class).selectRestBoardList(map);
	}
}
