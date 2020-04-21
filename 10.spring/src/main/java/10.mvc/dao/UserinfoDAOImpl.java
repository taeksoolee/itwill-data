package site.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.itwill10.dto.Userinfo;
import site.itwill10.mapper.UserinfoMapper;

@Repository
public class UserinfoDAOImpl implements UserinfoDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertUserinfo(Userinfo userinfo) {
		return sqlSession.getMapper(UserinfoMapper.class).insertUserinfo(userinfo);
	}

	@Override
	public int updateUserinfo(Userinfo userinfo) {
		return sqlSession.getMapper(UserinfoMapper.class).updateUserinfo(userinfo);
	}

	@Override
	public int deleteUserinfo(String userid) {
		return sqlSession.getMapper(UserinfoMapper.class).deleteUserinfo(userid);
	}

	@Override
	public Userinfo selectUserinfo(String userid) {
		return sqlSession.getMapper(UserinfoMapper.class).selectUserinfo(userid);
	}

	@Override
	public List<Userinfo> selectUserinfoList() {
		return sqlSession.getMapper(UserinfoMapper.class).selectUserinfoList();
	}

}
