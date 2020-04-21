package site.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.itwill10.dto.RestMemberJSON;
import site.itwill10.dto.RestMemberXML;
import site.itwill10.mapper.RestMemberMapper;

@Repository
public class RestMemberDAOImpl implements RestMemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<RestMemberXML> selectRestMemberListXML() {
		return sqlSession.getMapper(RestMemberMapper.class).selectRestMemberListXML();
	}

	@Override
	public List<RestMemberJSON> selectRestMemberListJSON() {
		return sqlSession.getMapper(RestMemberMapper.class).selectRestMemberListJSON();

	}

}
