package org.ssis.edu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssis.edu.board.model.BoardDto;
import org.ssis.edu.board.model.service.BoardService;
//
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BoardAjaxController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardAjaxController.class);
	
	@Autowired
	private BoardService boardService;
	//http://localhost:8090/board/api/list
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<BoardDto> listArticle(Model model) throws Exception {
		return boardService.listArticle();
	}
	
 

}

/*
[
    {
        "seq": 33,
        "id": "jim",
        "title": "sdf",
        "content": "sdafsdfsfsfsfsfsfsfsfsasa",
        "wdate": "2023-12-17T09:57:30.000+00:00",
        "ref": 0,
        "step": 0,
        "depth": 0,
        "parent": 0,
        "delflag": 0
    },
    {
        "seq": 34,
        "id": "jim",
        "title": "gpffh",
        "content": "헬로 헬로",
        "wdate": "2023-12-17T10:04:19.000+00:00",
        "ref": 0,
        "step": 0,
        "depth": 0,
        "parent": 0,
        "delflag": 0
    }
]
 * */
