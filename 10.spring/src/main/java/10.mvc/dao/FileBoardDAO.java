package site.itwill10.dao;

import java.util.List;

import site.itwill10.dto.FileBoard;

public interface FileBoardDAO {
	int insertFileBoard(FileBoard fileBoard);
	int deleteFileBoard(int num);
	FileBoard selectFileBoard(int num);
	List<FileBoard> selectFileBoardList();
}
