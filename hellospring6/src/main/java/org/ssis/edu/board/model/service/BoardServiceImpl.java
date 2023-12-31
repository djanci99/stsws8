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
	@Transactional(readOnly = true)
	public List<BoardDto> listArticle() throws SQLException {
		return boardMapper.listArticle();
	}

	@Override
	@Transactional(readOnly = true)
	public BoardDto getArticle(int seq) throws SQLException {
		return boardMapper.getArticle(seq);
	}

	@Override
	@Transactional
	public void updateArticle(BoardDto board) throws SQLException {
		System.out.println("글수정 전 dto : " + board);
		boardMapper.updateArticle(board);
		System.out.println("글수정 후 dto : " + board);
	}

	@Override
	@Transactional
	public BoardDto deleteArticle(int seq) throws SQLException {
		return boardMapper.deleteArticle(seq);
	}

	
}
