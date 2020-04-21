package site.itwill10.service;

import java.util.List;

import site.itwill10.dto.FileBoard;

public interface FileBoardService {
	void addFileBoard(FileBoard fileBoard);
	void removeFileBoard(int num);
	FileBoard getFileBoard(int num);
	List<FileBoard> getFileBoardList();
}
