package com.mirhenge.jyl.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mirhenge.jyl.calendar.dao.JYLCalendarService;
import com.mirhenge.jyl.calendar.help.CalendarParam;
import com.mirhenge.jyl.calendar.help.CalendarUtil;
import com.mirhenge.jyl.calendar.help.JYLCal;
import com.mirhenge.jyl.calendar.model.JYLCalendar;
import com.mirhenge.jyl.session.SessionHelp;

@Controller
public class CalendarController {

	private static final Logger logger = 
			LoggerFactory.getLogger(CalendarController.class);
	@Autowired
	private JYLCalendarService jYLCalendarService;

	@Autowired
	private SessionHelp help;
	
	@RequestMapping(value = "calendar.do", 
			method = {RequestMethod.GET,RequestMethod.POST})
	public String calendar(HttpServletRequest request,
			JYLCal jcal,Model model) throws Exception {
		logger.info("Welcome CalendarController calendar! "+ new Date());
		jcal.calculate();
		String id="";
		try{
			id=help.getId(request);//위에 메서드로 만듬
		}catch (Exception e) {
			return "redirect:/login.do";
		}
				
		String yyyyMm=CalendarUtil.yyyymm(
				jcal.getYear(), jcal.getMonth());
		logger.info("Welcome CalendarController calendar! "+ yyyyMm);
		JYLCalendar fcal=new JYLCalendar();
		fcal.setId(id);
		fcal.setWdate(yyyyMm);
		List<JYLCalendar> flist= jYLCalendarService.getCalendarList(fcal);
		model.addAttribute("flist", flist);
		model.addAttribute("doc_title", "CALENDAR");
		model.addAttribute("jcal", jcal);
		return "calendar.tiles";
	}//
	
	@RequestMapping(value = "calwrite.do", 
			method = RequestMethod.GET)
	public String calwrite(
			HttpServletRequest request,
			JYLCal jcal,Model model) {
		logger.info("Welcome CalendarController calwrite! "+ new Date());
		jcal.calculate();
		model.addAttribute("jcal", jcal);
		model.addAttribute("doc_title", "CALENDAR");
		return "calwrite.tiles";
	}//
	@RequestMapping(value = "calwriteAf.do", 
			method = RequestMethod.POST)
	public String calwriteAf(HttpServletRequest request,
			CalendarParam calparam,Model model) throws Exception {
		logger.info("Welcome CalendarController calwriteAf! "+ new Date());

		String yyyyMmdd=CalendarUtil.yyyymmddhhmm(calparam.getYear(),
				calparam.getMonth(), calparam.getDay(),
				calparam.getHour(),calparam.getMin());
		JYLCalendar fcal=new JYLCalendar(
				calparam.getId(),
				calparam.getTitle(),
				calparam.getContent(),
				yyyyMmdd
				);
		
		jYLCalendarService.writeCalendar(fcal);
		model.addAttribute("doc_title", "CALENDAR");
		model.addAttribute("year", calparam.getYear());
		model.addAttribute("month", calparam.getMonth());
		
		return "forward:/calendar.do";
	}//
	
	@RequestMapping(value = "calendar2.do", 
			method = RequestMethod.GET)
	public String calendar2(HttpServletRequest request,JYLCal jcal,Model model) {
		logger.info("Welcome CalendarController calendar2! "+ new Date());
		jcal.calculate();  
		String yyyyMm=CalendarUtil.yyyymm(
				jcal.getYear(), jcal.getMonth());
		JYLCalendar fcal=new JYLCalendar();
		fcal.setWdate(yyyyMm);
		model.addAttribute("doc_title", "AJAX CALENDAR");
		model.addAttribute("jcal", jcal);
		return "calendar2.tiles";
	}//
	@RequestMapping(value = "calendar3.do", 
			method = {RequestMethod.POST,RequestMethod.GET})
	public String calendar3(HttpServletRequest request,
			JYLCal jcal, Model model) throws Exception {
		logger.info("Welcome CalendarController callist! "+ new Date());
		jcal.calculate();  
		String id="";
		try{
			id=help.getId(request);//위에 메서드로 만듬
		}catch (Exception e) {
			return "redirect:/login.do";
		}
		String yyyyMm=CalendarUtil.yyyymm(
				jcal.getYear(), jcal.getMonth());
		JYLCalendar fcal=new JYLCalendar();
		fcal.setId(id);
		fcal.setWdate(yyyyMm);
		List<JYLCalendar> flist= jYLCalendarService.getCalendarList2(fcal);
		model.addAttribute("doc_title", "CALENDAR DAYLIST");
		model.addAttribute("callist", flist);
		model.addAttribute("year", jcal.getYear());
		model.addAttribute("month", jcal.getMonth());
		return "calendar3.tiles";
	}//
	
