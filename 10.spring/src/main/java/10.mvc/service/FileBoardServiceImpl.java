package site.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.itwill10.dao.FileBoardDAO;
import site.itwill10.dto.FileBoard;

@Service
public class FileBoardServiceImpl implements FileBoardService {
	@Autowired
	private FileBoardDAO fileBoardDAO;
	
	@Transactional
	@Override
	public void addFileBoard(FileBoard fileBoard) {
		fileBoardDAO.insertFileBoard(fileBoard);
	}

	@Transactional
	@Override
	public void removeFileBoard(int num) {
		fileBoardDAO.deleteFileBoard(num);
	}

	@Override
	public FileBoard getFileBoard(int num) {
		return fileBoardDAO.selectFileBoard(num);
	}

	@Override
	public List<FileBoard> getFileBoardList() {
		return fileBoardDAO.selectFileBoardList();
	}

}
