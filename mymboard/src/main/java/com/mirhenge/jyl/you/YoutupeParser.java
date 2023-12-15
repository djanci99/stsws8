package com.mirhenge.jyl.you;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import java.net.MalformedURLException;

import java.net.URL;

import java.net.URLDecoder;

import java.net.URLEncoder;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.mirhenge.jyl.you.model.YoutubeSave;


 
@Component
public class YoutupeParser{
	
	public YoutupeParser() {
		 //htmls = new ArrayList<>();
		 //urls = "https://www.youtube.com/results?search_query=";
	}

	String urls = "https://www.youtube.com/results?search_query=";
	ArrayList<String> htmls = new ArrayList<>();
	
	 
	public  ArrayList<String> search(String s){
		//htmls.clear();
		urls = "https://www.youtube.com/results?search_query=";
		htmls = new ArrayList<>();
		BufferedReader br = null;
		try 
		{
			String ss = URLEncoder.encode(s, "utf-8");
			System.out.println(ss);
			URL url = new URL(urls + ss);
			br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
			String msg = "";
			while ((msg = br.readLine()) != null){// EOF
				htmls.add(msg.trim());
			}
		} 
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return htmls;
	}
	//2017.4.12 /watch?v=PCaKey131NQ
	public String toUrl(String msg){
		String tt="";
		if(msg.indexOf("&")==-1){
			tt=msg;
		}else{
			tt=msg.substring(0, msg.indexOf("&"));
		}
		return tt;
	}
	
	// 
	public ArrayList<YoutubeSave> getTitles(String s_keyword) throws ParseException {
		ArrayList<YoutubeSave> yous = new ArrayList<YoutubeSave>();
		ArrayList<String> getTitles = search(s_keyword);
		 StringBuilder sb=new StringBuilder(); 
		 for(String st: getTitles) {
			
		    if(st.contains("var ytInitialData = ")) {
		    	String tt=st.substring(st.indexOf("var ytInitialData = ")+"var ytInitialData = ".length());
				sb.append(tt); 
			} 
		 }
		 String ts=sb.toString();
		 sb.setLength(0);
		 if(ts.contains("</script>")) {
    		ts=ts.substring(0,ts.indexOf("</script>"));
    		sb.append(ts);
    	 }
		 sb.setLength(sb.toString().trim().length()-1);  //";제거"

		 JSONParser jsonParser = new JSONParser();
		 System.out.println(".....-------------------------->"+sb.toString());
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
		 }
		return yous;
	}

    //
//	public ArrayList<Youtube> getSource(String key) {
//		ArrayList<Youtube> af = new ArrayList<Youtube>();
//		int i = 0;
//		ArrayList<String> asd = search(key);
//		ArrayList<String> img = searchimg(key);
//
//
//		for(int j=0; j<asd.size(); j++){
//			try{
//				String[] fu = asd.get(i).split("\"");
//				String ss = URLDecoder.decode(fu[5], "EUC-KR");
//				String s = URLDecoder.decode(fu[11], "EUC-KR");
//				Youtube f = new Youtube(s,ss,img.get(i));
//				af.add(f);
//
//			} 
//
//			catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//			i++;
//		}
//
//		return af;
//	}
}
