package site.itwill10.service;

import java.util.List;

import site.itwill10.dto.RestMemberJSON;
import site.itwill10.dto.RestMemberXML;

public interface RestMemberService {
	List<RestMemberXML> getRestMemberListXML();
	List<RestMemberJSON> getRestMemberListJSON();
}
