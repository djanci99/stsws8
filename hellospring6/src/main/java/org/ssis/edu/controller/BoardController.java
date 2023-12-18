package org.ssis.edu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writeArticle(@ModelAttribute BoardDto board)throws Exception {
		boardService.writeArticle(board);
		return "redirect:/list";// 성공하면 목록
	}
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam int seq, Model model) throws Exception {
		logger.debug("detail    {}.  ", seq);
		model.addAttribute("board", boardService.getArticle(seq));
		return "detail"; //상세보기
	}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam int seq, Model model) throws Exception {
		logger.debug("update    {}.  ", seq);
		model.addAttribute("board", boardService.getArticle(seq));
		return "update"; //상세보기
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateaf(@ModelAttribute BoardDto board, RedirectAttributes red)throws Exception {
		logger.debug("updateaf====={}.  ", board);
		boardService.updateArticle(board);
		red.addAttribute("seq",board.getSeq());
		return "redirect:/detail";// 성공하면 상세
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam int seq, RedirectAttributes red) throws Exception {
		logger.debug("delete    {}.  ", seq);
		boardService.deleteArticle(seq);
		return "redirect:/list"; //상세보기
	}
}
