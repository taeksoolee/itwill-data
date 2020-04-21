package site.itwill.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import site.itwill.dto.MyUser;
import site.itwill.mapper.MyUserMapper;

public class MyUserDAO extends AbstractSession {
	private static MyUserDAO _dao;
	
	private MyUserDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyUserDAO();
	}
	
	public static MyUserDAO getDAO() {
		return _dao;
	}
	
	public int insertUser(MyUser user) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyUserMapper.class).insertUser(user);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyUser> selectAllUser() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyUserMapper.class).selectAllUser();
		} finally {
			sqlSession.close();
		}
	}
}



