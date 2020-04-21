package site.itwill.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import site.itwill.dto.MyHewon;
import site.itwill.mapper.MyHewonMapper;

public class MyHewonDAO extends AbstractSession {
	private static MyHewonDAO _dao;
	
	private MyHewonDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyHewonDAO();
	}
	
	public static MyHewonDAO getDAO() {
		return _dao;
	}
	
	public int insertHewon(MyHewon hewon) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).insertHewon(hewon);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectHewonList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectHewonList();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectDiscriminatorHewonList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectDiscriminatorHewonList();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectStateHewonList(int state) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectStateHewonList(state);
		} finally {
			sqlSession.close();
		}
	}
	
	public String selectBeanHewonId(MyHewon hewon) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectBeanHewonId(hewon);
		} finally {
			sqlSession.close();
		}
	}
	
	public String selectMapHewonId(Map<String, Object> map) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectMapHewonId(map);
		} finally {
			sqlSession.close();
		}
	}
	
	public String selectParamHewonId(String name, String phone) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectParamHewonId(name, phone);
		} finally {
			sqlSession.close();
		}
	}
	
	public int insertHewonMap(Map<String, Object> map) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).insertHewonMap(map);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectSearchHewonList(Map<String, Object> map) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectSearchHewonList(map);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectNameHewonList(String name) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectNameHewonList(name);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectNameDynamicHewonList(Map<String, Object> map) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectNameDynamicHewonList(map);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectDynamicHewonList(Map<String, Object> map) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectDynamicHewonList(map);
		} finally {
			sqlSession.close();
		}
	}
	
	public int updateHewon(MyHewon hewon) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).updateHewon(hewon);
		} finally {
			sqlSession.close();
		}
	}
	
	public int updateDynamicHewon(MyHewon hewon) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).updateDynamicHewon(hewon);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyHewon> selectDynamicMultiHewonList(List<String> list) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyHewonMapper.class).selectDynamicMultiHewonList(list);
		} finally {
			sqlSession.close();
		}
	}
}






