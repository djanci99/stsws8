package org.ssis.edu.board.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.ssis.edu.board.model.BoardDto;

public interface BoardService {

	void writeArticle(BoardDto boardDto) throws SQLException;
	List<BoardDto> listArticle() throws SQLException;
	BoardDto getArticle(int seq) throws SQLException;
	
}
