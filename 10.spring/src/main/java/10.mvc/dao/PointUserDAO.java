package site.itwill10.dao;

import site.itwill10.dto.PointUser;

public interface PointUserDAO {
	int insertPointUser(PointUser user);
	int updatePointUserPlus(String id);
	int updatePointUserMinus(String id);
	PointUser selectPointUser(String id);
}
