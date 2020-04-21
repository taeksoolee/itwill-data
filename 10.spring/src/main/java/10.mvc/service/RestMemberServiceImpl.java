package site.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.itwill10.dao.RestMemberDAO;
import site.itwill10.dto.RestMemberJSON;
import site.itwill10.dto.RestMemberXML;

@Service
public class RestMemberServiceImpl implements RestMemberService {
	@Autowired	
	private RestMemberDAO restMemberDAO;
	
	@Override
	public List<RestMemberXML> getRestMemberListXML() {
		return restMemberDAO.selectRestMemberListXML();
	}

	@Override
	public List<RestMemberJSON> getRestMemberListJSON() {
		return restMemberDAO.selectRestMemberListJSON();
	}

}