	@RequestMapping(value = "caldetail.do", 
			method = {RequestMethod.GET,RequestMethod.POST})
	public String caldetail(HttpServletRequest request,
			JYLCalendar fcal,Model model) throws Exception {
		logger.info("Welcome CalendarController caldetail! "+ new Date());
		
		JYLCalendar flist= 
				jYLCalendarService.getDay(fcal);
		String wdate=flist.getWdate();
		flist.setWdate(CalendarUtil.toStrDate(wdate));
		String year=wdate.substring(0,4);
		String month=CalendarUtil.toOne(wdate.substring(4,6))+"";
		String urls=String.format("%s?year=%s&month=%s",
				"calendar.do",year,month);
		logger.info("Welcome CalendarController caldetail--------------------------------! "+ urls);
		model.addAttribute("cal", flist);
		model.addAttribute("urls", urls);
		model.addAttribute("doc_title", "CALENDAR DETAIL");
		return "caldetail.tiles";
	}//
	@RequestMapping(value = "calupdate.do", 
			method = {RequestMethod.GET,RequestMethod.POST})
	public String calupdate(HttpServletRequest request,
			JYLCalendar fcal,Model model) throws Exception {
		logger.info("Welcome CalendarController calupdate! "+ new Date());
		
		JYLCalendar flist= 
				jYLCalendarService.getDay(fcal);

		logger.info("Welcome CalendarController calupdate! ");
		model.addAttribute("cal", flist);
		model.addAttribute("doc_title", "CALENDAR UPDATE");
		return "calupdate.tiles";
	}//
	
	@RequestMapping(value = "calupdateaf.do", 
			method = RequestMethod.POST)
	public String calupdateaf(HttpServletRequest request,
			CalendarParam calparam,Model model) throws Exception {
		logger.info("Welcome CalendarController calupdateaf! "+ new Date());

		String yyyyMmdd=CalendarUtil.yyyymmddhhmm(calparam.getYear(),
				calparam.getMonth(), calparam.getDay(),
				calparam.getHour(),calparam.getMin());
		logger.info("Welcome CalendarController yyyyMmdd! "+ yyyyMmdd);
		JYLCalendar fcal=new JYLCalendar(
				calparam.getSeq(),
				calparam.getId(),
				calparam.getTitle(),
				calparam.getContent(),
				yyyyMmdd,
				null
				);
		logger.info("Welcome CalendarController -------------------- "+ fcal);
		jYLCalendarService.calupdate(fcal);
		model.addAttribute("doc_title", "CALENDAR");
		model.addAttribute("seq", calparam.getSeq());
		return "forward:/caldetail.do";
	}//
	@RequestMapping(value = "callist.do", 
			method = {RequestMethod.POST,RequestMethod.GET})
	public String callist(HttpServletRequest request,
			CalendarParam calparam, Model model) throws Exception {
		logger.info("Welcome CalendarController callist! "+ new Date());
		logger.info("Welcome CalendarController calparam! "+ calparam);
		String id="";
		try{
			id=help.getId(request);//위에 메서드로 만듬
		}catch (Exception e) {
			return "redirect:/login.do";
		}
		String yyyyMmdd=CalendarUtil.yyyymmdd(calparam.getYear(),
				calparam.getMonth(), calparam.getDay());
		JYLCalendar fcal=new JYLCalendar(
				-1,
				id,
				null,
				null,
				yyyyMmdd,
				null
				);
		
		List<JYLCalendar> flist= 
				jYLCalendarService.getDayList(fcal);
		model.addAttribute("callist", flist);
		model.addAttribute("doc_title", "CALENDAR DAYLIST");
		model.addAttribute("year", calparam.getYear());
		model.addAttribute("month", calparam.getMonth());
		return "callist.tiles";
	}//
	@RequestMapping(value = "caldel.do", 
			method = {RequestMethod.POST,RequestMethod.GET})
	public String caldel(HttpServletRequest request,
			JYLCalendar fcal,RedirectAttributes red,Model model) throws Exception {
		logger.info("Welcome CalendarController caldel! "+ new Date());

		logger.info("Welcome CalendarController -------- "+ fcal);
		JYLCalendar jcals2=jYLCalendarService.getDay(fcal);
		jYLCalendarService.caldel(fcal);

		logger.info("Welcome CalendarController after del getDay-------- "+ jcals2);
		red.addAttribute("year",jcals2.getWdate().substring(0, 4));
		red.addAttribute("month",jcals2.getWdate().substring(4, 6));
		red.addAttribute("day",jcals2.getWdate().substring(6, 8));
		return "redirect:/callist.do";
	}//
	
	
	
}
