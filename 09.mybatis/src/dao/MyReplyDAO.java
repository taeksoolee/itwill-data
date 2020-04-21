package site.itwill.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import site.itwill.dto.MyReply;
import site.itwill.dto.MyReplyUser;
import site.itwill.mapper.MyReplyMapper;

public class MyReplyDAO extends AbstractSession {
	private static MyReplyDAO _dao;
	
	private MyReplyDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyReplyDAO();
	}
	
	public static MyReplyDAO getDAO() {
		return _dao;
	}
	
	public int insertReply(MyReply reply) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyReplyMapper.class).insertReply(reply);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyReply> selectReplyList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyReplyMapper.class).selectReplyList();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyReplyUser> selectReplyUserList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyReplyMapper.class).selectReplyUserList();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyReply> selectCommentNoReplyList(int replyCommentNo) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyReplyMapper.class).selectCommentNoReplyList(replyCommentNo);
		} finally {
			sqlSession.close();
		}
	}
}





