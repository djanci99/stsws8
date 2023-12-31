package org.ssis.edu.board.model.service;

import java.util.List;
import java.util.Map;

import org.ssis.edu.board.model.BoardDto;
import org.ssis.edu.util.PageNavigation;

public interface BoardService {

	void writeArticle(BoardDto boardDto) throws Exception;
	List<BoardDto> listArticle(Map<String, String> map) throws Exception;
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	BoardDto getArticle(int articleNo) throws Exception;
	void updateHit(int articleNo) throws Exception;
	
	void modifyArticle(BoardDto boardDto) throws Exception;
	void deleteArticle(int articleNo, String path) throws Exception;
	
}
