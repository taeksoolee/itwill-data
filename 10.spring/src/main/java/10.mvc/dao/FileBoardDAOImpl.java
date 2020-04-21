package site.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.itwill10.dto.FileBoard;
import site.itwill10.mapper.FileBoardMapper;

@Repository
public class FileBoardDAOImpl implements FileBoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertFileBoard(FileBoard fileBoard) {
		return sqlSession.getMapper(FileBoardMapper.class).insertFileBoard(fileBoard);
	}

	@Override
	public int deleteFileBoard(int num) {
		return sqlSession.getMapper(FileBoardMapper.class).deleteFileBoard(num);
	}

	@Override
	public FileBoard selectFileBoard(int num) {
		return sqlSession.getMapper(FileBoardMapper.class).selectFileBoard(num);
	}

	@Override
	public List<FileBoard> selectFileBoardList() {
		return sqlSession.getMapper(FileBoardMapper.class).selectFileBoardList();
	}

}
