package site.itwill10.dao;

import java.util.List;

import site.itwill10.dto.PointBoard;

public interface PointBoardDAO {
	int insertPointBoard(PointBoard board);
	int deletePointBoard(int num);
	PointBoard seletePointBoard(int num);
	List<PointBoard> selectPointBoardList();
}
