package site.itwill.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import site.itwill.dto.MyHewon;
import site.itwill.mapper.MyHewonInterfaceMapper;

public class MyHewonInterfaceDAO extends AbstractSession {
	private static MyHewonInterfaceDAO _dao;
	
	private MyHewonInterfaceDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyHewonInterfaceDAO();
	}
	
	public static MyHewonInterfaceDAO getDAO() {
		return _dao;
	}
	
	public List<MyHewon> selectHewonList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonInterfaceMapper.class).selectHewonList();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectNameHewonList(String name) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonInterfaceMapper.class).selectNameHewonList(name);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectDynamicHewonList(Map<String, Object> map) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonInterfaceMapper.class).selectDynamicHewonList(map);
		} finally {
			sqlSession.close();
		}
	}
}






