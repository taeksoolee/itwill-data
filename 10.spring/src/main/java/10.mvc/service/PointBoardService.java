package site.itwill10.service;

import java.util.List;

import site.itwill10.dto.PointBoard;
import site.itwill10.dto.PointUser;

public interface PointBoardService {
	PointUser addPointBoard(PointBoard board);
	PointUser erasePointBoard(int num);
	List<PointBoard> getPointBoardList();
}
