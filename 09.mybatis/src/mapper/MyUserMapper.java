package site.itwill.mapper;

import java.util.List;

import site.itwill.dto.MyUser;

public interface MyUserMapper {
	int insertUser(MyUser user);
	List<MyUser> selectAllUser();
}







