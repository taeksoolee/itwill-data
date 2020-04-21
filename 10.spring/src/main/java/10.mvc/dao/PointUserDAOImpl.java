package site.itwill10.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.itwill10.dto.PointUser;
import site.itwill10.mapper.PointUserMapper;

@Repository
public class PointUserDAOImpl implements PointUserDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertPointUser(PointUser user) {
		return sqlSession.getMapper(PointUserMapper.class).insertPointUser(user);
	}

	@Override
	public int updatePointUserPlus(String id) {
		return sqlSession.getMapper(PointUserMapper.class).updatePointUserPlus(id);
	}

	@Override
	public int updatePointUserMinus(String id) {
		return sqlSession.getMapper(PointUserMapper.class).updatePointUserMinus(id);
	}

	@Override
	public PointUser selectPointUser(String id) {
		return sqlSession.getMapper(PointUserMapper.class).selectPointUser(id);
	}

}
