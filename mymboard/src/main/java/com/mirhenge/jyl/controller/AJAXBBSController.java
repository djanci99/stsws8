package com.mirhenge.jyl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mirhenge.jyl.calendar.dao.JYLCalendarService;
import com.mirhenge.jyl.calendar.model.JYLCalendar;
import com.mirhenge.jyl.calendar.model.NoticeDto;
import com.mirhenge.jyl.mboard.dao.JYLMBoardService;
import com.mirhenge.jyl.session.SessionHelp;

@Controller
public class AJAXBBSController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private JYLMBoardService jYLMBoardService;
	@Autowired
	private JYLCalendarService jYLCalendarService;
	@Autowired
	private SessionHelp help;
	
	public static String del(String msg){
		String s="";
		String bf="";
		String af="";
		if(msg.indexOf("?")>-1){
			System.out.println("과정:"+msg+"  "+msg.indexOf("?"));
			bf=msg.substring(0, msg.indexOf("?"));
			af=msg.substring(msg.indexOf("?")+1);
			return del(bf+af);
		}else{
			return msg;
		}
	}
	public static String delque(String msg){
		String s="";
		for (int i = 0; i < msg.length(); i++) {
			if(Character.isDigit(msg.charAt(i))){
				s+=msg.charAt(i);
			}
			if(msg.charAt(i)=='년' || msg.charAt(i)=='월'){
				s+="-";
			}
		}
		return s;	
	}

	@RequestMapping(value="boardAjax.do")
	public void ajaxlist(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int seq = Integer.parseInt(req.getParameter("seq"));
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		res.setHeader("Cache Controll", "no-cache");
		
		String preContent = jYLMBoardService.preView(seq);
		PrintWriter out = res.getWriter();
		out.print(preContent);
	}
	
	@RequestMapping(value = "calendarjson.do", 
			method = RequestMethod.POST)
	@ResponseBody
	public Map<String, List<JYLCalendar>> 
	calendarjson(
			JYLCalendar fcal, Model model) throws Exception {
		logger.info("Welcome CalendarController calendarjson! "+ new Date());
		logger.info("Welcome CalendarController --------- ========================"+ fcal);
		//postman post
		//http://localhost:8090/hkspring0126/calendarjson.do?wdate=20160113&id=kim
		List<JYLCalendar> flist= 
				jYLCalendarService.getDayList(fcal);
		Map<String, List<JYLCalendar>> 
		map=new HashMap<String, List<JYLCalendar>>();
		map.put("jina", flist);
		logger.info("Welcome CalendarController---------------"+map);
		return map;
	}//
	@RequestMapping(value = "/noctice_list.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, List<NoticeDto>> noctice_list(String year, String month,Model model ){
		logger.info("Welcome Notice_Control_ajax noctice_list! "+ new Date());
		logger.info("Welcome Notice_Control_ajax noctice_list! ------------------------------------------"+ year);
		logger.info("Welcome Notice_Control_ajax noctice_list! ------------------------------------------"+ year);
		int syear=Integer.parseInt(year);
		int smon=Integer.parseInt(month);
		HashMap<String, Object> map =new HashMap<>();
		map.put("syear", syear);
		map.put("eyear", syear);
		map.put("smon", smon);
		map.put("emon", smon);
		//map.put("id", id);
		HashMap<String, List<NoticeDto>> maps =new HashMap<>();
		maps.put("list", jYLCalendarService.getNotice(map));
		
		return maps;
	}
	@RequestMapping(value = "/getNotice.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, List<NoticeDto>> getNotice(HttpServletRequest request ,Model model, String start, String end){
		logger.info("Welcome Notice_Control_ajax getNotice! "+ new Date());
		//logger.info("Welcome Notice_Control_ajax 1 start!------------------------------ "+ start);
		//logger.info("Welcome Notice_Control_ajax 2 end!-------------------------------- "+ end);
		//logger.info("Welcome Notice_Control_ajax getNotice! ------------------------------------------"+ start.replaceAll("[.]", "-").replaceAll(" ", ""));
		//logger.info("Welcome Notice_Control_ajax getNotice! ------------------------------------------"+ end.replaceAll("[.]", "-").replaceAll(" ", ""));
		//logger.info("Welcome Notice_Control_ajax IE! "+ start.indexOf("\\?"));
		String pattern="";
		if(start.contains("년") || start.contains("월")|| start.contains("일")){//IE
			logger.info("Welcome Notice_Control_ajax IE! ");
			start=delque(start);
			end=delque(end);
			pattern="yyyy-MM-dd";
		}
		else{//Crome
			logger.info("Welcome Notice_Control_ajax NIE! "+ start.indexOf("."));
			start=start.replaceAll("[.]", "-").replaceAll(" ", "");
			end=end.replaceAll("[.]", "-").replaceAll(" ", "");
			pattern="yyyy-MM-dd-";
			//pattern=pattern.substring(0, pattern.lastIndexOf("-"));
		}
		logger.info("Welcome Notice_Control_ajax pattern!=============================================> ");
		logger.info("Welcome Notice_Control_ajax pattern!------------------------------ "+ pattern);
		logger.info("Welcome Notice_Control_ajax 2 start!------------------------------ "+ start);
		logger.info("Welcome Notice_Control_ajax 2 end!------------------------------ "+ end);
		//?2017?년 ?7?월 ?30?일
		//?2017?년 ?10?월 ?29?일
		//logger.info("Welcome Notice_Control_ajax getNotice????! ------------------------------------------"+ start.indexOf("?"));
//		String [] mm=start.split("?");
//		String tt="";
//		for(int i=0; i<mm.length; i++){
//			tt+=mm[i];
//		}
//		logger.info("Welcome Notice_Control_ajax getNotice    tt! ------------------------------------------"+ tt);
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		Date sdd=new Date();
		try {
			sdd=sdf.parse(start);
			//logger.info("Welcome Notice_Control_ajax 99! ----------=-------------------"+ sdd);
		} catch (ParseException e) {
			//logger.info("Welcome Notice_Control_ajax e! ----------=-------------------"+ e);
		}
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdd);
		int syear=scal.get(Calendar.YEAR);
		int smon=scal.get(Calendar.MONTH)+1;
		logger.info("Welcome Notice_Control_ajax getNotice! ------------------------------------------"+ syear+"-----------"+smon);
		SimpleDateFormat edf=new SimpleDateFormat(pattern);
		Date edd=new Date();
		try {
			edd=edf.parse(end);
			//logger.info("Welcome Notice_Control_ajax 99! ----------=-------------------"+ edd);
		} catch (ParseException e) {
			//logger.info("Welcome Notice_Control_ajax getNotice! ------=---------"+ e);
		}
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edd);
		int eyear=ecal.get(Calendar.YEAR);
		int emon=ecal.get(Calendar.MONTH)+1;
		//logger.info("Welcome Notice_Control_ajax getNotice! ------------------------------------------"+ eyear+"-----------"+emon);
