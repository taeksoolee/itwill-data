package site.itwill10.dao;

import java.util.List;

import site.itwill10.dto.RestMemberJSON;
import site.itwill10.dto.RestMemberXML;

public interface RestMemberDAO {
	List<RestMemberXML> selectRestMemberListXML();
	List<RestMemberJSON> selectRestMemberListJSON();
}
