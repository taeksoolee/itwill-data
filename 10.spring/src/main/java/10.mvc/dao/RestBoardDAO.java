package site.itwill10.dao;

import java.util.List;
import java.util.Map;

import site.itwill10.dto.RestBoard;

public interface RestBoardDAO {
	int insertRestBoard(RestBoard board);
	int updateRestBoard(RestBoard board);
	int deleteRestBoard(int num);
	RestBoard selectRestBoard(int num);
	int selectRestBoardCount();
	List<RestBoard> selectRestBoardList(Map<String, Object> map);
}
