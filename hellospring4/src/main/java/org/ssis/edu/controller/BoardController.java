package org.ssis.edu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ssis.edu.board.model.BoardDto;
import org.ssis.edu.board.model.service.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listArticle(Model model) throws Exception {
		model.addAttribute("lists", boardService.listArticle());
		return "list";
	}
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeArticle() throws Exception {
		return "write";
	}
	@RequestMapping(value = "/write", 
			method = RequestMethod.POST)
	public String writeArticle(@ModelAttribute BoardDto board)throws Exception {
		boardService.writeArticle(board);
		return "redirect:/list";// 성공하면 로그인 화면으로 이동
	}

}
