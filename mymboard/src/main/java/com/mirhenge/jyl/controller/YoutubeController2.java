package com.mirhenge.jyl.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mirhenge.jyl.mboard.help.YesMember;
import com.mirhenge.jyl.member.model.JYLMember;
import com.mirhenge.jyl.session.SessionHelp;
import com.mirhenge.jyl.you.Youtube;
import com.mirhenge.jyl.you.YoutupeParser;
import com.mirhenge.jyl.you.dao.YoutubeService;
import com.mirhenge.jyl.you.model.YoutubeSave;

//@Controller
public class YoutubeController2 {

	private static final Logger logger = LoggerFactory.getLogger(YoutubeController2.class);
	@Autowired
	private SessionHelp help;
	
	private String getYouTubeId (String youTubeUrl) {
		//videoId
		//String pattern = "(videoId)[^#\\&\\?]*";
	    String pattern = "(watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";
	    Pattern compiledPattern = Pattern.compile(pattern);
	    Matcher matcher = compiledPattern.matcher(youTubeUrl);
	    if(matcher.find()){
	        return matcher.group();
	    } else {
	        return "error";  
	    }
	}

	
	@Autowired private YoutupeParser youtupeParser;
	@Autowired
	private YoutubeService youtubeService;

	@RequestMapping(value = "yutube.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String yutube(String s_keyword, Model model) throws Exception {
		logger.info("Welcome YoutubeController yutube-----------! " + new Date());
		ArrayList<YoutubeSave> yous=new ArrayList<>();
		//YoutupeParser youtupeParser =new YoutupeParser();
		if (s_keyword != null && !s_keyword.equals("")) {
			logger.info("Welcome YoutubeController yutube!   " + s_keyword);
			try {
				yous=youtupeParser.getTitles(s_keyword);
			} catch (Exception e) {
				logger.info("Welcome YoutubeController error!   " + e);
			}
			model.addAttribute("s_keyword", s_keyword);
		}
		model.addAttribute("bbslist", yous);
		model.addAttribute("doc_title", "Youtube"+yous.size());
		return "yutube.tiles";
	}//

	@RequestMapping(value = "youtubesave.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public YoutubeSave youtubesave(YoutubeSave you, Model model) throws Exception {
		logger.info("Welcome YoutubeController youtubesave! " + new Date());
		logger.info("Welcome YoutubeController youtubesave! -------------------------" + you);
		youtubeService.writeYoutube(you);
		model.addAttribute("doc_title", "Youtube");
		YoutubeSave ysave = youtubeService.getYoutube(you);
		return ysave;
	}//

	@RequestMapping(value = "getyoutube.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public YesMember getyoutube(YoutubeSave you, Model model) throws Exception {
		logger.info("Welcome YoutubeController getyoutube! " + new Date());
		logger.info("Welcome YoutubeController getyoutube! -------------------------" + you);
		YoutubeSave ysave = youtubeService.getYoutube(you);
		YesMember yes = new YesMember();
		if (ysave != null && ysave.getId() != null) {
			yes.setMessage("SUCS"); // {"message","SUCS"}
		} else {
			yes.setMessage("FAIL");
		}
		logger.info("Welcome YoutubeController getyoutube! -------------------------" + yes);
		return yes;
	}//

	@RequestMapping(value = "yutubelist.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String yutubelist(HttpServletRequest request, Model model) throws Exception {

		logger.info("Welcome YoutubeController yutubelist! " + new Date());

		String id = "";
		try {
			id = help.getId(request);
		} catch (Exception e) {
			return "redirect:/login.do";
		}
		YoutubeSave you = new YoutubeSave();
		you.setId(id);
		List<YoutubeSave> getTitles = youtubeService.getYoutubeList(you);
		model.addAttribute("bbslist", getTitles);
		model.addAttribute("doc_title", "Youtube Saved");
		return "yutubelist.tiles";
	}//

}
