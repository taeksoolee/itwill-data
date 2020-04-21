package site.itwill.mapper;

import java.util.List;

import site.itwill.dto.MyMemberDTO;

public interface MyMemberXMLInterfaceMapper {
	int insertMember(MyMemberDTO member);
	int updateMember(MyMemberDTO member);
	int deleteMember(String id);
	MyMemberDTO selectMember(String id);
	List<MyMemberDTO> selectAllMember();
}
