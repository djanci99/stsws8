package org.ssis.edu.board.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.ssis.edu.board.model.BoardDto;

//org.ssis.edu.board.model.mapper.BoardMapper
@Mapper
public interface BoardMapper {
	void writeArticle(BoardDto boardDto) throws SQLException;
	List<BoardDto> listArticle() throws SQLException;
	BoardDto getArticle(int seq) throws SQLException;
	void updateArticle(BoardDto board) throws SQLException;
	BoardDto deleteArticle(int seq) throws SQLException;
}
