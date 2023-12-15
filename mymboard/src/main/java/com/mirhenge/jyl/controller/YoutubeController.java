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
@Controller
public class YoutubeController {

	private static final Logger logger = LoggerFactory.getLogger(YoutubeController.class);
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
	@Autowired
	private YoutupeParser youtupeParser;

	@Autowired
	private YoutubeService youtubeService;

	@Autowired
	private SessionHelp help;
	
	@RequestMapping(value = "yutube.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String yutube(String s_keyword, Model model) throws Exception {
		logger.debug("Welcome YoutubeController yutube-----------! " + new Date());
		ArrayList<YoutubeSave> yous=new ArrayList<>();
		if (s_keyword != null && !s_keyword.equals("")) {
			logger.debug("Welcome YoutubeController yutube!   " + s_keyword);
			// YoutupeParser parser=new YoutupeParser();
			try {
				ArrayList<String> getTitles = youtupeParser.search(s_keyword);
				//yous=youtupeParser.getTitles(s_keyword);

				//JSONParser parser = new JSONParser();
				 StringBuilder sb=new StringBuilder(); 
				 for(String st: getTitles) {
					//String aa=getYouTubeId(st);
					//if(aa!=null && !aa.equals("error")) {
				    if(st.contains("var ytInitialData = ")) {
				    	String tt=st.substring(st.indexOf("var ytInitialData = ")+"var ytInitialData = ".length());
						sb.append(tt); 
						//System.out.println("--------------------------->"+aa);
					} 
					 
				 }
				 String ts=sb.toString();
				 sb.setLength(0);
				 if(ts.contains("</script>")) {
		    		ts=ts.substring(0,ts.indexOf("</script>"));
		    		//System.out.println("-----------------<><>");
		    		sb.append(ts);
		    	 }
				 sb.setLength(sb.toString().trim().length()-1);  //";제거"

				 JSONParser jsonParser = new JSONParser();
				 
				 JSONObject result = (JSONObject)jsonParser.parse(sb.toString());
				 JSONObject contents =(JSONObject)result.get("contents");
				 JSONObject twoColumnSearchResultsRenderer =(JSONObject)contents.get("twoColumnSearchResultsRenderer");
				 JSONObject primaryContents =(JSONObject)twoColumnSearchResultsRenderer.get("primaryContents");
				 JSONObject sectionListRenderer =(JSONObject)primaryContents.get("sectionListRenderer");
				 //logger.info("Welcome YoutubeController sectionListRenderer!   " + sectionListRenderer.toJSONString());
				 JSONArray contents2 = (JSONArray)sectionListRenderer.get("contents");
				 //logger.info("Welcome YoutubeController sectionListRenderer  json!   " +contents2.toJSONString());
				 //logger.info("Welcome YoutubeController sectionListRenderer size !   " +contents2.size());
				 
				 JSONObject itemSectionRenderer =(JSONObject)contents2.get(0);
				 JSONObject tt =(JSONObject)itemSectionRenderer.get("itemSectionRenderer");
				 JSONArray contents3 = (JSONArray)tt.get("contents");
				 //String uuu="";
				 //logger.info("Welcome YoutubeController itemSectionRenderer contents size !   " +contents3.size());
				 for (int i = 0; i < contents3.size(); i++) {
					 JSONObject ttt =(JSONObject)contents3.get(i);
					 JSONObject videoRenderer =(JSONObject)ttt.get("videoRenderer");
					 JSONObject title =(JSONObject)videoRenderer.get("title");
					 JSONArray runs = (JSONArray)title.get("runs");
					 
					 JSONObject navigationEndpoint =(JSONObject)videoRenderer.get("navigationEndpoint");
					 //logger.info("Welcome YoutubeController navigationEndpoint !   "+ navigationEndpoint.toJSONString());
					 JSONObject watchEndpoint =(JSONObject)navigationEndpoint.get("watchEndpoint");
					 JSONObject commandMetadata =(JSONObject)navigationEndpoint.get("commandMetadata");
					 JSONObject webCommandMetadata =(JSONObject)commandMetadata.get("webCommandMetadata");
					 //logger.info("Welcome YoutubeController watchEndpoint !   "+ watchEndpoint.toJSONString());
					 //JSONObject videoId =(JSONObject)watchEndpoint.get("videoId");
					 //logger.info("Welcome YoutubeController title !   "+ ((JSONObject)runs.get(0)).get("text").toString());
					 //logger.info("Welcome YoutubeController videoId !   "+ watchEndpoint.get("videoId").toString());
					 //logger.info("Welcome YoutubeController url !   "+ webCommandMetadata.get("url").toString());
					 //uuu=watchEndpoint.toJSONString();
					 //logger.info("---------------------------------==============");
					 //String vname, String id, String title, String category
					 YoutubeSave you=new YoutubeSave(
							 watchEndpoint.get("videoId").toString(),
							 s_keyword,
							 ((JSONObject)runs.get(0)).get("text").toString(),
							 //webCommandMetadata.get("url").toString(),
							 s_keyword);
					 yous.add(you);
					 logger.debug("---------------------------------=============="+you);
				 }
				 
			} catch (Exception e) {
				
			}

			model.addAttribute("s_keyword", s_keyword);
		}
		model.addAttribute("bbslist", yous);
		model.addAttribute("doc_title", "Youtube Search");
		return "yutube.tiles";
	}//

	@RequestMapping(value = "youtubesave.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public YoutubeSave youtubesave(YoutubeSave you, Model model) throws Exception {
		logger.debug("Welcome YoutubeController youtubesave! " + new Date());
		logger.debug("Welcome YoutubeController youtubesave! -------------------------" + you);
		youtubeService.writeYoutube(you);
		YoutubeSave ysave = youtubeService.getYoutube(you);
		return ysave;
	}//

	@RequestMapping(value = "getyoutube.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public YesMember getyoutube(YoutubeSave you, Model model) throws Exception {
		logger.debug("Welcome YoutubeController getyoutube! " + new Date());
		logger.debug("Welcome YoutubeController getyoutube! -------------------------" + you);
		YoutubeSave ysave = youtubeService.getYoutube(you);
		YesMember yes = new YesMember();
		if (ysave != null && ysave.getId() != null) {
			yes.setMessage("SUCS"); // {"message","SUCS"}
		} else {
			yes.setMessage("FAIL");
		}
		logger.debug("Welcome YoutubeController getyoutube! -------------------------" + yes);
		return yes;
	}//


	@RequestMapping(value = "yutubelist.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String yutubelist(HttpServletRequest request, Model model) throws Exception {

		logger.debug("Welcome YoutubeController yutubelist! " + new Date());

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
