package site.itwill.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import site.itwill.dto.MyComment1;
import site.itwill.dto.MyComment2;
import site.itwill.dto.MyComment3;
import site.itwill.dto.MyCommentReply;
import site.itwill.dto.MyCommentUser1;
import site.itwill.dto.MyCommentUser2;
import site.itwill.dto.MyCommentUserReplyUser;
import site.itwill.mapper.MyCommentMapper;

public class MyCommentDAO extends AbstractSession {
	private static MyCommentDAO _dao;
	
	private MyCommentDAO() {
		//TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyCommentDAO();
	}
	
	public static MyCommentDAO getDAO() {
		return _dao;
	}
	
	public int insertComment(MyComment1 comment) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyCommentMapper.class).insertComment(comment);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyComment1> selectCommentList1() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyCommentMapper.class).selectCommentList1();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyComment2> selectCommentList2() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyCommentMapper.class).selectCommentList2();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyComment3> selectCommentList3() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyCommentMapper.class).selectCommentList3();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyCommentUser1> selectCommentUserList1() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyCommentMapper.class).selectCommentUserList1();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyCommentUser2> selectCommentUserList2() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyCommentMapper.class).selectCommentUserList2();
		} finally {
			sqlSession.close();
		}
	}
	
	public MyComment1 selectComment(int commentNo) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyCommentMapper.class).selectComment(commentNo);
		} finally {
			sqlSession.close();
		}
	}
	
	public MyCommentReply selectCommentReply(int commentNo) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyCommentMapper.class).selectCommentReply(commentNo);
		} finally {
			sqlSession.close();
		}
	}
	
	public MyCommentUserReplyUser selectCommentUserReplyUser(int commentNo) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyCommentMapper.class).selectCommentUserReplyUser(commentNo);
		} finally {
			sqlSession.close();
		}
	}
}