//		int syear=Integer.parseInt(start.substring(start.indexOf('년')-4,start.indexOf('년')).trim());
//		int eyear=Integer.parseInt(end.substring(end.indexOf('년')-4,end.indexOf('년')).trim());
//		int smon=Integer.parseInt( start.substring((start.indexOf('월')-2),start.indexOf('월')).trim());
//		int emon=Integer.parseInt( end.substring((end.indexOf('월')-2),end.indexOf('월')).trim());
		if (smon==12) {
			smon=1;
		}
//		System.out.println(syear+"@@@@@@@@@@@@@@@@@@@@@@@@@@@2");
//		System.out.println(eyear);
//		System.out.println(smon);
//		System.out.println(emon);
		
		HashMap<String, Object> map =new HashMap<>();
		map.put("syear", syear);
		map.put("eyear", eyear);
		map.put("smon", smon);
		map.put("emon", emon);
		String id="";
		try{
			id=help.getId(request);//위에 메서드로 만듬
			map.put("stype", "id");
			map.put("id", id);
		}catch (Exception e) {
			
		}
		
		
		List<NoticeDto> lists = new ArrayList<NoticeDto>();
		lists=jYLCalendarService.getNotice(map);
		for (int i = 0; i < lists.size(); i++) {
			if(lists.get(i).getMonth()-1==0){
				lists.get(i).setYear(lists.get(i).getYear()-1);
				lists.get(i).setMonth(12);
			}else{
				lists.get(i).setMonth(lists.get(i).getMonth()-1);				
			}
		}
		
		Map<String, List<NoticeDto>> maps=new HashMap<>();
		maps.put("list", lists);
		
		return maps;
	}
}
