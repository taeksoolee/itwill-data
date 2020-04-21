package site.itwill10.mapper;

import java.util.List;

import site.itwill10.dto.PointBoard;

public interface PointBoardMapper {
	int insertPointBoard(PointBoard board);
	int deletePointBoard(int num);
	PointBoard selectPointBoard(int num);
	List<PointBoard> selectPointBoardList();
}
