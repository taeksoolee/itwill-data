package site.itwill10.mapper;

import site.itwill10.dto.PointUser;

public interface PointUserMapper {
	int insertPointUser(PointUser user);
	int updatePointUserPlus(String id);
	int updatePointUserMinus(String id);
	PointUser selectPointUser(String id);
}
