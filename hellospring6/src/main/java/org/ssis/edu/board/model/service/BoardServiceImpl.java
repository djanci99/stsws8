package org.ssis.edu.board.model.service;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ssis.edu.board.model.BoardDto;
import org.ssis.edu.board.model.mapper.BoardMapper;


@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper boardMapper;

	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper) {
		super();
		this.boardMapper = boardMapper;
	}

	@Override
	@Transactional
	public void writeArticle(BoardDto boardDto) throws SQLException {
		System.out.println("글입력 전 dto : " + boardDto);
		boardMapper.writeArticle(boardDto);
		System.out.println("글입력 후 dto : " + boardDto);
		
	}

	@Override
	public List<BoardDto> listArticle() throws SQLException {
		return boardMapper.listArticle();
	}

	
}
