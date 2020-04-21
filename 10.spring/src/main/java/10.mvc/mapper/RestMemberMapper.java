package site.itwill10.mapper;

import java.util.List;

import site.itwill10.dto.RestMemberJSON;
import site.itwill10.dto.RestMemberXML;

public interface RestMemberMapper {
	List<RestMemberXML> selectRestMemberListXML();
	List<RestMemberJSON> selectRestMemberListJSON();
}
